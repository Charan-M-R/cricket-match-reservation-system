package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OrdersController {
    @FXML
    Button back;
    @FXML
    Label l1,l2,l3,l4,l5;
    @FXML
    public void goBack() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();

        Stage window;
        window = (Stage) back.getScene().getWindow();

        for(int j=1;j<=Main.count_matches;j++){
            switch(j){
                case 1: homeController.l1.setText(Main.matches.get(j-1).get(0));
                    break;
                case 2: homeController.l2.setText(Main.matches.get(j-1).get(0));
                    break;
                case 3: homeController.l3.setText(Main.matches.get(j-1).get(0));
                    break;
                case 4: homeController.l4.setText(Main.matches.get(j-1).get(0));
                    break;
                case 5: homeController.l5.setText(Main.matches.get(j-1).get(0));
                    break;
            }
        }
        window.setScene(new Scene(root, 600, 400));
    }
}
