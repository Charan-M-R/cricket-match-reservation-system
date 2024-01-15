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

public class CreateIdController {
    @FXML
    Button create, back;
    @FXML
    TextField username,password;

    public void createId() throws Exception{
        Main.uid_pwd.add(new ArrayList<String>());
        Main.uid_pwd.get(Main.count_uid).add(username.getText());
        Main.uid_pwd.get(Main.count_uid).add(password.getText());
        Main.count_uid+=1;

        username.setText("");
        password.setText("");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("User ID created");
        alert.show();
    }

    public void goBack() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Stage window;
        window = (Stage) create.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }
}
