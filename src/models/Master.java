package models;

import java.util.Set;

public class Master extends Person {
    Set<Class> classes;

    @Override
    public String toString() {
        return "Master{" +
                "classes=" + classes +
                "} " + super.toString();
    }
}
