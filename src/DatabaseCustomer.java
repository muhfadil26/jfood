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
        for (int i = 0; i < CUSTOMER_DATABASE.size(); i++) {
            if(id==CUSTOMER_DATABASE.get(i).getId()){
                return CUSTOMER_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addCustomer(Customer customer)
    {
        if(CUSTOMER_DATABASE.size()>0){
            boolean existingEmail=false;
            for (int i = 0; i < CUSTOMER_DATABASE.size(); i++) {
                if(customer.getEmail()==CUSTOMER_DATABASE.get(i).getEmail()){
                    existingEmail=true;
                }
            }
            if(!existingEmail){
                CUSTOMER_DATABASE.add(customer);
                lastId=customer.getId();
                return true;
            }
            else return false;
        }
        else
        {
            CUSTOMER_DATABASE.add(customer);
            lastId=customer.getId();
            return true;
        }
    }

    public static boolean removeCustomer(int id)
    {
        for (int i = 0; i < CUSTOMER_DATABASE.size(); i++) {
            if(id==CUSTOMER_DATABASE.get(i).getId()){
                CUSTOMER_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }
}
