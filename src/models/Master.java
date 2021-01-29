package models;

import java.io.Serializable;
import java.util.Set;

public class Master extends Person implements Serializable {
    Set<Class> classes;

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Master{" +
                "classes=" + classes +
                "} " + super.toString();
    }
}
