package MuhamadFadil.jfood.controller; //library group yang digunakan pada folder controller

import MuhamadFadil.jfood.*; //library group yang berhubungan dengan folder jfood
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

/**
 * kelas InvoiceController digunanakn untuk mengontrol invoice
 * kelas ini berfungsi untuk menyambungkan dengan server lain menggunakan SPRINGBOOT agar dapat terkoneksi ke aplikasi lain
 * menghubungkan dengan menggunakan localhost:8080/{nama_deskripsi_alamat}
 * alaamat localhost(dapat bervariasi sesuai dengan kebutuhan)
 *
 * @author Muhamad Fadil
 * @version 17 Maret 2020
 */

@CrossOrigin(origins = "",allowedHeaders = "") //merupakan code yang digunakan untuk default (kosong)
@RestController

public class InvoiceController
{
    /**
     * metode yang digunakan untuk membuat alamat request dengan metode GET
     * alamat yang digunakan localhost:8080/invoice
     *
     * @return invoice
     */
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        //mendapatkan arrayList dari DatabaseInvice yang ada
        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceDatabase(); //membuka semua data invoice yang ada
        return invoice;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode GET
     * alamat yang digunakan localhost:8080/invoice/{id}
     *
     * @param id, variable yang digunakan untuk mendapatkan kode invoice
     * @return invoice
     */
    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {

        //mendapatkan data-data pada DatabaseInvoice berdasarkan pada DatabseInvoice
        Invoice invoice = null;
        try {
            invoice =  DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode GET
     * alamat yang digunakan localhost:8080/invoice/customer/{customerId}
     *
     * @param customerId, variable yang digunakan untuk mendapatkan Id dari customer
     * @return invoice
     */
    @RequestMapping(value = "/invoice/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId) {
        //mendaptkan Customer pada DatabaseInvoice berdasarkan Id customer
        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return invoice;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode PUT
     * alamat yang digunakan localhost:8080/invoice/invoiceStatus/{id}
     *
     * @param id, variable yang digunakan untuk mendapatkan id dari invoice
     * @param status, variable yang digunakan untuk mengubah status (finish, cancelled, atau ongoing)
     * @return invoice
     */
    @RequestMapping(value = "/invoice/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) {

        //mengubah status invoiceStatus dengan mendapatkan Idnya dan mengubah statusnya pada DatabaseInvoice
        Invoice invoice= null;
        DatabaseInvoice.changeInvoiceStatus(id,status);
        try{
            invoice = DatabaseInvoice.getInvoiceById(id);
        }catch (InvoiceNotFoundException e){
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode DELETE
     * alamat yang digunakan localhost:8080/invoice/{id}
     *
     * @param id, variable yang digunakan untuk mendapatkan Id dari Invoice
     * @return
     */
    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        //mendapatkan Id invoice pada DatabaseInvoce untuk menghapus Id invoice tersebut
        try {
            if (DatabaseInvoice.removeInvoice(id)){
                return true;
            }
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode POST
     * alamat yang digunakan localhost:8080/invoice/createCashInvoice
     *
     * @param foodIdList, variable yang digunakan untuk mendapatkan list dari array FOOD
     * @param customerId, variable yang digunakan untuk mendapatkan id dari customer
     * @param deliveryFee, variable yang digunakan untuk mendapatkan deliveryFee pada setiap pesanan Food
     * @return null
     */
    @RequestMapping(value = "/invoice/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value = "customerId") int customerId,
                                  @RequestParam(value = "deliveryFee") int deliveryFee) {
        // merupakan fungsi yang digunakan untuk mendapatkan array dari DATABASE food yang ada
        ArrayList<Food> foodList = new ArrayList<>();
        for (int temp: foodIdList) {
            //try cath digunakan untuk menambahkan array list dari food yang berbentuk array
            try {
                foodList.add(DatabaseFood.getFoodById(temp)); //menambahkan arraylist food pada database food
            } catch (FoodNotFoundException e) {
                e.getMessage(); //pesan jika tidak berhasil
            }
        }

        //membuat database invoice foodlist baru pada DatabaseInvoice
        try{
            //membuat invoice baru pada databseInvoce
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, foodList, DatabaseCustomerPostgre.getCustomer(customerId),deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();;
            return invoice;
        }
        catch (OngoingInvoiceAlreadyExistsException e){
            e.getMessage();
            return null;
        }
    }

    /**
     * metode yang digunakan untuk membuat alamat request dengan metode POST
     * alamat yang digunakan localhost:8080/invoice/createCashlessInvoice
     *
     * @param foodIdList, variable yang digunakan untuk mendapatkan ID dari array FOOD
     * @param customerId, variable yang digunakan untuk mendapatkan ID dari customer
     * @param promoCode, variable yang digunakan untuk mendapatkan promo dari makanan
     * @return null
     */
    @RequestMapping(value = "/invoice/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "promoCode") String promoCode)
    {

        //mendapatkan Foodlist
        ArrayList<Food> foodList = new ArrayList<>();
        for (Integer temp: foodIdList) {
            try {
                foodList.add(DatabaseFood.getFoodById(temp)); //menambahkan foodlist pada databaseFood
            } catch (FoodNotFoundException e) {
                e.getMessage();
            }
        }

        //membuat databse invoice baru secara CashLess pada DatabaseInvoice
        try{
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, foodList, DatabaseCustomerPostgre.getCustomer(customerId), DatabasePromo.getPromoByCode(promoCode));
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();
            return invoice;
        }
        catch (OngoingInvoiceAlreadyExistsException e){
            e.getMessage();
            return null;
        }
    }
}