package fxmls;

import assistant.LoginAssistant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Master;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginPageController implements Initializable {

    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public Label lblForget;
    public JFXButton btnLogin;
    public Label lblMessage;

    private String errorMessage = "نمی تواند خالی باشد.";
    private LoginAssistant loginAssistant;

    private void onClickLogin() {
        if (txtUsername.getText().length() == 0 || txtPassword.getText().length() == 0) {
            if (txtPassword.getText().length() == 0) {
                emptyTextField(txtPassword);
            }
            if (txtUsername.getText().length() == 0) {
                emptyTextField(txtUsername);
            }
            return;
        }
        Object object = loginAssistant.login(txtUsername.getText(), txtPassword.getText());
        Stage stage = new Stage();
        Parent root = null;
        if (object == null) {
            lblMessage.setText("کاربری با این مشخصات وجود ندارد.");
        } else if (object instanceof Master) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("master.fxml"));
            MasterController masterController = new MasterController();
            masterController.setUsername(txtUsername.getText());
            loader.setController(masterController);
            stage.setTitle("Master");
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
            StudentController studentController = new StudentController();
            studentController.setUsername(txtUsername.getText());
            loader.setController(studentController);
            stage.setTitle("Student");
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        stage.setScene(new Scene(root));
        ((Stage) btnLogin.getScene().getWindow()).close();
        stage.show();


    }

    private void onClickForget() {
        if (txtUsername.getText().length() == 0) {
            emptyTextField(txtUsername);
            return;
        }
        if (loginAssistant.forgetPass(txtUsername.getText()))
            lblMessage.setText("نام کاربری و رمز عبور پیامک شد.");
        else
            lblMessage.setText("کاربری با این مشخصات وجود ندارد.");

    }

    private void emptyTextField(JFXTextField textField) {
        textField.setText(errorMessage);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblForget.setOnMouseClicked(e -> onClickForget());
        btnLogin.setOnAction(e -> onClickLogin());
        loginAssistant = new LoginAssistant();
        txtPassword.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                if (txtPassword.getText().equals(errorMessage))
                    txtPassword.clear();
            }
        });
        txtUsername.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                if (txtUsername.getText().equals(errorMessage))
                    txtUsername.clear();
            }
        });
    }
}
