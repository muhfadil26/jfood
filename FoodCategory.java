
/**
 * Write a description of class FoodCategory here.
 *
 * @author (your name)
 * @version (a version number or a date)
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


   
