package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class SampleController {
    String uid,pwd;
    int flag;
    @FXML
    Button login,create;
    @FXML
    CheckBox admin_chk;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    public void handleLogin() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();

        Stage window;
        window = (Stage) login.getScene().getWindow();

        /*Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window;
        window = (Stage) login.getScene().getWindow();*/

        if(admin_chk.isSelected()){
            try{
                if(!(username.getText().equals("java") && password.getText().equals("123")))
                    throw new LoginCredentailsException("Incorrect username or password");
                root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                window = (Stage) login.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }
            catch(LoginCredentailsException e){
                System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect username or password");
                alert.show();
            }
        }
        else {
            try{
                if(Main.count_uid==0)
                    throw new LoginCredentailsException("No user exists");
            }
            catch(LoginCredentailsException e){
                System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No user exists");
                alert.show();
            }

            if (Main.count_uid == 0) {
                Main.count_uid += 0;
                /*Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No user exists");
                alert.show();*/
            } else {
                uid = username.getText();
                pwd = password.getText();

                flag = 0;

                for (int i = 0; i < Main.count_uid; i++) {
                    if (uid.equals(Main.uid_pwd.get(i).get(0)) && pwd.equals(Main.uid_pwd.get(i).get(1))) {
                        flag = 1;
                        Main.cur_uid = i;

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
                        break;
                    }
                }

                try{
                    if(flag==0)
                        throw new LoginCredentailsException("Incorrect username or password");
                }
                catch(LoginCredentailsException e){
                    System.out.println(e);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Incorrect username or password");
                    alert.show();
                }
            }
        }
    }

    public void createFunc() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateId.fxml"));
        Parent root = loader.load();
        Stage window;
        window = (Stage) create.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }
}
