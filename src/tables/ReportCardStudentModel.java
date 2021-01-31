package tables;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

public class ReportCardStudentModel {
    private SimpleIntegerProperty row;
    private SimpleStringProperty name;
    private SimpleStringProperty masterName;
    private SimpleIntegerProperty unit;
    private SimpleDoubleProperty grade;
    private Label label;

    public ReportCardStudentModel(int row, String name, String masterName, int unit, double grade, boolean pass) {
        this.row = new SimpleIntegerProperty(row);
        this.name = new SimpleStringProperty(name);
        this.masterName = new SimpleStringProperty(masterName);
        this.unit = new SimpleIntegerProperty(unit);
        this.grade = new SimpleDoubleProperty(grade);
        this.label = new Label();
        if (pass)
            label.setStyle("-fx-background-color: red");
        else
            label.setStyle("-fx-background-color: green");
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

    public String getMasterName() {
        return masterName.get();
    }

    public SimpleStringProperty masterNameProperty() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName.set(masterName);
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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
