package fxmls;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    private String username;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setUsername(String username) {
        this.username = username;
    }
}
