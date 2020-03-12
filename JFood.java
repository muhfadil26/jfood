
public class JFood{
    public static void main (String[] args)
    {
 
        Location locationbaru = new Location ("Tegal", "Jawa Tengah", "Kelahiranku"); 
        Seller sellerbaru = new Seller (28022020, "Muhamad Fadil", "muhamad.fadil@ui.ac.id", "087881490385", locationbaru); 
 
        //no.a
        Food food1 = new Food (123, "Kedondong", sellerbaru,50000, FoodCategory.Rice); 
        Food food2 = new Food (123, "Kedondong", sellerbaru,50000, FoodCategory.Rice); 
        Food food3 = new Food (123, "Kedondong", sellerbaru,50000, FoodCategory.Rice); 
        //no.a
        Customer customer = new Customer (12345,"Muhamad Fadhilah", "Muhamadfadhilah@gmail.com", "rahasiadong","28-02-2020"); 
        Customer customer2 = new Customer (12345,"Muhamad Fadhilah", "Muhamadfadhilah@gmail.com", "rahasiadong","28-02-2020");
        //no.b
        //Invoice invoicebaru = new Invoice (2603,123,"28-02-2020", customer, 399000,InvoiceStatus); 
        CashlessInvoice invoice1 = new CashlessInvoice (2980, food1, "13-03-2020",customer, InvoiceStatus.Ongoing); 
        CashlessInvoice invoice2 = new CashlessInvoice (2980, food2, "13-03-2020",customer2, InvoiceStatus.Finished); 
        CashlessInvoice invoice3 = new CashlessInvoice (2980, food3, "13-03-2020",customer, InvoiceStatus.Cancelled); 
        
        
        //System.out.println(sellerbaru.getName());
        //System.out.println(invoicebaru.getDate());
        invoice1.printData(); 
        invoice2.printData(); 
        invoice3.printData(); 
        //no.9
        //foodbaru.printData(); 
        
        //bonus
        //DatabaseFood.removeFood(foodbaru); 
    }
}

