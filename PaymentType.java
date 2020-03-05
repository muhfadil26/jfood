
/**
 * this class is enum .
 *
 * @author Muhamad Fadil
 * @version 5 Maret 2020
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
