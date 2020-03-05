
public class JFood{
    public static void main (String[] args)
    {
        //FoodCategory foodcategory1 = new FoodCategory ("cstrgory"); 
        //n0.1
        Location location1 = new Location ("Tegal", "Jawa Tengah", "Kelahiranku"); 
        
        //no.2
        Seller seller1 = new Seller (28022020, "Muhamad Fadil", "muhamad.fadil@ui.ac.id", "087881490385", location1); 
 
        //no.3
        Food food1 = new Food (123, "Buah Naga", seller1,50000, FoodCategory.Rice); 
        
        //no.4
        Customer customer1 = new Customer (12345,"Muhamad Fadhilah", "Muhamadfadhilah@gmail.com", "rahasiadong","28-02-2020"); 
        
        //no.5
        Invoice invoice1 = new Invoice (2603,123,"28-02-2020", customer1, 399000); 
        
        //no.6
        System.out.println(seller1.getName());
        
        //no.7
        seller1.setName("Fadel"); 
        
        //no.8
        System.out.println(seller1.getName());
        
        //no.9
        food1.printData(); 
        
        //bonus
        DatabaseFood.removeFood(food1); 
    }
}

