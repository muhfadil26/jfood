import java.util.ArrayList;

/**
 * this class for DatabaseCustomer
 *
 * @author Muhamad Fadil
 * @version 5 Maret 2020
 */
public class DatabaseCustomer
{
    // Instance variable: List of Seller
    private static ArrayList<Customer> CUSTOMER_DATABASE =  new ArrayList<Customer>(0);;
    private static int lastId=0;

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Customer getCustomerById(int id)
    {
        Customer customer = CUSTOMER_DATABASE.get(id);
        if (customer != null) {
            return customer;
        }
        return null;
    }

    public static boolean addCustomer(Customer customer)
    {
        // initialise instance variables
        boolean sameEmail= false;
        for (Customer i : CUSTOMER_DATABASE) {
            if (customer.getEmail() == i.getEmail()) {
                sameEmail = true;
            }
        }

        if (!sameEmail) {
            CUSTOMER_DATABASE.add(customer);
            lastId = CUSTOMER_DATABASE.indexOf(customer);
        }
        return false;
    }

    public static boolean removeCustomer(int id)
    {
        // put your code here
        Customer customer = CUSTOMER_DATABASE.get(id);
        if (customer != null) {
            CUSTOMER_DATABASE.remove(customer);
            return true;
        }
        return false;
    }
}
