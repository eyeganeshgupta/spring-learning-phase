package io.spring.runner;

import io.spring.dto.DepartmentDTO;
import io.spring.dto.EmployeeDTO;
import io.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final DepartmentService departmentService;
    @Autowired
    public ApplicationRunner(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n=========================================");
            System.out.println("       DEPARTMENT MANAGEMENT SYSTEM      ");
            System.out.println("=========================================");
            System.out.println("1. Create a new Department");
            System.out.println("2. Add an Employee to a Department");
            System.out.println("3. Retrieve all Departments with Employees");
            System.out.println("4. Update the name of an Employee");
            System.out.println("5. Update the name of a Department");
            System.out.println("6. Remove an Employee from a Department");
            System.out.println("7. Delete a Department with all its Employees");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createDepartment(scanner);
                    break;
                case 2:
                    addEmployeeToDepartment(scanner);
                    break;
                case 3:
                    retrieveAllDepartments();
                    break;
                case 4:
                    updateEmployeeName(scanner);
                    break;
                case 5:
                    updateDepartmentName(scanner);
                    break;
                case 6:
                    removeEmployeeFromDepartment(scanner);
                    break;
                case 7:
                    deleteDepartment(scanner);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        } while (true);
    }

    private void createDepartment(Scanner scanner) {
        System.out.print("\nEnter Department Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department Location: ");
        String location = scanner.nextLine();

        DepartmentDTO deptDto = new DepartmentDTO();
        deptDto.setName(name);
        deptDto.setLocation(location);

        try {
            DepartmentDTO savedDept = departmentService.createDepartment(deptDto);
            System.out.println("\nDepartment created successfully!");
            System.out.println(savedDept);
        } catch (Exception e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }

    private void addEmployeeToDepartment(Scanner scanner) {
        System.out.print("\nEnter Department ID: ");
        Long departmentId = scanner.nextLong();
        scanner.nextLine(); //Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Employee Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Employee Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        Double salary = scanner.nextDouble();
        scanner.nextLine(); //Consume newline

        System.out.print("Enter Employee Role: ");
        String role = scanner.nextLine();

        EmployeeDTO empDto = new EmployeeDTO();
        empDto.setName(name);
        empDto.setEmail(email);
        empDto.setPhone(phone);
        empDto.setGender(gender);
        empDto.setSalary(salary);
        empDto.setRole(role);

        try {
            EmployeeDTO savedEmp = departmentService.addEmployeeToDepartment(departmentId, empDto);
            System.out.println("\nEmployee added successfully!");
            System.out.println(savedEmp);
        } catch (Exception e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }

    private void retrieveAllDepartments() {
        try {
            List <DepartmentDTO> departments = departmentService.getAllDepartments();
            if (departments.isEmpty()) {
                System.out.println("\nNo departments found.");
            } else {
                for (DepartmentDTO department: departments) {
                    department.printSummary();
                }
            }
        } catch (Exception e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }

    private void updateEmployeeName(Scanner scanner) {
        System.out.print("\nEnter Employee ID: ");
        Long employeeId = scanner.nextLong();
        scanner.nextLine(); //Consume newline

        System.out.print("Enter New Name for the Employee: ");
        String newName = scanner.nextLine();

        try {
            EmployeeDTO updatedEmp = departmentService.updateEmployeeName(employeeId, newName);
            System.out.println("\nEmployee updated successfully!");
            System.out.println(updatedEmp);
        } catch (Exception e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }

    private void updateDepartmentName(Scanner scanner) {
        System.out.print("\nEnter Department ID: ");
        Long departmentId = scanner.nextLong();
        scanner.nextLine(); //Consume newline

        System.out.print("Enter New Name for the Department: ");
        String newName = scanner.nextLine();

        try {
            DepartmentDTO updatedDept = departmentService.updateDepartmentName(departmentId, newName);
            System.out.println("\nDepartment updated successfully!");
            System.out.println(updatedDept);
        } catch (Exception e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }

    private void removeEmployeeFromDepartment(Scanner scanner) {
        System.out.print("\nEnter Employee ID to Remove: ");
        Long employeeId = scanner.nextLong();

        try {
            departmentService.removeEmployeeFromDepartment(employeeId);
            System.out.println("\nEmployee removed successfully!");
        } catch (Exception e) {
            System.err.println("\nError:" + e.getMessage());
        }
    }

    private void deleteDepartment(Scanner scanner) {
        System.out.print("\nEnter Department ID to Delete: ");
        Long departmentId = scanner.nextLong();

        try {
            departmentService.deleteDepartment(departmentId);
            System.out.println("\nDepartment deleted successfully!");
        } catch (Exception e) {
            System.err.println("\nError:" + e.getMessage());
        }
    }
}
