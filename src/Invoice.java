/**
* This class is Invoice
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;


public abstract class Invoice{
    private int id; 
    //private int idFood;
    private ArrayList<Food> foods;
    //private Food food;
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
    * @param foods, this variable is used for id Food
    * @param date, this variable is used for date invoice
    * @param totalPrice, this variable is used for total price
    * @param customer, this variable is used for customer
    */
    
    public Invoice (int id, ArrayList<Food> foods, Customer customer){
        
        this.id=id; 
        this.foods=foods;
        //this.date=new isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.date= new GregorianCalendar(); 
        this.customer=customer; 

    }
    
    public int getId(){
         /*
         * @return id
         */
        return id; 
    }
    
    public ArrayList<Food> getFoods(){
         /*
         * @return idFood
         */
        return foods;
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
    
    public void setFoods(ArrayList<Food> foods){
            this.foods=this.foods;
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
