package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentController {
    int match, stand, num_of_seats;
    String upiText, pwdText, upiType;
    @FXML
    Button backpay;
    @FXML
    TextField upi,pwd;
    @FXML
    RadioButton r1,r2,r3;
    public void getInfo(int i, int j,int k){
        match = i;
        stand = j;
        num_of_seats = k;
    }
    @FXML
    public void backfromPay() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();

        Stage window;
        window = (Stage) backpay.getScene().getWindow();

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
    @FXML
    public void payment() throws Exception{
        upiText = upi.getText();
        pwdText = pwd.getText();

        Pattern p = Pattern.compile("\\b[A-Za-z0-9._%-]+@[A-Za-z.-]");
        Matcher m = p.matcher(upiText);

        if(!m.find()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter UPI ID");
            alert.show();
            return;
        }
        if(pwdText.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter Password");
            alert.show();
            return;
        }
        if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Select a UPI method");
            alert.show();
            return;
        }

        if(r1.isSelected())
            upiType = "Gpay";
        if(r2.isSelected())
            upiType = "PhonePe";
        if(r3.isSelected())
            upiType = "Paytm";

        if(Main.count[Main.cur_uid]==5){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Booking unsuccesful\nMaximum number of orders have been reached");
            alert1.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Payment done\n"+num_of_seats+" seats have been booked");
            alert.show();

            PaymentDetails payee = new PaymentDetails(upiText, pwdText, upiType);
            Main.orders[Main.cur_uid][Main.count[Main.cur_uid]] = new BookingDetails(payee, stand, num_of_seats, Main.matches.get(match).get(0), Main.matches.get(match).get(1), Main.matches.get(match).get(2), Main.matches.get(match).get(3), Main.matches.get(match).get(4));
            Main.count[Main.cur_uid] += 1;
        }
    }
}
