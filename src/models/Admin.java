package models;

public class Admin extends Person{
    public static Admin getInstance() {
        Admin admin = new Admin();
        admin.setFirstName("Fatemeh");
        admin.setLastName("Ghafouri");
        admin.setIdNumber("1360000000");
        admin.setPhoneNumber("09146633942");
        admin.setUsername("moon");
        admin.setPassword("moon");
        return admin;
    }
}
