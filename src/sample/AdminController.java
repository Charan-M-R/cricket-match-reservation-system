package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AdminController {
    @FXML
    Button back;
    @FXML
    TextField t1,t2,t3,t4,t5;

    public void createMatchFunc() throws Exception{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Match Created");
        alert.show();

        Main.matches.add(new ArrayList<String>());
        Main.matches.get(Main.count_matches).add(t1.getText());
        Main.matches.get(Main.count_matches).add(t2.getText());
        Main.matches.get(Main.count_matches).add(t3.getText());
        Main.matches.get(Main.count_matches).add(t4.getText());
        Main.matches.get(Main.count_matches).add(t5.getText());

        Main.count_matches+=1;

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");

    }

    public void goBack() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Stage window;
        window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }
}
