package io.spring.service;

import io.spring.dto.DepartmentDTO;
import io.spring.dto.EmployeeDTO;
import io.spring.entity.Department;
import io.spring.entity.Employee;
import io.spring.repository.DepartmentRepository;
import io.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    // 1. Create a new Department
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDto(savedDepartment);
    }

    // 2. Add an Employee to a Department
    public EmployeeDTO addEmployeeToDepartment(Long departmentId, EmployeeDTO employeeDTO) {
        Optional <Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            Employee employee = convertToEntity(employeeDTO);

            department.addEmployee(employee); // Add employee to the department
            employee.setDepartment(department); // Set bidirectional relationship

            departmentRepository.save(department); // Saving department (cascades to Employee)

            return convertToDto(employee);
        } else {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }
    }

    // 3. Retrieve all Departments along with their Employees
    public List <DepartmentDTO> getAllDepartments() {
        List <Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 4. Update the name of an Employee
    public EmployeeDTO updateEmployeeName(Long employeeId, String newName) {
        Optional <Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(newName);
            Employee updatedEmployee = employeeRepository.save(employee);
            return convertToDto(updatedEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }

    // 5. Update the name of a Department
    public DepartmentDTO updateDepartmentName(Long departmentId, String newName) {
        Optional <Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(newName);
            Department updatedDepartment = departmentRepository.save(department);
            return convertToDto(updatedDepartment);
        } else {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }
    }

    // 6. Remove an Employee from a Department
    public void removeEmployeeFromDepartment(Long employeeId) {
        Optional <Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Department department = employee.getDepartment();
            if (department != null) {
                department.removeEmployee(employee); // Remove from department's list
                employee.setDepartment(null); // Break bidirectional relationship

                // For consistency amongst JPA and SQL
                departmentRepository.save(department);

                employeeRepository.delete(employee); // Delete the employee record
            } else {
                throw new RuntimeException("The specified employee does not belong to any department.");
            }
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }

    // 7. Delete a Department along with all its Employees
    public void deleteDepartment(Long departmentId) {
        Optional <Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            departmentRepository.delete(optionalDepartment.get()); // Cascade deletes employees as well
        } else {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }
    }

    // 8. Change an Employee's Department
    public EmployeeDTO changeEmployeeDepartment(Long employeeId, Long newDepartmentId) {
        // Check if the employee exists
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (!optionalEmployee.isPresent()) {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }

        // Check if the target department exists
        Optional<Department> optionalNewDepartment = departmentRepository.findById(newDepartmentId);
        if (!optionalNewDepartment.isPresent()) {
            throw new RuntimeException("Department not found with ID: " + newDepartmentId);
        }

        Employee employee = optionalEmployee.get();
        Department currentDepartment = employee.getDepartment();
        Department newDepartment = optionalNewDepartment.get();

        // Remove the employee from their current department (if any)
        if (currentDepartment != null) {
            currentDepartment.removeEmployee(employee);
            departmentRepository.save(currentDepartment); // Save changes to current department
        }

        // Add the employee to the new department
        newDepartment.addEmployee(employee);
        employee.setDepartment(newDepartment); // Update bidirectional relationship

        // Save changes to both entities
        departmentRepository.save(newDepartment); // Save changes to new department
        Employee updatedEmployee = employeeRepository.save(employee); // Save updated employee

        return convertToDto(updatedEmployee);
    }

    // Utility: Convert Entity to DTO (for Department)
    private DepartmentDTO convertToDto(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setLocation(department.getLocation());

        List <EmployeeDTO> employees = department.getEmployees().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        dto.setEmployees(employees);

        return dto;
    }

    // Utility: Convert Entity to DTO (for Employee)
    private EmployeeDTO convertToDto(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setGender(employee.getGender());
        dto.setSalary(employee.getSalary());
        dto.setRole(employee.getRole());
        dto.setDepartmentId(employee.getDepartment() != null ? employee.getDepartment().getId() : null);
        return dto;
    }

    // Utility: Convert DTO to Entity (for Department)
    private Department convertToEntity(DepartmentDTO dto) {
        Department department = new Department();
        department.setId(dto.getId());
        department.setName(dto.getName());
        department.setLocation(dto.getLocation());

        if (dto.getEmployees() != null) {
            List <Employee> employees = dto.getEmployees().stream()
                    .map(this::convertToEntity)
                    .collect(Collectors.toList());
            department.setEmployees(employees);
        }

        return department;
    }

    // Utility: Convert DTO to Entity (for Employee)
    private Employee convertToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setGender(dto.getGender());
        employee.setSalary(dto.getSalary());
        employee.setRole(dto.getRole());

        if (dto.getDepartmentId() != null) {
            Optional <Department> optionalDepartment = departmentRepository.findById(dto.getDepartmentId());
            optionalDepartment.ifPresent(employee::setDepartment);
        }

        return employee;
    }
}
