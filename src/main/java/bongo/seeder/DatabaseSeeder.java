package bongo.seeder;

import bongo.employee.Employee;
import bongo.employee.EmployeeService;
import bongo.employee.Role;
import bongo.team.Team;
import bongo.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DatabaseSeeder {

    @Autowired
    TeamService teamService;
    @Autowired
    EmployeeService employeeService;

    private Logger logger;

    public DatabaseSeeder() {
        this.logger = Logger.getLogger("Main.class");
    }

    public void seedTeamTable() {
        if (teamService.isEmpty()) {
            Team team = new Team();
            team.setName("Admin superteam");
            teamService.add(team);
            logger.info("Teams seeded");
        } else {
            logger.info("Teams seeding not required");
        }
    }

    public void seedEmployeeTable() {
        if (employeeService.isEmpty()) {
            Employee employee = new Employee();
            employee.setFirstName("Oto");
            employee.setLastName("Yumi");
            employee.setRole(Role.ADMIN);
            employee.setSalary(9999);
            Team team = new Team();
            team.setId(15);
            employee.setTeam(team);
            employeeService.add(employee);
            logger.info("Admin employee seeded");
        } else {
            logger.info("Admin employee seeding not required");
        }
    }
}
