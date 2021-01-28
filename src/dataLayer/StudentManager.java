package dataLayer;

import models.Student;

import java.io.IOException;
import java.util.ArrayList;

public class StudentManager {
    private DataBase dataBase;

    public StudentManager() {
        try {
            this.dataBase = new DataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //check if student with this username exist or not
    public boolean isExist(String username) {
        //todo
        return false;
    }

    //get student password with username
    public String getPassword(String username) {
        //todo
        return null;
    }

    //get student phone number with username
    public String getPhoneNumber(String username) {
        //todo
        return null;
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

}
