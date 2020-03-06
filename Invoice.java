/**
* This class is Invoice
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class Invoice{
    private int id; 
    private int idFood; 
    private String date; 
    private int totalPrice; 
    private Customer customer; //connecting to Customer class
    private PaymentType paymentType; 
    private InvoiceStatus status; 
    
    /**
    * this method class invoice is used for getting information about food  
    * 
    * @param id, this variable is used for id invoice
    * @param idFodd, this variable is used for id Food
    * @param date, this variable is used for date invoice
    * @param totalPrice, this variable is used for total price
    */
    
    public Invoice (int id, int idFood, String date, Customer customer, int totalPrice, InvoiceStatus status){
        this.id=id; 
        this.idFood=idFood; 
        this.date=date; 
        this.totalPrice=totalPrice; 
        this.customer=customer; 
        this.status=status; 
    }
    
    public int getId(){
         /*
         * @return id
         */
        return id; 
    }
    
    public int getIdFood(){
         /*
         * @return idFood
         */
        return idFood; 
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
    
    public PaymentType getPaymentType(){
        return paymentType; 
    }
    
    public InvoiceStatus getInvoiceStatus(){
        return status; 
    }
    
    public void setId (int id){
    
    }
    
    public void setIdFood(int idFood){
    
    }
    
    public void setDate (String date){
    
    }
    
    public void setTotalPrice (int totalPrice){
    
    }
    
    public void setCustomer (Customer customer){
    
    }
    
    public void setPaymentType (PaymentType paymentType){
        
    }
    
    public void setInvoiceStatus (InvoiceStatus status){
        
    }
    
    public void printData(){
        System.out.println("===============INVOICE=============="); 
        System.out.println("ID: " +id); 
        System.out.println("Food ID: " +idFood); 
        System.out.println("Date: " +date); 
        System.out.println("Customer: " +customer.getName()); 
        System.out.println("Total Price: " +totalPrice); 
        System.out.println("status: " +status); 
        
        //System.out.println(totalPrice); // print name customer
    }
    
}
