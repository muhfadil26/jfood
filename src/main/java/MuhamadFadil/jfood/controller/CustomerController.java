package MuhamadFadil.jfood.controller;

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;

/**
 * this class is ControllerCustomer
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
        try{
            customer = DatabaseCustomer.getCustomerById(id);
        }catch (CustomerNotFoundException e){
            e.getMessage();
            return null;
        }
        return customer;
    }

    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    public Customer registerCustomer (@RequestParam(value = "name") String name,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password){
        Customer customer = new Customer(DatabaseCustomer.getLastId()+1, name, email, password);
        try{
            DatabaseCustomer.addCustomer(customer);
        }catch (EmailAlreadyExistException e){
            e.getMessage();
            return null;
        }
        return customer;
    }

    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password){
        Customer customer = null;
        customer = DatabaseCustomer.getCustomerLogin(email, password);
        return customer;
    }
}
