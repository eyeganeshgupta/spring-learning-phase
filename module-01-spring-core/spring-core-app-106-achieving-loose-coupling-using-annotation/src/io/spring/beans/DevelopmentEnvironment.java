package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DevelopmentEnvironment implements Environment {
    private boolean isDebugMode;
    private String baseURL;
    private String databaseConnectionString;
    private String developerToolsVersion;
    private boolean autoReloadEnabled;

    // Constructor
    public DevelopmentEnvironment(@Value("true") boolean isDebugMode, @Value("http://localhost:8080") String baseURL, @Value("jdbc:devdb://localhost:3306/devdb") String databaseConnectionString,
                                  @Value("v1.2.3") String developerToolsVersion, @Value("true") boolean autoReloadEnabled) {
        this.isDebugMode = isDebugMode;
        this.baseURL = baseURL;
        this.databaseConnectionString = databaseConnectionString;
        this.developerToolsVersion = developerToolsVersion;
        this.autoReloadEnabled = autoReloadEnabled;
        System.out.println("==== DevelopmentEnvironment bean created! ====");
    }

    @Override
    public void setup() {
        System.out.println("Setting up Development Environment...");
        System.out.println("Debug Mode: " + (isDebugMode ? "Enabled" : "Disabled"));
        System.out.println("Base URL: " + baseURL);
        System.out.println("Database Connection: " + databaseConnectionString);
        System.out.println("Developer Tools Version: " + developerToolsVersion);
        System.out.println("Auto-Reload: " + (autoReloadEnabled ? "Enabled" : "Disabled"));
    }

    @Override
    public String getEnvironmentName() {
        return "Development Environment";
    }

    @Override
    public String getBaseURL() {
        return baseURL;
    }

    @Override
    public String getDatabaseConnectionString() {
        return databaseConnectionString;
    }

    // Additional Getters
    public String getDeveloperToolsVersion() {
        return developerToolsVersion;
    }

    public boolean isAutoReloadEnabled() {
        return autoReloadEnabled;
    }
}
