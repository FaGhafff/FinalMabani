package fxmls;

import assistant.AdminAssistant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Lesson;

import java.net.URL;
import java.util.ResourceBundle;

public class AddLessonController implements Initializable {

    public JFXTextField txtCode;
    public JFXTextField txtLessonName;
    public JFXTextField txtUnit;
    public JFXButton btnExit;
    public JFXButton btnAdd;
    public Label lblMessage;

    private AdminAssistant adminAssistant;

    private final String errorMessage = "نمی تواند خالی باشد.";

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

    private void onClickAdd() {
        if (txtCode.getText().length() == 0 ||
                txtLessonName.getText().length() == 0 ||
                txtUnit.getText().length() == 0) {
            if (txtCode.getText().length() == 0)
                emptyTextField(txtCode);
            if (txtLessonName.getText().length() == 0)
                emptyTextField(txtLessonName);
            if (txtUnit.getText().length() == 0)
                emptyTextField(txtUnit);
            return;
        }
        try {
            Lesson lesson = new Lesson();
            lesson.setId(Long.parseLong(txtCode.getText()));
            lesson.setName(txtLessonName.getText());
            lesson.setUnit(Integer.parseInt(txtUnit.getText()));
            lesson.setPresented(false);
            if (adminAssistant.addLesson(lesson)) {
                lblMessage.setText("درس اضافه شد.");
            } else {
                lblMessage.setText("خطا");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            lblMessage.setText("خطا");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminAssistant = new AdminAssistant();
        btnAdd.setOnAction(e -> onClickAdd());
        btnExit.setOnAction(e -> ((Stage) btnExit.getScene().getWindow()).close());
        setOnTextChanged(txtCode);
        setOnTextChanged(txtLessonName);
        setOnTextChanged(txtUnit);
    }
}
