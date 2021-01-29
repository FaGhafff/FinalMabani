package tables;

import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LessonAdminModel {

    private SimpleIntegerProperty row;
    private SimpleStringProperty name;
    private SimpleStringProperty code;
    private SimpleIntegerProperty units;
    private JFXToggleButton isPresented;

    public LessonAdminModel(int row, String name, String  code, int units,boolean isPresented) {
        this.row = new SimpleIntegerProperty(row);
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
        this.units = new SimpleIntegerProperty(units);
        this.isPresented = new JFXToggleButton();
        this.isPresented.setSelected(isPresented);
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

    public int getUnits() {
        return units.get();
    }

    public SimpleIntegerProperty unitsProperty() {
        return units;
    }

    public void setUnits(int units) {
        this.units.set(units);
    }

    public JFXToggleButton getIsPresented() {
        return isPresented;
    }

    public void setIsPresented(JFXToggleButton isPresented) {
        this.isPresented = isPresented;
    }
}
