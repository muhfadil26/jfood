package MuhamadFadil.jfood;

/**
 * class PriceCalculator digunakan untuk menambahkan invoice yang ada
 *
 */
public class PriceCalculator implements Runnable{
    //variable
    private Invoice invoice;

    /**
     * metode konstraktor yang digunakan untuk menghitung
     *
     * @param invoice, variable untuk menghubungkan dengan invoice
     */
    PriceCalculator(Invoice invoice)
    {
        this.invoice = invoice;
    }

    //metode untuk cetak
    public void run()
    {
        System.out.println("Calculating invoice id: " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("Finish calculating invoice id: " + invoice.getId());
    }
}
