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

        if (FOOD_DATABASE.add(food)) {
            FOOD_DATABASE.indexOf(food);
            return true;
        }
        return false;
    }

    public static boolean removeFood(int id) {
        Food food = FOOD_DATABASE.get(id);
        if (food != null) {
            FOOD_DATABASE.remove(food);
            return true;
        }
        return false;
    }

    public static Food getFoodById(int idx){
        Food food = FOOD_DATABASE.get(idx);

        if (food != null) {
            return food;
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int idseller) {
        ArrayList<Food> ret = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if (food.getSeller().getId() == idseller) {
                ret.add(food);
            }
        }
        return ret;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        ArrayList<Food> ret = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if (food.getCategory() == category) {
                ret.add(food);
            }
        }
        return ret;
    }

    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

}