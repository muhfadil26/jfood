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
       
       Customer customer1=new Customer(111,"Fadil","fadoli@gmail.com","awekawek",2019,6,12);
       Customer customer2=new Customer(112,"Weki","wekiwek@host-net.com","wekwekwek",new GregorianCalendar(2020,1,19));
       Customer customer3=new Customer(113,"Jaki","jaki@joki.com","Santui+62");
       
       //promo
       Promo promo1=new Promo(1,"lebaran",15050,25200,true);
       //Discount discount1=new Discount (
       
       //print customer
       customer1.toString();
       customer2.toString();
       customer3.toString();
       
       customer1.setEmail(",fadoli@gmail.com");
       customer1.toString();
       
       customer1.setEmail("fadoli@-gmail.com");
       customer1.toString();
       
       customer1.setEmail("fadoli@gmail_net.com");
       customer1.toString();
       
       customer1.setEmail("fadoli.op@ui.ac.id");
       customer1.toString();
       
       customer1.setPassword("23456");
       customer1.toString();
       
       customer1.setEmail("fadil-lo@officenet.com"); 
       customer1.setPassword("123-Aws@qw");
       customer1.toString();
       
       customer1.setEmail("fadilo@host-new.ui.ac.id"); 
       customer1.setPassword("103203aSW");
       customer1.toString();
       
       //customer2.toString();
         
    }
}

