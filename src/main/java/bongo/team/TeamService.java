package bongo.team;

import bongo.employee.Employee;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class TeamService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAll() {
        return (List<Team>)teamRepository.findAll();
    }

    public Optional<Team> get(int id) {
        return teamRepository.findById(id);
    }

    public List<Employee> getAllMembers(int id) {
        throw new NotImplementedException();
//        how to use this
//        TypedQuery<Employee> query = em.createQuery("select e from Team t join Employee e on e.team_id = t.id where t.id = ?1", Employee.class);
//        query.setParameter(1, id);
//
//        return query.getResultList();
    }

    @Transactional()
    public void add(Team team) {
        teamRepository.save(team);
    }

    @Transactional()
    public void update(Team team) {
        teamRepository.save(team);
    }

    @Transactional()
    public void delete(int id) {
        teamRepository.deleteById(id);
    }
}
