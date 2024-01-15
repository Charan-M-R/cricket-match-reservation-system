package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
class LoginCredentailsException extends Exception
{
    String type;
    LoginCredentailsException(String type) {
        this.type = type;
    }
    public String toString() {
        return type;
    }
}
interface MatchRequirements{
    String getMatch();
    String getSeries();
    String getDate();
    String getTime();
    String getVenue();
}

interface BookingDetailsRequirements extends MatchRequirements{
    int getstand();
    int getNumOfSeats();
}

class Match implements MatchRequirements{
    final private String match, series, date, time, venue;

    Match(){
        this.match ="";
        this.series="";
        this.date = "";
        this.time = "";
        this.venue= "";
    }
    Match(String match,String series,String date,String time,String venue){
        this.match = match;
        this.series = series;
        this.date = date;
        this.time = time;
        this.venue= venue;
    }
    public String getMatch(){ return match; }
    public String getSeries(){ return series; }
    public String getDate(){ return date; }
    public String getTime(){ return time; }
    public String getVenue(){ return venue; }
}

class BookingDetails extends Match implements BookingDetailsRequirements{
    PaymentDetails payment_details;
    final private int stand, num_of_seats;

    BookingDetails(PaymentDetails payment_details,int stand, int num_of_seats,String match,String series,String date,String time,String venue){
        super(match, series, date, time, venue);
        this.payment_details = payment_details;
        this.stand = stand;
        this.num_of_seats = num_of_seats;
    }

    public int getstand(){ return stand; }
    public int getNumOfSeats(){ return num_of_seats; }
}

public class Main extends Application {
    //public static int s1=100,s2=100,s3=100,s4=100,s5=100,s6=100,s7=100,s8=100,s9=100,s10=100,s11=100,s12=100;
    public static int s1[] = new int[5];
    public static int s2[] = new int[5];
    public static int s3[] = new int[5];
    public static int s4[] = new int[5];
    public static int s5[] = new int[5];
    public static int s6[] = new int[5];
    public static int s7[] = new int[5];
    public static int s8[] = new int[5];
    public static int s9[] = new int[5];
    public static int s10[] = new int[5];
    public static int s11[] = new int[5];
    public static int s12[] = new int[5];
    public static int cur_uid;
    public static int count_uid=0,count_matches=0;
    public static int count[] = new int[100];
    public static BookingDetails[][] orders= new BookingDetails[100][5];
    public static ArrayList<ArrayList<String> > uid_pwd = new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String> > matches = new ArrayList<ArrayList<String>>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        for(int j=0;j<100;j++)
            count[j]=0;

        for(int j=0;j<5;j++){
            s1[j] = 100;
            s2[j] = 100;
            s3[j] = 100;
            s4[j] = 100;
            s5[j] = 100;
            s6[j] = 100;
            s7[j] = 100;
            s8[j] = 100;
            s9[j] = 100;
            s10[j] = 100;
            s11[j] = 100;
            s12[j] = 100;
        }
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cricket Match Reservation system");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
