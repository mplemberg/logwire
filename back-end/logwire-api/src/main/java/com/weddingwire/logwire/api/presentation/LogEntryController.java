package com.weddingwire.logwire.api.presentation;

import com.weddingwire.logwire.api.application.LogEntryService;
import com.weddingwire.logwire.api.data.LogEntryRepository;
import com.weddingwire.logwire.api.interfaces.ILogEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log-entries")
public class LogEntryController {
    private static final Logger LOG = LoggerFactory.getLogger(LogEntryController.class);

    @Autowired
    private LogEntryRepository logEntryRepository;

    @GetMapping("")
    public Page get(LogEntrySearchModel searchModel){
        ILogEntryService logEntryService = new LogEntryService(logEntryRepository);
        return logEntryService.search(searchModel);
    }
}
