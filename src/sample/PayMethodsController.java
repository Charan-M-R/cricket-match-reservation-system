package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class PayMethodsController {
    @FXML
    Button backpaym;
    @FXML
    public void goBackPaym() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();

        Stage window;
        window = (Stage) backpaym.getScene().getWindow();

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
