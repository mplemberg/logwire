package com.weddingwire.logwire.api.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LogEntryBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(LogEntryBuilder.class);
    private String rawEntryText;
    private static final String UUID_BEGIN_SEPARATOR = "[";
    private static final String STARTED_KEY = "Started";
    private static final String COMPLETED_KEY = "Completed";

    public LogEntryBuilder(String rawEntryText){
        this.rawEntryText = rawEntryText;
    }

    public LogEntry create(){
        LogEntry logEntry = new LogEntry();
        logEntry.setRawText(rawEntryText);
        String[] lines = rawEntryText.split(System.lineSeparator());
        //with more time would use regex to extract data
        for(String line : lines){
            String[] lineParts = line.split(" ");
            if(lineParts.length > 1) {
                if (StringUtils.isEmpty(logEntry.getId()) && line.startsWith(UUID_BEGIN_SEPARATOR)) {
                    String requestId = lineParts[0].replace("[", "").replace("]", "");
                    logEntry.setId(requestId);
                }

                if (lineParts[1].equalsIgnoreCase(STARTED_KEY)) {
                    logEntry.setRequestMethod(lineParts[2]);
                    logEntry.setResourcePath(lineParts[3]);
                    logEntry.setIpAddress(lineParts[5]);
                    String timeStampString = lineParts[7] + " " + lineParts[8] + " " + lineParts[9];
                    SimpleDateFormat requestDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss Z");
                    try {
                        logEntry.setRequestDateTime(requestDateTimeFormat.parse(timeStampString));
                    } catch (ParseException e) {
                        LOG.error("Invalid Timestamp:" + timeStampString, e);
                    }

                } else if (lineParts[1].equalsIgnoreCase(COMPLETED_KEY)) {
                    String contentsAfterCompleted = line.substring(line.indexOf(COMPLETED_KEY) + COMPLETED_KEY.length() + 1);
                    logEntry.setResponseCode(contentsAfterCompleted.substring(0, 3));
                    logEntry.setRequestMethod(contentsAfterCompleted.substring(4, contentsAfterCompleted.indexOf(" in ")));
                    String requestDuration = contentsAfterCompleted.substring(contentsAfterCompleted.indexOf(" in ") + (" in ").length(), contentsAfterCompleted.indexOf(" ("));
                    logEntry.setRequestDurationValue(Integer.parseInt(requestDuration.replaceAll("[^0-9]", "")));
                    logEntry.setRequestDurationUnit(requestDuration.replaceAll("[^A-Za-z]+", ""));
                }
            }
        }
        return logEntry;
    }
}
