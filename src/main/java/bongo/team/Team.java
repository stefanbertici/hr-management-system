package bongo.team;

import bongo.employee.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Team {
    @Id
    private int id;
    @Column(name = "team_name")
    private String teamName;
//    @ManyToOne
//    private Employee manager;


    public Team() {
    }

    public Team(int id) {
        this.id = id;
        this.teamName = "";
        //this.manager = null;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Employee getManager() {
//        return manager;
//    }
//
//    public void setManager(Employee manager) {
//        this.manager = manager;
//    }
}
