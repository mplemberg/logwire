package com.weddingwire.logwire.api.data;

import com.weddingwire.logwire.api.interfaces.ILogEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class LogEntry implements ILogEntry {
    @Id
    private String id;

    @Column(columnDefinition = "TEXT")
    public String rawText;

    private String resourcePath;
    private String ipAddress;
    private String requestMethod;
    private Date requestDateTime;
    private String responseCode;
    private Integer requestDurationValue;
    private String requestDurationUnit;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getRawText() {
        return rawText;
    }

    @Override
    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    @Override
    public String getResourcePath() {
        return resourcePath;
    }

    @Override
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String getRequestMethod() {
        return requestMethod;
    }

    @Override
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Override
    public String getResponseCode() {
        return responseCode;
    }

    @Override
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public Date getRequestDateTime() {
        return requestDateTime;
    }

    @Override
    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @Override
    public Integer getRequestDurationValue() {
        return requestDurationValue;
    }

    @Override
    public void setRequestDurationValue(Integer requestDurationValue) {
        this.requestDurationValue = requestDurationValue;
    }

    @Override
    public String getRequestDurationUnit() {
        return requestDurationUnit;
    }

    @Override
    public void setRequestDurationUnit(String requestDurationUnit) {
        this.requestDurationUnit = requestDurationUnit;
    }
}
