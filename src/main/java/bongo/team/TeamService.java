package bongo.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    bongo.team.TeamRepository teamRepository;

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeam(int id) {
        return teamRepository.findById(id);
    }

    public void updateTeam(Team team) {
        teamRepository.save(team);
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}
