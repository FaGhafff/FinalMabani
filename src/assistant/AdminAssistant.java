package assistant;

import dataLayer.MasterManager;
import dataLayer.StudentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Master;
import models.Student;
import tables.MasterAdminModel;
import tables.StudentAdminModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminAssistant {

    //get report for student() with username
    //get students list
    public ObservableList<StudentAdminModel> getStudentsTableData() {
        ArrayList<Student> list = new ArrayList<>();
        StudentManager studentManager = new StudentManager();
        list = studentManager.getStudentsList();
        ObservableList<StudentAdminModel> data = FXCollections.observableArrayList();
//        for (Student student : list) {
//            data.add(new StudentAdminModel(list.indexOf(student)+1,student.getLastName(),student.getFirstName(),student.getUsername(), student.getPassword()));
//        }

        //test
        data.add(new StudentAdminModel(1, "forghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhani", "ali", "qwe", "qqq"));
        data.add(new StudentAdminModel(2, "ghafouri", "fatemeh", "ahahah", "aksjaskj"));

        return data;
    }

    public ObservableList<MasterAdminModel> getMasterTableData() {
        ArrayList<Master> list = new ArrayList<>();
        MasterManager masterManager = new MasterManager();
        list = masterManager.getMastersList();
        ObservableList<MasterAdminModel> data = FXCollections.observableArrayList();
//        for (Master master : list) {
//            data.add(new MasterAdminModel(list.indexOf(master)+1,master.getFirstName(),master.getLastName(),master.getIdNumber(),master.getPhoneNumber()));
//        }

        //test
        data.add(new MasterAdminModel(1, "ali", "aliali", "alialaiila", "laialiailailila"));

        return data;
    }

    //add student and return suitable bool
    public boolean addStudent(Student student) {
        return true;
    }

    //add master and return bool
    public boolean addMaster(Master master) {
        return true;
    }
    //add student
}
