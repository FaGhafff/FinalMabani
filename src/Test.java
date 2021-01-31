import models.Master;
import tools.SMS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Test {
    //class for unit testing
    public static void main(String[] args) throws IOException {

        ArrayList<Master> list = new ArrayList<>();
        Master master = new Master();
        master.setFirstName("fatemeh");
        master.setLastName("ghafouri");

        list.add(master);
        master = new Master();
        master.setFirstName("ali");
        master.setLastName("forghani");
        list.add(master);
        ArrayList<String> l = list.stream().map(master1 -> master1.getFirstName()+" "+master1.getLastName()).collect(Collectors.toCollection(ArrayList::new));
        l.forEach(s -> System.out.println(s));
    }
}
