package bongo.employee;

import bongo.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    bongo.employee.EmployeeService employeeService;

    @PostMapping(path = "/teams/{id}/employees")
    public @ResponseBody String addEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setTeam(new Team(id));
        employeeService.addEmployee(employee);
        return "Saved!";
    }

    @GetMapping(path = "/employees")
    public @ResponseBody Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "employees/{id}")
    public @ResponseBody Optional<Employee> getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping(path = "/teams/{id}/employees")
    public @ResponseBody Iterable<Employee> getAllEmployees(@PathVariable int id) {
        return employeeService.getAllEmployees(id);
    }

    @PutMapping(path = "/teams/{teamId}/employees/{id}")
    public @ResponseBody String updateEmployee(@PathVariable int teamId, @PathVariable int id, @RequestBody Employee employee) {
        Team team = new Team(teamId);
        employee.setTeam(team);
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "Updated!";
    }

    @DeleteMapping(path = "employees/{id}")
    public @ResponseBody String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Deleted!";
    }
}
