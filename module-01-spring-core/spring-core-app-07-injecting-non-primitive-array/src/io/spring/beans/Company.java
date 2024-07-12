package io.spring.beans;

public class Company {
    private String companyName;
    private String address;
    private Employee[] workers;

    // Constructor
    public Company() {
        System.out.println("Company Bean Created!");
    }

    // Getter and Setter for companyName
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for workers
    public Employee[] getWorkers() {
        return workers;
    }

    public void setWorkers(Employee[] workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        StringBuilder workersList = new StringBuilder();
        for (Employee worker : workers) {
            workersList.append(worker.toString()).append("\n");
        }

        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", workers=\n" + workersList.toString() +
                '}';
    }
}
