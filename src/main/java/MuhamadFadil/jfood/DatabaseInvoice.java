package MuhamadFadil.jfood;
import java.util.ArrayList;

/**
 * This class is DatabaseFood
 *
 * @author  Muhamad Fadil
 * @version   2020-04-3
 */

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;
    //private static int id;
    //private static Object InvoiceStatus;

    public DatabaseInvoice() {

    }

    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException{
        boolean checker = false;
        for(int i=0;i<INVOICE_DATABASE.size();i++)
            if (INVOICE_DATABASE.get(i).getId() == id) {
                checker = true;
                return INVOICE_DATABASE.get(i);
            }
        throw new InvoiceNotFoundException(id);
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        boolean check = false;
        ArrayList<Invoice> temp= new ArrayList<Invoice>();
        for(int i=0;i<INVOICE_DATABASE.size();i++)
            if (INVOICE_DATABASE.get(i).getCustomer().getId() == customerId) {
                temp.add(INVOICE_DATABASE.get(i));
                check = true;
            }
        if (check) return temp;
        return temp;
    }

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException{
        for (Invoice array1 : INVOICE_DATABASE) {
            if(array1.getCustomer().equals(invoice.getCustomer()) && invoice.getInvoiceStatus().equals(InvoiceStatus.Finished)) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for(int i=0;i<INVOICE_DATABASE.size();i++)
            if (INVOICE_DATABASE.get(i).getId() == id) {
                INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
        return false;
    }

        public static boolean removeInvoice ( int id) throws InvoiceNotFoundException
        {
            for (Invoice invoice: INVOICE_DATABASE)
                if (invoice.getId() == id) {
                    INVOICE_DATABASE.remove(invoice);
                    return true;
                }
            throw new InvoiceNotFoundException(id);
        }
    }





