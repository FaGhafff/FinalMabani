package dataLayer;

import models.Lesson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LessonManager {

    public ArrayList<Lesson> getLessonsList(){
        try {
            return new DataBase().readLessons();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean save(Lesson lesson) {
        try {
            DataBase dataBase = new DataBase();
            ArrayList<Lesson> list = dataBase.readLessons();
            if (list.contains(lesson))
                return false;
            list.add(lesson);
            dataBase.writeLessons(list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void update(HashMap<Long, Boolean> hashMap) {
        try {
            DataBase dataBase = new DataBase();
            ArrayList<Lesson> list = dataBase.readLessons();
            hashMap.forEach((aLong, aBoolean) -> list.forEach(lesson -> {
                if (aLong==lesson.getId()){
                    lesson.setPresented(aBoolean);
                }
            }));
            dataBase.writeLessons(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
