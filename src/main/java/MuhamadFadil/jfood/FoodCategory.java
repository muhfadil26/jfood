package MuhamadFadil.jfood;
/**
 * Write a description of class FoodCategory here.
 * this enum is used for Foodcategory
 * @author Muhamad Fadil
 * @version 5 Maret 2020
 */

public enum FoodCategory
{
    
    Beverage("Beverage"), Coffe("Coffe"), Western("Westren"), Snacks("Snacks"), Rice("Rice"), Noodles("Noodles"), Bakery("Bakery"), Japanese("Japanese");   
    
    private String category; 
    
    private FoodCategory(String category){
        this.category=category; 
    }
    
    public String toString (){
        return category; 
    }
}


   
