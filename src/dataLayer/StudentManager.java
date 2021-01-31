package dataLayer;

import models.Lesson;
import models.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {

    //check if student with this username exist or not
    public boolean isExist(String username) {
        return getStudent(username) != null;
    }

    //get student password with username
    public String getPassword(String username) {
        return getStudent(username).getPassword();
    }

    //get student phone number with username
    public String getPhoneNumber(String username) {
        return getStudent(username).getPhoneNumber();
    }

    //get students list
    public ArrayList<Student> getStudentsList(){
        try {
            return new DataBase().readStudents();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Student getStudent(String username) {
        try {
            return new DataBase().readStudents().stream().filter(student ->
                    student.getUsername().equals(username)).findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addClass(String username, String selectedCode) {
        try {
            DataBase dataBase = new DataBase();
            ArrayList<Student> list = dataBase.readStudents();
            Student student = list.stream().filter(student1 ->
                    student1.getUsername().equals(username)).findFirst().orElse(null);
            list.remove(student);
            Lesson lesson = new ClassManager().get(selectedCode).getLesson();
            student.addLesson(lesson);
            list.add(student);
            dataBase.writeStudents(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//s is student id and double is grade
    public void setGrade(String s, Double aDouble, String idClass) {
        ClassManager classManager = new ClassManager();
        Lesson lesson = classManager.get(idClass).getLesson();
        try {
            DataBase dataBase = new DataBase();
            ArrayList<Student> list = dataBase.readStudents();
            Student student = list.stream().filter(student1 -> student1.getUsername().equals(s)).findFirst().orElse(null);
            list.remove(student);
            student.getLessons().put(lesson,aDouble);
            list.add(student);
            dataBase.writeStudents(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //save new Student
    public boolean save(Student student) {
        try {
            DataBase dataBase = new DataBase();
            ArrayList<Student> list = dataBase.readStudents();
            student.setLessons(new HashMap<>());
            list.add(student);
            dataBase.writeStudents(list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
