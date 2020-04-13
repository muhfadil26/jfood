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
        Invoice invoice = INVOICE_DATABASE.get(id);
        if (invoice != null) {
            return invoice;
        }
        throw new InvoiceNotFoundException(id);
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

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException{
        for (Invoice array1: INVOICE_DATABASE) {
            if (array1.getCustomer().getId() == invoice.getCustomer().getId()
                    && array1.getInvoiceStatus().equals(InvoiceStatus.Ongoing)) {
                throw new OngoingInvoiceAlreadyExistsException(invoice.getId());
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

        public static boolean removeInvoice ( int id) throws InvoiceNotFoundException
        {
            for (Invoice invoice: INVOICE_DATABASE) {
                if (invoice.getId() == id) {
                    INVOICE_DATABASE.remove(invoice);
                    return true;
                }
            }
            throw new InvoiceNotFoundException(id);
        }


    }





