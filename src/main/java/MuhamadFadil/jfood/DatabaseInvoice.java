package MuhamadFadil.jfood;
import java.util.ArrayList;

/**
 * kelas database yang diguanakn untuk menyimpan invoice baru
 *
 * @author  Muhamad Fadil
 * @version   2020-04-3
 */

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;
    //private static int id;
    //private static Object InvoiceStatus;

    /**
     * konstraktor yang digunakan untuk database invoice
     */
    public DatabaseInvoice() {

    }

    /**
     * metode yang digunakan untuk mendapatkan database invoice
     * @return
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    /**
     * metode yang digunakan untuk mendapatkan id terakhir
     * @return
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * metode yang digunakan untuk mendapatkan invoice berdasarkan idnya
     *
     * @param id, digunakan untuk menentukan id invoice
     * @return INVOICE_DATABASE.get(i)
     * @throws InvoiceNotFoundException, mengecek ada tidaknya invoice
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException{
        boolean checker = false;
        for(int i=0;i<INVOICE_DATABASE.size();i++)
            if (INVOICE_DATABASE.get(i).getId() == id) {
                checker = true;
                return INVOICE_DATABASE.get(i);
            }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * metode yang digunakan untuk menentukan invoice berdasarkan customer
     *
     * @param customerId, digunakan untuk id customer
     * @return
     */
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

    /**
     * metode yang digunakan untuk menambahkan invoice
     *
     * @param invoice, digunakan untuk terkoneksi ke invoice
     * @return
     * @throws OngoingInvoiceAlreadyExistsException, mengecek status
     */
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

    /**
     * metode yang digunakan untuk menentukan perubahan status
     *
     * @param id, digunakan untuk id invoice
     * @param invoiceStatus, digunakan untuk status invoicenya
     * @return
     */
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





