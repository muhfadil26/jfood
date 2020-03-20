import java.util.Calendar; 
import java.util.GregorianCalendar; 

public class JFood{
    public static void main (String[] args)
    {
       Location location1 = new Location("DKI Jakarta","Jakarta Selatan","Bagian Selatan");
       Location location2 = new Location("Jawa Tengah", "Tegal", "Kota Bahari");
       
       Seller seller1 = new Seller(1,"Muhamad Fadil","fadil_fadil@ui.acid","087881409890",location1);
       Seller seller2 = new Seller(2,"Fadil Muhamad","fadil.muh26@gmail.com","02134521010",location2);
       
       Food food1=new Food(1,"Roti Keju",seller1,20000,FoodCategory.Bakery);
       Food food2=new Food(2,"Kopi Tubruk",seller2,35500,FoodCategory.Coffe);
       Food food3=new Food(3,"Manisan",seller2,25000,FoodCategory.Snacks);
       Food food4 = new Food (43, "Gado-gado", seller2,90000, FoodCategory.Coffe);
       
       Customer customer1=new Customer(111,"Fadil","Fadoli@gmail.com","aweK90awek",2019,6,12);
       Customer customer2=new Customer(112,"Weki","wekiwek@host-net.com","90wekWekwek",new GregorianCalendar(2020,1,19));
       Customer customer3=new Customer(113,"Jaki","jaki98@joki.com","Santui62");
       
       //promo
       Promo promo1=new Promo(1,"lebaran",15050,25200,true);
       //Discount discount1=new Discount (
       
       //print customer
       customer1.toString();
       customer2.toString();
       customer3.toString();
       
       customer1.setEmail(",fadoli@gmail.com");
       customer1.toString();
       
       customer1.setEmail("fadoli.iu@-gmail.com");
       customer1.toString();
       
       customer1.setEmail("fadoli@gmail_net.com");
       customer1.toString();
       
       customer1.setEmail("fadoli..op@ui.ac.id");
       customer1.toString();
       
       customer1.setEmail("fadoli.op@ui.ac.id");
       customer1.setPassword("23ui96");
       customer1.toString();
       
       customer1.setPassword("234561");
       customer1.toString();
       
       customer1.setEmail("Fadil-lo@officenet.com"); 
       customer1.setPassword("123-Aws@qw");
       customer1.toString();
       
       customer1.setEmail("fadilo-26@host-new.ui.ac.id"); 
       customer1.setPassword("103203aSW");
       customer1.toString();
       
       //customer2.toString();
       
       
       
       //Post test
       Promo promo2 = new Promo (1243, "hd43jdhj", 10000, 50000,true);
       
       
       CashlessInvoice invoice1 = new CashlessInvoice (3, food1, new GregorianCalendar(2020, 3, 20),customer1, InvoiceStatus.Ongoing); 
       CashlessInvoice invoice2 = new CashlessInvoice (2, food2, new GregorianCalendar(2020,3,20),customer2, InvoiceStatus.Finished,promo1); 
       CashlessInvoice invoice3 = new CashlessInvoice (4, food3, new GregorianCalendar(2020,3,20),customer3, InvoiceStatus.Ongoing); 
       CashlessInvoice invoice4 = new CashlessInvoice (7, food4, new GregorianCalendar(2020,3,20),customer3, InvoiceStatus.Ongoing, promo2);
         
       CashInvoice invoicebaru1 = new CashInvoice (4, food1, new GregorianCalendar(2020,3,20),customer1, InvoiceStatus.Finished); 
       CashInvoice invoicebaru2 = new CashInvoice (5, food2, new GregorianCalendar(2020, 3,20),customer2, InvoiceStatus.Finished, 13000);  
        
       //
        invoicebaru1.setTotalPrice();
        invoicebaru2.setTotalPrice();
        
        //
        invoice1.setTotalPrice();
        invoice2.setTotalPrice();
        invoice3.setTotalPrice();
        invoice4.setTotalPrice();
        
        invoice1.toString(); 
        invoice2.toString(); 
        invoice3.toString();
        invoice4.toString();
        
        
        //
        invoicebaru1.toString(); 
        invoicebaru2.toString();
       
    }
}

