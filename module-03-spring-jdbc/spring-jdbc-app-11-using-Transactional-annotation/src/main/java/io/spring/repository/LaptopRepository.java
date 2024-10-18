package io.spring.repository;

import io.spring.model.Laptop;
import io.spring.model.LaptopProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LaptopRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LaptopRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertLaptop() {
        String sqlQuery01 = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) VALUES\n" +
                "('HP', 'Spectre x360', 'Intel', 'Core i5-1135G7', 8, 'SSD', 512, 13.3, '1920x1080', 'Integrated', 'Intel Iris Xe', 'Windows 11', 1.3, 120000.00, 11, TRUE, 8, 24)";

        String sqlQuery02 = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) VALUES\n" +
                "('Lenovo', 'Legion 5', 'AMD', 'Ryzen 7 4800H', 16, 'SSD', 1, 15.6, '2560x1440', 'Dedicated', 'NVIDIA RTX 3060', 'Windows 11', 2.3, 140000.00, 8, TRUE, 7, 12)";

        String sqlQuery03 = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) VALUES\n" +
                "('Apple', 'MacBook Air', 'Apple', 'M1', 8, 'SSD', 256, 13.3, '2560x1600', 'Integrated', 'Apple M1 GPU', 'macOS', 1.29, 92000.00, 18, TRUE, 12, 12)";

        int[] acknowledge = jdbcTemplate.batchUpdate(sqlQuery01, sqlQuery02, sqlQuery03);

        for (int i = 0; i < acknowledge.length; i++) {
            System.out.println("Query " + (i + 1) + " affected " + acknowledge[i] + " row(s).");
        }
    }

    public List<Laptop> getAllLaptops() {
        String sql = "SELECT * FROM laptops";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Laptop.class));
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

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LaptopProductInfo.class));
    }
}
