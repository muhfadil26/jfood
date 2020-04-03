
/**
 * this class is used for class Promo
 *
 * @author Muhamad Fadil
 * @version 12 Maret 2020
 */
public class Promo
{
    private int id; 
    private String code; 
    private int discount; 
    private int minPrice; 
    private boolean active; 
    
    
     /**
    * this method class invoice is used for getting information about food  
    * 
    * @param id, this variable is used for id invoice
    * @param code, this variable is used for id code
    * @param discount, this variable is used for discount
    * @param minPrice, this variable is used for minPrice
    * @param actice, this variable is used for active
    */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        this.id=id; 
        this.code=code; 
        this.discount=discount; 
        this.minPrice=minPrice; 
        this.active=active; 
        
    }
    
    public int getId(){
        return id; 
    }
    
    public String getCode(){
        return code; 
    }
    
    public int getDiscount(){
        return discount; 
    }
    
    public int getMinPrice(){
        return minPrice; 
    }
    
    public boolean getActive(){
        return true; 
    }
        
    public void setId(int id){
        
    }
    
    public void setCode(String code){
        
    }
    
    public void setDiscount(int discount){
        
    }
    
    public void setMinPrice(int minPrice){
        
    }
    
    public void setActice(boolean active){
        
    }
    
    public String toString(){
         return 

        "\n"+"Id = "+ id+ "\n"+
        "Code = "+ code+ "\n"+
        "Discount = "+ discount+ "\n"+
        "MinPrice = "+ minPrice+ "\n"+
        "Active Status = "+ active+ "\n";
    }

    public void setActive(boolean b) {
    }
}
