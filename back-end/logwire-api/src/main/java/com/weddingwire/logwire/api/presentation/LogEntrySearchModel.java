package com.weddingwire.logwire.api.presentation;

import com.weddingwire.logwire.api.interfaces.ISearchModel;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class LogEntrySearchModel implements ISearchModel {
    @NotEmpty
    public String searchValue;

    public int pageNumber;
    public int pageSize;

    //TODO Add DateFormat Validation
    //TODO handle date range varaitions more elegenatly, this is hacky
    public Date startDate = new Date(Long.MIN_VALUE);
    public Date endDate = new Date();

    @Override
    public String getSearchValue() {
        return searchValue;
    }

    @Override
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
