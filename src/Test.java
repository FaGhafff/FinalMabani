import models.Master;
import tools.SMS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Test {
    //class for unit testing
    public static void main(String[] args) throws IOException {

       SMS sms = new SMS("09145030651");
       sms.setMessage("test message");
        System.out.println(sms.send());
    }
}
