package fxmls;

import assistant.StudentAssistant;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tables.ReportCardStudentModel;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportCardController implements Initializable {

    public TableView<ReportCardStudentModel> tblReport;
    public Label lblAve;
    public JFXButton btnExit;
    public JFXButton btnPDF;

    private StudentAssistant studentAssistant;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    private void initTable() {
        TableColumn<ReportCardStudentModel, Integer> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));
        TableColumn<ReportCardStudentModel, String> cName = new TableColumn<>("نام درس");
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ReportCardStudentModel, String> cMasterName = new TableColumn<>("نام استاد");
        cMasterName.setCellValueFactory(new PropertyValueFactory<>("masterName"));
        TableColumn<ReportCardStudentModel, Integer> cUnit = new TableColumn<>("تعداد واحد");
        cUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        TableColumn<ReportCardStudentModel, Double> cGrade = new TableColumn<>("نمره");
        cGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        TableColumn<ReportCardStudentModel,Label> cLabel = new TableColumn<>("قبول / رد");
        cLabel.setCellValueFactory(new PropertyValueFactory<>("label"));
        tblReport.getColumns().addAll(cRow,cName,cMasterName,cUnit,cGrade,cLabel);
        tblReport.setItems(studentAssistant.getReportCardTableData(username));
    }

    private void calculateAverage(){
        lblAve.setText(lblAve.getText() +" "+studentAssistant.getAverage(username));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentAssistant = new StudentAssistant();
        btnExit.setOnAction(e -> ((Stage) btnExit.getScene().getWindow()).close());
        btnPDF.setDisable(true);
        btnPDF.setVisible(false);
        initTable();
        calculateAverage();
    }
}
