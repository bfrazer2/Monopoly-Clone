package main.java;

public class BoardSpace {

    private String name;
    private String type;

    public BoardSpace() {
    }

    public BoardSpace(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
