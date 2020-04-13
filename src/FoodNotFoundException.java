/**
 * Write a description of class FoodNotFoundException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */
import java.util.*;


public class FoodNotFoundException extends Exception {
    private int food_error;
    public FoodNotFoundException (int food_input){
        //super();
        super("\n"+"Food ID: ");
        this.food_error = food_input;
    }

    public String getMessage(){
        return super.getMessage() + food_error + " not found";
    }
}
