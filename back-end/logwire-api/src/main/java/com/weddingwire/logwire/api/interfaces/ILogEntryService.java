package com.weddingwire.logwire.api.interfaces;

import org.springframework.data.domain.Page;

public interface ILogEntryService {
    Page search(ISearchModel searchModel);
}
