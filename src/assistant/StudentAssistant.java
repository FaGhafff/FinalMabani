package assistant;

import com.sun.istack.internal.NotNull;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Student;
import tables.ReportCardStudentModel;
import tables.SelectUnitStudentModel;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;

public class StudentAssistant {


    //todo
    public ObservableList<ReportCardStudentModel>
    getReportCardTableData(String username) {
        return null;
    }


    //return Student for filling personal info
    public Student getStudent(String username){
        //test
        Student student = new Student();
        student.setLastName("forghani");
        student.setFirstName("ali");
        student.setIdNumber("123");
        student.setUsername("1");
        return student;
    }

    public String getAverage(String username) {
        return "ali";
    }

    public ObservableList<SelectUnitStudentModel> getSelectTableData() {
        ObservableList<SelectUnitStudentModel> list = FXCollections.observableArrayList();
        list.add(new SelectUnitStudentModel(1,"mabani","123","shanbe",2,3,"mamadu"));

        return list;
    }

    public void saveSelections(String username, ArrayList<String> selected) {
        System.out.println("StudentAssistant.saveSelections");
        System.out.println(username);
        selected.forEach(System.out::println);
        System.out.println("end");
    }
}
