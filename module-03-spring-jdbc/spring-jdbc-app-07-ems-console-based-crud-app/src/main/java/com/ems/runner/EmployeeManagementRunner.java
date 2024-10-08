package com.ems.runner;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class EmployeeManagementRunner implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeManagementRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewEmployee(scanner);
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    listAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n--- Employee Management System ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. List All Employees");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addEmployee(Scanner scanner) {
        Employee newEmployee = new Employee();
        System.out.print("Enter First Name: ");
        newEmployee.setFirstName(scanner.nextLine());
        System.out.print("Enter Last Name: ");
        newEmployee.setLastName(scanner.nextLine());
        System.out.print("Enter Email: ");
        newEmployee.setEmail(scanner.nextLine());
        System.out.print("Enter Phone Number: ");
        newEmployee.setPhoneNumber(scanner.nextLine());
        System.out.print("Enter Job Title: ");
        newEmployee.setJobTitle(scanner.nextLine());
        System.out.print("Enter Department: ");
        newEmployee.setDepartment(scanner.nextLine());
        System.out.print("Enter Salary: ");
        newEmployee.setSalary(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Enter Gender (Male, Female, Other): ");
        newEmployee.setGender(scanner.nextLine());
        System.out.print("Enter Address: ");
        newEmployee.setAddress(scanner.nextLine());
        System.out.print("Enter City: ");
        newEmployee.setCity(scanner.nextLine());
        System.out.print("Enter Country: ");
        newEmployee.setCountry(scanner.nextLine());
        System.out.print("Enter Postal Code: ");
        newEmployee.setPostalCode(scanner.nextLine());
        System.out.print("Enter Emergency Contact Phone: ");
        newEmployee.setEmergencyContactPhone(scanner.nextLine());
        System.out.print("Enter Employment Status (Full-time, Part-time, Contract, Intern): ");
        newEmployee.setEmploymentStatus(scanner.nextLine());

        employeeService.createEmployee(newEmployee);
        System.out.println("Employee added successfully!");
    }

    private void viewEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int viewId = scanner.nextInt();
        Employee employee = employeeService.getEmployeeById(viewId);
        if (employee != null) {
            printTableHeader();
            printEmployeeRow(employee);
            printTableFooter();
        } else {
            System.out.println("Employee not found!");
        }
    }

    private void updateEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();
        Employee updateEmployee = employeeService.getEmployeeById(updateId);
        if (updateEmployee != null) {
            System.out.print("Enter First Name: ");
            updateEmployee.setFirstName(scanner.nextLine());
            System.out.print("Enter Last Name: ");
            updateEmployee.setLastName(scanner.nextLine());
            System.out.print("Enter Email: ");
            updateEmployee.setEmail(scanner.nextLine());
            System.out.print("Enter Phone Number: ");
            updateEmployee.setPhoneNumber(scanner.nextLine());
            System.out.print("Enter Job Title: ");
            updateEmployee.setJobTitle(scanner.nextLine());
            System.out.print("Enter Department: ");
            updateEmployee.setDepartment(scanner.nextLine());
            System.out.print("Enter Salary: ");
            updateEmployee.setSalary(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Enter Gender (Male, Female, Other): ");
            updateEmployee.setGender(scanner.nextLine());
            System.out.print("Enter Address: ");
            updateEmployee.setAddress(scanner.nextLine());
            System.out.print("Enter City: ");
            updateEmployee.setCity(scanner.nextLine());
            System.out.print("Enter Country: ");
            updateEmployee.setCountry(scanner.nextLine());
            System.out.print("Enter Postal Code: ");
            updateEmployee.setPostalCode(scanner.nextLine());
            System.out.print("Enter Emergency Contact Phone: ");
            updateEmployee.setEmergencyContactPhone(scanner.nextLine());
            System.out.print("Enter Employment Status (Full-time, Part-time, Contract, Intern): ");
            updateEmployee.setEmploymentStatus(scanner.nextLine());

            employeeService.updateEmployee(updateEmployee);
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private void deleteEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to delete: ");
        int deleteId = scanner.nextInt();
        employeeService.deleteEmployee(deleteId);
        System.out.println("Employee deleted successfully!");
    }

    private void listAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            printTableHeader();
            for (Employee emp : employees) {
                printEmployeeRow(emp);
            }
            printTableFooter();
        }
    }

    private void printTableHeader() {
        System.out.printf("%-15s %-15s %-30s %-15s %-20s %-15s %-10s %-10s\n",
                "First Name", "Last Name", "Email", "Phone Number", "Job Title", "Department", "Salary", "Status");
        System.out.println("---------------------------------------------------------------------");
    }

    private void printEmployeeRow(Employee emp) {
        System.out.printf("%-15s %-15s %-30s %-15s %-20s %-15s ₹%-10.2f %s\n",
                emp.getFirstName(), emp.getLastName(), emp.getEmail(),
                emp.getPhoneNumber(), emp.getJobTitle(), emp.getDepartment(),
                emp.getSalary(), emp.getEmploymentStatus());
    }

    private void printTableFooter() {
        System.out.println("---------------------------------------------------------------------");
    }
}
