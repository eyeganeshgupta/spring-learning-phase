package io.spring.runner;

import io.spring.enums.GraphicsType;
import io.spring.enums.ProcessorBrand;
import io.spring.enums.StorageType;
import io.spring.model.Laptop;
import io.spring.model.LaptopProductInfo;
import io.spring.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class LaptopDataEntryRunner implements CommandLineRunner {

    private final LaptopService laptopService;

    @Autowired
    public LaptopDataEntryRunner(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Enter new laptop details");
            System.out.println("2. Display all laptops");
            System.out.println("3. Display all laptop product information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    enterLaptopDetails(scanner);
                    break;
                case 2:
                    displayAllLaptops();
                    break;
                case 3:
                    displayAllLaptopProductInfo();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void enterLaptopDetails(Scanner scanner) {
        /*
        Laptop laptop = new Laptop();

        System.out.println("Enter laptop details:");

        System.out.print("Brand: ");
        laptop.setBrand(scanner.nextLine());

        System.out.print("Model: ");
        laptop.setModel(scanner.nextLine());

        System.out.print("Processor Brand (Intel/AMD/Apple/Other): ");
        try {
            laptop.setProcessorBrand(ProcessorBrand.valueOf(scanner.nextLine().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid processor brand. Setting to Other.");
            laptop.setProcessorBrand(ProcessorBrand.Other);
        }

        System.out.print("Processor Model: ");
        laptop.setProcessorModel(scanner.nextLine());

        System.out.print("RAM (GB): ");
        laptop.setRamGb(Integer.parseInt(scanner.nextLine()));

        System.out.print("Storage Type (SSD/HDD/Hybrid/eMMC): ");
        try {
            laptop.setStorageType(StorageType.valueOf(scanner.nextLine().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid storage type. Setting to SSD.");
            laptop.setStorageType(StorageType.SSD);
        }

        System.out.print("Storage Capacity (GB): ");
        laptop.setStorageCapacityGb(Integer.parseInt(scanner.nextLine()));

        System.out.print("Screen Size (inches): ");
        laptop.setScreenSizeInches(Double.parseDouble(scanner.nextLine()));

        System.out.print("Resolution: ");
        laptop.setResolution(scanner.nextLine());

        System.out.print("Graphics Type (Integrated/Dedicated/Hybrid): ");
        try {
            laptop.setGraphicsType(GraphicsType.valueOf(scanner.nextLine().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid graphics type. Setting to Integrated.");
            laptop.setGraphicsType(GraphicsType.Integrated);
        }

        System.out.print("Graphics Card: ");
        laptop.setGraphicsCard(scanner.nextLine());

        System.out.print("Operating System: ");
        laptop.setOperatingSystem(scanner.nextLine());

        System.out.print("Weight (kg): ");
        laptop.setWeightKg(Double.parseDouble(scanner.nextLine()));

        System.out.print("Price (Rupees): ");
        laptop.setPriceRupees(Double.parseDouble(scanner.nextLine()));

        System.out.print("Battery Life (hours): ");
        laptop.setBatteryLifeHours(Integer.parseInt(scanner.nextLine()));

        System.out.print("In Stock (true/false): ");
        laptop.setInStock(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("Stock Quantity: ");
        laptop.setStockQuantity(Integer.parseInt(scanner.nextLine()));

        System.out.print("Warranty (months): ");
        laptop.setWarrantyMonths(Integer.parseInt(scanner.nextLine()));

        try {
            laptopService.addLaptop(laptop);
            System.out.println("Laptop inserted successfully!");
        } catch (Exception e) {
            System.out.println("Error inserting laptop: " + e.getMessage());
        }
        */

        Laptop laptop1 = new Laptop();
        laptop1.setLaptopId(1);
        laptop1.setBrand("HP");
        laptop1.setModel("Pavilion 15");
        laptop1.setProcessorBrand(ProcessorBrand.Intel);
        laptop1.setProcessorModel("i7-12700H");
        laptop1.setRamGb(16);
        laptop1.setStorageType(StorageType.SSD);
        laptop1.setStorageCapacityGb(512);
        laptop1.setScreenSizeInches(15.6);
        laptop1.setResolution("1920x1080");
        laptop1.setGraphicsType(GraphicsType.Dedicated);
        laptop1.setGraphicsCard("NVIDIA GTX 1650");
        laptop1.setOperatingSystem("Windows 11");
        laptop1.setWeightKg(1.85);
        laptop1.setPriceRupees(75000);
        laptop1.setBatteryLifeHours(8);
        laptop1.setInStock(true);
        laptop1.setStockQuantity(20);
        laptop1.setWarrantyMonths(24);

        Laptop laptop2 = new Laptop();
        laptop2.setLaptopId(2);
        laptop2.setBrand("Dell");
        laptop2.setModel("Inspiron 14");
        laptop2.setProcessorBrand(ProcessorBrand.AMD);
        laptop2.setProcessorModel("Ryzen 5 5600U");
        laptop2.setRamGb(8);
        laptop2.setStorageType(StorageType.SSD);
        laptop2.setStorageCapacityGb(256);
        laptop2.setScreenSizeInches(14.0);
        laptop2.setResolution("1920x1080");
        laptop2.setGraphicsType(GraphicsType.Integrated);
        laptop2.setGraphicsCard("AMD Radeon Graphics");
        laptop2.setOperatingSystem("Windows 10");
        laptop2.setWeightKg(1.5);
        laptop2.setPriceRupees(55000);
        laptop2.setBatteryLifeHours(10);
        laptop2.setInStock(true);
        laptop2.setStockQuantity(15);
        laptop2.setWarrantyMonths(12);

        Laptop laptop3 = new Laptop();
        laptop3.setLaptopId(3);
        laptop3.setBrand("Apple");
        laptop3.setModel("MacBook Pro");
        laptop3.setProcessorBrand(ProcessorBrand.Apple);
        laptop3.setProcessorModel("M1");
        laptop3.setRamGb(16);
        laptop3.setStorageType(StorageType.SSD);
        laptop3.setStorageCapacityGb(512);
        laptop3.setScreenSizeInches(13.3);
        laptop3.setResolution("2560x1600");
        laptop3.setGraphicsType(GraphicsType.Integrated);
        laptop3.setGraphicsCard("Apple M1 GPU");
        laptop3.setOperatingSystem("macOS");
        laptop3.setWeightKg(1.4);
        laptop3.setPriceRupees(120000);
        laptop3.setBatteryLifeHours(15);
        laptop3.setInStock(true);
        laptop3.setStockQuantity(10);
        laptop3.setWarrantyMonths(12);

        Laptop laptop4 = new Laptop();
        laptop4.setLaptopId(4);
        laptop4.setBrand("Asus");
        laptop4.setModel("ROG Strix");
        laptop4.setProcessorBrand(ProcessorBrand.Intel);
        laptop4.setProcessorModel("i9-11900H");
        laptop4.setRamGb(32);
        laptop4.setStorageType(StorageType.SSD);
        laptop4.setStorageCapacityGb(1024);
        laptop4.setScreenSizeInches(17.3);
        laptop4.setResolution("2560x1440");
        laptop4.setGraphicsType(GraphicsType.Dedicated);
        laptop4.setGraphicsCard("NVIDIA RTX 3080");
        laptop4.setOperatingSystem("Windows 11");
        laptop4.setWeightKg(2.9);
        laptop4.setPriceRupees(200000);
        laptop4.setBatteryLifeHours(6);
        laptop4.setInStock(false);
        laptop4.setStockQuantity(0);
        laptop4.setWarrantyMonths(24);

        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(laptop1);
        laptopList.add(laptop2);
        laptopList.add(laptop3);
        laptopList.add(laptop4);

        try {
            int[] acknowledge = laptopService.addLaptop(laptopList);
            for (int row: acknowledge) {
                System.out.println(row);
            }
        } catch (Exception e) {
            System.out.println("Error inserting laptop: " + e.getMessage());
        }
    }

    private void displayAllLaptops() {
        List<Laptop> laptops = laptopService.getAllLaptops();
        if (laptops.isEmpty()) {
            System.out.println("No laptops found in the database.");
        } else {
            System.out.println("\nAll Laptops:");
            printTableHeader();
            for (Laptop laptop : laptops) {
                printLaptopRow(laptop);
            }
            printTableFooter();
        }
    }

    private void displayAllLaptopProductInfo() {
        List<LaptopProductInfo> laptops = laptopService.getAllLaptopProductInfo();
        if (laptops.isEmpty()) {
            System.out.println("No laptops found in the database.");
        } else {
            System.out.println("\nAll Laptop Product Information:");
            printProductInfoTableHeader();
            for (LaptopProductInfo laptop : laptops) {
                printProductInfoRow(laptop);
            }
            printProductInfoTableFooter();
        }
    }

    private void printProductInfoTableHeader() {
        System.out.println("+-----+--------+--------+------------------+------------+--------------+---------------------------+------------------+-------------+-------------+");
        System.out.printf("| %-3s | %-6s | %-6s | %-16s | %-10s | %-12s | %-25s | %-16s | %-11s | %-11s |\n",
                "ID", "Brand", "Model", "Processor", "Memory", "Storage", "Display", "OS", "Price (₹)", "Availability");
        System.out.println("+-----+--------+--------+------------------+------------+--------------+---------------------------+------------------+-------------+-------------+");
    }

    private void printProductInfoRow(LaptopProductInfo laptop) {
        System.out.printf("| %-3d | %-6s | %-6s | %-16s | %-10s | %-12s | %-25s | %-16s | %-11.2f | %-11s |\n",
                laptop.getLaptopId(),
                truncate(laptop.getBrand(), 6),
                truncate(laptop.getModel(), 6),
                truncate(laptop.getProcessor(), 16),
                truncate(laptop.getMemory(), 10),
                truncate(laptop.getStorage(), 12),
                truncate(laptop.getDisplay(), 25),
                truncate(laptop.getOperatingSystem(), 16),
                laptop.getPriceRupees(),
                truncate(laptop.getAvailability(), 11));
    }

    private void printProductInfoTableFooter() {
        System.out.println("+-----+--------+--------+------------------+------------+--------------+---------------------------+------------------+-------------+-------------+");
    }


    private void printTableHeader() {
        System.out.println("+--------+--------+---------------+---------------+-------+-------------+--------+---------+-------------+------------+--------+-----------+--------+--------+--------+----------+--------+");
        System.out.printf("| %-6s | %-6s | %-13s | %-13s | %-5s | %-11s | %-6s | %-7s | %-11s | %-10s | %-6s | %-9s | %-6s | %-6s | %-6s | %-8s | %-6s |\n",
                "Brand", "Model", "Processor", "Proc. Model", "RAM", "Storage", "Screen", "Res.", "Graphics", "OS", "Weight", "Price", "Battery", "Stock", "Qty", "Warranty", "In Stock");
        System.out.println("+--------+--------+---------------+---------------+-------+-------------+--------+---------+-------------+------------+--------+-----------+--------+--------+--------+----------+--------+");
    }

    private void printLaptopRow(Laptop laptop) {
        System.out.printf("| %-6s | %-6s | %-13s | %-13s | %-5d | %-5s %-5d | %-6.1f | %-7s | %-11s | %-10s | %-6.2f | %-9.2f | %-6d | %-6b | %-6d | %-8d | %-6b |\n",
                truncate(laptop.getBrand(), 6),
                truncate(laptop.getModel(), 6),
                laptop.getProcessorBrand(),
                truncate(laptop.getProcessorModel(), 13),
                laptop.getRamGb(),
                laptop.getStorageType(),
                laptop.getStorageCapacityGb(),
                laptop.getScreenSizeInches(),
                truncate(laptop.getResolution(), 7),
                laptop.getGraphicsType(),
                truncate(laptop.getOperatingSystem(), 10),
                laptop.getWeightKg(),
                laptop.getPriceRupees(),
                laptop.getBatteryLifeHours(),
                laptop.isInStock(),
                laptop.getStockQuantity(),
                laptop.getWarrantyMonths(),
                laptop.isInStock());
    }

    private void printTableFooter() {
        System.out.println("+--------+--------+---------------+---------------+-------+-------------+--------+---------+-------------+------------+--------+-----------+--------+--------+--------+----------+--------+");
    }

    private String truncate(String str, int length) {
        if (str == null) return "";
        return str.length() <= length ? str : str.substring(0, length - 2) + "..";
    }
}
