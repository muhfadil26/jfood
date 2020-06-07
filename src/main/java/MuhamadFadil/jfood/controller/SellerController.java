package MuhamadFadil.jfood.controller; //library group yang digunakan pada folder controller

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * kelas SellerController digunanakn untuk mengontrol invoice
 * kelas ini berfungsi untuk menyambungkan dengan server lain menggunakan SPRINGBOOT agar dapat terkoneksi ke aplikasi lain
 * menghubungkan dengan menggunakan localhost:8080/{nama_deskripsi_alamat}
 * alaamat localhost(dapat bervariasi sesuai dengan kebutuhan)
 *
 * @author Muhamad Fadil
 * @version 16 Maret 2020
 */

//@RequestMapping("/seller")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController
public class SellerController {

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode POST
     * alamat yang digunakan adalah "localhost:8080/seller"
     *
     * @return seller
     */
    @RequestMapping(value = "/seller", method = RequestMethod.POST)
    public ArrayList<Seller> getAllSeller(){
        ArrayList<Seller> seller = DatabaseSeller.getSellerDatabase();
        return seller;
    }

    /**
     * metode yang digunakan untuk membuat alamat request denga metode GET
     * alamat yang digunakan untuk adlah "localhost:8080/seller/{id}"
     *
     * @param id, variable digunakan untuk mendapatkan id Seller
     * @return seller
     * @throws SellerNotFoundException, throws digunakan untuk mengetahui jika ada seller yang sama
     */
    @RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) throws SellerNotFoundException {
        Seller seller = DatabaseSeller.getSellerById(id);
        return seller;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan menggunakan metode POST
     * alamat yang digunakan ialah "localhost:8080/seller/add"
     *
     * @param name, variable name digunakan untuk mendapatkan nama dari seller
     * @param email, variable yang digunakan untuk mendapatkan email seller
     * @param phoneNumber, variable yang digunakan untuk mendapatkan nomor telepon seller
     * @param province, variable yang digunakan untuk mendapatkan province
     * @param description, variable yang digunakan untuk deskripsi dari seller
     * @param city, variable yang digunakan untuk mendapatkan kota dari seller
     * @return null
     */
    @RequestMapping(value = "/seller/add", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name,
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
