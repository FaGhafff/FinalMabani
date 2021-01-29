package dataLayer;

import models.Master;

import java.io.IOException;
import java.util.ArrayList;

public class MasterManager {
    private DataBase dataBase;
    public MasterManager(){
        try {
            dataBase = new DataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //add master
    //add lesson for master
    //add number for student
    //is master exist
    public boolean isExist(String username){
        for (Master readMaster : dataBase.readMasters()) {
            if (readMaster.getUsername().equals(username))
                return true;
        }
        return false;
    }
    //get master password with username
    public String getPassword(String username){
        for (Master readMaster : dataBase.readMasters()) {
            if (readMaster.getUsername().equals(username))
                return readMaster.getPassword();
        }
        return null;
    }
    //get master phone number with username
    public String getPhoneNumber(String username){
        for (Master readMaster : dataBase.readMasters()) {
            if (readMaster.getUsername().equals(username))
                return readMaster.getPhoneNumber();
        }
        return null;
    }

    public ArrayList<Master> getMastersList() {
        return null;
    }
}