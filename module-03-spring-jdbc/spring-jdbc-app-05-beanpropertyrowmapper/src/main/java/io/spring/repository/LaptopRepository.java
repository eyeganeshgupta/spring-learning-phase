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

    public void insertLaptop(Laptop laptop) {
        String sql = "INSERT INTO laptops (brand, model, processor_brand, processor_model, ram_gb, " +
                "storage_type, storage_capacity_gb, screen_size_inches, resolution, graphics_type, " +
                "graphics_card, operating_system, weight_kg, price_rupees, battery_life_hours, " +
                "in_stock, stock_quantity, warranty_months) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                laptop.getBrand(),
                laptop.getModel(),
                laptop.getProcessorBrand().toString(),
                laptop.getProcessorModel(),
                laptop.getRamGb(),
                laptop.getStorageType().toString(),
                laptop.getStorageCapacityGb(),
                laptop.getScreenSizeInches(),
                laptop.getResolution(),
                laptop.getGraphicsType().toString(),
                laptop.getGraphicsCard(),
                laptop.getOperatingSystem(),
                laptop.getWeightKg(),
                laptop.getPriceRupees(),
                laptop.getBatteryLifeHours(),
                laptop.isInStock(),
                laptop.getStockQuantity(),
                laptop.getWarrantyMonths()
        );
    }

    public List<Laptop> getAllLaptops() {
        String sql = "SELECT * FROM laptops";
        /* return jdbcTemplate.query(sql, new LaptopRowMapper()); */
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Laptop>(Laptop.class));
    }

    /*
    private static class LaptopRowMapper implements RowMapper<Laptop> {
        @Override
        public Laptop mapRow(ResultSet rs, int rowNum) throws SQLException {
            Laptop laptop = new Laptop();
            laptop.setLaptopId(rs.getInt("laptop_id"));
            laptop.setBrand(rs.getString("brand"));
            laptop.setModel(rs.getString("model"));
            laptop.setProcessorBrand(ProcessorBrand.valueOf(rs.getString("processor_brand")));
            laptop.setProcessorModel(rs.getString("processor_model"));
            laptop.setRamGb(rs.getInt("ram_gb"));
            laptop.setStorageType(StorageType.valueOf(rs.getString("storage_type")));
            laptop.setStorageCapacityGb(rs.getInt("storage_capacity_gb"));
            laptop.setScreenSizeInches(rs.getDouble("screen_size_inches"));
            laptop.setResolution(rs.getString("resolution"));
            laptop.setGraphicsType(GraphicsType.valueOf(rs.getString("graphics_type")));
            laptop.setGraphicsCard(rs.getString("graphics_card"));
            laptop.setOperatingSystem(rs.getString("operating_system"));
            laptop.setWeightKg(rs.getDouble("weight_kg"));
            laptop.setPriceRupees(rs.getDouble("price_rupees"));
            laptop.setBatteryLifeHours(rs.getInt("battery_life_hours"));
            laptop.setInStock(rs.getBoolean("in_stock"));
            laptop.setStockQuantity(rs.getInt("stock_quantity"));
            laptop.setWarrantyMonths(rs.getInt("warranty_months"));
            return laptop;
        }
    }
    */

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

        /* return jdbcTemplate.query(sql, new LaptopProductInfoRowMapper()); */
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<LaptopProductInfo>(LaptopProductInfo.class));
    }

    /*
    private static class LaptopProductInfoRowMapper implements RowMapper<LaptopProductInfo> {
        @Override
        public LaptopProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            LaptopProductInfo laptopInfo = new LaptopProductInfo();
            laptopInfo.setLaptopId(rs.getInt("laptop_id"));
            laptopInfo.setBrand(rs.getString("brand"));
            laptopInfo.setModel(rs.getString("model"));
            laptopInfo.setProcessor(rs.getString("processor"));
            laptopInfo.setMemory(rs.getString("memory"));
            laptopInfo.setStorage(rs.getString("storage"));
            laptopInfo.setDisplay(rs.getString("display"));
            laptopInfo.setOperatingSystem(rs.getString("operating_system"));
            laptopInfo.setPriceRupees(rs.getDouble("price_rupees"));
            laptopInfo.setAvailability(rs.getString("availability"));
            return laptopInfo;
        }
    }
    */
}
