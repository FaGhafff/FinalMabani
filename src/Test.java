import models.Student;
import tools.SMS;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    //class for unit testing
    public static void main(String[] args) throws IOException {

        SMS sms = new SMS("09145030651");
        sms.setMessage("test message : code is 1234");
        System.out.println(sms.send());

    }
}
