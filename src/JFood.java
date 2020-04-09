import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JFood{
    public static void main (String[] args)
    {
        //lokasi
       Location location1 = new Location("DKI Jakarta","Jakarta Selatan","Bagian Selatan");
       Location location2 = new Location("Jawa Tengah", "Tegal", "Kota Bahari");
        //pengesetan database untuk seler dan customer
        DatabaseSeller.addSeller(new Seller(1, "Fadil", "fadil.fadil@ui.ac.id", "087881490385", location2));
        DatabaseSeller.addSeller(new Seller(2, "Muhamad Fadil", "muh.fadil@ui.ac.id", "081821287015", location1));
        DatabaseSeller.addSeller(new Seller(2, "Muh", "muh@ui.ac.id", "085554287015", location1));

        DatabaseCustomer.addCustomer(new Customer(1, "Muhamad Fadil", "muhamad.fadil@ui.ac.id", "sia2pBos", 2020, 4, 2));
        DatabaseCustomer.addCustomer(new Customer(3, "Fadil", "fadil2345@ui.ac.id", "Coba21op", 2020, 4, 2));
        DatabaseCustomer.addCustomer(new Customer(2, "Luhtfi Mufadel", "Luhfti.mufadel@ui.ac.id", "Mufadelluhfti26", 2020, 4, 2));

        DatabaseFood.addFood(new Food(1, "Dukuh Jogja", DatabaseSeller.getSellerById(1), 18000, FoodCategory.Western));
        DatabaseFood.addFood(new Food(2, "Martabak", DatabaseSeller.getSellerById(2), 18000, FoodCategory.Rice));
        DatabaseFood.addFood(new Food(3, "Straberry", DatabaseSeller.getSellerById(3), 16000, FoodCategory.Western));

        //CashInvoice cashInvoice1 = new CashInvoice(1, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1), 52000);
        //CashInvoice cashInvoice2 = new CashInvoice(2, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1));
        //CashlessInvoice cashlessInvoice1 = new CashlessInvoice(1, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(1));
        //CashlessInvoice cashlessInvoice2 = new CashlessInvoice(2, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(2));

        //DatabaseInvoice.getInvoiceByCustomer(DatabaseInvoice.getLastId());
        //DatabaseInvoice.changeInvoiceStatus (DatabaseInvoice.getInvoiceByCustomer(2), InvoiceStatus.Ongoing);
        ////DatabaseInvoice.changeInvoiceStatus (DatabaseInvoice.getInvoiceByCustomer(3), DatabaseInvoice.changeInvoiceStatus(DatabaseInvoice.getLastId(), InvoiceStatus.Finished);

        /*for (Invoice array1 : DatabaseInvoice.getInvoiceDatabase()) {
            DatabaseInvoice.changeInvoiceStatus(DatabaseInvoice.getInvoiceByCustomer(), InvoiceStatus.Finished);
        }*/

        /**
         * post Test Modul 6
         */
        //NO.1
       DatabasePromo.addPromo(new Promo(1, "CuciGudang", 50000, 30000, true));
       DatabasePromo.addPromo(new Promo(2, "Liburan", 25000, 30545, true));

       //No.2
        System.out.println("\n");
        for(Promo promo : DatabasePromo.getPromoDatabase()){
            System.out.println(promo);
        }
       //Seller seller1 = new Seller(1,"Muhamad Fadil","fadil_fadil@ui.acid","087881409890",location1);
       //Seller seller2 = new Seller(2,"Fadil Muhamad","fadil.muh26@gmail.com","02134521010",location2);

        //No.3
        ArrayList<Food> order1 = DatabaseFood.getFoodDatabase();
        ArrayList<Food> order2 = DatabaseFood.getFoodByCategory(FoodCategory.Rice);

        //No.4
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, order1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));

        //No.5
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        //NO.6
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, order2, DatabaseCustomer.getCustomerById(1)));

        //No.7
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        //No.8
        System.out.println(("\n"+"=====jawaban No.8====="));
        for (Invoice invoice: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoice);
        }

        //No.9
        DatabaseInvoice.changeInvoiceStatus(DatabaseCustomer.getCustomerById(1).getId(), InvoiceStatus.Finished);


        //No.10
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() +1, order2, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(1)));

        //No.11
        DatabasePromo.getPromoById(1).setActive(true);


        //No.12
        DatabaseInvoice.getInvoiceByCustomer(2).get(DatabaseInvoice.getInvoiceByCustomer(2).size()-1).setTotalPrice();


        //No.13
        System.out.println("\n"+"=====Jawaban No.13======");
        for (Invoice invoice: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoice);
        }


        /*//mencetak
         System.out.println(DatabasePromo.getPromoDatabase());
        //System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Western));

        for (Customer i: DatabaseCustomer.getCustomerDatabase()){

            System.out.println(i);
        }

        for ( Food i : DatabaseFood.getFoodByCategory(FoodCategory.Western)){

            System.out.println(i);
        }

        /*for ( Invoice i : DatabaseInvoice.getInvoiceDatabase()){

            System.out.println(i);
        }*/

    }
}

