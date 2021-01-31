package assistant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import models.Class;
import models.Master;
import tables.ClassMasterModel;

import java.util.ArrayList;
import java.util.HashMap;

public class MasterAssistant {
    public ObservableList<PieChart.Data> getChartData(String classID) {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.add(new PieChart.Data("علی",30));
        list.add(new PieChart.Data("فاطمه",40));
        list.add(new PieChart.Data("مجید",50));
        return list;
    }

    public void saveGrades(HashMap<String, Double> list, String idClass) {
    }

    public ObservableList<ClassMasterModel> getClassTableData() {
        return null;
    }

    public Master getMaster(String username) {
        return new Master();
    }

    public ArrayList<Class> getClassForMaster(String username) {
        return new ArrayList<Class>();
    }
}
