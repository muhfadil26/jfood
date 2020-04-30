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

//@RequestMapping("/promo")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController
public class PromoController {
    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo(){
        ArrayList<Promo> promo;
        promo = DatabasePromo.getPromoDatabase();
        return promo;
    }

    @RequestMapping(value = "/promo/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code){
        Promo promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

    @RequestMapping(value = "/promo", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code") String code,
                          @RequestParam(value = "discount") int discount,
                          @RequestParam(value = "minPrice") int minPrice,
                          @RequestParam(value = "active") boolean active){
        Promo promo = null;
        try{
            promo = new Promo(DatabaseSeller.getLastId()+1,code,discount,minPrice,active);
            DatabasePromo.addPromo(promo);
        }catch (PromoCodeAlreadyExistException e){
            e.getMessage();
        }
        return promo;
    }

}
