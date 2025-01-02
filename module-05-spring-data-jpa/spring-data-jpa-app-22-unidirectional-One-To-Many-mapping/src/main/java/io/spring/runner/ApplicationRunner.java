package io.spring.runner;

import io.spring.dto.DepartmentDTO;
import io.spring.dto.EmployeeDTO;
import io.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final DepartmentService departmentService;

    @Autowired
    public ApplicationRunner(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Creating a new Department with multiple Employees
        System.out.println("Creating a new Department...");

        EmployeeDTO emp1 = new EmployeeDTO();
        emp1.setName("Ganesh Gupta");
        emp1.setEmail("eyeganeshgupta@gmail.com");
        emp1.setPhone("8983971752");
        emp1.setGender("Male");
        emp1.setSalary(75000.0);
        emp1.setRole("Software Engineer");

        EmployeeDTO emp2 = new EmployeeDTO();
        emp2.setName("Ryan Reynolds");
        emp2.setEmail("ryan.reynolds@gmail.com");
        emp2.setPhone("9876543211");
        emp2.setGender("Female");
        emp2.setSalary(85000.0);
        emp2.setRole("Team Lead");

        DepartmentDTO dept1 = new DepartmentDTO();
        dept1.setName("Technology");
        dept1.setLocation("Bangalore");

        List<EmployeeDTO> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        dept1.setEmployees(employees);

        // Saving the department
        dept1 = departmentService.createDepartment(dept1);

        System.out.println("Created: \n" + dept1);

        // 2. Retrieve all Departments along with their Employees
        System.out.println("\nRetrieving all Departments...");
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        departments.forEach(System.out::println);

        // 3. Updating the name of a Department
        System.out.println("\nUpdating the name of the Technology Department...");
        dept1 = departmentService.updateDepartmentName(dept1.getId(), "Information Technology");
        System.out.println("Updated: \n" + dept1);

        // 4. Adding a new Employee to an existing Department
        System.out.println("\nAdding a new Employee to the Information Technology Department...");

        EmployeeDTO emp3 = new EmployeeDTO();
        emp3.setName("Ravi Kumar");
        emp3.setEmail("ravi.kumar@example.com");
        emp3.setPhone("9876543212");
        emp3.setGender("Male");
        emp3.setSalary(65000.0);
        emp3.setRole("Analyst");

        dept1 = departmentService.addEmployeeToDepartment(dept1.getId(), emp3);
        System.out.println("After Adding Employee: \n" + dept1);

        // 5. Removing an Employee from the IT Department
        System.out.println("\nRemoving an Employee from the IT Department...");

        dept1 = departmentService.removeEmployeeFromDepartment(dept1.getId(), emp2.getId());

        System.out.println("After Removing Employee: \n" + dept1);

        // 6. Deleting a Department along with all its Employees
        System.out.println("\nDeleting the IT Department...");

        departmentService.deleteDepartment(dept1.getId());

        System.out.println("Deleted the IT Department.");

        System.out.println("\nFinal List of Departments:");

        departments = departmentService.getAllDepartments();

        departments.forEach(System.out::println);
    }
}
