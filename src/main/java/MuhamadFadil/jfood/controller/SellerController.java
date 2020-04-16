package MuhamadFadil.jfood.controller;

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * this class is ControllerCustomer
 *
 * @author Muhamad Fadil
 * @version 16 Maret 2020
 */

@RequestMapping("/seller")
@RestController
public class SellerController {

    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller(){
        ArrayList<Seller> seller;
        seller = DatabaseSeller.getSellerDatabase();
        return seller;
    }

    @RequestMapping("/{id}")
    public Seller getSellerById(@PathVariable int id){
        Seller seller = null;
        try{
            seller = DatabaseSeller.getSellerById(id);
        }catch (SellerNotFoundException e){
            e.getMessage();
            return null;
        }
        return seller;
    }

    @RequestMapping(value = "/seller", method = RequestMethod.POST)
    public void addSeller(@RequestParam(value = "id") int id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "phoneNumber") String phoneNumber,
                          @RequestParam(value = "province") String province,
                          @RequestParam(value = "description") String description,
                          @RequestParam(value = "city") String city){
        Location temp = new Location(city, province, description);
        Seller seller = new Seller(id, name, email, phoneNumber, temp);
        DatabaseSeller.addSeller(seller);
    }
}
