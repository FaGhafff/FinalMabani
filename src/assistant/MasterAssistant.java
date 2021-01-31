package assistant;

import dataLayer.ClassManager;
import dataLayer.MasterManager;
import dataLayer.StudentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import models.Class;
import models.Lesson;
import models.Master;
import models.Student;
import tables.ClassMasterModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MasterAssistant {

    public ObservableList<PieChart.Data> getChartData(String classID) {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        ClassManager classManager = new ClassManager();
        int pass = 0;
        int fail = 0;
        Class c = classManager.get(classID);
        if (c == null)
            return null;
        else {
            Lesson lesson = c.getLesson();
            for (Student student : c.getStudents()) {
                if (student.getLessons().get(lesson) > 9)
                    pass++;
                else
                    fail++;
            }
            list.add(new PieChart.Data("قبول شده", pass));
            list.add(new PieChart.Data("رد شده", fail));
            return list;
        }
    }

    // save grade for student that username and grade in hash map for class with id idClass
    public void saveGrades(HashMap<String, Double> list, String idClass) {
        StudentManager studentManager = new StudentManager();
        list.forEach(studentManager::setGrade);
    }

    public ObservableList<ClassMasterModel> getClassTableData(String idClass) {
        ClassManager classManager = new ClassManager();
        Class c = classManager.readAll().stream().filter(aClass -> String.valueOf(aClass.getId()).equals(idClass)).findFirst().orElse(null);
        ObservableList<ClassMasterModel> list = FXCollections.observableArrayList();
        AtomicInteger i = new AtomicInteger();
        if (c != null)
            c.getStudents().forEach(student -> list.add(new ClassMasterModel(i.getAndIncrement(), student.getUsername(), student.getLastName(), student.getFirstName(), "0")));
        return list;
    }

    public Master getMaster(String username) {
        MasterManager masterManager = new MasterManager();
        return masterManager.getMastersList().stream().filter(master -> master.getUsername().equals(username)).findFirst().orElse(null);
    }

    public ArrayList<Class> getClassForMaster(String username) {
        ClassManager classManager = new ClassManager();
        return classManager.readAll().stream().filter(aClass -> aClass.getMaster().getUsername().equals(username)).collect(Collectors.toCollection(ArrayList::new));
        }
}
