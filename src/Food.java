/**
* This class is Food
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class Food{
    private int id; 
    private String name; 
    private Seller seller; //connecting to Seller class
    private int price;    
    private FoodCategory category; 
    
    /**
    * this method is used to check food
    * contains private variable
    * @param id, this variable is used for id Food  
    * @param name, this variable is used for name Food
    * @param seller, this variable is used for seller
    * @param category, this variable is used for category food
    * @param price, this variable is used for price value
    */
   
    public Food (int id, String name, Seller seller, int price, FoodCategory category){
        this.id=id; 
        this.name=name; 
        this.seller=seller; 
        this.price=price; 
        this.category=category; 
    }
    
    public int getId(){
        /*
         * @return id, this is used for returning id 
         */
        return id; 
    }
    
    public String getName(){
         /*
         * @return name, this is used for returning name
         */
        return name; 
    }
    
    public Seller getSeller(){
         /*
         * @return seller, this is used for returning seller
         */
        return seller; 
    }
    
    public int getPrice(){
         /*
         * @return price, this is used for returning price
         */
        return price; 
    }
    
    public FoodCategory getCategory(){
         /*
         * @return category, this is used for returning category
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
    
    public void setCategory(FoodCategory category){
        this.category=category; 
    }
    
    public String toString(){
        String string = "\n"+"Id : "+ id+ "\n"+
        "Name : "+ name+ "\n"+
        "Seller : "+ seller+ "\n"+
        "City : "+ getSeller().getLocation().getCity()+ "\n"+
        "Price : "+ price+ "\n"+
        "Category : "+ category+ "\n";
        return string;
    }
    
}
