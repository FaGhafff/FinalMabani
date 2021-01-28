package assistant;

import dataLayer.MasterManager;
import dataLayer.StudentManager;
import models.Master;
import models.Student;
import tools.SMS;

public class LoginAssistant {

    public Object login(String username, String password) {
        MasterManager masterManager = new MasterManager();
        if (masterManager.isExist(username))
            if (masterManager.getPassword(username).equals(password)) {
                Master master = new Master();
                master.setUsername(username);
                return master;
            }

        StudentManager studentManager = new StudentManager();
        if (studentManager.isExist(username))
            if (studentManager.getPassword(username).equals(password)) {
                Student student = new Student();
                student.setUsername(username);
                return student;
            }
        return new Master();
    }

    //forgetPass
    public boolean forgetPass(String username) {
    String message = "username is : %s \n password is : %s";
    String password ="";
        SMS sms;
        MasterManager masterManager = new MasterManager();
        if (masterManager.isExist(username)){
            sms = new SMS(masterManager.getPhoneNumber(username));
            password = masterManager.getPassword(username);
            sms.setMessage(String.format(message,username,password));
            sms.send();
            return true;
        }
        StudentManager studentManager = new StudentManager();
        if (studentManager.isExist(username)){
            sms = new SMS(studentManager.getPhoneNumber(username));
            password = studentManager.getPassword(username);
            sms.setMessage(String.format(message,username,password));
            sms.send();
            return true;
        }
        return false;
    }

}
