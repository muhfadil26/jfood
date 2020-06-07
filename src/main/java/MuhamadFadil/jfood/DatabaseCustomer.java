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

    /**
     * konstraktor yang digunakan untuk DatabaseCustomer
     */
    public DatabaseCustomer(){

    }

    /**
     * metode yang digunakan untuk list dari customer
     *
     * @return
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    /**
     * metode yang digunakan untuk mendapatkan id terakhir  dari customer
     *
     * @return
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * metode yang digunakan untuk mendapatkan customer berdasarkan idnya
     *
     * @param customerId, digunakan untuk id customer
     * @return
     * @throws CustomerNotFoundException, digunakan untuk terhubung dengan class CustomerNotFoundException
     */
    public static Customer getCustomerById(int customerId) throws CustomerNotFoundException {
        for (Customer customer : CUSTOMER_DATABASE){
            if (customer.getId() == customerId ){
                return customer;
            }
        }
        throw new CustomerNotFoundException(customerId);
    }

    /**
     * metode yang digunakan untuk menambahkan customer
     *
     * @param customer, digunakan untuk berkomunikasi dengan customer
     * @return
     * @throws EmailAlreadyExistException, digunakan untuk pengecekan apakah emailnya telah terdaftar atau tidak
     */
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

    /**
     * metode yang digunakan untuk menghapus customer
     *
     * @param id, digunakan untuk melakukan penentuan id customer
     * @return
     * @throws CustomerNotFoundException, digunakan untuk pengecekan customer ada atau tidak pada database
     */
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

    /**
     * metode yang digunakan untuk melakukan login dengan email dan password yang sesuai
     *
     * @param email, digunaan untuk menentukan email yang akan diberikan untuk login
     * @param password, digunakan untuk menentukan password yang akan diberikan untuk login
     * @return
     */
    public static Customer getCustomerLogin (String email, String password){
        for (Customer customer : CUSTOMER_DATABASE){
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                return customer;
            }
        }
        return null;
    }
}
