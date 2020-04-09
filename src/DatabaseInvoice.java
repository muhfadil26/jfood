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
    private static int id;
    //private static Object InvoiceStatus;

    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) {
        Invoice invoice = INVOICE_DATABASE.get(id);
        if (invoice != null) {
            return invoice;
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        ArrayList<Invoice> array1 = new ArrayList<>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getCustomer().getId() == customerId) {
                array1.add(invoice);
            }
        }
        return array1;
    }

    public static boolean addInvoice(Invoice invoice) {
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        //ArrayList<Invoice> invoiceStatus1 = new ArrayList<>();
        Invoice invoiceStatus1 = INVOICE_DATABASE.get(id);
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoiceStatus1.getInvoiceStatus() == InvoiceStatus.Ongoing){
                INVOICE_DATABASE.set(id, invoiceStatus1);
                return true;
            }
            else {
                return false;
            }

        }
        return true;
    }

        public static boolean removeInvoice ( int id)
        {
            Invoice invoice = INVOICE_DATABASE.get(id);
            if (invoice != null) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
            return false;
        }


    }





