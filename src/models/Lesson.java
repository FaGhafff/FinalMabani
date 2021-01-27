package models;

import java.io.Serializable;
import java.util.Objects;

public class Lesson implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", unit=" + unit +
                ", name='" + name + '\'' +
                ", isPresented=" + isPresented +
                '}';
    }
}
