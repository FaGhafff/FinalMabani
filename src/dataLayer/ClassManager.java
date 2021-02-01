package dataLayer;

import models.Class;
import models.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassManager {


    public ArrayList<Class> readAll() {
        try {
            DataBase dataBase = new DataBase();
            return dataBase.readClasses();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void addStudent(String selectedCode, String username) {
        try {
            StudentManager studentManager = new StudentManager();
            Student student = studentManager.getStudent(username);
            ArrayList<Class> list = new DataBase().readClasses();
            list.forEach(aClass -> {
                if (String.valueOf(aClass.getId()).equals(selectedCode)) {
                    aClass.getStudents().add(student);

                }
            });
            DataBase dataBase = new DataBase();
            dataBase.writeClasses(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Class get(String classID) {
        return readAll().stream().filter(aClass -> String.valueOf(aClass.getId()).equals(classID)).findFirst().orElse(null);
    }

    //save class
    public void save(Class aClass) {
        try {
            DataBase dataBase = new DataBase();
            ArrayList<Class> list = dataBase.readClasses();
            list.remove(aClass);
            list.add(aClass);
            dataBase.writeClasses(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateClass(HashMap<Long, Boolean> hashMap) {
        try {
            DataBase dataBase = new DataBase();
            ArrayList<Class> list = dataBase.readClasses();
            hashMap.forEach((aLong, aBoolean) -> list.forEach(aClass -> {
                if (aClass.getId() == aLong) {
                    aClass.setEnable(aBoolean);
                }
            }));
            dataBase.writeClasses(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}