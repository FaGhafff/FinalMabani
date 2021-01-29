package fxmls;

import assistant.AdminAssistant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tables.ClassAdminModel;
import tables.LessonAdminModel;
import tables.MasterAdminModel;
import tables.StudentAdminModel;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public JFXButton btnAddMaster;
    public TableView<LessonAdminModel> tblLesson;
    public JFXButton btnAddLesson;
    public TableView<ClassAdminModel> tblClass;
    public JFXButton btnAddClass;
    public JFXButton btnSaveLesson;
    public JFXButton btnSaveClass;
    public TableView<StudentAdminModel> tblStudent;
    public JFXButton btnAddStudent;
    public Label lblExit;
    public ImageView imgExit;
    public TableView<MasterAdminModel> tblMaster;

    private AdminAssistant adminAssistant;

    //class
    private void initClassTable() {
        TableColumn<ClassAdminModel, Integer> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));
        TableColumn<ClassAdminModel, String> cName = new TableColumn<>("نام");
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ClassAdminModel, String> cCode = new TableColumn<>("کد کلاس");
        cCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        TableColumn<ClassAdminModel, String> cMasterName = new TableColumn<>("نام استاد");
        cMasterName.setCellValueFactory(new PropertyValueFactory<>("masterName"));
        TableColumn<ClassAdminModel, Integer> cCapacity = new TableColumn<>("ظرفیت");
        cCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        TableColumn<ClassAdminModel, JFXToggleButton> cEnable = new TableColumn<>("فعال / غیر فعال");
        cEnable.setCellValueFactory(new PropertyValueFactory<>("enable"));

        tblClass.getColumns().addAll(cRow,cName,cCode,cMasterName,cCapacity,cEnable);
        tblClass.setItems(adminAssistant.getClassTableData());

    }

    private void onClickSaveClass() {
        HashMap<Long,Boolean> hashMap = new HashMap<>();
        tblClass.getItems().forEach(classAdminModel -> hashMap.put(Long.valueOf(classAdminModel.getCode()),classAdminModel.getEnable().isSelected()));
        adminAssistant.saveClasses(hashMap);
    }

    private void onClickAddClass() {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addClass.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //lesson
    private void initLessonTable() {
        TableColumn<LessonAdminModel, Integer> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));
        TableColumn<LessonAdminModel, String> cName = new TableColumn<>("نام");
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<LessonAdminModel, String> cCode = new TableColumn<>("کد درس");
        cCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        TableColumn<LessonAdminModel, Integer> cUnit = new TableColumn<>("تعداد واحد");
        cUnit.setCellValueFactory(new PropertyValueFactory<>("units"));
        TableColumn<LessonAdminModel, JFXToggleButton> cToggle = new TableColumn<>("فعال");
        cToggle.setCellValueFactory(new PropertyValueFactory<>("isPresented"));

        tblLesson.getColumns().addAll(cRow, cName, cCode, cUnit, cToggle);
        tblLesson.setItems(adminAssistant.getLessonTableData());
        //todo update table after adding lesson
    }

    private void onClickSaveLessons() {
        HashMap<Long, Boolean> hashMap = new HashMap<>();
        for (LessonAdminModel item : tblLesson.getItems()) {
            hashMap.put(Long.valueOf(item.getCode()), item.getIsPresented().isSelected());
        }
        adminAssistant.saveLessons(hashMap);
    }

    private void onClickAddLesson() {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addLesson.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //master
    private void initMasterTable() {

        TableColumn<MasterAdminModel, String> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));
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

        tblMaster.getColumns().addAll(cRow, cFirstName, cLastName, cIdNumber, cPhoneNumber, cSend);

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

        //lesson management
        btnAddLesson.setOnAction(e -> onClickAddLesson());
        btnSaveLesson.setOnAction(e -> onClickSaveLessons());
        initLessonTable();

        //class management
        btnAddClass.setOnAction(e -> onClickAddClass());
        btnSaveClass.setOnAction(e -> onClickSaveClass());
        initClassTable();
    }
}
