package bongo.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public void add(Team team) {
        teamRepository.save(team);
    }

    public Iterable<Team> getAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> get(int id) {
        return teamRepository.findById(id);
    }

    public void update(Team team) {
        teamRepository.save(team);
    }

    public void delete(int id) {
        teamRepository.deleteById(id);
    }
}
