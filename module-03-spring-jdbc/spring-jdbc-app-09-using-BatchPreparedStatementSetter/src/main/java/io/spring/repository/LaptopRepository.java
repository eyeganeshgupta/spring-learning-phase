package io.spring.repository;

import io.spring.model.Laptop;
import io.spring.model.LaptopProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LaptopRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LaptopRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int[] save(List<Laptop> laptopList) {
        /*
        String sqlQuery01 = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) VALUES\n" +
                "('Sony', 'VAIO Z', 'Intel', 'Core i7-11375H', 16, 'SSD', 1, 14.0, '1920x1200', 'Integrated', 'Intel Iris Xe', 'Windows 10', 1.1, 160000.00, 10, TRUE, 5, 24)";

        String sqlQuery02 = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) VALUES\n" +
                "('Acer', 'Aspire 7', 'AMD', 'Ryzen 5 3550H', 8, 'SSD', 512, 15.6, '1920x1080', 'Dedicated', 'NVIDIA GTX 1650', 'Windows 10', 2.2, 60000.00, 6, TRUE, 15, 12)";

        String sqlQuery03 = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) VALUES\n" +
                "('Dell', 'Latitude 7420', 'Intel', 'Core i7-1185G7', 16, 'SSD', 1, 14.0, '1920x1200', 'Integrated', 'Intel Iris Xe', 'Windows 10', 1.3, 130000.00, 12, TRUE, 10, 24)";

        int[] acknowledge = jdbcTemplate.batchUpdate(sqlQuery01, sqlQuery02, sqlQuery03);

        for (int i = 0; i < acknowledge.length; i++) {
            System.out.println("Query " + (i + 1) + " affected " + acknowledge[i] + " row(s).");
        }
         */

        String sqlQuery = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.batchUpdate(sqlQuery, new LaptopBatchPreparedStatementSetter(laptopList));
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
