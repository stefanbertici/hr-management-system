package bongo.employee;

import bongo.employee.models.AddModel;
import bongo.employee.models.UpdateModel;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Operation(operationId = "employees_getAll", description = "Returns a list of all employees without any pagination")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> getAll() { return employeeService.getAll(); }

    @Operation(operationId = "employees_get", description = "Returns an employee")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Employee> get(@PathVariable int id) {
        return employeeService.get(id);
    }

    @Operation(operationId = "employees_add", description = "Adds an employee to the system")
    @PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String add(@RequestBody AddModel model) {
        Employee employee = new Employee();
        employee.setFirstName(model.getFirstName());
        employee.setLastName(model.getLastName());
        employee.setRole(model.getRole());
        employee.setSalary(model.getSalary());
        employeeService.add(employee);
        return "Saved!";
    }

    @Operation(operationId = "employees_update", description = "Updates an employee with given information")
    @PutMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String update(@PathVariable int id, @RequestBody UpdateModel model) {
        Employee employee = new Employee();
        employee.setFirstName(model.getFirstName());
        employee.setLastName(model.getLastName());
        employee.setRole(model.getRole());
        employee.setSalary(model.getSalary());
        employee.setId(id);
        employeeService.update(employee);
        return "Updated!";
    }

    @Operation(operationId = "employees_delete", description = "Deletes an employee from the system")
    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "Deleted!";
    }
}
