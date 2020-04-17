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

@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice(){
        ArrayList<Invoice> invoice;
        invoice = DatabaseInvoice.getInvoiceDatabase();
        return invoice;
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id){
        Invoice invoice = null;
        try{
            invoice = DatabaseInvoice.getInvoiceById(id);
        }catch (InvoiceNotFoundException e){
            e.getMessage();
            return null;
        }
        return invoice;
    }

    @RequestMapping(value = "/invoice/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId){
        ArrayList<Invoice> invoice= null;
        try {
            invoice = DatabaseInvoice.getInvoiceByCustomer(customerId);
        }catch (CustomerNotFoundException e){
            e.getMessage();
        }
        return invoice;
    }

    @RequestMapping(value= "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus (@PathVariable int id, @RequestParam InvoiceStatus status){

        boolean check = DatabaseInvoice.changeInvoiceStatus(id,status);
        if (check){
            try{
                return DatabaseInvoice.getInvoiceById(id);
            }catch (InvoiceNotFoundException e){
                e.getMessage();
            }
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id){
        try{
            if (DatabaseInvoice.removeInvoice(id)){
                return true;
            }
        }catch (InvoiceNotFoundException e){
            e.getMessage();
        }
        return false;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="id") int id,
                                  @RequestParam(value="foods") ArrayList<Food> foods,
                                  @RequestParam(value="customer") Customer customer,
                                  @RequestParam(value="deliveryFee") int deliveryFee)
    {
        try {
            if(DatabaseInvoice.addInvoice(new CashInvoice(id, foods, customer, deliveryFee))){
                return DatabaseInvoice.getInvoiceById(id);
            }
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="id") int id,
                                      @RequestParam(value="foods") ArrayList<Food> foods,
                                      @RequestParam(value="customer") Customer customer,
                                      @RequestParam(value="promo") Promo promo)
    {
        try {
            if(DatabaseInvoice.addInvoice(new CashlessInvoice(id, foods, customer, promo))){
                return DatabaseInvoice.getInvoiceById(id);
            }
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

}
