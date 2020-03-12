/**
* This class is Invoice
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public abstract class Invoice{
    private int id; 
    //private int idFood; 
    private Food food; 
    private String date; 
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
    
    public Invoice (int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus){
        this.id=id; 
        this.food=food; 
        this.date=date; 
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
        return null; 
    }
    
    public String getDate(){
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
    
    public void setDate (String date){
    
    }
    
    public void setTotalPrice (){
    
    }
    
    public void setCustomer (Customer customer){
    
    }
    
    public void setPaymentType (PaymentType paymentType){
        
    }
    
    public void setInvoiceStatus (InvoiceStatus status){
        
    }
    
    public void printData(){
        
    }
    
}
