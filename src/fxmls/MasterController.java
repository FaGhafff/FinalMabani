package fxmls;

import assistant.MasterAssistant;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Class;
import models.Master;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MasterController implements Initializable {
    public JFXTextField txtFirsName;
    public JFXTextField txtLastName;
    public JFXTextField txtIdNumber;
    public JFXTextField txtUsername;
    public TabPane tabClass;
    public AnchorPane parentReportCard;
    public TabPane tabReport;
    public ImageView imgExit;
    public Label lblExit;

    private String username;
    private MasterAssistant masterAssistant;

    public void setUsername(String username) {
        this.username = username;
    }

    //profile
    private void initPersonalInfo() {
        Master master = masterAssistant.getMaster(username);
        txtFirsName.setText(master.getFirstName());
        txtLastName.setText(master.getLastName());
        txtIdNumber.setText(master.getIdNumber());
        txtUsername.setText(master.getUsername());
    }

    //class
    private void initClass() throws IOException {
        ArrayList<Class> list = masterAssistant.getClassForMaster(username);
        ArrayList<Tab> tabs = new ArrayList<>();
        for (Class aClass : list) {
            Tab tab = new Tab();
            tab.setText(aClass.getLesson().getName()+" - "+aClass.getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("class.fxml"));
            ClassController classController = new ClassController();
            classController.setIdClass(String.valueOf(aClass.getId()));
            loader.setController(classController);
            Parent root = loader.load();
            tab.setContent(root);
            tabs.add(tab);
        }
        tabClass.getTabs().addAll(tabs);
    }

    //init reports (charts)
    private void initReports() throws IOException {
        ArrayList<Class> list = masterAssistant.getClassForMaster(username);
        ArrayList<Tab> tabs = new ArrayList<>();
        for (Class aClass : list) {
            Tab tab = new Tab();
            tab.setText(aClass.getLesson().getName()+" - "+aClass.getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chart.fxml"));
            ChartController chartController = new ChartController();
            chartController.setClassID(String.valueOf(aClass.getId()));
            loader.setController(chartController);
            Parent root = loader.load();
            tab.setContent(root);
            tabs.add(tab);
        }
        tabReport.getTabs().addAll(tabs);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgExit.setOnMouseClicked(e -> System.exit(0));
        lblExit.setOnMouseClicked(e -> System.exit(0));
        masterAssistant = new MasterAssistant();
    try{
        initPersonalInfo();
        initClass();
        initReports();
    }catch (Exception e){
        System.out.println("MasterController.initialize");
        System.out.println(e.getMessage());
        System.out.println("end");
    }
    }

}
