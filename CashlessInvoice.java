
/**
 * this subclass is used for CashlessInvoice
 *
 * @author Muhamad Fadil
 * @version 13 Maret 2020
 */
import java.util.*; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashlessInvoice extends Invoice
{
    public static PaymentType PAYMENT_TYPE=PaymentType.Cashless;  
    private Promo promo; 
    /*
     * metode konstraktor untuk CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, customer, invoiceStatus);
    }
    /*
     * membuat metode konstraktor CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo){
         super(id, food, customer, invoiceStatus);
         this.promo=promo;
    }
    /*
     * metode untuk mengakses class PamentType
     */
    public PaymentType getPaymentType(){
         return PAYMENT_TYPE; 
    }
    /*
     * metode accessor getter untuk promo 
     */
    public Promo getPromo(){
         return promo; 
    }
    /*
     * metode untuk meng-set promo
     */
    public void setPromo(Promo promo){
        
    }
    
    /*
     * metode yang digunakan untuk meng-eset total price dengan kodisi sebagai berikut 
     */
    public void setTotalPrice(){
        if((promo != null) && (promo.getActive()==true) && (super.getFood().getPrice()>=promo.getMinPrice())
        )
        {
            super.totalPrice= getFood().getPrice()-promo.getDiscount(); 
        }
          
        else
        {
             super.totalPrice = getFood().getPrice(); 
        }
        
    }
    
    /*
     * metode untuk mengeprin data 
     */
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(promo == null || promo.getActive()==false || super.getTotalPrice()<promo.getMinPrice()
        )
        
        {
            System.out.println("-----------INVOICE------------"); 
            System.out.println("ID: " + super.getId()); 
            System.out.println("Food = "+ getFood().getName()); 
            System.out.println("Date: " + sdf.format(getDate().getTime())); 
            System.out.println("Customer: " + super.getCustomer().getName()); 
            System.out.println("Total Price: " + getTotalPrice()); 
            System.out.println("Status: " + super.getInvoiceStatus()); 
            System.out.println("Payment Type: " + PAYMENT_TYPE); 
            System.out.println("==============================="); 
        }
        else
        {
            System.out.println("-----------INVOICE------------"); 
            System.out.println("ID: " + super.getId()); 
            System.out.println("Food = "+ getFood().getName());
            System.out.println("Date: " + sdf.format(getDate().getTime())); 
            System.out.println("Customer: " + super.getCustomer().getName()); 
            System.out.println("Code Promo: " + promo.getCode());
            System.out.println("Total Price: " + getTotalPrice()); 
            System.out.println("Status: " + super.getInvoiceStatus()); 
            System.out.println("Payment Type: " + PAYMENT_TYPE); 
            System.out.println("==============================="); 
            
        }
        return null; 
    }
    
  
    
}
