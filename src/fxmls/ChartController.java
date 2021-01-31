package fxmls;

import assistant.MasterAssistant;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class ChartController implements Initializable {
    public PieChart chart;
    private String classID;
    private MasterAssistant masterAssistant;

    public void setClassID(String classID) {
        this.classID = classID;
    }

    private void initChart() {
        chart.setData(masterAssistant.getChartData(classID));
        chart.setTitle("وضعیت");
        chart.setClockwise(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        masterAssistant = new MasterAssistant();
        initChart();
    }


}
