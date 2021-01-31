package dataLayer;

import models.Lesson;

import java.io.IOException;
import java.util.ArrayList;

public class LessonManager {

    public ArrayList<Lesson> getLessonsList(){
        try {
            return new DataBase().readLessons();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
