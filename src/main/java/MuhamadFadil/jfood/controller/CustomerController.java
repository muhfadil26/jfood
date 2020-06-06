package MuhamadFadil.jfood.controller;

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;

/**
 * kelas ini digunakan untuk membuat kontroler pada customer
 *
 * @author Muhamad Fadil
 * @version 14 Maret 2020
 */

//@RequestMapping("/customer")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController
public class CustomerController {
    @RequestMapping("/customer")
    public String indexPage(@RequestParam(value = "name", defaultValue = "word")String name){
        return "Hello " + name;
    }

    @RequestMapping("/customer/{id}")
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

    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    public Customer registerCustomer (@RequestParam(value = "name") String name,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password){
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
