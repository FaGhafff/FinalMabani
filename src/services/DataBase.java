package services;

import models.Admin;
import models.Lesson;
import models.Master;
import models.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class DataBase {
    private static String STUDENT_FILE_ADDRESS = "student.dat";
    private static String MASTER_FILE_ADDRESS = "master.dat";
    private static String CLASS_FILE_ADDRESS = "class.dat";
    private static String LESSON_FILE_ADDRESS = "lesson.dat";
    private static String ADMIN_FILE_ADDRESS = "admin.dat";
    private File studentFile;
    private File masterFile;
    private File classFile;
    private File lessonFile;
    private File adminFile;

    DataBase() throws IOException {
        studentFile = new File(STUDENT_FILE_ADDRESS);
        if (studentFile.exists())
            studentFile.createNewFile();
        masterFile = new File(MASTER_FILE_ADDRESS);
        if (masterFile.exists())
            masterFile.createNewFile();
        classFile = new File(CLASS_FILE_ADDRESS);
        if (classFile.exists())
            classFile.createNewFile();
        lessonFile = new File(LESSON_FILE_ADDRESS);
        if (lessonFile.exists())
            lessonFile.createNewFile();
        adminFile = new File(ADMIN_FILE_ADDRESS);
        if (adminFile.exists())
            adminFile.createNewFile();
    }

    public ArrayList<Student> readStudents(){return null;}
    public void writeStudents(ArrayList<Student> list){}

    public ArrayList<Master> readMasters(){return null;}
    public void writeMasters(ArrayList<Master> list){}

    public ArrayList<Class> readClasses(){return  null;}
    public void writeClasses(ArrayList<Class> list){}

    public ArrayList<Lesson> readLessons(){return null;}
    public void writeLessons(ArrayList<Lesson> list){}

    public Admin readAdmin(){return Admin.getInstance();}
    public void writeAdmin(Admin admin){}
}
