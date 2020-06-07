package MuhamadFadil.jfood;
/**
 * This class is used for enum Invoice method
 *
 * @author Muhamad fadil
 * @version 6 Maret 2018
 */
public enum InvoiceStatus
{
    //jenis-jenis status pesanan
    Ongoing ("Ongoing"), Finished ("Finished"), Cancelled ("Cancelled"); 

    //variable status
    private String status; 

    //konstraktor metode yang digunakan untuk status
    private InvoiceStatus(String status){
        this.status=status; 
    }

    //metode untuk cetak class InvoiceStatus
    public String toString (){
        return status; 
    }
    
}
