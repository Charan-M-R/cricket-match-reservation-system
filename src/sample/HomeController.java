package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class HomeController {
    int sel = 0,temp=0;
    @FXML
    Button home,select1,paym,orders;
    @FXML
    Label l1,l2,l3,l4,l5;

    @FXML
    public void goHome() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window;
        window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }
    public void goPaym() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("paymethods.fxml"));
        Stage window;
        window = (Stage) paym.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }
    public void goOrders() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Orders.fxml"));
        Parent root = loader.load();
        OrdersController ordersController = loader.getController();

        for(int i=0;i<Main.count[Main.cur_uid];i++){
            switch(i){
                case 0: ordersController.l1.setText("Match: "+Main.orders[Main.cur_uid][i].getMatch()+"\t\tSeries: "+Main.orders[Main.cur_uid][i].getSeries()+"\n"+"Date: "+Main.orders[Main.cur_uid][i].getDate()+"\t\tTime: "+Main.orders[Main.cur_uid][i].getTime()+"\nVenue: "+Main.orders[Main.cur_uid][i].getVenue()+"\t\tTickets: "+Main.orders[Main.cur_uid][i].getNumOfSeats()+"\t\tStand: "+Main.orders[Main.cur_uid][i].getstand());
                    break;
                case 1: ordersController.l2.setText("Match: "+Main.orders[Main.cur_uid][i].getMatch()+"\t\tSeries: "+Main.orders[Main.cur_uid][i].getSeries()+"\n"+"Date: "+Main.orders[Main.cur_uid][i].getDate()+"\t\tTime: "+Main.orders[Main.cur_uid][i].getTime()+"\nVenue: "+Main.orders[Main.cur_uid][i].getVenue()+"\t\tTickets: "+Main.orders[Main.cur_uid][i].getNumOfSeats()+"\t\tStand: "+Main.orders[Main.cur_uid][i].getstand());
                    break;
                case 2: ordersController.l3.setText("Match: "+Main.orders[Main.cur_uid][i].getMatch()+"\t\tSeries: "+Main.orders[Main.cur_uid][i].getSeries()+"\n"+"Date: "+Main.orders[Main.cur_uid][i].getDate()+"\t\tTime: "+Main.orders[Main.cur_uid][i].getTime()+"\nVenue: "+Main.orders[Main.cur_uid][i].getVenue()+"\t\tTickets: "+Main.orders[Main.cur_uid][i].getNumOfSeats()+"\t\tStand: "+Main.orders[Main.cur_uid][i].getstand());
                    break;
                case 3: ordersController.l4.setText("Match: "+Main.orders[Main.cur_uid][i].getMatch()+"\t\tSeries: "+Main.orders[Main.cur_uid][i].getSeries()+"\n"+"Date: "+Main.orders[Main.cur_uid][i].getDate()+"\t\tTime: "+Main.orders[Main.cur_uid][i].getTime()+"\nVenue: "+Main.orders[Main.cur_uid][i].getVenue()+"\t\tTickets: "+Main.orders[Main.cur_uid][i].getNumOfSeats()+"\t\tStand: "+Main.orders[Main.cur_uid][i].getstand());
                    break;
                case 4: ordersController.l5.setText("Match: "+Main.orders[Main.cur_uid][i].getMatch()+"\t\tSeries: "+Main.orders[Main.cur_uid][i].getSeries()+"\n"+"Date: "+Main.orders[Main.cur_uid][i].getDate()+"\t\tTime: "+Main.orders[Main.cur_uid][i].getTime()+"\nVenue: "+Main.orders[Main.cur_uid][i].getVenue()+"\t\tTickets: "+Main.orders[Main.cur_uid][i].getNumOfSeats()+"\t\tStand: "+Main.orders[Main.cur_uid][i].getstand());
                    break;

            }
        }

        Stage window;
        window = (Stage) orders.getScene().getWindow();
        window.setScene(new Scene(root,600,400));

        /*Parent root = FXMLLoader.load(getClass().getResource("Orders.fxml"));
        Stage window;
        window = (Stage) orders.getScene().getWindow();
        window.setScene(new Scene(root,600,400));*/
    }
    public void SelectAction() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("match.fxml"));
        Parent root = loader.load();
        MatchController matchController = loader.getController();
        matchController.display(sel);

        Stage window;
        window = (Stage) select1.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }
    public void select1Action() throws Exception{
        if(Main.count_matches<1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Match doesn't exist");
            alert.show();
            return;
        }
        sel = 0;
        SelectAction();
    }
    public void select2Action() throws Exception{
        if(Main.count_matches<2){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Match doesn't exist");
            alert.show();
            return;
        }
        sel = 1;
        SelectAction();
    }
    public void select3Action() throws Exception{
        if(Main.count_matches<3){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Match doesn't exist");
            alert.show();
            return;
        }
        sel = 2;
        SelectAction();
    }

    public void select4Action() throws Exception{
        if(Main.count_matches<4){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Match doesn't exist");
            alert.show();
            return;
        }
        sel = 3;
        SelectAction();
    }

    public void select5Action() throws Exception{
        if(Main.count_matches<5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Match doesn't exist");
            alert.show();
            return;
        }
        sel = 4;
        SelectAction();
    }
}
