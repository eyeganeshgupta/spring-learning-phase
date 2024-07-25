package io.spring.beans;

public class Desktop implements Computer {
    private String brand;
    private String processor;
    private int ramSize;
    private int storageSize;

    public Desktop() {
        System.out.println("Desktop Bean Created");
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String getProcessor() {
        return processor;
    }

    @Override
    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    @Override
    public int getRamSize() {
        return ramSize;
    }

    @Override
    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    @Override
    public int getStorageSize() {
        return storageSize;
    }
}
