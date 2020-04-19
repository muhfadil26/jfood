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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ArrayList<Seller> getAllSeller(){
        /*ArrayList<Seller> seller;
        seller = DatabaseSeller.getSellerDatabase();
        return seller;*/
        return DatabaseSeller.getSellerDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) throws SellerNotFoundException {
        Seller seller = DatabaseSeller.getSellerById(id);
        return seller;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Seller addSeller(//@RequestParam(value = "id") int id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "phoneNumber") String phoneNumber,
                          @RequestParam(value = "province") String province,
                          @RequestParam(value = "description") String description,
                          @RequestParam(value = "city") String city){
        Seller seller = new Seller (DatabaseSeller.getLastId()+1, name, email, phoneNumber, new Location(city, province, description));
        if(DatabaseSeller.addSeller(seller)) {
            return seller;
        }
        return null;
    }
}
