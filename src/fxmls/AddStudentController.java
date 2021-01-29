package fxmls;

import assistant.AdminAssistant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Student;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {

    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtIdNumber;
    public JFXTextField txtPhoneNumber;
    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public JFXButton btnExit;
    public JFXButton btnAdd;
    public Label lblMessage;

    private final String errorMessage = "نمی تواند خالی باشد.";
    private AdminAssistant adminAssistant;

    private void emptyTextField(JFXTextField textField) {
        textField.setText(errorMessage);
    }

    private void setOnTextChanged(JFXTextField textField) {
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                if (textField.getText().equals(errorMessage))
                    textField.clear();
        });
    }

    //check each txt fields and try to save new student with AdminAssistant
    private void onClickAdd() {
        if (txtFirstName.getText().length() == 0 || txtLastName.getText().length() == 0
                || txtIdNumber.getText().length() == 0 || txtPhoneNumber.getText().length() == 0
                || txtUsername.getText().length() == 0 || txtPassword.getText().length() == 0) {
            if (txtUsername.getText().length() == 0)
                emptyTextField(txtUsername);

            if (txtPassword.getText().length() == 0)
                emptyTextField(txtPassword);

            if (txtFirstName.getText().length() == 0)
                emptyTextField(txtFirstName);

            if (txtLastName.getText().length() == 0)
                emptyTextField(txtLastName);

            if (txtIdNumber.getText().length()==0)
                emptyTextField(txtIdNumber);

            if (txtPhoneNumber.getText().length()==0)
                emptyTextField(txtPhoneNumber);

                return;
        }
        Student student = new Student();
        student.setUsername(txtUsername.getText());
        student.setPassword(txtPassword.getText());
        student.setFirstName(txtFirstName.getText());
        student.setLastName(txtLastName.getText());
        student.setIdNumber(txtIdNumber.getText());
        student.setPhoneNumber(txtPhoneNumber.getText());
        student.setLessons(new HashMap<>());
        if (adminAssistant.addStudent(student))
            lblMessage.setText("دانشجو اضافه و نام کاربری و رمز عبور پیامک شد.");
        else
            lblMessage.setText("خطا");


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminAssistant = new AdminAssistant();
        btnExit.setOnAction(e -> ((Stage) btnExit.getScene().getWindow()).close());
        btnAdd.setOnAction(e -> onClickAdd());
        setOnTextChanged(txtFirstName);
        setOnTextChanged(txtIdNumber);
        setOnTextChanged(txtLastName);
        setOnTextChanged(txtUsername);
        setOnTextChanged(txtPassword);
        setOnTextChanged(txtPhoneNumber);

    }
}
