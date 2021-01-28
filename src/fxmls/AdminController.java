package fxmls;

import assistant.AdminAssistant;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import tables.StudentAdminModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    private AdminAssistant adminAssistant;

    public TableView<StudentAdminModel> tblStudent;
    public JFXButton btnAddStudent;
    public Label lblExit;
    public ImageView imgExit;



    private void initStudentTable(){
        //todo set best width for each columns
        TableColumn<StudentAdminModel,Integer> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));

        TableColumn<StudentAdminModel,String> cLastName = new TableColumn<>("نام خانوادگی");
        cLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<StudentAdminModel,String> cFirstName = new TableColumn<>("نام");
        cFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<StudentAdminModel,String> cUsername = new TableColumn<>("نام کاربری");
        cUsername.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<StudentAdminModel,String> cPassword = new TableColumn<>("رمز عبور");
        cPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<StudentAdminModel,JFXButton> cReport = new TableColumn<>("کارنامه");
        cReport.setCellValueFactory(new PropertyValueFactory<>("report"));

        tblStudent.getColumns().addAll(cRow,cLastName,cFirstName,cUsername,cPassword,cReport);

        tblStudent.setItems(adminAssistant.getStudentsTableData());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminAssistant = new AdminAssistant();
        //exit listener
        imgExit.setOnMouseClicked(e -> System.exit(0));
        lblExit.setOnMouseClicked(e -> System.exit(0));

        initStudentTable();
    }
}
