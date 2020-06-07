package MuhamadFadil.jfood.controller; //library group yang digunakan pada folder controller

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * kelas PromoController digunanakn untuk mengontrol invoice
 * kelas ini berfungsi untuk menyambungkan dengan server lain menggunakan SPRINGBOOT agar dapat terkoneksi ke aplikasi lain
 * menghubungkan dengan menggunakan localhost:8080/{nama_deskripsi_alamat}
 * alaamat localhost(dapat bervariasi sesuai dengan kebutuhan)
 *
 * @author Muhamad Fadil
 * @version 16 Maret 2020
 */


//@RequestMapping("/promo")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController
public class PromoController {
    /**
     * metode yag digunakan untuk membuat request untuk mendapatkan promo dengan metode GET
     * alamat yang digunakan ialah "localhost:8080/promo"
     *
     * @return promo
     */
    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo(){
        ArrayList<Promo> promo;
        promo = DatabasePromo.getPromoDatabase();
        return promo;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan menggunakan metode GET
     * alamat yang digunakan ialah "localhost:8080/promo/{code}
     *
     * @param code, varibale ini digunakan untuk mendaptkan code dari promo
     * @return
     */
    @RequestMapping(value = "/promo/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code){
        Promo promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode POST
     * alamat yang digunakan ialah "localhost:8080/promo/add"
     *
     * @param code, variable yang digunakn untuk menambah code
     * @param discount, varible yang digunakan untuk menambahkan discount
     * @param minPrice, , varible yang digunakan untuk menambahkan minPrice
     * @param active, , varible yang digunakan untuk menambhakan active nya promoCode
     * @return
     */
    @RequestMapping(value = "/promo/add", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code") String code,
                          @RequestParam(value = "discount") int discount,
                          @RequestParam(value = "minPrice") int minPrice,
                          @RequestParam(value = "active") boolean active){
        Promo promo = new Promo(DatabaseSeller.getLastId()+1,code,discount,minPrice,active);
        try{
            DatabasePromo.addPromo(promo);
        }catch (PromoCodeAlreadyExistException e){
            e.getMessage();
        }
        return promo;

    }

}
