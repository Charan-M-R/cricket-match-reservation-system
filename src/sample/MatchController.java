package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MatchController {
    int match;
    /*public static String[][] arr= {{"Ind vs NZ","WTC final","18/06/21","1500 Hrs","Southampton"},
            {"RSA vs WI 4th T20I","SA tour of WI 2021","01/07/21","1130 Hrs","St lucia"},
            {"Ind vs SL 1st ODI","India tour of SL 2021","18/06/21","1430 Hrs","Colombo"}};*/

    @FXML
    Button back,book;
    @FXML
    TextField d1,d2,d3,d4,d5;

    public void display(int s){
        match = s;
        d1.setText(Main.matches.get(s).get(0));
        d2.setText(Main.matches.get(s).get(1));
        d3.setText(Main.matches.get(s).get(2));
        d4.setText(Main.matches.get(s).get(3));
        d5.setText(Main.matches.get(s).get(4));
    }
    @FXML
    public void backHome() throws Exception{
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

        /*Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window;
        window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,600,400));*/
    }
    public void bookTickets() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sim.fxml"));
        Parent root = loader.load();
        SimController simController = loader.getController();
        simController.getMatch(match);

        Stage window;
        window = (Stage) book.getScene().getWindow();
        window.setScene(new Scene(root,600,400));

        /*Parent root = FXMLLoader.load(getClass().getResource("sim.fxml"));
        Stage window;
        window = (Stage) book.getScene().getWindow();
        window.setScene(new Scene(root,600,400));*/
    }
}
