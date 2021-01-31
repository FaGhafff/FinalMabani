package models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Class implements Serializable {
    private long id;
    private String time;
    private Master master;
    private Lesson lesson;
    private Set<Student> students;
    private int capacity;
    private  boolean isEnable;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student student){
        return students.add(student);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return id == aClass.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", master=" + master +
                ", lesson=" + lesson +
                ", students=" + students +
                ", capacity=" + capacity +
                ", isEnable=" + isEnable +
                '}';
    }
}
