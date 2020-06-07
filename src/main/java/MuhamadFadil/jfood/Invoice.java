package MuhamadFadil.jfood;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 * This class is Invoice
 *
 * @author  Muhamad Fadil
 * @version   2020-02-27
 */
public abstract class Invoice{
    //variables
    private int id;
    private ArrayList<Food> foods;
    private Calendar date; 
    protected int totalPrice; 
    private Customer customer; //connecting to Customer class
    private InvoiceStatus invoiceStatus;
    
    /**
    * this konstraktor class invoice is used for getting information about food
    * 
    * @param id, this variable is used for id invoice
    * @param foods, this variable is used for id Food
    * @param customer, this variable is used for customer
    */
    
    public Invoice (int id, ArrayList<Food> foods, Customer customer){
        Calendar calendar = Calendar.getInstance();

        this.id = id;
        this.foods = foods;
        this.customer = customer;
        this.date = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        this.invoiceStatus = InvoiceStatus.Ongoing;

    }

    //metode untuk mendaptkan id
    public int getId(){
         /*
         * @return id
         */
        return id; 
    }

    //metode untuk mendaptkan food array
    public ArrayList<Food> getFoods(){
         /*
         * @return idFood
         */
        return foods;
    }

    //metode untuk mendapatkan tanggal
    public Calendar getDate(){
         /*
         * @return date
         */
        return date; 
    }

    //metode yang digunakan untuk mendapatkan total biaya
    public int getTotalPrice(){
        return totalPrice; 
    }

    //metode yang digunakan untuk mendapatkan data customer
    public Customer getCustomer(){
        return customer; 
    }

    //metode abstrak paymentType
    public abstract PaymentType getPaymentType();

    //metode unntuk mendapatkan status dari invoice
    public InvoiceStatus getInvoiceStatus(){
        return invoiceStatus; 
    }

    //metode yang digunakan untuk set Id
    public void setId (int id){
        this.id=id;
    }

    //metode yang digunakan untuk set array food
    public void setFoods(ArrayList<Food> foods){
            this.foods=this.foods;
    }

    //metode yang digunakan untuk meng-set data pada calender
    public Calendar setDate (Calendar date){
        this.date=date; 
        return date;  
    }

    //metode untuk set format date
    public  void setDate (int year, int month, int dayOfMonth){
            this.date= new GregorianCalendar(year,month,dayOfMonth);
    }

    //metode untuk set total price
    public abstract void setTotalPrice ();

    //metode untuk setCustomer
    public void setCustomer (Customer customer){
        this.customer=customer;
    }

    //metode untuk setInvoiceStatus
    public void setInvoiceStatus (InvoiceStatus invoiceStatus){
        this.invoiceStatus=invoiceStatus;
    }

    //metode yang berfungsi untuk cetak class abstrak Invoice
    public abstract String toString();
    
}
