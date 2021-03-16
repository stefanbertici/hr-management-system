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
    public @ResponseBody String addTeams(@RequestBody Team team) {
        teamService.addTeam(team);
        return "Saved!";
    }

    @GetMapping(path = "/teams")
    public @ResponseBody Iterable<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping(path = "/teams/{id}")
    public @ResponseBody Optional<Team> getTeam(@PathVariable int id) {
        return teamService.getTeam(id);
    }

    @PutMapping(path = "/teams/{id}")
    public @ResponseBody String updateTeam(@PathVariable int id, @RequestBody Team team) {
        teamService.updateTeam(id, team);
        return "Updated!";
    }

    @DeleteMapping(path = "/teams/{id}")
    public @ResponseBody String deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
        return "Deleted!";
    }
}
