package com.weddingwire.logwire.api.interfaces;

import java.util.Date;

public interface ISearchModel {
    String getSearchValue();

    void setSearchValue(String searchValue);

    int getPageNumber();

    void setPageNumber(int pageNumber);

    int getPageSize();

    void setPageSize(int pageSize);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);
}
