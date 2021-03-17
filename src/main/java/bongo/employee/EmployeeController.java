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
    public @ResponseBody String add(@PathVariable int id, @RequestBody Employee employee) {
        employee.setTeam(new Team(id));
        employeeService.add(employee);
        return "Saved!";
    }

    @GetMapping(path = "/employees")
    public @ResponseBody Iterable<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping(path = "employees/{id}")
    public @ResponseBody Optional<Employee> get(@PathVariable int id) {
        return employeeService.get(id);
    }

    @GetMapping(path = "/teams/{id}/employees")
    public @ResponseBody Iterable<Employee> getAllOfTeam(@PathVariable int id) {
        return employeeService.getAllByTeamId(id);
    }

    @PutMapping(path = "/teams/{teamId}/employees/{id}")
    public @ResponseBody String update(@PathVariable int teamId, @PathVariable int id, @RequestBody Employee employee) {
        Team team = new Team(teamId);
        employee.setTeam(team);
        employee.setId(id);
        employeeService.update(employee);
        return "Updated!";
    }

    @DeleteMapping(path = "employees/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "Deleted!";
    }
}
