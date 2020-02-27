
public class Invoice
{
    private int id; 
    private int idFood; 
    private String date; 
    private int totalPrice; 
    private Customer customer; 
    
    public Invoice (int id, int idFood, String date, Customer customer, int totalPrice){
        this.id=id; 
        this.idFood=idFood; 
        this.date=date; 
        this.totalPrice=totalPrice; 
        this.customer=customer; 
    }
    
    public int getId(){
        return id; 
    }
    
    public int getIdFood(){
        return idFood; 
    }
    
    public String getDate(){
        return date; 
    }
    
    public int getTotalPrice(){
        return totalPrice; 
    }
    
    public Customer getCustomer(){
        return customer; 
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
    
     public void printData(){
    
    }
    
}
