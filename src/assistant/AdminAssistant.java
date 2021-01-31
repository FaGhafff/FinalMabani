package assistant;

import dataLayer.LessonManager;
import dataLayer.MasterManager;
import dataLayer.StudentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Class;
import models.Lesson;
import models.Master;
import models.Student;
import tables.ClassAdminModel;
import tables.LessonAdminModel;
import tables.MasterAdminModel;
import tables.StudentAdminModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
    //add lessson and return bool
    public boolean addLesson(Lesson lesson) {
        return true;
    }

    //get prepared data for lesson table
    public ObservableList getLessonTableData() {
        ObservableList<LessonAdminModel> data = FXCollections.observableArrayList();
        data.add(new LessonAdminModel(1,"alii","234",4,false));
        data.add(new LessonAdminModel(1,"aalalialiai","2eeeee4",4,true));
        return data;
    }

    //return lessons where isPresented is true
    public ArrayList<Lesson> getPresentedLessons(){
        return null;
    }

    //update isPresent for Lessons
    public void saveLessons(HashMap<Long, Boolean> hashMap) {
        hashMap.forEach((aLong, aBoolean) -> System.out.println(aLong+" "+aBoolean));
    }

    public ObservableList<ClassAdminModel> getClassTableData() {
        ObservableList<ClassAdminModel> data =FXCollections.observableArrayList();
        data.add(new ClassAdminModel(1,"aliali","12344","mastername",3,true));
        data.add(new ClassAdminModel(2,"alalalalla","123","mastername",5,false));
        return data;
    }

    //update isEnable for classes
    public void saveClasses(HashMap<Long, Boolean> hashMap) {
        System.out.println("class");
        hashMap.forEach((aLong, aBoolean) -> System.out.println(aLong+" "+aBoolean));
    }

    public ArrayList<Lesson> getLessonsForAddClass() {
        Lesson lesson= new Lesson();
        lesson.setName("alialialia");
        lesson.setId(1212);
        ArrayList<Lesson> list = new ArrayList<>();
        list.add(lesson);
        return list;
    }

    public ArrayList<Master> getMastersForAddClass() {
        return new ArrayList<>();
    }

    public void addClass(Class aClass) {

    }

    public void sendUserPassMaster(String idNumber) {
        System.out.println("AdminAssistant.sendUserPassMaster");
        System.out.println(idNumber);

    }
    //add student
}
