package MuhamadFadil.jfood;
/**
 * Write a description of class InvoiceNotFoundException
 * @author Muhamad Fadil
 * @version 13 April 2020
 */
public class InvoiceNotFoundException extends Exception{
    private int invoice_error;

    /**
     * konstraktor yang digunakan untuk pengecekan input invoice
     * @param invoice_input, input yang digunakan untuk mengecek inputan invoice
     */
    public InvoiceNotFoundException(int invoice_input){
        super("\n"+"Invoice ID: ");
        this.invoice_error=invoice_input;
    }

    public String getMessage(){
        return super.getMessage() + invoice_error + " not found";
    }
}
