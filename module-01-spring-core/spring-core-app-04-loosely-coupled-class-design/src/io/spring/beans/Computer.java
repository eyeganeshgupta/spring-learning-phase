package io.spring.beans;

public interface Computer {
    void setBrand(String brand);
    String getBrand();

    void setProcessor(String processor);
    String getProcessor();

    void setRamSize(int ramSize);
    int getRamSize();

    void setStorageSize(int storageSize);
    int getStorageSize();
}
