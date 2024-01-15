package sample;

public class PaymentDetails {
    final private String upi_id,password,upi;

    PaymentDetails(){
        this.upi  = "";
        this.upi_id  = "";
        this.password  = "";
    }

    PaymentDetails(String upi_id,String password,String upi){
        this.upi  = upi;
        this.upi_id  = upi_id;
        this.password  = password;
    }
    public String getUpi(){ return upi; }
    public String getUpiId(){ return upi_id; }
    public String getPassword(){ return password;}
}
