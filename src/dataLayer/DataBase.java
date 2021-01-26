package dataLayer;

import models.Admin;
import models.Lesson;
import models.Master;
import models.Student;
import models.Class;

import java.io.*;
import java.util.ArrayList;


class DataBase {
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

    protected ArrayList<Student> readStudents() {
        ArrayList<Student> list = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(studentFile));
            list = (ArrayList<Student>) stream.readObject();
            stream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected void writeStudents(ArrayList<Student> list) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(studentFile));
            stream.writeObject(list);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Master> readMasters() {
        ArrayList<Master> list = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(masterFile));
            list = (ArrayList<Master>) stream.readObject();
            stream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected void writeMasters(ArrayList<Master> list) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(masterFile));
            stream.writeObject(list);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Class> readClasses() {
        ArrayList<Class> list = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(lessonFile));
            list = (ArrayList<Class>) stream.readObject();
            stream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected void writeClasses(ArrayList<Class> list) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(classFile));
            stream.writeObject(list);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Lesson> readLessons() {
        ArrayList<Lesson> list = null;
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(lessonFile));
            list = (ArrayList<Lesson>) stream.readObject();
            stream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected void writeLessons(ArrayList<Lesson> list) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(lessonFile));
            stream.writeObject(list);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Admin readAdmin() {
        return Admin.getInstance();
    }

    protected void writeAdmin(Admin admin) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(adminFile));
            stream.writeObject(admin);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
