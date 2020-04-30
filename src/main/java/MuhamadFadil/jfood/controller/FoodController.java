package MuhamadFadil.jfood.controller;

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

/**
 * this class is ControllerCustomer
 *
 * @author Muhamad Fadil
 * @version 16 Maret 2020
 */

//@RequestMapping("/food")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController
public class FoodController {

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood(){
        ArrayList<Food> food;
        food = DatabaseFood.getFoodDatabase();
        return food;
    }

    @RequestMapping("/food/{id}")
    public Food getFoodById(@PathVariable int id){
        Food food = null;
        try{
            food = DatabaseFood.getFoodById(id);
        }catch (FoodNotFoundException e){
            e.getMessage();
            return null;
        }
        return food;
    }

    @RequestMapping(value = "/food/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId){
        ArrayList<Food> food = null;
        try {
            food = DatabaseFood.getFoodBySeller(sellerId);
        }catch (SellerNotFoundException e){
            e.getMessage();
        }
        return food;
    }

    @RequestMapping(value = "/food/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory (@PathVariable FoodCategory category){
        ArrayList<Food> food = null;
        food = DatabaseFood.getFoodByCategory(category);
        return food;
    }

    @RequestMapping(value = "/food", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name")String name,
                        @RequestParam(value = "sellerId")int sellerId,
                        @RequestParam(value = "price")int price,
                        @RequestParam(value = "category") FoodCategory category) throws SellerNotFoundException{
        Food food = new Food(DatabaseFood.getlastId()+1, name, DatabaseSeller.getSellerById(sellerId),price,FoodCategory.Western);
        DatabaseFood.addFood(food);
        return food;
    }


}
