package com.weddingwire.logwire.api.application;

import com.weddingwire.logwire.api.data.LogEntryRepository;
import com.weddingwire.logwire.api.interfaces.ILogEntryService;
import com.weddingwire.logwire.api.interfaces.ISearchModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

public class LogEntryService implements ILogEntryService {
    private LogEntryRepository logEntryRepository;

    public LogEntryService(LogEntryRepository logEntryRepository){
        this.logEntryRepository = logEntryRepository;
    }

    @Override
    public Page search(ISearchModel searchModel){
        Page entriesPage = null;
        //search text param provided, and possibly a date parameter
        if(searchModel != null && !StringUtils.isEmpty(searchModel.getSearchValue())){
            entriesPage = logEntryRepository.findByRawTextIgnoreCaseContainingAndRequestDateTimeBetweenOrderByRequestDateTimeDesc(searchModel.getSearchValue(), searchModel.getStartDate(), searchModel.getEndDate(), PageRequest.of(0,100));
        //at least one date parameter passed, if not the searchModel would be null
        }else if(searchModel !=null){
            entriesPage = logEntryRepository.findByRequestDateTimeBetweenOrderByRequestDateTimeDesc(searchModel.getStartDate(), searchModel.getEndDate(), PageRequest.of(0,100));
        }else{
            entriesPage = logEntryRepository.findAllByOrderByRequestDateTimeDesc(PageRequest.of(0,100));
        }

        return entriesPage;
    }
}
