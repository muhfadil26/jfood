
public class JFood{
    public static void main (String[] args)
    {
 
        Location locationbaru = new Location ("Tegal", "Jawa Tengah", "Kelahiranku"); 
        Seller sellerbaru = new Seller (28022020, "Muhamad Fadil", "muhamad.fadil@ui.ac.id", "087881490385", locationbaru); 
 
        //no.a
        Food food1 = new Food (123, "Martabak", sellerbaru,50000, FoodCategory.Rice); 
        Food food2 = new Food (13, "Gorengan", sellerbaru,60000, FoodCategory.Snacks); 
        Food food3 = new Food (23, "Martabak", sellerbaru,59000, FoodCategory.Coffe); 
        Food food4 = new Food (43, "Gado-gado", sellerbaru,90000, FoodCategory.Coffe);
        Promo promo1 = new Promo (12, "hdsjdhj", 12000, 13000,true); 
        Promo promo2 = new Promo (1243, "hd43jdhj", 10000, 50000,true);
        
        //no.a
        Customer customer1 = new Customer (12345,"Jony Jony", "jony@gmail.com", "rahasiadong","28-02-2020"); 
        Customer customer2 = new Customer (12345,"Muhamad Fadil", "Muhamadfadil@gmail.com", "rahasiadong","28-02-2020");
        Customer customer3 = new Customer (12345,"Hanifer ah", "fadhilah@gmail.com", "rahasiadong","28-02-2020");
        //no.b
        //no.b
        //Invoice invoicebaru = new Invoice (2603,123,"28-02-2020", customer, 399000,InvoiceStatus); 
        CashlessInvoice invoice1 = new CashlessInvoice (3, food1, "13-03-2020",customer1, InvoiceStatus.Ongoing); 
        CashlessInvoice invoice2 = new CashlessInvoice (2, food2, "13-03-2020",customer2, InvoiceStatus.Finished,promo1); 
        CashlessInvoice invoice3 = new CashlessInvoice (4, food3, "13-03-2020",customer3, InvoiceStatus.Ongoing); 
        CashlessInvoice invoice4 = new CashlessInvoice (7, food4, "13-03-2020",customer3, InvoiceStatus.Ongoing, promo2);
        
        //PostTest
        CashInvoice invoicebaru1 = new CashInvoice (4, food1, "3/3/2020",customer1, InvoiceStatus.Finished); 
        CashInvoice invoicebaru2 = new CashInvoice (5, food2, "3/3/2020",customer2, InvoiceStatus.Finished, 13000); 
 
        //soal baru
        invoicebaru1.setTotalPrice();
        invoicebaru2.setTotalPrice();
        
        //CS*********************MOdul 4***
        invoice1.setTotalPrice();
        invoice2.setTotalPrice();
        invoice3.setTotalPrice();
        invoice4.setTotalPrice();
        
        invoice1.printData(); 
        invoice2.printData(); 
        invoice3.printData();
        invoice4.printData();
        
        
        //Modul post test********Modul 4***
        invoicebaru1.printData(); 
        invoicebaru2.printData();
        
    }
}

