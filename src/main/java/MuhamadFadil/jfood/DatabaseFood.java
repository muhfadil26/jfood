package MuhamadFadil.jfood;
import java.util.ArrayList;

/**
* This class is DatabaseFood
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class DatabaseFood {
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();
    private static int lastId=0;

    /**
     * konstraktor yang digunakan untuk database food
     */
    public DatabaseFood()
    {
        // initialise instance variables
    }

    /**
     * konstraktor digunakan untuk mendapatkan database food
     * @return
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    /**
     * konnstraktor yang digunakan untuk mendapatkan id terakhir food
     * @return
     */
    public static int getlastId()
    {
        return lastId;
    }

    /**
     * konstraktor yang digunakan untuk mendapatkan food berdasarkan idnya
     * @param id, digunakan untuk id food
     * @return
     * @throws FoodNotFoundException, untuk mengecek apakah terdapat food atau tidak
     */
    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        /*Food food = FOOD_DATABASE.get(id);
        if (food != null) {
            return food;
        }
        throw new FoodNotFoundException(id);*/
        for (Food food: FOOD_DATABASE)
        {
            if (food.getId() == id)
            {
                return food;
            }
        }
        throw new FoodNotFoundException(id);
    }

    /**
     * konstraktor yang digunakan untuk menentukan database makanan berdasarkan seller
     * @param sellerId, id seller
     * @return
     * @throws SellerNotFoundException, mengecek ada tidaknya seller
     */
    public static ArrayList<Food> getFoodBySeller (int sellerId) throws SellerNotFoundException
    {
        ArrayList<Food> array1 = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                array1.add(food);
            }
        }
        throw new SellerNotFoundException(sellerId);
    }

    /**
     * konstraktor yang digunakan untuk mengecek makan berdasarkan categorynya
     * @param category, digunakan untuk menentukan kategory
     * @return
     */
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

    /**
     * konstraktor yang digunakan untuk menambahkan Food
     * @param food
     * @return
     */
    public static boolean addFood(Food food) //throws FoodNotFoundException
    {
        // put your code here
        //FOOD_DATABASE.add(food);
        //FOOD_DATABASE.indexOf(food);
        if(FOOD_DATABASE.add(food)){
            lastId = food.getId();
            return true;
        }
        return false;

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