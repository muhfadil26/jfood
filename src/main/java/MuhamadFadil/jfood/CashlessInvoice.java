package MuhamadFadil.jfood;
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
import java.util.ArrayList;

public class CashlessInvoice extends Invoice
{
    public static PaymentType PAYMENT_TYPE=PaymentType.Cashless;  
    private Promo promo; 
    /*
     * metode konstraktor untuk CashlessInvoice
     * * @param id, digunakan untuk id Food
     * @param foods, digunakan untuk list Food
     * @param customer, digunakan untuk pemanggilan customer
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer){
        super(id, foods, customer);
        setTotalPrice();
    }
    /*
     * membuat metode konstraktor CashlessInvoice
     * * @param id, digunakan untuk id Food
     * @param foods, digunakan untuk list Food
     * @param customer, digunakan untuk pemanggilan customer
     * @param promo, digunakan untuk melakukan pemberian code promo
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo){
         super(id, foods, customer);
         this.promo=promo;
         setTotalPrice();
    }
    /*
     * metode untuk mengakses class PamentType
     */
    public PaymentType getPaymentType(){
         return PAYMENT_TYPE; 
    }
    /*
     * metode accessor getter untuk promo
     * @param promo, digunakan untuk mendapatkan promo
     */
    public Promo getPromo(){
         return promo; 
    }
    /*
     * metode untuk meng-set promo
     * @param promo, digunakan untuk memberikan nilai promo
     */
    public void setPromo(Promo promo){
        this.promo=promo;
    }
    
    /*
     * metode yang digunakan untuk meng-eset total price dengan kodisi sebagai berikut 
     */
    public void setTotalPrice(){
        int foodPrice=0;
        for(int i = 0; i < super.getFoods().size(); i++){
            foodPrice=foodPrice+super.getFoods().get(i).getPrice();
        }
        if(promo!=null&&promo.getActive()==true&&foodPrice>promo.getMinPrice())
        {
            super.totalPrice=foodPrice-promo.getDiscount();
        }
        else {
            super.totalPrice=foodPrice;
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
            System.out.println("Food = "+ getFoods());
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
            System.out.println("Food = "+ getFoods());
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
