package MuhamadFadil.jfood;
/**
 * Write a description of class OngoingInvoiceAlreadyExistsException
 * @author Muhamad Fadil
 * @version 13 April 2020
 */

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    /**
     * konstraktor yang digunakan untuk mengecek status invoice agar tidak duplikasi
     * @param invoice_input, digunakan untuk input invoice
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super("\n"+"Ongoing Invoice ");
        this.invoice_error=invoice_input;
    }

    public String getMessage(){
        return super.getMessage() + invoice_error + " Already Exists";
    }
}
