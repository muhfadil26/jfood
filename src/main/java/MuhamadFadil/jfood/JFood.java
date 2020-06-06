package MuhamadFadil.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

@SpringBootApplication
public class JFood{
    public JFood(){
    }
    public static void main (String[] args) throws CustomerNotFoundException {
        Location loc1 = new Location("DKI Jakarta", "Jakarta", "kode pos: 12400");
        Location loc2 = new Location("Jawa Barat", "bandung", "kode pos: 12400");
        Seller seller1 = new Seller(DatabaseSeller.getLastId()+1, "Muhamad Fadil", "muhamadfadil@gmail.com", "087881009876", loc1);
        Seller seller2 = new Seller(DatabaseSeller.getLastId()+1, "Fadil Jaya", "muhamad@gmail.com", "087881009876", loc2);
        Seller seller3 = new Seller(DatabaseSeller.getLastId()+1, "Fadil Muhamad", "fadil@gmail.com", "087881009876", loc1);
        DatabaseSeller.addSeller(seller1);
                
        DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Kolek", seller1, 12000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Es Buah", seller2, 15000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Pizza", seller3, 15000, FoodCategory.Snacks));


        /*Location location1 = new Location("Slemar", "Yogyakarta", "Bagian Selatan");
        Location location2 = new Location("Blitar", "Jawa Timur", "dekat pantai");
        Location location3 = new Location("Jonggol", "Jawa Barat", "Kota hujan");

        Location location4 = new Location("DKI Jakarta", "Jakarta Selatan", "Bagian Selatan");
        Location location5 = new Location("Jawa Tengah", "Tegal", "Kota Bahari");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Fadil", "fadil.fadil@ui.ac.id", "087881490385", location2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhamad Fadil", "muh.fadil@ui.ac.id", "081821287015", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muha", "muha@ui.ac.id", "085554287015", location5));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Fadol Muh", "muhfadol@ui.ac.id", "085554347015", location3));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muh", "muh@ui.ac.id", "085554287015", location4));

        Seller seller3 = new Seller(DatabaseSeller.getLastId()+1, "Muhamad Fadil Jaya", "muh.jaya@fadil.com", "08961272", location1);
        Seller seller1 = new Seller(DatabaseSeller.getLastId()+1, "Muhamad Jaya Baya", "muh.jaya@baya.com", "089600001", location2);
        Seller seller2= new Seller(DatabaseSeller.getLastId()+1, "Muhamad Bayajaya", "muh.bayajaya@gmail.com", "08960002", location3);

        DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Martbak", seller1,12000,FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Torabika", seller1,67000,FoodCategory.Coffe));
        DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "BBQ", seller2,167000,FoodCategory.Western));

        DatabaseSeller.addSeller(seller1);
        DatabaseSeller.addSeller(seller2);
        DatabaseSeller.addSeller(seller3);*/

        SpringApplication.run(JFood.class, args);

    }
}
