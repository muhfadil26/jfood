
/**
 * Write a description of class PromoCodeAlreadyExistException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */
import java.util.*;

public class PromoCodeAlreadyExistException extends Exception{
    private Promo promo_error;
    public PromoCodeAlreadyExistException(Promo promo_input){
        super("\n"+"Promo Code: ");
        this.promo_error=promo_input;
    }

    public String getMessage(){
        return super.getMessage()+promo_error.getCode() + "\n"+"already exist";
    }
}
