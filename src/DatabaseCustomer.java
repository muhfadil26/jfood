import java.util.ArrayList;

/**
 * this class for DatabaseCustomer
 *
 * @author Muhamad Fadil
 * @version 5 Maret 2020
 */
public class DatabaseCustomer
{
    private ArrayList<Customer> CUSTOMER_DATABASE;
    private int lastId;

    public ArrayList<Customer> getCustomerDatabase() {
        return CUSTOMER_DATABASE;
    }

    public int getLastId(){
        return lastId;
    }

    public Customer getCustomerById(int id){
        Customer value = null;
        for (Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getId()==id){
                value=customer;
            }
        }
        return value;
    }

    public static boolean addCustomer(Customer customer){
        return false;
    }

    public static boolean removeCustomer(Customer customer){
        return false;
    }

    
}
