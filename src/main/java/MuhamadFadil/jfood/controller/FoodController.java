package MuhamadFadil.jfood.controller; //library group yang digunakan pada folder controller

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * kelas FoodController digunanakn untuk mengontrol invoice
 * kelas ini berfungsi untuk menyambungkan dengan server lain menggunakan SPRINGBOOT agar dapat terkoneksi ke aplikasi lain
 * menghubungkan dengan menggunakan localhost:8080/{nama_deskripsi_alamat}
 * alaamat localhost(dapat bervariasi sesuai dengan kebutuhan)
 *
 * @author Muhamad Fadil
 * @version 17 Maret 2020
 */

//@RequestMapping("/food")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController
public class FoodController {

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode GET
     * alamat yang digunakaen ialah "localhost:8080/food"
     *
     * @return food
     */
    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood(){
        ArrayList<Food> food;
        food = DatabaseFood.getFoodDatabase();
        return food;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode GET
     * alamat yang digunakaen ialah "localhost:8080/food/{id}"
     *
     * @param id, variable  yang digunakan untuk mendaptkan id dari food
     * @return food
     */
    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id)  {
        Food food=null;
        try{
            food = DatabaseFood.getFoodById(id);
        }catch (FoodNotFoundException e){
            e.getMessage();
            return null;
        }
        return food;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode GET
     * alamat yang digunakaen ialah "localhost:8080/food/seller/{sellerId}"
     *
     * @param sellerId, variable yang digunakan untuk mendapatkan id dari seller
     * @return food
     */
    @RequestMapping(value = "/food/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId){
        ArrayList<Food> food = null;
        try {
            food = DatabaseFood.getFoodBySeller(sellerId);
        }catch (SellerNotFoundException e){
            e.getMessage();
        }
        return food;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode GET
     * alamat yang digunakaen ialah "localhost:8080/food/category/{category}"
     *
     * @return food
     */
    @RequestMapping(value = "/food/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory (@PathVariable FoodCategory category){
        ArrayList<Food> food = null;
        food = DatabaseFood.getFoodByCategory(category);
        return food;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode POST
     * alamat yang digunakaen ialah "localhost:8080/food"
     *
     * @param category, variable yang digunakan untuk mendapatkan kategori dari makanan
     * @param name, variable yang digunakan untuk mendapatkan nama dari makanan
     * @param price, variable yang digunakan untuk mendapatkan harga makanan
     * @param sellerId, variable yang digunakan untuk mendapatkan id dari Seller
     * @return food
     */
    @RequestMapping(value = "/food", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name")String name,
                        @RequestParam(value = "sellerId")int sellerId,
                        @RequestParam(value = "price")int price,
                        @RequestParam(value = "category") FoodCategory category) throws SellerNotFoundException{
        Food food = new Food(DatabaseFood.getlastId()+1, name, DatabaseSeller.getSellerById(sellerId),price,FoodCategory.Western);
        DatabaseFood.addFood(food);
        return food;
    }


}
