package models;

import java.io.Serializable;
import java.util.Set;

public class Master extends Person implements Serializable {
    Set<Class> classes;

    @Override
    public String toString() {
        return "Master{" +
                "classes=" + classes +
                "} " + super.toString();
    }
}
