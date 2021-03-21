package bongo.team;

import javax.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "team_name")
    private String name;
//    @ManyToOne
//    private Employee manager;


    public Team() {
        this.name = "";
    }

    public Team(int id) {
        this.id = id;
        this.name = "";
        //this.manager = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
