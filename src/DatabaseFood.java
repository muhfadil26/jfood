import java.util.ArrayList;

/**
* This class is DatabaseFood
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class DatabaseFood {
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public DatabaseFood()
    {
        // initialise instance variables
    }

    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    public static int getlastId()
    {
        return lastId;
    }

    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        Food food = FOOD_DATABASE.get(id);
        if (food != null) {
            return food;
        }
        throw new FoodNotFoundException(id);
    }

    public static ArrayList<Food> getFoodBySeller (int sellerId)
    {
        ArrayList<Food> array1 = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                array1.add(food);
            }
        }
        return array1;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category)
    {
        ArrayList<Food> array1 = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if (food.getCategory() == category) {
                array1.add(food);
            }
        }
        return array1;
    }

    public static boolean addFood(Food food) //throws FoodNotFoundException
    {
        // put your code here
        FOOD_DATABASE.add(food);
        FOOD_DATABASE.indexOf(food);
        return true;

        //throw new FoodNotFoundException(food.getId());
    }

    /**
     * This is removeFood method that used to return true value
     * @return true, boolen return
     */

    public static boolean removeFood(int id) throws FoodNotFoundException
    {

        Food food = FOOD_DATABASE.get(id);
        if (food != null) {
            FOOD_DATABASE.remove(food);
            return true;
        }
        throw new FoodNotFoundException(id);
    }

}