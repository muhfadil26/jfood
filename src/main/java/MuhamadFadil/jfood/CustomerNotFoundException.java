package MuhamadFadil.jfood;
/**
 * Write a description of class CustomerNotFOundException
 * @author Muhamad Fadil
 * @version 9 April 2020
 */
public class CustomerNotFoundException extends Exception {
    private int customer_error;

    public CustomerNotFoundException(int customer_input){
        super("\n"+"Customer ID: ");
        this.customer_error=customer_input;
    }

    public String getMessage(){
        return super.getMessage() + customer_error + " not found";
    }
}
