package io.spring.service;

import io.spring.model.Laptop;
import io.spring.repository.LaptopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public void addLaptop(Laptop laptop) {
        laptopRepository.insertLaptop(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.getAllLaptops();
    }
}
