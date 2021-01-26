package models;

import java.util.HashMap;

public class Student extends Person{
    private HashMap<Lesson,Double> lessons;

    @Override
    public String toString() {
        return "Student{" +
                "lessons=" + lessons +
                "} " + super.toString();
    }
}
