
public class JFood
{
    public static void main (String[] args)
    {
        Location location0 = new Location ("Jakarta", "DKI Jakarta", "Bagus"); 
        System.out.println(location0.getProvince()); 
        
        Seller seller0 = new Seller (12334, "Joni", "Joni@joni.com", "0212334", location0); 
        System.out.println(seller0.getName());
        
        Food food0 = new Food (123, "Jeruk", seller0, 120000, "Buah"); 
        System.out.println(food0.getName());
        
        Customer customer0 = new Customer (12345,"John Oy", "Muh@fadil.com", "dediko","12-02-2012"); 
        System.out.println(customer0.getName());
        System.out.println(customer0.getEmail());
        
        Invoice invoice0 = new Invoice (1234,1290, "12-02-2010", customer0, 1204000); 
        System.out.println(invoice0.getDate());
        
    }
}

