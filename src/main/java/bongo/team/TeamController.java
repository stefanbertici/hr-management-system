package bongo.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping(path = "/teams")
    public @ResponseBody String add(@RequestBody Team team) {
        teamService.add(team);
        return "Saved! " + team.getTeamName() + " has the id: " + team.getId();
    }

    @GetMapping(path = "/teams")
    public @ResponseBody Iterable<Team> getAll() {
        return teamService.getAll();
    }

    @GetMapping(path = "/teams/{id}")
    public @ResponseBody Optional<Team> get(@PathVariable int id) {
        return teamService.get(id);
    }

    @PutMapping(path = "/teams/{id}")
    public @ResponseBody String update(@PathVariable int id, @RequestBody Team team) {
        team.setId(id);
        teamService.update(team);
        return "Updated!";
    }

    @DeleteMapping(path = "/teams/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        teamService.delete(id);
        return "Deleted!";
    }
}
