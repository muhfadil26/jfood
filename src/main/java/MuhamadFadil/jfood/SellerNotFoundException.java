package MuhamadFadil.jfood;
/**
 * Write a description of class SellerNotFoundException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */

public class SellerNotFoundException extends Exception{
    private int seller_error;

    /**
     * konstraktor yang digunakan untuk pengecekan ada tidaknya seller
     * @param seller_input, digunakan untuk pengecekan id seller sudah terdapat pada database belum
     */
    public SellerNotFoundException (int seller_input){
        super("\n"+"Seller ID: ");
        this.seller_error= seller_input;
    }

    //metode untuk cetak jika tidak terdapat seller pada database
    public String getMessage(){
        return super.getMessage() +seller_error+" not found";
    }
}


