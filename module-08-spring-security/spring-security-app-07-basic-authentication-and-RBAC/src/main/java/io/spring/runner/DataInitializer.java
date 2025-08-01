package io.spring.runner;

import io.spring.entity.Category;
import io.spring.entity.Role;
import io.spring.entity.User;
import io.spring.repository.CategoryRepository;
import io.spring.repository.RoleRepository;
import io.spring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, CategoryRepository categoryRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElse(new Role("ROLE_ADMIN"));
        Role managerRole = roleRepository.findByName("ROLE_MANAGER").orElse(new Role("ROLE_MANAGER"));
        Role employeeRole = roleRepository.findByName("ROLE_EMPLOYEE").orElse(new Role("ROLE_EMPLOYEE"));
        roleRepository.saveAll(List.of(adminRole, managerRole, employeeRole));

        Category electronics = categoryRepository.findByName("Electronics").orElse(new Category("Electronics"));
        Category furniture = categoryRepository.findByName("Furniture").orElse(new Category("Furniture"));
        categoryRepository.saveAll(List.of(electronics, furniture));

        if (!userRepository.existsByUsername("admin")) {
            User admin = new User("admin", passwordEncoder.encode("admin123"), new HashSet<>(Set.of(adminRole)));
            userRepository.save(admin);
        }

        if (!userRepository.existsByUsername("manager")) {
            User manager = new User("manager", passwordEncoder.encode("manager123"), new HashSet<>(Set.of(managerRole)));
            userRepository.save(manager);
        }

        if (!userRepository.existsByUsername("employee")) {
            User employee = new User("employee", passwordEncoder.encode("employee123"), new HashSet<>(Set.of(employeeRole)));
            userRepository.save(employee);
        }
    }
}
