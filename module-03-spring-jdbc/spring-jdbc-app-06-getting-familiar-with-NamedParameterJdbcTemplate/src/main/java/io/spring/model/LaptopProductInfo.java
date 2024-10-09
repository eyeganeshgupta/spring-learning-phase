package io.spring.model;

public class LaptopProductInfo {
    private int laptopId;
    private String brand;
    private String model;
    private String processor;
    private String memory;
    private String storage;
    private String display;
    private String operatingSystem;
    private double priceRupees;
    private String availability;

    public LaptopProductInfo() {

    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPriceRupees() {
        return priceRupees;
    }

    public void setPriceRupees(double priceRupees) {
        this.priceRupees = priceRupees;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "LaptopProductInfo{" +
                "laptopId=" + laptopId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", processor='" + processor + '\'' +
                ", memory='" + memory + '\'' +
                ", storage='" + storage + '\'' +
                ", display='" + display + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", priceRupees=" + priceRupees +
                ", availability='" + availability + '\'' +
                '}';
    }
}
