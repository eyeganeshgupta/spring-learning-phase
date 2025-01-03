package io.spring.service;

import io.spring.dto.DepartmentDTO;
import io.spring.dto.EmployeeDTO;
import io.spring.entity.Department;
import io.spring.entity.Employee;
import io.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Creating a new Department with multiple Employees
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDto(savedDepartment);
    }

    // Retrieving all Departments along with their Employees
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Updating the name of a Department
    public DepartmentDTO updateDepartmentName(Long departmentId, String newName) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(newName);
            Department updatedDepartment = departmentRepository.save(department);
            return convertToDto(updatedDepartment);
        } else {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }
    }

    // Adding a new Employee to an existing Department
    public DepartmentDTO addEmployeeToDepartment(Long departmentId, EmployeeDTO employeeDTO) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            Employee employee = convertToEntity(employeeDTO);
            department.addEmployee(employee);
            Department updatedDepartment = departmentRepository.save(department);
            return convertToDto(updatedDepartment);
        } else {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }
    }

    // Removing an Employee from a Department
    public DepartmentDTO removeEmployeeFromDepartment(Long departmentId, Long employeeId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            boolean removed = department.removeEmployeeById(employeeId);

            if (removed) {
                Department updatedDepartment = departmentRepository.save(department);
                return convertToDto(updatedDepartment);
            } else {
                throw new RuntimeException("Employee not found in the specified Department.");
            }
        } else {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }
    }

    // Deleting a Department along with all its Employees
    public void deleteDepartment(Long departmentId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            departmentRepository.delete(optionalDepartment.get());
        } else {
            throw new RuntimeException("Department not found with ID: " + departmentId);
        }
    }

    // Utility: Converting Entity to DTO
    private DepartmentDTO convertToDto(Department department) {
        DepartmentDTO dto = new DepartmentDTO();

        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setLocation(department.getLocation());

        List<EmployeeDTO> employeeDtos = department.getEmployees().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        dto.setEmployees(employeeDtos);

        return dto;
    }

    // Utility: Converting DTO to Entity
    private Department convertToEntity(DepartmentDTO dto) {
        Department entity = new Department();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());

        List<Employee> employees = dto.getEmployees().stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        entity.setEmployees(employees);

        return entity;
    }

    // Utility: Converting Employee Entity to DTO
    private EmployeeDTO convertToDto(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setGender(employee.getGender());
        dto.setSalary(employee.getSalary());
        dto.setRole(employee.getRole());

        return dto;
    }

    // Utility: Converting Employee DTO to Entity
    private Employee convertToEntity(EmployeeDTO dto) {
        Employee entity = new Employee();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setGender(dto.getGender());
        entity.setSalary(dto.getSalary());
        entity.setRole(dto.getRole());

        return entity;
    }
}
