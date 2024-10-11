package io.spring.model;

import io.spring.enums.GraphicsType;
import io.spring.enums.ProcessorBrand;
import io.spring.enums.StorageType;

public class Laptop {
    private int laptopId;
    private String brand;
    private String model;
    private ProcessorBrand processorBrand;
    private String processorModel;
    private int ramGb;
    private StorageType storageType;
    private int storageCapacityGb;
    private double screenSizeInches;
    private String resolution;
    private GraphicsType graphicsType;
    private String graphicsCard;
    private String operatingSystem;
    private double weightKg;
    private double priceRupees;
    private int batteryLifeHours;
    private boolean inStock;
    private int stockQuantity;
    private int warrantyMonths;

    public Laptop() {

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

    public ProcessorBrand getProcessorBrand() {
        return processorBrand;
    }

    public void setProcessorBrand(ProcessorBrand processorBrand) {
        this.processorBrand = processorBrand;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    public int getStorageCapacityGb() {
        return storageCapacityGb;
    }

    public void setStorageCapacityGb(int storageCapacityGb) {
        this.storageCapacityGb = storageCapacityGb;
    }

    public double getScreenSizeInches() {
        return screenSizeInches;
    }

    public void setScreenSizeInches(double screenSizeInches) {
        this.screenSizeInches = screenSizeInches;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public GraphicsType getGraphicsType() {
        return graphicsType;
    }

    public void setGraphicsType(GraphicsType graphicsType) {
        this.graphicsType = graphicsType;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getPriceRupees() {
        return priceRupees;
    }

    public void setPriceRupees(double priceRupees) {
        this.priceRupees = priceRupees;
    }

    public int getBatteryLifeHours() {
        return batteryLifeHours;
    }

    public void setBatteryLifeHours(int batteryLifeHours) {
        this.batteryLifeHours = batteryLifeHours;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", processorBrand=" + processorBrand +
                ", processorModel='" + processorModel + '\'' +
                ", ramGb=" + ramGb +
                ", storageType=" + storageType +
                ", storageCapacityGb=" + storageCapacityGb +
                ", screenSizeInches=" + screenSizeInches +
                ", resolution='" + resolution + '\'' +
                ", graphicsType=" + graphicsType +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", weightKg=" + weightKg +
                ", priceRupees=" + priceRupees +
                ", batteryLifeHours=" + batteryLifeHours +
                ", inStock=" + inStock +
                ", stockQuantity=" + stockQuantity +
                ", warrantyMonths=" + warrantyMonths +
                '}';
    }
}
