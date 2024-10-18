package io.spring.service;

import io.spring.model.Laptop;
import io.spring.model.LaptopProductInfo;
import io.spring.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public void addLaptop() {
        laptopRepository.insertLaptop();
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.getAllLaptops();
    }

    public List<LaptopProductInfo> getAllLaptopProductInfo() {
        return laptopRepository.getAllLaptopProductInfo();
    }
}
