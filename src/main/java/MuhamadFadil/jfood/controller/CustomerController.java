package MuhamadFadil.jfood.controller; //library group yang digunakan pada folder controller

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;

/**
 * kelas CustomerController digunanakn untuk mengontrol invoice
 * kelas ini berfungsi untuk menyambungkan dengan server lain menggunakan SPRINGBOOT agar dapat terkoneksi ke aplikasi lain
 * menghubungkan dengan menggunakan localhost:8080/{nama_deskripsi_alamat}
 * alaamat localhost(dapat bervariasi sesuai dengan kebutuhan)
 *
 * @author Muhamad Fadil
 * @version 14 Maret 2020
 */

//@RequestMapping("/customer")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController
public class CustomerController {
    /**
     * metode yang digunakan untuk menampilkan Hello word
     * alamat yang yang digunakan "localhost:8080/customer"
     *
     * @param name, memunculkan kata Hello
     * @return
     */
    @RequestMapping("/customer")
    public String indexPage(@RequestParam(value = "name", defaultValue = "word")String name){
        return "Hello " + name;
    }

    /**
     * metode yang digunakan untuk membuat alamat dengan metode request GET
     * alamat yang digunakan adalah "localhost:8080/customer/{id}"
     *
     * @param id, variable yang digunakan untuk mendapatkan id dari customer
     * @return  customer
     */
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int id){
        Customer customer = null;
        try
        {
            customer = DatabaseCustomerPostgre.getCustomer(id);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return customer;
    }

    /**
     * metode yang digunakan untuk membuat alamat request POST
     * alamat yang digunakan adalah "localhost:8080/customer/register"
     *
     * @param name, variable yang digunakan untuk mendapatkan nama dari customer
     * @param email, variable yang digunakan untuk mendapatkan email dari customer
     * @param password, variabele yang digunakan untuk mendapatkan password dari customer
     * @return null
     */
    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    public Customer registerCustomer (@RequestParam(value = "name") String name,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password) {
        try
        {
            return DatabaseCustomerPostgre.insertCustomer(DatabaseCustomerPostgre.getLastCustomerId()+1, name,  email,  password);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

    }

    /**
     * metode yang digunakan untuk membuat alamat dengan menggunakan metode POST
     * alamat yang digunakan adalah "localhost:8080/customer/login"
     *
     * @param email, variable yang digunakan untuk mendapatkan email dari customer
     * @param password, variable yang digunakan untuk mendapatkan password dari customer
     * @return customer
     */
    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password){

        Customer customer = null;

        try
        {
            customer = DatabaseCustomerPostgre.getLogin(email, password);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
        return customer;
    }
}
