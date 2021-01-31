package assistant;

import dataLayer.ClassManager;
import dataLayer.StudentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Class;
import models.Lesson;
import models.Master;
import models.Student;
import tables.ReportCardStudentModel;
import tables.SelectUnitStudentModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class StudentAssistant {


    public ObservableList<ReportCardStudentModel>
    getReportCardTableData(String username) {
        StudentManager studentManager = new StudentManager();
        Student student = studentManager.getStudent(username);
        if (student != null) {
            ObservableList<ReportCardStudentModel> list = FXCollections.observableArrayList();
            AtomicInteger i = new AtomicInteger(1);
            student.getLessons().forEach((lesson, aDouble) -> list.add(new ReportCardStudentModel(i.getAndIncrement(),
                    lesson.getName(), getMasterNameForLesson(lesson), lesson.getUnit(), aDouble, isPassed(aDouble))));
            return list;
        } else
            return null;
    }

    private boolean isPassed(double d) {
        return d > 9;
    }

    private String getMasterNameForLesson(Lesson lesson) {
        ClassManager classManager = new ClassManager();
        ArrayList<Class> list = classManager.readAll();
        Master master = null;
        for (Class aClass : list) {
            if (aClass.getLesson().getId() == lesson.getId()) {
                master = aClass.getMaster();
                break;
            }
        }
        if (master == null)
            return null;
        else
            return master.getFirstName() + " " + master.getLastName();
    }


    //return Student for filling personal info
    public Student getStudent(String username) {
        return new StudentManager().getStudent(username);
    }

    public String getAverage(String username) {
        StudentManager studentManager = new StudentManager();
        AtomicInteger sumUnits = new AtomicInteger();
        AtomicReference<Double> sumGrades = new AtomicReference<>((double) 0);
        HashMap<Lesson, Double> lessons = studentManager.getStudent(username).getLessons();
        lessons.forEach((lesson, aDouble) -> {
            sumUnits.addAndGet(lesson.getUnit());
            sumGrades.updateAndGet(v -> v + lesson.getUnit() * aDouble);
        });
        return (sumGrades.get() / sumUnits.doubleValue()) + "";
    }

    public ObservableList<SelectUnitStudentModel> getSelectTableData() {
        ClassManager classManager = new ClassManager();
        ArrayList<Class> list = classManager.readAll();
        ObservableList<SelectUnitStudentModel> result = FXCollections.observableArrayList();
        AtomicInteger i = new AtomicInteger(1);
        list.forEach(aClass ->{
            if (aClass.isEnable())
                result.add(new SelectUnitStudentModel(i.getAndIncrement(),aClass.getLesson().getName(),
                        aClass.getId()+"",aClass.getTime(),aClass.getCapacity(),aClass.getLesson().getUnit(),
                        aClass.getMaster().getFirstName()+" "+aClass.getMaster().getLastName()));
        });
        return result;
    }

    public void saveSelections(String username, ArrayList<String> selectedCodes) {
       StudentManager studentManager = new StudentManager();
       ClassManager classManager = new ClassManager();
        for (String selectedCode : selectedCodes) {
            studentManager.addClass(username,selectedCode);
            classManager.addStudent(selectedCode,username);
        }
    }
}
