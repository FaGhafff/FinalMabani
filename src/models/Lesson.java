package models;

public class Lesson {
    private long id;
    private int unit;
    private String name;
    private boolean isPresented;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPresented() {
        return isPresented;
    }

    public void setPresented(boolean presented) {
        isPresented = presented;
    }
}
