package MuhamadFadil.jfood;
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
    private ArrayList<Food> foods;
    private Calendar date; 
    protected int totalPrice; 
    private Customer customer; //connecting to Customer class
    private InvoiceStatus invoiceStatus;
    
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
        Calendar calendar = Calendar.getInstance();

        this.id = id;
        this.foods = foods;
        this.customer = customer;
        this.date = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        this.invoiceStatus = InvoiceStatus.Ongoing;

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
        this.id=id;
    }
    
    public void setFoods(ArrayList<Food> foods){
            this.foods=this.foods;
    }
    
    public Calendar setDate (Calendar date){
        this.date=date; 
        return date;  
    }
    
    public  void setDate (int year, int month, int dayOfMonth){
            this.date= new GregorianCalendar(year,month,dayOfMonth);
    }
    
    public abstract void setTotalPrice ();
    
    public void setCustomer (Customer customer){
        this.customer=customer;
    }

    public void setInvoiceStatus (InvoiceStatus invoiceStatus){
        this.invoiceStatus=invoiceStatus;
    }
    
    public abstract String toString();
    
}
