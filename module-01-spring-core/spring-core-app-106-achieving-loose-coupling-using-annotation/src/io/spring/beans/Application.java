package io.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private String appName;
    private String version;
    private String language;
    private int port;
    private boolean isProductionReady;
    private Environment environment;

    // Constructor
    public Application() {
        System.out.println("==== Application bean created! ====");
    }

    @Autowired
    public Application(@Value("DevApp") String appName, @Value("1.0.0") String version, @Value("Java") String language, @Value("8080") int port, @Value("false") boolean isProductionReady, Environment environment) {
        this.appName = appName;
        this.version = version;
        this.language = language;
        this.port = port;
        this.isProductionReady = isProductionReady;
        this.environment = environment;
        System.out.println("==== Application bean created! ====");
    }

    // Getters and Setters
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isProductionReady() {
        return isProductionReady;
    }

    public void setProductionReady(boolean productionReady) {
        isProductionReady = productionReady;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    // Method to display application details along with environment
    public void displayAppDetails() {
        System.out.println("\n==========================================");
        System.out.println("Application Name     : " + appName);
        System.out.println("Version              : " + version);
        System.out.println("Language             : " + language);
        System.out.println("Port                 : " + port);
        System.out.println("Production Ready     : " + (isProductionReady ? "Yes" : "No"));
        System.out.println("Running in " + environment.getEnvironmentName());
        environment.setup();
        System.out.println("==========================================");
    }
}
