package MuhamadFadil.jfood;
/**
 * Write a description of class PromoCodeAlreadyExistException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */

public class PromoCodeAlreadyExistException extends Exception{
    //variable
    private Promo promo_error;

    /**
     * konstraktor yang digunakan untuk mengecek promo agar tidak duplikasi
     * @param promo_input, digunakan untuk code promo
     */
    public PromoCodeAlreadyExistException(Promo promo_input){
        super("\n"+"Promo Code: ");
        this.promo_error=promo_input;
    }

    //metode yang digunakan untuk mencetak jika promocode yang dibuat sudah ada
    public String getMessage(){
        return super.getMessage()+promo_error.getCode() + " already exist";
    }
}
