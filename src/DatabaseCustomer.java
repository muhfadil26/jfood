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
    private static ArrayList<Customer> CUSTOMER_DATABASE =  new ArrayList<>();
    private static int lastId=0;

    public DatabaseCustomer(){

    }

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Customer getCustomerById(int id) throws CustomerNotFoundException {
        Customer customer = CUSTOMER_DATABASE.get(id);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException(id);
        }
    }

    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistException
    {
        for (Customer i : CUSTOMER_DATABASE)
        {
            if(i.getEmail().equals(customer.getEmail()))
            {
                throw new EmailAlreadyExistException (customer);
                // return false;
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }


    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        // put your code here
        Customer customer = CUSTOMER_DATABASE.get(id);
        if (customer != null) {
            CUSTOMER_DATABASE.remove(customer);
            return true;
        }
        throw new CustomerNotFoundException(id);
    }
}
