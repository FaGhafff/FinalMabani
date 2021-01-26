package models;

import java.io.Serializable;
import java.util.HashMap;

public class Student extends Person implements Serializable {
    private HashMap<Lesson,Double> lessons;

    @Override
    public String toString() {
        return "Student{" +
                "lessons=" + lessons +
                "} " + super.toString();
    }
}
