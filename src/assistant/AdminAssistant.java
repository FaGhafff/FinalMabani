package assistant;

import dataLayer.StudentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Student;
import tables.StudentAdminModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminAssistant {

    //get report for student() with username
    //get students list
    public ObservableList<StudentAdminModel> getStudentsTableData(){
        ArrayList<Student> list = new ArrayList<>();
        StudentManager studentManager = new StudentManager();
        list = studentManager.getStudentsList();
        ObservableList<StudentAdminModel> data = FXCollections.observableArrayList();
//        for (Student student : list) {
//            data.add(new StudentAdminModel(list.indexOf(student)+1,student.getLastName(),student.getFirstName(),student.getUsername(), student.getPassword()));
//        }
        data.add(new StudentAdminModel(1,"forghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhani","ali","qwe","qqq"));
        data.add(new StudentAdminModel(2,"ghafouri","fatemeh","ahahah","aksjaskj"));

        return data;
    }
    //add student
}
