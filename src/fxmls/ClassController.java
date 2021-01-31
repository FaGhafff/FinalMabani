package fxmls;

import assistant.MasterAssistant;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import tables.ClassMasterModel;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ClassController implements Initializable {
    public TableView<ClassMasterModel> tblClass;
    public JFXButton btnSave;

    private String idClass;
    private MasterAssistant masterAssistant;

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    private void intiTable() {
        TableColumn<ClassMasterModel,Integer> cRow = new TableColumn<>("ردیف");
        cRow.setCellValueFactory(new PropertyValueFactory<>("row"));

        TableColumn<ClassMasterModel,String> cUsername = new TableColumn<>("شماره دانشجویی");
        cUsername.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<ClassMasterModel,String> cLastName = new TableColumn<>("نام خانوادگی");
        cLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<ClassMasterModel,String> cFirstName = new TableColumn<>("نام");
        cFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<ClassMasterModel,String> cGrade = new TableColumn<>("نمره");
        cGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        cGrade.setCellFactory(TextFieldTableCell.forTableColumn());
        cGrade.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setGrade(e.getNewValue()));

        tblClass.getColumns().addAll(cRow,cUsername,cLastName,cFirstName,cGrade);
        tblClass.setItems(masterAssistant.getClassTableData(idClass));

    }

    private void onClickSave() {
        HashMap<String, Double> list = new HashMap<>();
        tblClass.getItems().forEach(item -> {
            double dGrade;
            if (item.getGrade().length()==0)
                dGrade = 0;
            else
                dGrade = Double.parseDouble(item.getGrade());
            list.put(item.getUsername(),dGrade);
        });
        masterAssistant.saveGrades(list,idClass);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        masterAssistant = new MasterAssistant();
        intiTable();
        btnSave.setOnAction(e -> onClickSave());

    }
}
