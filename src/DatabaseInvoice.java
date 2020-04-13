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

    public static Invoice getInvoiceById(int id) {
        Invoice invoice = INVOICE_DATABASE.get(id);
        if (invoice != null) {
            return invoice;
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        ArrayList<Invoice> array1 = new ArrayList<>();

        for (Invoice invoice: INVOICE_DATABASE) {
            if (invoice.getCustomer().getId() == customerId) {
                array1.add(invoice);
            }
        }

        if (!array1.isEmpty()) {
            return array1;
        }
        return null;
    }

    public static boolean addInvoice(Invoice invoice) {
        for (Invoice array1: INVOICE_DATABASE) {
            if (array1.getCustomer().getId() == invoice.getCustomer().getId()
                    && array1.getInvoiceStatus().equals(InvoiceStatus.Ongoing)) {
                return false;
            }
        }

        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for (Invoice invoice: INVOICE_DATABASE) {
            if (invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.Ongoing)){
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

        public static boolean removeInvoice ( int id)
        {
            for (Invoice invoice: INVOICE_DATABASE) {
                if (invoice.getId() == id) {
                    INVOICE_DATABASE.remove(invoice);
                    return true;
                }
            }
            return false;
        }


    }





