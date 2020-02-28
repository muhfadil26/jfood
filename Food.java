/**
* This class is Food
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class Food{//this class is use for Food
    /**
    * this method is used to check food
    * contains private variable
    * @param id, this is a variable 
    * @param name, this is a variable  
    * @param seller, this is a variable 
    * @param category, this is a variable 
    * @param seller, this is a variable 
    */
    private int id; 
    private String name; 
    private int price; 
    private String category;
    private Seller seller;  
    
    public Food(int id, String name, Seller seller, int price, String category){
        this.id=id; 
        this.name=name; 
        this.seller=seller; 
        this.price=price; 
        this.category=category; 
    }
    
    public int getId(){
        /*
         * @return id
         */
        return id; 
    }
    
    public String getName(){
         /*
         * @return name
         */
        return name; 
    }
    
    public Seller getSeller(){
         /*
         * @return seller
         */
        return seller; 
    }
    
    public int getPrice(){
         /*
         * @return price
         */
        return price; 
    }
    
    public String getCategory(){
         /*
         * @return category
         */
        return category; 
    }
    
    public void setId (int id){
        this.id=id; 
    }
    
    public void setName(String name){
        this.name=name; 
    }
    
    public void setSeller (Seller seller){
    
    }
    
    public void setPrice(int price){
        this.price=price; 
    }
    
    public void setCategory(String category){
        this.category=category; 
    }
    
    public void printData(){
    
    }
    
    
    
}
