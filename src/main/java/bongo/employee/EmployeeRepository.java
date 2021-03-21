package bongo.employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public Iterable<Employee> findByTeamId(int teamId);
}
