package io.spring.runner;

import io.spring.enums.GraphicsType;
import io.spring.enums.ProcessorBrand;
import io.spring.enums.StorageType;
import io.spring.model.Laptop;
import io.spring.service.LaptopService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class LaptopDataEntryRunner implements CommandLineRunner {

    private final LaptopService laptopService;

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
            System.out.println("3. Exit");
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
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void enterLaptopDetails(Scanner scanner) {
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
