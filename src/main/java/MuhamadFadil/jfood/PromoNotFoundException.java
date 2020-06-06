package MuhamadFadil.jfood;
/**
 * Write a description of class PromoNotFoundException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */

public class PromoNotFoundException extends Exception{
    private int promo_error;

    /**
     * konstraktor yang digunakan untuk mengecek promo
     * @param promo_input, digunakan untuk cek id promo
     */
    public PromoNotFoundException(int promo_input){
        super("\n"+"Promo ID: ");
        this.promo_error=promo_input;
    }

    public String getMessage(){
        return super.getMessage()+promo_error+" not found";
    }

}
