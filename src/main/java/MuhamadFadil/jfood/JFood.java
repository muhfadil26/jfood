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
        Location location1 = new Location("Slemar", "Yogyakarta", "Bagian Selatan");
        Location location2 = new Location("Blitar", "Jawa Timur", "dekat pantai");
        Location location3 = new Location("Jonggol", "Jawa Barat", "Kota hujan");

        Location location4 = new Location("DKI Jakarta", "Jakarta Selatan", "Bagian Selatan");
        Location location5 = new Location("Jawa Tengah", "Tegal", "Kota Bahari");

        DatabaseSeller.addSeller(new Seller(1, "Fadil", "fadil.fadil@ui.ac.id", "087881490385", location2));
        DatabaseSeller.addSeller(new Seller(3, "Muhamad Fadil", "muh.fadil@ui.ac.id", "081821287015", location1));
        DatabaseSeller.addSeller(new Seller(2, "Muha", "muha@ui.ac.id", "085554287015", location1));
        DatabaseSeller.addSeller(new Seller(4, "Fadol Muh", "muhfadol@ui.ac.id", "085554347015", location3));
        DatabaseSeller.addSeller(new Seller(5, "Muh", "muh@ui.ac.id", "085554287015", location4));

        //DatabaseCustomer.getLastId()+1
        SpringApplication.run(JFood.class, args);
        //lokasi
        //Post Test - modul 8
        //1
        ArrayList<Food> order1= new ArrayList<Food>();
        ArrayList<Food> order2 = new ArrayList<Food>();
        ArrayList<Food> order3 = new ArrayList<Food>();

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Dukuh Jogja", DatabaseSeller.getSellerById(1), 182000, FoodCategory.Western));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Martabak", DatabaseSeller.getSellerById(2), 180000, FoodCategory.Rice));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getlastId()+1, "Straberry", DatabaseSeller.getSellerById(4), 16000, FoodCategory.Coffe));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            order1.add(DatabaseFood.getFoodById(1));
        }catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            order2.add(DatabaseFood.getFoodById(1));
        }catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        //No.2 (mengubah invoice status)











        try {
            DatabaseSeller.getSellerById(200);
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Muhamad Fadil", "fadil2345@ui.ac.id", "sia2pBos", 2020, 4, 2));
        }catch (EmailAlreadyExistException e) { //pengecekan email yang sama
        System.out.println(e.getMessage());
         }

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Fadil", "fadil2345@ui.ac.id", "Coba21op", 2020, 4, 9));
        }catch (EmailAlreadyExistException e) { //pengecekan email yang sama
            System.out.println(e.getMessage());
        }

        try{
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Luhtfi", "Luhfti.mufadel@ui.ac.id", "Mufadelluhfti26", 2020, 4, 2));
        }catch (EmailAlreadyExistException e) { //pengecekan email yang sama
            System.out.println(e.getMessage());
        }
            try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Luhtfi Mufadel", "Luhfti.mufadel@ui.ac.id", "Mufadelluhfti", 2020, 4, 9));
        }catch (EmailAlreadyExistException e) { //pengecekan email yang sama
            System.out.println(e.getMessage());
        }

        //cek keberadaan customer
        try {
            DatabaseCustomer.getCustomerById(1);
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        //penambahan promo
        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "Liburan", 25000, 30545, true));
        }catch (PromoCodeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

            try{
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "Liburan", 25000, 30545, true));
            }catch (PromoCodeAlreadyExistException e) {
                System.out.println(e.getMessage());
            }
            try{
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "CuciGudang", 50000, 30000, false));
        }catch (PromoCodeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

            try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "LebaranKuy", 25000, 30545, true));
        }catch (PromoCodeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabasePromo.getPromoById(1);
        }catch (PromoNotFoundException e){
            System.out.println(e.getMessage());
        }



        try {
            DatabaseFood.getFoodById(2);
        } catch (FoodNotFoundException a) {
            System.out.println(a.getMessage());
        }

        System.out.println("\n===Data Yang Berhasil Masuk===");
        for (Promo promo : DatabasePromo.getPromoDatabase()) {
            System.out.println(promo + "\n");
        }

        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer + "\n");
        }

        for (Food food : DatabaseFood.getFoodDatabase()) {
            System.out.println(food + "\n");
        }
        for (Seller seller : DatabaseSeller.getSellerDatabase()) {
            System.out.println(seller + "\n");
        }

        //No.

        try{
            order1.add(DatabaseFood.getFoodById(1));
        }catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            order3.add(DatabaseFood.getFoodById(1));
        }catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        /**
         * post test modul 7
         */
        //No.2
        System.out.println("\n=====Modul Post test======");
        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, order1, DatabaseCustomer.getCustomerById(1),2200));
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, order2, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));
            Invoice invoice1 = new CashInvoice(3,order1, DatabaseCustomer.getCustomerById(1), 1000);
            DatabaseInvoice.addInvoice(invoice1);
            Invoice invoice2 = new CashInvoice(2, order2, DatabaseCustomer.getCustomerById(1), 2000);
            DatabaseInvoice.addInvoice(invoice2);
            Invoice invoice3 = new CashInvoice(1, order3, DatabaseCustomer.getCustomerById(1), 3000);
            DatabaseInvoice.addInvoice(invoice3);
        } catch (CustomerNotFoundException a) {
            System.out.println(a.getMessage());
        }catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (PromoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.getInvoiceById(100);
        }catch (InvoiceNotFoundException e1){
            System.out.println(e1.getMessage());
        }
        //no.3 skenarionya



        //THREAD
        System.out.println("\n=====Thread======");
        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            PriceCalculator priceCalculator = new PriceCalculator(invoice);
            Thread thread = new Thread(priceCalculator);
            thread.start();
        }
    }
}
