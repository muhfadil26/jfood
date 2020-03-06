
public class JFood{
    public static void main (String[] args)
    {
 
        Location locationbaru = new Location ("Tegal", "Jawa Tengah", "Kelahiranku"); 
        Seller sellerbaru = new Seller (28022020, "Muhamad Fadil", "muhamad.fadil@ui.ac.id", "087881490385", locationbaru); 
 
        //no.a
        Food foodbaru = new Food (123, "Kedondong", sellerbaru,50000, FoodCategory.Rice); 
        
        //no.a
        Customer customer = new Customer (12345,"Muhamad Fadhilah", "Muhamadfadhilah@gmail.com", "rahasiadong","28-02-2020"); 
        
        //no.b
        Invoice invoicebaru = new Invoice (2603,123,"28-02-2020", customer, 399000,InvoiceStatus.Ongoing); 
        
        
        
        //System.out.println(sellerbaru.getName());
        //System.out.println(invoicebaru.getDate());
        invoicebaru.printData(); 
        
        //no.9
        //foodbaru.printData(); 
        
        //bonus
        //DatabaseFood.removeFood(foodbaru); 
    }
}

