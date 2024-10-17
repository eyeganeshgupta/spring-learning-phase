package io.spring.repository;

import io.spring.model.Laptop;
import io.spring.model.LaptopProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LaptopRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public LaptopRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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

        String sqlQuery = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, in_stock, stock_quantity, warranty_months) values (:brand, :model, :processor_brand, :processor_model, :ram_gb, :storage_type, :storage_capacity_gb, :screen_size_inches, :resolution, :graphics_type, :graphics_card, :operating_system, :weight_kg, :price_rupees, :battery_life_hours, :in_stock, :stock_quantity, :warranty_months)";
        MapSqlParameterSource[] records = new MapSqlParameterSource[laptopList.size()];

        for (int i = 0; i < records.length; i++) {
            Laptop laptop = laptopList.get(i);

            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("brand", laptop.getBrand());
            params.addValue("model", laptop.getModel());
            params.addValue("processor_brand", laptop.getProcessorBrand());
            params.addValue("processor_model", laptop.getProcessorModel());
            params.addValue("ram_gb", laptop.getRamGb());
            params.addValue("storage_type", laptop.getStorageType());
            params.addValue("storage_capacity_gb", laptop.getStorageCapacityGb());
            params.addValue("screen_size_inches", laptop.getScreenSizeInches());
            params.addValue("resolution", laptop.getResolution());
            params.addValue("graphics_type", laptop.getGraphicsType());
            params.addValue("graphics_card", laptop.getGraphicsCard());
            params.addValue("operating_system", laptop.getOperatingSystem());
            params.addValue("weight_kg", laptop.getWeightKg());
            params.addValue("price_rupees", laptop.getPriceRupees());
            params.addValue("battery_life_hours", laptop.getBatteryLifeHours());
            params.addValue("in_stock", laptop.isInStock());
            params.addValue("stock_quantity", laptop.getStockQuantity());
            params.addValue("warranty_months", laptop.getWarrantyMonths());

            records[i] = params;
        }

        return namedParameterJdbcTemplate.batchUpdate(sqlQuery, records);
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
