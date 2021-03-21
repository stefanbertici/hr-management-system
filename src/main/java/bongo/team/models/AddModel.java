package bongo.team.models;

public class AddModel {
    private String name;

    public AddModel() {
        this.name = "";
    }

    public AddModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
