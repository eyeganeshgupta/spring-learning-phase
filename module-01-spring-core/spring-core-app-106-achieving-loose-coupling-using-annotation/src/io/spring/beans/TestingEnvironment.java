package io.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestingEnvironment implements Environment {
    private double testCoveragePercentage;
    private String baseURL;
    private String databaseConnectionString;
    private String testFrameworkVersion;
    private int numberOfTestSuites;

    // Constructor
    public TestingEnvironment(@Value("85.5") double testCoveragePercentage, @Value("http://localhost:9090") String baseURL, @Value("jdbc:testdb://localhost:3306/testdb") String databaseConnectionString,
                              @Value("JUnit v5") String testFrameworkVersion, @Value("25") int numberOfTestSuites) {
        this.testCoveragePercentage = testCoveragePercentage;
        this.baseURL = baseURL;
        this.databaseConnectionString = databaseConnectionString;
        this.testFrameworkVersion = testFrameworkVersion;
        this.numberOfTestSuites = numberOfTestSuites;
        System.out.println("==== TestingEnvironment bean created! ====");
    }

    @Override
    public void setup() {
        System.out.println("Setting up Testing Environment...");
        System.out.println("Test Coverage: " + testCoveragePercentage + "%");
        System.out.println("Base URL: " + baseURL);
        System.out.println("Database Connection: " + databaseConnectionString);
        System.out.println("Test Framework Version: " + testFrameworkVersion);
        System.out.println("Number of Test Suites: " + numberOfTestSuites);
    }

    @Override
    public String getEnvironmentName() {
        return "Testing Environment";
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
    public String getTestFrameworkVersion() {
        return testFrameworkVersion;
    }

    public int getNumberOfTestSuites() {
        return numberOfTestSuites;
    }

    public double getTestCoveragePercentage() {
        return testCoveragePercentage;
    }
}
