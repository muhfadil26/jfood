package MuhamadFadil.jfood.controller;

import MuhamadFadil.jfood.*;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

/**
 * this class is Controller Invoice
 *
 * @author Muhamad Fadil
 * @version 17 Maret 2020
 */

//@RequestMapping("/invoice")
@CrossOrigin(origins = "",allowedHeaders = "")
@RestController

public class InvoiceController
{
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceDatabase();
        return invoice;
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
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

    @RequestMapping(value = "/invoice/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId) {
        ArrayList<Invoice> invoice = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return invoice;
        //return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }

    @RequestMapping(value = "/invoice/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) {
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

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        try {
            if (DatabaseInvoice.removeInvoice(id)){
                return true;
            }
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @RequestMapping(value = "/invoice/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value = "customerId") int customerId,
                                  @RequestParam(value = "deliveryFee", defaultValue = "0") int deliveryFee) {

        ArrayList<Food> foodList = new ArrayList<>();
        //Customer customer = null;
        for (int temp: foodIdList) {
            try {
                foodList.add(DatabaseFood.getFoodById(temp));
            } catch (FoodNotFoundException e) {
                e.getMessage();
            }
        }

        try{
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, foodList, DatabaseCustomer.getCustomerById(customerId),deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();;
            return invoice;
        }catch (CustomerNotFoundException e){
            e.getMessage();
            return null;
        }catch (OngoingInvoiceAlreadyExistsException e){
            e.getMessage();
            return null;
        }
    }

    @RequestMapping(value = "/invoice/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "promoCode") String promoCode)
    {

        ArrayList<Food> foodList = new ArrayList<>();
        //Customer customer = null;
        for (Integer temp: foodIdList) {
            try {
                foodList.add(DatabaseFood.getFoodById(temp));
            } catch (FoodNotFoundException e) {
                e.getMessage();
            }
        }

        try{
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, foodList, DatabaseCustomer.getCustomerById(customerId), DatabasePromo.getPromoByCode(promoCode));
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();
            return invoice;
        }catch (CustomerNotFoundException e){
            e.getMessage();
            return null;
        }catch (OngoingInvoiceAlreadyExistsException e){
            e.getMessage();
            return null;
        }
    }
}