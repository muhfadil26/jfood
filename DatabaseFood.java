/**
* This class is DatabaseFood
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class DatabaseFood {
   
   private String[] listFood; 
   
   //tambahan untuk bonus
   private Food food; 

    /**
    * This method is used to check databasefood
    * contain array listFood and boolean default
    * @param listFood, this param is used for listFood
    */
   
   public DatabaseFood(){
    
    }
   
   public boolean addFood(Food food){
       /*
        * @return false, this accesor is used for exit method
        */
          return false; 
    }
    
   public boolean removeFood(Food food){
       /*
        * @return false, this accesor is used for exit method
        */
          return false; 
    }
    
   public String[] getListFood(){
       /*
        * @return listFood, this accesor is used for exit method
        */
        return listFood; 
    }
    
   //tambahan untuk bonus
   public Food setFood(){
            return food; 
    }
   //tambahan untuk bonus
   public Food getFood(){
            return food; 
    }
}
