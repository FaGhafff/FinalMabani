package tables;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.text.SimpleDateFormat;

public class SelectUnitStudentModel {

    private SimpleIntegerProperty row;
    private SimpleStringProperty name;
    private SimpleStringProperty code;
    private SimpleStringProperty time;
    private SimpleIntegerProperty capacity;
    private SimpleIntegerProperty unit;
    private SimpleStringProperty masterName;
    private CheckBox select;

    public SelectUnitStudentModel(int row,
                                  String name,
                                  String code,
                                  String time,
                                  int capacity,
                                  int unit,
                                  String masterName) {
        this.row = new SimpleIntegerProperty(row);
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
        this.time = new SimpleStringProperty(time);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.unit = new SimpleIntegerProperty(unit);
        this.masterName = new SimpleStringProperty(masterName);
        this.select = new CheckBox("انتخاب");
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

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
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

    public int getUnit() {
        return unit.get();
    }

    public SimpleIntegerProperty unitProperty() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit.set(unit);
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

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }
}
