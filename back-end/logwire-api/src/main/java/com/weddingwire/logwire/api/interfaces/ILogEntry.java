package com.weddingwire.logwire.api.interfaces;

import java.util.Date;

public interface ILogEntry {
    String getId();

    void setId(String id);

    String getRawText();

    void setRawText(String rawText);

    String getResourcePath();

    void setResourcePath(String resourcePath);

    String getIpAddress();

    void setIpAddress(String ipAddress);

    String getRequestMethod();

    void setRequestMethod(String requestMethod);

    String getResponseCode();

    void setResponseCode(String responseCode);

    Date getRequestDateTime();

    void setRequestDateTime(Date requestDateTime);

    Integer getRequestDurationValue();

    void setRequestDurationValue(Integer requestDurationValue);

    String getRequestDurationUnit();

    void setRequestDurationUnit(String requestDurationUnit);
}
