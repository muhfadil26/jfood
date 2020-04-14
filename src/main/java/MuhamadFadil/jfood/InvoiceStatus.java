package MuhamadFadil.jfood;
/**
 * This class is used for enum Invoice method
 *
 * @author Muhamad fadil
 * @version 6 Maret 2018
 */
public enum InvoiceStatus
{
    Ongoing ("Ongoing"), Finished ("Finished"), Cancelled ("Cancelled"); 
    
    private String status; 
    
    private InvoiceStatus(String status){
        this.status=status; 
    }
    
    public String toString (){
        return status; 
    }
    
}
