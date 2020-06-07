package MuhamadFadil.jfood;
/**
 * Write a description of class CustomerNotFOundException
 * @author Muhamad Fadil
 * @version 9 April 2020
 */
public class CustomerNotFoundException extends Exception {
    private int customer_error;

    /**
     * konstraktor yang digunakan untuk menetukan id customer
     * @param customer_input, digunakan untuk melakukan inputan id customer
     *
     */
    public CustomerNotFoundException(int customer_input){
        super("Customer ID: ");
        this.customer_error=customer_input;
    }

    //metode yang digunakan untuk cetak jika tidak terdapat customer pada database customer
    public String getMessage(){
        return super.getMessage() + customer_error + " not found";
    }
}
