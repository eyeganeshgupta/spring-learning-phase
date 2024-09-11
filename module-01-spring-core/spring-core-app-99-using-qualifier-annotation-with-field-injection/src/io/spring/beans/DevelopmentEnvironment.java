package io.spring.beans;

public class DevelopmentEnvironment {
    private String operatingSystem;
    private String ide;
    private String versionControlSystem;
    private String buildTool;
    private String database;
    private String testingFramework;
    private String deploymentEnvironment;
    private String codeAnalysisTool;
    private String loggingFramework;
    private String virtualizationTool;

    // Constructor
    public DevelopmentEnvironment() {
        System.out.println("==== DevelopmentEnvironment bean created! ====");
    }

    public DevelopmentEnvironment(String operatingSystem, String ide, String versionControlSystem, String buildTool,
                                  String database, String testingFramework, String deploymentEnvironment,
                                  String codeAnalysisTool, String loggingFramework, String virtualizationTool) {
        this.operatingSystem = operatingSystem;
        this.ide = ide;
        this.versionControlSystem = versionControlSystem;
        this.buildTool = buildTool;
        this.database = database;
        this.testingFramework = testingFramework;
        this.deploymentEnvironment = deploymentEnvironment;
        this.codeAnalysisTool = codeAnalysisTool;
        this.loggingFramework = loggingFramework;
        this.virtualizationTool = virtualizationTool;
        System.out.println("==== DevelopmentEnvironment " + this.operatingSystem + " bean created! ====");
    }

    // Getters and Setters
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getVersionControlSystem() {
        return versionControlSystem;
    }

    public void setVersionControlSystem(String versionControlSystem) {
        this.versionControlSystem = versionControlSystem;
    }

    public String getBuildTool() {
        return buildTool;
    }

    public void setBuildTool(String buildTool) {
        this.buildTool = buildTool;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTestingFramework() {
        return testingFramework;
    }

    public void setTestingFramework(String testingFramework) {
        this.testingFramework = testingFramework;
    }

    public String getDeploymentEnvironment() {
        return deploymentEnvironment;
    }

    public void setDeploymentEnvironment(String deploymentEnvironment) {
        this.deploymentEnvironment = deploymentEnvironment;
    }

    public String getCodeAnalysisTool() {
        return codeAnalysisTool;
    }

    public void setCodeAnalysisTool(String codeAnalysisTool) {
        this.codeAnalysisTool = codeAnalysisTool;
    }

    public String getLoggingFramework() {
        return loggingFramework;
    }

    public void setLoggingFramework(String loggingFramework) {
        this.loggingFramework = loggingFramework;
    }

    public String getVirtualizationTool() {
        return virtualizationTool;
    }

    public void setVirtualizationTool(String virtualizationTool) {
        this.virtualizationTool = virtualizationTool;
    }

    // Method to display development environment details
    public void displayEnvironmentDetails() {
        String border = "==========================================";
        String header = "       Development Environment Details     ";
        String line1 = String.format("%-25s : %s", "Operating System", operatingSystem);
        String line2 = String.format("%-25s : %s", "IDE", ide);
        String line3 = String.format("%-25s : %s", "Version Control System", versionControlSystem);
        String line4 = String.format("%-25s : %s", "Build Tool", buildTool);
        String line5 = String.format("%-25s : %s", "Database", database);
        String line6 = String.format("%-25s : %s", "Testing Framework", testingFramework);
        String line7 = String.format("%-25s : %s", "Deployment Environment", deploymentEnvironment);
        String line8 = String.format("%-25s : %s", "Code Analysis Tool", codeAnalysisTool);
        String line9 = String.format("%-25s : %s", "Logging Framework", loggingFramework);
        String line10 = String.format("%-25s : %s", "Virtualization Tool", virtualizationTool);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(line8);
        System.out.println(line9);
        System.out.println(line10);
        System.out.println(border);
    }
}
