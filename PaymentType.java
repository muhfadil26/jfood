
/**
 * Write a description of class PaymentType here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public enum PaymentType
{
    Cashless ("Cashless"), Cash("Cash"); 
    
    private String paymentType; 
    
    private PaymentType(String paymentType){
        this.paymentType=paymentType; 
    }
    
    public String toString(){
        return paymentType; 
    }
}
