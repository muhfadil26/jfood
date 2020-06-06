package MuhamadFadil.jfood;
/**
 * kelas ini digunakan untuk kelas invoice yang melakukan pembayaran secara cash
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
import java.util.ArrayList;

public class CashInvoice extends Invoice
{
    
    private static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

     /*
     * metode konstraktor untuk CashInvoice
     * @param id, digunakan untuk id Food
     * @param foods, digunakan untuk list Food
     * @param customer, digunakan untuk pemanggilan customer
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer) {
        super(id, foods, customer);
        setTotalPrice();
         
    }
    /*
     * membuat metode konstraktor CashInvoice
     * * @param id, digunakan untuk id Food
     * @param foods, digunakan untuk list Food
     * @param customer, digunakan untuk pemanggilan customer
     * @param deliveryFee, diguanakn untuk menginisialisasi ongkos kirim
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee){
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
        setTotalPrice();
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
     * @param deliveryFee, digunakan untuk mengatur ongkos kirim
     */
    public void setDeliveryFee(int deliveryFee){
        this.deliveryFee=deliveryFee;
    }
    
    public void setTotalPrice() {
        int foodPrice=0;
        for(int i = 0; i < super.getFoods().size(); i++){
            foodPrice+=super.getFoods().get(i).getPrice();
        }
        if(deliveryFee>0)
        {
            super.totalPrice=foodPrice+deliveryFee;
        }
        else super.totalPrice=foodPrice;
    }

    public String toString() {
        if((super.getDate()!=null) && (deliveryFee > 0)){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println("\nId: " + super.getId() + "\n" +
                            "Food: " + super.getFoods() + "\n" +
                            "Date: " + sdf.format(getDate().getTime()) + "\n" +
                            "Delivery Fee: " + deliveryFee + "\n" +
                            "Total Price: " + super.totalPrice + "\n" +
                            "Customer Name: " + super.getCustomer().getName() + "\n" +
                            "Invoice Status: " + super.getInvoiceStatus().toString() + "\n" + 
                            "Payment Type: " + PAYMENT_TYPE.toString());
        }else{
         SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println("\nId: " + super.getId() + "\n" +
                            "Food: " + super.getFoods() + "\n" +
                            "Delivery Fee: 0" + "\n" +
                            "Total Price: " + super.totalPrice + "\n" +
                            "Customer Name: " + super.getCustomer().getName() + "\n" +
                            "Invoice Status: " + super.getInvoiceStatus().toString() + "\n" + 
                            "Payment Type: " + PAYMENT_TYPE.toString());
        }
   
        return null; 
    }
}
