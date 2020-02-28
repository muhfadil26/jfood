
public class JFood{
    public static void main (String[] args)
    {
        //set value for Location, making location0
        Location location0 = new Location ("Jakarta", "DKI Jakarta", "Bagus"); 
        //prints 
        System.out.println(location0.getProvince()); 
        //set value for Seller, making seller0
        Seller seller0 = new Seller (12334, "Joni", "Joni@joni.com", "0212334", location0); 
        System.out.println(seller0.getName());
        //set value for Food, making food0
        Food food0 = new Food (123, "Jeruk", seller0, 120000, "Buah"); 
        System.out.println(food0.getName());
        //set value for Customer, making customer0
        Customer customer0 = new Customer (12345,"John Oy", "Muh@fadil.com", "dediko","12-02-2012"); 
        System.out.println(customer0.getName());
        customer0.setName("Ola"); 
        System.out.println(customer0.getName());
        System.out.println(customer0.getEmail());
        //set value for invoice, making invoice0
        Invoice invoice0 = new Invoice (1234,1290, "12-02-2010", customer0, 1204000); 
        System.out.println(invoice0.getDate());
        
    }
}

