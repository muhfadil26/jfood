/**
* This class is Invoice
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/
import java.util.*; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Invoice{
    private int id; 
    //private int idFood; 
    private Food food; 
    private Calendar date; 
    protected int totalPrice; 
    private Customer customer; //connecting to Customer class
    private InvoiceStatus invoiceStatus; 
    //private PaymentType paymentType; 
    //private InvoiceStatus status; 
    
    /**
    * this method class invoice is used for getting information about food  
    * 
    * @param id, this variable is used for id invoice
    * @param food, this variable is used for id Food
    * @param date, this variable is used for date invoice
    * @param totalPrice, this variable is used for total price
    * @param customer, this variable is used for customer
    */
    
    public Invoice (int id, Food food, Customer customer, InvoiceStatus invoiceStatus){
        
        this.id=id; 
        this.food=food; 
        //this.date=new isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.date= new GregorianCalendar(); 
        this.customer=customer; 
        this.invoiceStatus=invoiceStatus; 
    }
    
    public int getId(){
         /*
         * @return id
         */
        return id; 
    }
    
    public Food getFood(){
         /*
         * @return idFood
         */
        return food; 
    }
    
    public Calendar getDate(){
         /*
         * @return date
         */
        return date; 
    }
    
    public int getTotalPrice(){
        return totalPrice; 
    }
    
    public Customer getCustomer(){
        return customer; 
    }
    
    public abstract PaymentType getPaymentType(); 
    
    public InvoiceStatus getInvoiceStatus(){
        return invoiceStatus; 
    }
    
    public void setId (int id){
    
    }
    
    public void setFood(Food food){
    
    }
    
    public Calendar setDate (Calendar date){
        this.date=date; 
        return date;  
    }
    
    public Calendar setDate (int year, int month, int dayOfMonth){
            this.date= new GregorianCalendar(year,month,dayOfMonth);
            return null; 
    }
    
    public void setTotalPrice (){
    
    }
    
    public void setCustomer (Customer customer){
    
    }
    
    public void setPaymentType (PaymentType paymentType){
        
    }
    
    public void setInvoiceStatus (InvoiceStatus status){
        
    }
    
    public String toString(){
        return null; 
    }
    
}
