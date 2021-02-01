package assistant;

import dataLayer.ClassManager;
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
import tools.SMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AdminAssistant {

    //get report for student() with username
    //get students list
    public ObservableList<StudentAdminModel> getStudentsTableData() {
        ArrayList<Student> list;
        StudentManager studentManager = new StudentManager();
        list = studentManager.getStudentsList();
        ObservableList<StudentAdminModel> data = FXCollections.observableArrayList();
        if (list != null)
            for (Student student : list) {
                data.add(new StudentAdminModel(list.indexOf(student) + 1, student.getLastName(), student.getFirstName(),
                        student.getUsername(), student.getPassword()));
            }
        return data;
    }

    public ObservableList<MasterAdminModel> getMasterTableData() {
        ArrayList<Master> list;
        MasterManager masterManager = new MasterManager();
        list = masterManager.getMastersList();
        ObservableList<MasterAdminModel> data = FXCollections.observableArrayList();
        if (list != null)
            for (Master master : list) {
                data.add(new MasterAdminModel(list.indexOf(master) + 1, master.getFirstName(), master.getLastName(), master.getIdNumber(), master.getPhoneNumber()));
            }
        return data;
    }

    //add student and return suitable bool
    public boolean addStudent(Student student) {
        StudentManager studentManager = new StudentManager();
        return studentManager.save(student);
    }

    //add master and return bool
    public boolean addMaster(Master master) {
        return new MasterManager().save(master);
    }

    //add lesson and return bool
    public boolean addLesson(Lesson lesson) {
        return new LessonManager().save(lesson);
    }

    //get prepared data for lesson table
    public ObservableList<LessonAdminModel> getLessonTableData() {
        ObservableList<LessonAdminModel> data = FXCollections.observableArrayList();
        LessonManager lessonManager = new LessonManager();
        AtomicInteger i = new AtomicInteger(1);
        try {
            lessonManager.getLessonsList().forEach(lesson -> data.add(new LessonAdminModel(i.getAndIncrement(),
                    lesson.getName(), lesson.getId() + "", lesson.getUnit(), lesson.isPresented())));
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    //return lessons where isPresented is true
    public ArrayList<Lesson> getPresentedLessons() {
        LessonManager lessonManager = new LessonManager();
        return lessonManager.getLessonsList().stream().filter(Lesson::isPresented).collect(Collectors.toCollection(ArrayList::new));
    }

    //update isPresent for Lessons
    public void saveLessons(HashMap<Long, Boolean> hashMap) {
        LessonManager lessonManager = new LessonManager();
        lessonManager.update(hashMap);
    }

    public ObservableList<ClassAdminModel> getClassTableData() {
        ObservableList<ClassAdminModel> data = FXCollections.observableArrayList();
        ClassManager classManager = new ClassManager();
        int i = 1;
        if (classManager.readAll() != null)
            try {
                for (Class aClass : classManager.readAll()) {
                    data.add(new ClassAdminModel(i++, aClass.getLesson().getName(), aClass.getId() + "",
                            aClass.getMaster().getFirstName() + " " + aClass.getMaster().getLastName(),
                            aClass.getCapacity(), aClass.isEnable()));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return data;
    }

    //update isEnable for classes
    public void saveClasses(HashMap<Long, Boolean> hashMap) {
        ClassManager classManager = new ClassManager();
        classManager.updateClass(hashMap);
    }

    public ArrayList<Lesson> getLessonsForAddClass() {
        LessonManager lessonManager = new LessonManager();
        ArrayList<Lesson> list = lessonManager.getLessonsList();
        ArrayList<Lesson> result = new ArrayList<>();
        list.forEach(lesson -> {
            if (lesson.isPresented())
                result.add(lesson);
        });
        return result;
    }

    public ArrayList<Master> getMastersForAddClass() {
        return new MasterManager().getMastersList();
    }

    public void addClass(Class aClass) {
        ClassManager classManager = new ClassManager();
        classManager.save(aClass);
    }

    public void sendUserPassMaster(String idNumber) {
        MasterManager masterManager = new MasterManager();
        Master master = masterManager.getMastersList().stream().filter(master1 ->
                master1.getIdNumber().equals(idNumber)).findFirst().orElse(null);
        if (master != null) {
            SMS sms = new SMS(master.getPhoneNumber());
            sms.setMessage("username is : " + master.getUsername() + " password is : " + master.getPassword());
            System.out.println("SMS");
            System.out.println(sms.send());
        }
    }
    //add student
}
