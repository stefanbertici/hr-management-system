package bongo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }
    public Iterable<Employee> getAllByTeamId(int id) {
        return employeeRepository.findByTeamId(id);
    }

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
