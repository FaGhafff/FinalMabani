package tables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClassMasterModel {
    private SimpleIntegerProperty row;
    private SimpleStringProperty username;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty grade;

    public ClassMasterModel(int row,
                            String username,
                            String lastName,
                            String firstName,
                            String grade) {
        this.row = new SimpleIntegerProperty(row);
        this.username = new SimpleStringProperty(username);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.grade = new SimpleStringProperty(grade);
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

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
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

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }
}
