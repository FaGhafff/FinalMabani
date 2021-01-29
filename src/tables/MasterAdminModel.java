package tables;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MasterAdminModel {
    private SimpleIntegerProperty row;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty idNumber;
    private SimpleStringProperty phoneNumber;
    private JFXButton send;

    public MasterAdminModel(int row, String firstName, String lastName, String idNumber, String phoneNumber) {
        this.row = new SimpleIntegerProperty(row);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.idNumber = new SimpleStringProperty(idNumber);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.send = new JFXButton("ارسال نام کاربری و رمز عبور");
    }

    public int getRow() {
        return row.get();
    }

    public SimpleIntegerProperty rowProperty() {
        return row;
    }

    public void setRow(int row) {
        this.row.set(row);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getIdNumber() {
        return idNumber.get();
    }

    public SimpleStringProperty idNumberProperty() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber.set(idNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public JFXButton getSend() {
        return send;
    }

    public void setSend(JFXButton send) {
        this.send = send;
    }
}
