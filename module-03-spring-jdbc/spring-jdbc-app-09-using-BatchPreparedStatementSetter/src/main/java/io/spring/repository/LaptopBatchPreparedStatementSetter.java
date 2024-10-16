package io.spring.repository;

import io.spring.model.Laptop;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LaptopBatchPreparedStatementSetter implements BatchPreparedStatementSetter {
    private List<Laptop> laptopList;

    public LaptopBatchPreparedStatementSetter(List<Laptop> laptopList) {
        this.laptopList = laptopList;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        Laptop laptop = this.laptopList.get(i);
        ps.setString(1, laptop.getBrand());
        ps.setString(2, laptop.getModel());
        ps.setString(3, String.valueOf(laptop.getProcessorBrand()));
        ps.setString(4, laptop.getProcessorModel());
        ps.setInt(5, laptop.getRamGb());
        ps.setString(6, String.valueOf(laptop.getStorageType()));
        ps.setInt(7, laptop.getStorageCapacityGb());
        ps.setDouble(8, laptop.getScreenSizeInches());
        ps.setString(9, laptop.getResolution());
        ps.setString(10, String.valueOf(laptop.getGraphicsType()));
        ps.setString(11, laptop.getGraphicsCard());
        ps.setString(12, laptop.getOperatingSystem());
        ps.setDouble(13, laptop.getWeightKg());
        ps.setDouble(14, laptop.getPriceRupees());
        ps.setInt(15, laptop.getBatteryLifeHours());
        ps.setBoolean(16, laptop.isInStock());
        ps.setInt(17, laptop.getStockQuantity());
        ps.setInt(18, laptop.getWarrantyMonths());
    }

    @Override
    public int getBatchSize() {
        return laptopList.size();
    }
}
