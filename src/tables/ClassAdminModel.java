package tables;

import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClassAdminModel {

    private SimpleIntegerProperty row;
    private SimpleStringProperty name;
    private SimpleStringProperty code;
    private SimpleStringProperty masterName;
    private SimpleIntegerProperty capacity;
    private JFXToggleButton enable;

    public ClassAdminModel(int row, String name, String code, String masterName, int capacity,boolean isEnable) {
        this.row = new SimpleIntegerProperty(row);
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
        this.masterName = new SimpleStringProperty(masterName);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.enable = new JFXToggleButton();
        this.enable.setSelected(isEnable);
    }

    public int getRow() {
        return row.get();
    }

    public SimpleIntegerProperty rowProperty() {
        return row;
    }

    public void setRow(int row) {
        this.row.set(row);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCode() {
        return code.get();
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getMasterName() {
        return masterName.get();
    }

    public SimpleStringProperty masterNameProperty() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName.set(masterName);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public SimpleIntegerProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    public JFXToggleButton getEnable() {
        return enable;
    }

    public void setEnable(JFXToggleButton enable) {
        this.enable = enable;
    }
}
