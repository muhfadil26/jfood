package MuhamadFadil.jfood;
/**
 * Write a description of class SellerNotFoundException here.
 * @author Muhamad Fadil
 * @version 9 April 2020
 */

public class EmailAlreadyExistException extends Exception{
    private Customer customer_error;

    /**
     * konstraktor yang digunakan untuk menentukan inputan dari customer
     * @param customer_input, digunakan untuk mengecek inputan customer
     */
    public EmailAlreadyExistException (Customer customer_input){
        super("\n"+"Customer Email: ");
        this.customer_error=customer_input;
    }

    //metode yang digunakan untuk menampilkan error handling jika email sudah ada
    public String getMessage(){
        return super.getMessage() + customer_error.getEmail() + " already exist";
    }
}
