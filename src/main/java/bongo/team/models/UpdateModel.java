package bongo.team.models;

public class UpdateModel {
    private String name;

    public UpdateModel() {
        this.name = "";
    }

    public UpdateModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
