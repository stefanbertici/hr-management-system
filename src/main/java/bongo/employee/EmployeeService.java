package bongo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAll() { return (List<Employee>)employeeRepository.findAll(); }

    public Optional<Employee> get(int id) {
        return employeeRepository.findById(id);
    }

    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
