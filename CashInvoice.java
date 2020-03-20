
/**
 * Write a description of class CashInvoice here.
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

public class CashInvoice extends Invoice
{
    
    PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee; 
    //int deliveryFee = 0;

     /*
     * metode konstraktor untuk CashInvoice
     */
    public CashInvoice(int id, Food food, Calendar date, Customer customer, InvoiceStatus invoiceStatus) {
        super(id, food, date, customer, invoiceStatus);
         
    }
    /*
     * membuat metode konstraktor CashInvoice
     */
    public CashInvoice(int id, Food food, Calendar date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee){
        super(id, food, date, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }
    /*
     * metode untuk mengakses class PamentType
     */
    public PaymentType getPaymentType(){
         return PAYMENT_TYPE; 
    }
    /*
     * metode accessor getter untuk deliveryFee
     */
    public int getDeliveryFee(){
         return deliveryFee; 
    }
     /*
     * metode untuk meng-set deliveryFee
     */
    public void setDeliveryFee(int deliveryFee){
        
    }
    
    public void setTotalPrice() {
        Food food = super.getFood();
        if (deliveryFee > 0) {
            super.totalPrice = food.getPrice() + deliveryFee;
        } else {
            super.totalPrice = food.getPrice();
        }
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println("===============INVOICE==========="); 
        System.out.println("\nId: " + super.getId() + "\n" +
                            "Food Name: " + super.getFood().getName() + "\n" +
                            "Date: " + sdf.format(getDate().getTime()) + "\n" +
                            "Delivery Fee: " + deliveryFee + "\n" +
                            "Total Price: " + super.totalPrice + "\n" +
                            "Customer Name: " + super.getCustomer().getName() + "\n" +
                            "Invoice Status: " + super.getInvoiceStatus().toString() + "\n" + 
                            "Payment Type: " + PAYMENT_TYPE.toString());
    
   
        return null; 
    }
}
