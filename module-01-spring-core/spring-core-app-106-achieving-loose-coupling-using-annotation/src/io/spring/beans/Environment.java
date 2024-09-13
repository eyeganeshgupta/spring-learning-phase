package io.spring.beans;

public interface Environment {
    void setup();
    String getEnvironmentName();
    String getBaseURL();
    String getDatabaseConnectionString();
}
