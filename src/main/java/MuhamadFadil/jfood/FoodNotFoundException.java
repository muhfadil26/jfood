package MuhamadFadil.jfood;
/**
 * Write a description of class FoodNotFoundException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */
import java.util.*;



public class FoodNotFoundException extends Exception {
    private int food_error;

    /**
     * konstraktor yang digunakan untuk inputan id food
     *
     * @param food_input, input yang digunakan untuk mengecek class food
     */
    public FoodNotFoundException (int food_input){
        //super();
        super("\n"+"Food ID: ");
        this.food_error = food_input;
    }

    //cetak error jika tidak terdapat makanan
    public String getMessage(){
        return super.getMessage() + food_error + " not found";
    }
}
