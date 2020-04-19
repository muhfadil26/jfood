package MuhamadFadil.jfood;
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

    public static Customer getCustomerById(int customerId) throws CustomerNotFoundException {
        for (Customer customer : CUSTOMER_DATABASE){
            if (customer.getId() == customerId ){
                return customer;
            }
        }
        throw new CustomerNotFoundException(customerId);
    }

    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistException
    {
        boolean sameEmailBuff = false;
        for (Customer buff: CUSTOMER_DATABASE) {
            if (customer.getEmail().equals(buff.getEmail())) {
                sameEmailBuff = true;
                break;
            }
        }

        if (!sameEmailBuff) {
            CUSTOMER_DATABASE.add(customer);
            lastId = customer.getId();
            return true;
        }
        throw new EmailAlreadyExistException(customer);
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

    public static Customer getCustomerLogin (String email, String password){
        for (Customer customer : CUSTOMER_DATABASE){
            if(customer.getEmail() ==email && customer.getPassword()==password){
                return customer;
            }
        }
        return null;
    }
}
