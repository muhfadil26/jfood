
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
    
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, date, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo){
         super(id, food, date, customer, invoiceStatus);
         this.promo=promo;
    }
    
    public PaymentType getPaymentType(){
         return PAYMENT_TYPE; 
    }
    
    public Promo getPromo(){
         return promo; 
    }
    
    public void setPromo(Promo promo){
        
    }
    
    public void setTotalPrice(){
        if(promo != null && promo.getActive()==true && super.getFood().getPrice()>promo.getMinPrice()
        )
        {
            super.totalPrice= getFood().getPrice()-promo.getDiscount(); 
        }
          
        else
        {
             super.totalPrice = getFood().getPrice(); 
        }
        
    }
    
    public void printData(){
        if(promo == null || promo.getActive()==false || super.getFood().getPrice()<promo.getMinPrice()
        )
        {
            System.out.println(super.getId()); 
            System.out.println(super.getFood().getName()); 
            System.out.println(super.getDate()); 
            System.out.println(super.getTotalPrice()); 
            System.out.println(super.getInvoiceStatus()); 
            System.out.println(PAYMENT_TYPE); 
            
        }
        
    }
    
}
