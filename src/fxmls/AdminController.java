package fxmls;

import assistant.AdminAssistant;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tables.MasterAdminModel;
import tables.StudentAdminModel;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public JFXButton btnAddMaster;
    private AdminAssistant adminAssistant;

    public TableView<StudentAdminModel> tblStudent;
    public JFXButton btnAddStudent;
    public Label lblExit;
    public ImageView imgExit;
    public TableView<MasterAdminModel> tblMaster;


    //master
    private void initMasterTable() {
        TableColumn<MasterAdminModel, String> cFirstName = new TableColumn<>("نام");
        cFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<MasterAdminModel, String> cLastName = new TableColumn<>("نام خانوادگی");
        cLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<MasterAdminModel, String> cIdNumber = new TableColumn<>("شماره ملی");
        cIdNumber.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        TableColumn<MasterAdminModel, String> cPhoneNumber = new TableColumn<>("شماره تلفن");
        cPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableColumn<MasterAdminModel, JFXButton> cSend = new TableColumn<>("ارسال نام کاربری و رمز عبور");
        cSend.setCellValueFactory(new PropertyValueFactory<>("send"));

        tblMaster.getColumns().addAll(cFirstName, cLastName, cIdNumber, cPhoneNumber, cSend);

        tblMaster.setItems(adminAssistant.getMasterTableData());
        //todo update table after adding new master
    }

    private void onClickAddMaster() {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addStudent.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //student

    private void initStudentTable() {
        //todo set best width for each columns
        TableColumn<StudentAdminModel, Integer> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));

        TableColumn<StudentAdminModel, String> cLastName = new TableColumn<>("نام خانوادگی");
        cLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<StudentAdminModel, String> cFirstName = new TableColumn<>("نام");
        cFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<StudentAdminModel, String> cUsername = new TableColumn<>("نام کاربری");
        cUsername.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<StudentAdminModel, String> cPassword = new TableColumn<>("رمز عبور");
        cPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<StudentAdminModel, JFXButton> cReport = new TableColumn<>("کارنامه");
        cReport.setCellValueFactory(new PropertyValueFactory<>("report"));

        tblStudent.getColumns().addAll(cRow, cLastName, cFirstName, cUsername, cPassword, cReport);

        tblStudent.setItems(adminAssistant.getStudentsTableData());
        //todo update table after adding new student

    }

    private void onClickAddStudent() {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addStudent.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminAssistant = new AdminAssistant();
        //exit listener
        imgExit.setOnMouseClicked(e -> System.exit(0));
        lblExit.setOnMouseClicked(e -> System.exit(0));

        //student management
        btnAddStudent.setOnAction(e -> onClickAddStudent());
        initStudentTable();

        //master management
        btnAddMaster.setOnAction(e -> onClickAddMaster());
        initMasterTable();
    }
}
