import java.util.ArrayList;

/**
 * This class is DatabaseFood
 *
 * @author  Muhamad Fadil
 * @version   2020-04-3
 */

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId=0;
    //private static Object InvoiceStatus;

    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Invoice getInvoiceById(int id)
    {
        Invoice invoice = INVOICE_DATABASE.get(id);
        if (invoice != null) {
            return invoice;
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if(customerId==INVOICE_DATABASE.get(i).getId()){
                return INVOICE_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        INVOICE_DATABASE.add(invoice);
        lastId=invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if(InvoiceStatus==INVOICE_DATABASE.get(i).getId()){
                return INVOICE_DATABASE.get(i);
            }
        }
        return null;
    }


    public static boolean removeInvoice(int id)
    {
        Invoice invoice= INVOICE_DATABASE.get(id);
        if (invoice!= null) {
            INVOICE_DATABASE.remove(invoice);
            return true;
        }
        return false;
    }

}




