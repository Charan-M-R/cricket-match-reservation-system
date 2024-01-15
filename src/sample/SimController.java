package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

interface lambda {
    int sub(int t);
}
public class SimController {
    int match,stand,num_of_seats;
    int flag=0;
    String temp;
    @FXML
    Button  simback, gotopay;

    @FXML
    TextField price,seats,seat_book;
    @FXML
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12;

    public void getMatch(int i){
        match = i;
    }
    @FXML
    public void goBackSim() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("match.fxml"));
        Parent root = loader.load();
        MatchController matchController = loader.getController();
        matchController.display(match);

        Stage window;
        window = (Stage) simback.getScene().getWindow();
        window.setScene(new Scene(root,600,400));

        /*Parent root = FXMLLoader.load(getClass().getResource("match.fxml"));
        Stage window;
        window = (Stage) simback.getScene().getWindow();
        window.setScene(new Scene(root,600,400));*/
    }

    public void goToPay() throws Exception{
        lambda res = (b) -> {
            return (b-num_of_seats);
        };

        if(flag==0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Stand not selected");
            alert.show();
            return;
        }

        num_of_seats = Integer.parseInt(seat_book.getText());
        if(num_of_seats==0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Enter number of seats");
            alert.show();
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
        Parent root = loader.load();
        PaymentController paymentController = loader.getController();
        paymentController.getInfo(match, stand,num_of_seats);

        switch(stand){
            case 1: if(num_of_seats>Main.s1[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s1[match] = res.sub(Main.s1[match]);
                break;
            case 2: if(num_of_seats>Main.s2[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s2[match] = res.sub(Main.s2[match]);
                break;
            case 3: if(num_of_seats>Main.s3[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s3[match] = res.sub(Main.s3[match]);
                break;
            case 4: if(num_of_seats>Main.s4[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s4[match] = res.sub(Main.s4[match]);
                break;
            case 5: if(num_of_seats>Main.s5[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s5[match] = res.sub(Main.s5[match]);
                break;
            case 6: if(num_of_seats>Main.s6[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s6[match] = res.sub(Main.s6[match]);
                break;
            case 7: if(num_of_seats>Main.s7[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s7[match] = res.sub(Main.s7[match]);
                break;
            case 8: if(num_of_seats>Main.s8[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s8[match] = res.sub(Main.s8[match]);
                break;
            case 9: if(num_of_seats>Main.s9[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s9[match] = res.sub(Main.s9[match]);
                break;
            case 10: if(num_of_seats>Main.s10[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s10[match] = res.sub(Main.s10[match]);
                break;
            case 11: if(num_of_seats>Main.s11[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s11[match] = res.sub(Main.s11[match]);
                break;
            case 12: if(num_of_seats>Main.s12[match]){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Available seats are lesser");
                alert.show();
                return;
            }
                Main.s12[match] = res.sub(Main.s12[match]);
                break;
        }
        Stage window;
        window = (Stage) gotopay.getScene().getWindow();
        window.setScene(new Scene(root,600,400));

        /*Parent root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
        Stage window;
        window = (Stage) gotopay.getScene().getWindow();
        window.setScene(new Scene(root,600,400));*/

    }

    public void click(){
        flag = 1;

        if(r1.isSelected()) {
            seats.setText(String.valueOf(Main.s1[match]));
            price.setText(String.valueOf(500));
            stand = 1;
        }
        else if(r2.isSelected()) {
            seats.setText(String.valueOf(Main.s2[match]));
            price.setText(String.valueOf(500));
            stand = 2;
        }
        else if(r3.isSelected()) {
            seats.setText(String.valueOf(Main.s3[match]));
            price.setText(String.valueOf(500));
            stand = 3;
        }
        else if(r4.isSelected()) {
            seats.setText(String.valueOf(Main.s4[match]));
            price.setText(String.valueOf(500));
            stand = 4;
        }
        else if(r5.isSelected()) {
            seats.setText(String.valueOf(Main.s5[match]));
            price.setText(String.valueOf(500));
            stand = 5;
        }
        else if(r6.isSelected()) {
            seats.setText(String.valueOf(Main.s6[match]));
            price.setText(String.valueOf(500));
            stand = 6;
        }
        else if(r7.isSelected()) {
            seats.setText(String.valueOf(Main.s7[match]));
            price.setText(String.valueOf(1000));
            stand = 7;
        }
        else if(r8.isSelected()) {
            seats.setText(String.valueOf(Main.s8[match]));
            price.setText(String.valueOf(1000));
            stand = 8;
        }
        else if(r9.isSelected()) {
            seats.setText(String.valueOf(Main.s9[match]));
            price.setText(String.valueOf(1000));
            stand = 9;
        }
        else if(r10.isSelected()) {
            seats.setText(String.valueOf(Main.s10[match]));
            price.setText(String.valueOf(1000));
            stand = 10;
        }
        else if(r11.isSelected()) {
            seats.setText(String.valueOf(Main.s11[match]));
            price.setText(String.valueOf(1000));
            stand = 11;
        }
        else if(r12.isSelected()) {
            seats.setText(String.valueOf(Main.s12[match]));
            price.setText(String.valueOf(1000));
            stand = 12;
        }
        else{
            seats.setText("");
            price.setText("");
        }
    }
}
