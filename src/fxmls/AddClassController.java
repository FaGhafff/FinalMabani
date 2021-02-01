package fxmls;

import assistant.AdminAssistant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import models.Class;
import models.Lesson;
import models.Master;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddClassController implements Initializable {
    public JFXTextField txtCode;
    public JFXTextField txtTime;
    public JFXTextField txtCapacity;
    public JFXButton btnExit;
    public JFXButton btnAdd;
    public JFXComboBox<String> comboMaster;
    public JFXComboBox<String> comboLesson;

    private AdminAssistant adminAssistant;
    private ArrayList<Master> listMasters;
    private ArrayList<Lesson> listLessons;
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
                txtTime.getText().length() == 0 ||
                txtCapacity.getText().length() == 0) {
            if (txtCapacity.getText().length() == 0)
                emptyTextField(txtCapacity);
            if (txtCode.getText().length() == 0)
                emptyTextField(txtCode);
            if (txtTime.getText().length() == 0)
                emptyTextField(txtTime);
            return;
        }
        try {
            Class aClass = new Class();
            aClass.setCapacity(Integer.parseInt(txtCapacity.getText()));
            aClass.setEnable(false);
            aClass.setId(Long.parseLong(txtCode.getText()));
            aClass.setLesson(getLesson(comboLesson));
            aClass.setMaster(getMaster(comboMaster));
            aClass.setTime(txtTime.getText());
            aClass.setStudents(new HashSet<>());
            adminAssistant.addClass(aClass);
        } catch (Exception e) {
            System.out.println("AddClassController.onClickAdd");
            System.out.println(e.getMessage());
        }
    }

    private Master getMaster(JFXComboBox<String> comboMaster) {
        if (comboMaster.getSelectionModel().getSelectedIndex()>-1)
            return listMasters.get(comboMaster.getSelectionModel().getSelectedIndex());
        return null;
    }

    private Lesson getLesson(JFXComboBox<String> comboLesson) {
        if (comboLesson.getSelectionModel().getSelectedIndex()>-1)
            return listLessons.get(comboLesson.getSelectionModel().getSelectedIndex());
        return null;
    }

    private void initComboLesson() {
        comboLesson.getItems().addAll(listLessons.stream().map(lesson -> lesson.getId() + " - " + lesson.getName()).collect(Collectors.toCollection(ArrayList::new)));
    }

    private void initComboMaster() {
        comboMaster.getItems().addAll(listMasters.stream().map(master -> master.getFirstName() + " " + master.getLastName()).collect(Collectors.toCollection(ArrayList::new)));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminAssistant = new AdminAssistant();
        btnAdd.setOnAction(e -> onClickAdd());
        btnExit.setOnAction(e -> ((Stage) btnExit.getScene().getWindow()).close());
        setOnTextChanged(txtTime);
        setOnTextChanged(txtCode);
        setOnTextChanged(txtCapacity);
        listLessons = adminAssistant.getLessonsForAddClass();
        listMasters = adminAssistant.getMastersForAddClass();
        initComboLesson();
        initComboMaster();

    }
}
