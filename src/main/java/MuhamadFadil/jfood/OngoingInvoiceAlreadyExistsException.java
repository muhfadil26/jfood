package MuhamadFadil.jfood;
/**
 * Write a description of class OngoingInvoiceAlreadyExistsException
 * @author Muhamad Fadil
 * @version 13 April 2020
 */

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private int invoice_error;

    public OngoingInvoiceAlreadyExistsException(int invoice_input){
        super("\n"+"Ongoing Invoice ");
        this.invoice_error=invoice_input;
    }

    public String getMessage(){
        return super.getMessage() + invoice_error + " Already Exists";
    }
}
