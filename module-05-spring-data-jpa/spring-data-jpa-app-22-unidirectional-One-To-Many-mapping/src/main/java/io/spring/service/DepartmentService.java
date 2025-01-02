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
        List<EmployeeDTO> employeeDtos = department.getEmployees().stream()
                .map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getEmail(), emp.getPhone(),
                        emp.getGender(), emp.getSalary(), emp.getRole()))
                .collect(Collectors.toList());

        return new DepartmentDTO(department.getId(), department.getName(), department.getLocation(), employeeDtos);
    }

    // Utility: Converting DTO to Entity
    private Department convertToEntity(DepartmentDTO dto) {
        List<Employee> employees = dto.getEmployees().stream()
                .map(empDto -> new Employee(empDto.getId(), empDto.getName(), empDto.getEmail(),
                        empDto.getPhone(), empDto.getGender(), empDto.getSalary(), empDto.getRole()))
                .collect(Collectors.toList());

        return new Department(dto.getId(), dto.getName(), dto.getLocation(), employees);
    }

    // Utility: Converting Employee DTO to Entity
    private Employee convertToEntity(EmployeeDTO dto) {
        return new Employee(dto.getId(), dto.getName(), dto.getEmail(), dto.getPhone(),
                dto.getGender(), dto.getSalary(), dto.getRole());
    }
}
