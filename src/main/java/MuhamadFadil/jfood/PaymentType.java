package MuhamadFadil.jfood;
/**
 * this class is enum PaymentType
 *
 * @author Muhamad Fadil
 * @version 5 Maret 2020
 */
public enum PaymentType
{
    //pembuatan jenis pembayaran
    Cashless ("Cashless"), Cash("Cash"); 

    //variable
    private String paymentType; 

    //metode konstraktor pembayaran
    private PaymentType(String paymentType){
        this.paymentType=paymentType; 
    }

    //metode untuk cetak
    public String toString(){
        return paymentType; 
    }
}
