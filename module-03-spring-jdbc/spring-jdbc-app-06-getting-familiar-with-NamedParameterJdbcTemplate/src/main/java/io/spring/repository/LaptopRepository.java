package io.spring.repository;

import io.spring.model.Laptop;
import io.spring.model.LaptopProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LaptopRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public LaptopRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insertLaptop(Laptop laptop) {
        String sql = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, " +
                "storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, " +
                "graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, " +
                "in_stock, stock_quantity, warranty_months) " +
                "VALUES (:brand, :model, :processorBrand, :processorModel, :ramGb, :storageType, " +
                ":storageCapacityGb, :screenSizeInches, :resolution, :graphicsType, :graphicsCard, " +
                ":operatingSystem, :weightKg, :priceRupees, :batteryLifeHours, :inStock, :stockQuantity, " +
                ":warrantyMonths)";

        Map<String, Object> params = new HashMap<>();
        params.put("brand", laptop.getBrand());
        params.put("model", laptop.getModel());
        params.put("processorBrand", laptop.getProcessorBrand().toString());
        params.put("processorModel", laptop.getProcessorModel());
        params.put("ramGb", laptop.getRamGb());
        params.put("storageType", laptop.getStorageType().toString());
        params.put("storageCapacityGb", laptop.getStorageCapacityGb());
        params.put("screenSizeInches", laptop.getScreenSizeInches());
        params.put("resolution", laptop.getResolution());
        params.put("graphicsType", laptop.getGraphicsType().toString());
        params.put("graphicsCard", laptop.getGraphicsCard());
        params.put("operatingSystem", laptop.getOperatingSystem());
        params.put("weightKg", laptop.getWeightKg());
        params.put("priceRupees", laptop.getPriceRupees());
        params.put("batteryLifeHours", laptop.getBatteryLifeHours());
        params.put("inStock", laptop.isInStock());
        params.put("stockQuantity", laptop.getStockQuantity());
        params.put("warrantyMonths", laptop.getWarrantyMonths());

        namedParameterJdbcTemplate.update(sql, params);
    }

    public List<Laptop> getAllLaptops() {
        String sql = "SELECT * FROM laptops";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Laptop.class));
    }

    public List<LaptopProductInfo> getAllLaptopProductInfo() {
        String sql = "SELECT " +
                "laptop_id, " +
                "brand, " +
                "model, " +
                "CONCAT(processor_brand, ' ', processor_model) AS processor, " +
                "CONCAT(ram_gb, 'GB RAM') AS memory, " +
                "CONCAT(storage_capacity_gb, 'GB ', storage_type) AS storage, " +
                "CONCAT(" +
                "screen_size_inches, '\" ', " +
                "CASE " +
                "WHEN graphics_type = 'Integrated' THEN 'Integrated Graphics' " +
                "ELSE 'Dedicated Graphics' " +
                "END" +
                ") AS display, " +
                "operating_system, " +
                "price_rupees, " +
                "CASE " +
                "WHEN in_stock = TRUE AND stock_quantity > 0 THEN 'In Stock' " +
                "ELSE 'Out of Stock' " +
                "END AS availability " +
                "FROM " +
                "laptops " +
                "ORDER BY " +
                "brand, price_rupees";

        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LaptopProductInfo.class));
    }
}