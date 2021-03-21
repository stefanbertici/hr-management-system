package bongo.team;

import bongo.employee.Employee;
import bongo.team.models.AddModel;
import bongo.team.models.UpdateModel;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Operation(operationId = "teams_getAll", description = "Returns a list of all teams without any pagination")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Team> getAll() {
        return teamService.getAll();
    }

    @Operation(operationId = "teams_get", description = "Returns a team")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Team> get(@PathVariable int id) {
        return teamService.get(id);
    }

    @Operation(operationId = "teams_getMembers", description = "Returns a list of employees belonging to the team")
    @GetMapping(path = "/{id}/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> getMembers(@PathVariable int id) {
        return teamService.getAllMembers(id);
    }

    @Operation(operationId = "teams_add", description = "Adds a team to the system")
    @PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String add(@RequestBody AddModel model) {
        Team team = new Team();
        team.setName(model.getName());
        teamService.add(team);
        return "Saved! " + team.getName() + " has the id: " + team.getId();
    }

    @Operation(operationId = "teams_update", description = "Updates a team with given information")
    @PutMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String update(@PathVariable int id, @RequestBody UpdateModel model) {
        Team team = new Team();
        team.setId(id);
        team.setName(model.getName());
        teamService.update(team);
        return "Updated!";
    }

    @Operation(operationId = "teams_delete", description = "Deletes a team from the system")
    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String delete(@PathVariable int id) {
        teamService.delete(id);
        return "Deleted!";
    }
}
