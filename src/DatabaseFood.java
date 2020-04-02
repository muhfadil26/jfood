import java.util.ArrayList;

/**
* This class is DatabaseFood
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class DatabaseFood {
    // instance variables - replace the example below with your own
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();
    private static int lastId = 0;


    public static boolean addFood(Food food) {

        FOOD_DATABASE.add(food);
        lastId=food.getId();
        return true;
    }

    public static boolean removeFood(int id) {
        for (int i = 0; i < FOOD_DATABASE.size(); i++) {
            if(id==FOOD_DATABASE.get(i).getId()){
                FOOD_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

    public static Food getFoodById(int id){
        for (int i = 0; i < FOOD_DATABASE.size(); i++) {
            if(id==FOOD_DATABASE.get(i).getId()){
                return FOOD_DATABASE.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId) {
        ArrayList<Food> filteredBySeller= new ArrayList<Food>(0);;
        for (int i = 0; i < FOOD_DATABASE.size(); i++) {
            if(sellerId==FOOD_DATABASE.get(i).getSeller().getId()){
                filteredBySeller.add(FOOD_DATABASE.get(i));
            }
        }
        return filteredBySeller;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        ArrayList<Food> filteredByCategory= new ArrayList<Food>(0);;
        for (int i = 0; i < FOOD_DATABASE.size(); i++) {
            if(category==FOOD_DATABASE.get(i).getCategory()){
                filteredByCategory.add(FOOD_DATABASE.get(i));
            }
        }
        return filteredByCategory;
    }

    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

}