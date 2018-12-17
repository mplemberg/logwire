package com.weddingwire.logwire.api.data;

import com.weddingwire.logwire.api.interfaces.IDatabaseSeeder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class DatabaseSeeder implements IDatabaseSeeder {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    private LogEntryRepository logEntryRepository;
    private static final String UUID_BEGIN_SEPERATOR = "[";

    @Override
    public void runIfEmpty(){
        if(logEntryRepository.count() == 0){
            seedDatabase();
        }
    }

    private void seedDatabase(){
        try(Stream<String> stream = Files.lines(Paths.get("sample.log"))){
            Map<String, String> requestLineGroupsMap = new HashMap();
            String previousEntryId = null;
            for(String line : stream.toArray(String[]::new)){
                String processedLines = null;
                String id = null;
                if(line.startsWith(UUID_BEGIN_SEPERATOR)){
                    String[] lineParts = line.split(" ");
                    String requestId = lineParts[0].replace("[", "").replace("]", "");
                    previousEntryId = requestId;
                    processedLines = requestLineGroupsMap.get(requestId);
                    id = requestId;
                }
                else{
                    id = previousEntryId;
                    processedLines = requestLineGroupsMap.get(previousEntryId);
                }

                if (StringUtils.isEmpty(processedLines)) {
                    requestLineGroupsMap.put(id, line);
                } else {
                    processedLines = processedLines + System.lineSeparator() + line;
                    requestLineGroupsMap.put(id, processedLines);
                }
            }

            List<LogEntry> logEntries = new ArrayList<>();
            requestLineGroupsMap.values().stream().forEach(requestLineGroup -> {
                logEntries.add(new LogEntryBuilder(requestLineGroup).create());
            });

            logEntryRepository.saveAll(logEntries);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
        }
    }
}
