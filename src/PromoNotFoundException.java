/**
 * Write a description of class PromoNotFoundException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */

public class PromoNotFoundException extends Exception{
    private int promo_error;
    public PromoNotFoundException(int promo_input){
        super("\n"+"Promo ID: ");
        this.promo_error=promo_input;
    }

    public String getMessage(){
        return super.getMessage()+promo_error+" not found";
    }

}
