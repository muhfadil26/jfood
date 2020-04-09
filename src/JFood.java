import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JFood{
    public static void main (String[] args) {
        //lokasi
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Bagian Selatan");
        Location location2 = new Location("Jawa Tengah", "Tegal", "Kota Bahari");

        //pengesetan database untuk seler dan customer
        try {
            DatabaseSeller.addSeller(new Seller(DatabaseCustomer.getLastId() + 1, "Fadil", "fadil.fadil@ui.ac.id", "087881490385", location2));
            DatabaseSeller.addSeller(new Seller(DatabaseCustomer.getLastId() + 2, "Muhamad Fadil", "muh.fadil@ui.ac.id", "081821287015", location1));
            DatabaseSeller.addSeller(new Seller(DatabaseCustomer.getLastId() + 3, "Muh", "muh@ui.ac.id", "085554287015", location1));

            DatabaseCustomer.addCustomer(new Customer(1, "Muhamad Fadil", "muhamad.fadil@ui.ac.id", "sia2pBos", 2020, 4, 2));
            DatabaseCustomer.addCustomer(new Customer(3, "Fadil", "fadil2345@ui.ac.id", "Coba21op", 2020, 4, 9));
            DatabaseCustomer.addCustomer(new Customer(2, "Luhtfi Mufadel", "Luhfti.mufadel@ui.ac.id", "Mufadelluhfti26", 2020, 4, 2));
            DatabaseCustomer.addCustomer(new Customer(4, "Luhtfi", "Luhfti@ui.ac.id", "Mufadelluhfti", 2020, 4, 9));


            DatabaseFood.addFood(new Food(DatabaseFood.getlastId() + 1, "Dukuh Jogja", DatabaseSeller.getSellerById(1), 182000, FoodCategory.Western));
            DatabaseFood.addFood(new Food(DatabaseFood.getlastId() + 2, "Martabak", DatabaseSeller.getSellerById(2), 180000, FoodCategory.Rice));
            DatabaseFood.addFood(new Food(DatabaseFood.getlastId() + 3, "Straberry", DatabaseSeller.getSellerById(3), 16000, FoodCategory.Western));

            ArrayList<Food> order1 = DatabaseFood.getFoodByCategory(FoodCategory.Western);
            ArrayList<Food> order2 = DatabaseFood.getFoodByCategory(FoodCategory.Rice);


            DatabasePromo.addPromo(new Promo(3, "Liburan", 25000, 30545, true));
            DatabasePromo.addPromo(new Promo(2, "Liburan", 25000, 30545, true));
            DatabasePromo.addPromo(new Promo(1, "CuciGudang", 50000, 30000, false));
            DatabasePromo.addPromo(new Promo(2, "Liburan", 25000, 30545, true));

            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, order2, DatabaseCustomer.getCustomerById(1)));
            Thread thread1 = new Thread(new PriceCalculator(DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId())));
            thread1.start();
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 2, order1, DatabaseCustomer.getCustomerById(2)));
            Thread thread2 = new Thread(new PriceCalculator(DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId())));
            thread2.start();
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, order1, DatabaseCustomer.getCustomerById(3)));
            Thread thread3 = new Thread(new PriceCalculator(DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId())));
            thread3.start();

        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (FoodNotFoundException food) {
            System.out.println(food.getMessage());
        } catch (PromoCodeAlreadyExistException e) {
            System.out.println(e.getMessage());
            System.out.println("\n" + "====PROMO=====");
            for (Promo promo : DatabasePromo.getPromoDatabase()) {
                System.out.println(promo.getId());
                System.out.println(promo.getCode());
                System.out.println(promo.getDiscount());
                System.out.println(promo.getMinPrice());
                System.out.println(promo.getActive());

            }

        } catch (EmailAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

    }
        private static  class PriceCalculator implements Runnable {

            Invoice input;

            PriceCalculator(Invoice input){
                this.input = input;
            }
            @Override
            public void run() {
                System.out.println("Calculating Invoice ID: " + input.getId());
                input.setTotalPrice();
                System.out.println("Finish calculating Invoice ID: " + input.getId());
            }
        }



        //DatabaseInvoice.addInvoice(new Invoice(1, DatabaseFood.getFoodById(1), DatabaseCustomer.getCustomerById(2).getId());
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

        //mencetak
        //System.out.println(DatabasePromo.getPromoDatabase());
        //System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Western));

        /*for (Customer i: DatabaseCustomer.getCustomerDatabase()){

            System.out.println(i);
        }

        for ( Food i : DatabaseFood.getFoodByCategory(FoodCategory.Western)){

            System.out.println(i);
        }

        for ( Invoice i : DatabaseInvoice.getInvoiceDatabase()){

            System.out.println(i);
        }*/

        /*//POST TEST MODUL 6
        //NO.1
       DatabasePromo.addPromo(new Promo(1, "CuciGudang", 50000, 30000, false));
       DatabasePromo.addPromo(new Promo(2, "Liburan", 25000, 30545, true));

       //No.2
        System.out.println("====PROMO=====");
        for(Promo promo : DatabasePromo.getPromoDatabase()){
            System.out.println(promo);
        }
       //Seller seller1 = new Seller(1,"Muhamad Fadil","fadil_fadil@ui.acid","087881409890",location1);
       //Seller seller2 = new Seller(2,"Fadil Muhamad","fadil.muh26@gmail.com","02134521010",location2);

        //No.3
        ArrayList<Food> order1 = DatabaseFood.getFoodDatabase();
        ArrayList<Food> order2 = DatabaseFood.getFoodByCategory(FoodCategory.Rice);

        //No.4
        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, order1, DatabaseCustomer.getCustomerById(1), 10000));
        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 2, order2, DatabaseCustomer.getCustomerById(2), 12000));

        //No.5
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(2).size()-1).setTotalPrice();

        //NO.6
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, order2, DatabaseCustomer.getCustomerById(1)));
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+2, order1, DatabaseCustomer.getCustomerById(2)));

        //No.7
        DatabaseInvoice.getInvoiceByCustomer(2).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        //No.8
        System.out.println(("=====jawaban No.8====="));
        for (Invoice invoice1: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoice1.getId());
            System.out.println(invoice1.getCustomer().getName());
            System.out.println(invoice1.getInvoiceStatus());
        }

        //No.9
        DatabaseInvoice.changeInvoiceStatus(DatabaseCustomer.getCustomerById(1).getId(), InvoiceStatus.Finished);

        //No.10
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() +1, order2, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));

        //No.11
        DatabasePromo.getPromoById(1).setActive(true);

        //No.12
        DatabaseInvoice.getInvoiceByCustomer(2).get(DatabaseInvoice.getInvoiceByCustomer(2).size()-1).setTotalPrice();

        //No.13
        System.out.println("=====Jawaban No.13======");
        for (Invoice invoice2: DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoice2.getId());
            System.out.println(invoice2.getTotalPrice());
            System.out.println("\n");
        }
        for (Customer i: DatabaseCustomer.getCustomerDatabase()){

            System.out.println(i);
        }

        //throw new SellerNotFoundException(), EmailAlreadyExistException

         */

}

