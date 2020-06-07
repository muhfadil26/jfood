package MuhamadFadil.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

@SpringBootApplication
public class JFood{

    //metode konstraktor yang digunakan untuk menambahkan data-data
    public JFood(){
    }

    //metode yang digunakan untuk main pada program
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


        SpringApplication.run(JFood.class, args);

    }
}
