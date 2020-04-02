import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar; 

public class JFood{
    public static void main (String[] args)
    {
        //lokasi
       Location location1 = new Location("DKI Jakarta","Jakarta Selatan","Bagian Selatan");
       Location location2 = new Location("Jawa Tengah", "Tegal", "Kota Bahari");
       DatabasePromo.addPromo(new Promo(1, "CuciGudang", 50000, 30000, true));

       //Seller seller1 = new Seller(1,"Muhamad Fadil","fadil_fadil@ui.acid","087881409890",location1);
       //Seller seller2 = new Seller(2,"Fadil Muhamad","fadil.muh26@gmail.com","02134521010",location2);

        //pengesetan database untuk seler dan customer
        DatabaseSeller.addSeller(new Seller(1, "Fadil", "fadil.fadil@ui.ac.id", "087881490385", location2));
        DatabaseCustomer.addCustomer(new Customer(1, "Muhamad Fadil", "muhamad.fadil@ui.ac.id", "siapbos", 2020, 4, 2));
        DatabaseCustomer.addCustomer(new Customer(2, "Luhtfi Mufadel", "Luhfti.mufadel@ui.ac.id", "mufadelluhfti", 2020, 4, 2));

        DatabaseFood.addFood(new Food(1, "Dukuh Jogja", DatabaseSeller.getSellerById(1), 18000, FoodCategory.Western));
        DatabaseFood.addFood(new Food(2, "Martabak", DatabaseSeller.getSellerById(1), 18000, FoodCategory.Rice));
        DatabaseFood.addFood(new Food(3, "Straberry", DatabaseSeller.getSellerById(1), 16000, FoodCategory.Western));

        CashInvoice cashInvoice1 = new CashInvoice(1, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1), 52000);
        CashInvoice cashInvoice2 = new CashInvoice(2, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1));
        CashlessInvoice cashlessInvoice1 = new CashlessInvoice(1, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1));
        CashlessInvoice cashlessInvoice2 = new CashlessInvoice(2, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1));

        //mencetak
        System.out.println(DatabaseCustomer.getCustomerDatabase());
        System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Western));

    }
}

