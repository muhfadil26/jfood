
/**
 * this subclass is used for CashlessInvoice
 *
 * @author Muhamad Fadil
 * @version 13 Maret 2020
 */
public class CashlessInvoice extends Invoice
{
    public static PaymentType PAYMENT_TYPE=PaymentType.Cashless;  
    private Promo promo; 
    /*
     * metode konstraktor untuk CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, date, customer, invoiceStatus);
    }
    /*
     * membuat metode konstraktor CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo){
         super(id, food, date, customer, invoiceStatus);
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
        if(promo != null && promo.getActive()==true && super.getFood().getPrice()>=promo.getMinPrice()
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
    public void printData(){
        if(promo == null || promo.getActive()==false || super.getFood().getPrice()<promo.getMinPrice()
        )
        {
            System.out.println("-----------INVOICE------------"); 
            System.out.println("ID: " + super.getId()); 
            System.out.println("Date: " + super.getFood().getName()); 
            System.out.println("Customer: " + super.getDate()); 
            //System.out.println("Code Promo: " + super.promo.getCode()); 
            System.out.println("Total Price: " + super.getTotalPrice()); 
            System.out.println("Status: " + super.getInvoiceStatus()); 
            System.out.println("Payment Type: " + PAYMENT_TYPE); 
            System.out.println("==============================="); 
            
        }
        
    }
    
    public void printData1(){
        if(promo == null || promo.getActive()==false || super.getFood().getPrice()<promo.getMinPrice()
        )
        {
            System.out.println("-----------INVOICE------------"); 
            System.out.println("ID: " + super.getId()); 
            System.out.println("Date: " + super.getFood().getName()); 
            System.out.println("Customer: " + super.getDate()); 
            System.out.println("Code Promo: " + promo.getCode()); 
            System.out.println("Total Price: " + super.getTotalPrice()); 
            System.out.println("Status: " + super.getInvoiceStatus()); 
            System.out.println("Payment Type: " + PAYMENT_TYPE); 
            System.out.println("==============================="); 
            
        }
        
    }
    
  
    
}
