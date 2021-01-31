package fxmls;

import assistant.StudentAssistant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Student;
import tables.SelectUnitStudentModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public JFXTextField txtFirsName;
    public JFXTextField txtLastName;
    public JFXTextField txtIdNumber;
    public JFXTextField txtUsername;
    public TableView<SelectUnitStudentModel> tblSelect;
    public JFXButton btnSaveUnit;
    public AnchorPane parentReportCard;
    public ImageView imgExit;
    public Label lblExit;

    private StudentAssistant studentAssistant;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    private void initPersonalInfo() {
        Student student = studentAssistant.getStudent(username);
        txtFirsName.setText(student.getFirstName());
        txtLastName.setText(student.getLastName());
        txtIdNumber.setText(student.getIdNumber());
        txtUsername.setText(student.getUsername());
    }

    private void initSelectTable() {
        tblSelect.getItems().clear();
        tblSelect.getColumns().clear();

        TableColumn<SelectUnitStudentModel, Integer> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));
        TableColumn<SelectUnitStudentModel, String> cName = new TableColumn<>("نام درس");
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<SelectUnitStudentModel, String> cCode = new TableColumn<>("کد درس");
        cCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        TableColumn<SelectUnitStudentModel, String> cTime = new TableColumn<>("زمان");
        cTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        TableColumn<SelectUnitStudentModel, Integer> cCapacity = new TableColumn<>("ظرفیت");
        cCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        TableColumn<SelectUnitStudentModel, Integer> cUnit = new TableColumn<>("واحد");
        cUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        TableColumn<SelectUnitStudentModel, String> cMasterName = new TableColumn<>("نام استاد");
        cMasterName.setCellValueFactory(new PropertyValueFactory<>("masterName"));
        TableColumn<SelectUnitStudentModel, CheckBox> cSelect = new TableColumn<>("انتخاب");
        cSelect.setCellValueFactory(new PropertyValueFactory<>("select"));

        tblSelect.getColumns().addAll(cRow, cName,cCode,cTime, cCapacity, cUnit, cMasterName, cSelect);
        tblSelect.setItems(studentAssistant.getSelectTableData());

    }

    private void initReportCard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reportCard.fxml"));
            ReportCardController reportCardController = new ReportCardController();
            reportCardController.setUsername(username);
            loader.setController(reportCardController);
            Parent root = loader.load();
            parentReportCard.getChildren().setAll(root);
        } catch (Exception e) {
            System.out.println("StudentController.initReportCard");
            System.err.println(e.getMessage());
        }
    }

    private void onClickSave() {
        ArrayList<String> selected = new ArrayList<>();
        for (SelectUnitStudentModel item : tblSelect.getItems())
            if (item.getSelect().isSelected())
                selected.add(item.getCode());
        studentAssistant.saveSelections(username, selected);
        initSelectTable();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentAssistant = new StudentAssistant();

        //exit listener
        imgExit.setOnMouseClicked(e -> System.exit(0));
        lblExit.setOnMouseClicked(e -> System.exit(0));

        btnSaveUnit.setOnAction(e -> onClickSave());

        initPersonalInfo();
        initReportCard();
        initSelectTable();
    }
}
