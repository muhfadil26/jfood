package MuhamadFadil.jfood;

/**
* This class is used for Customer
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/
import java.util.Calendar; 
import java.util.Date; 
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat; 
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class Customer{
    //inisialisasi atribut
   private int id; 
   private String name; 
   private String email; 
   private String password; 
   private Calendar joinDate; 
   
    /**
    * this method constructor is used for add customer
    * contains private variable
    * @param id, this is a variable for id customer
    * @param name, this is a variable for name customer
    * @param email, this is a variable for email customer
    * @param password, this is a variable for customer's password
    * @param joinDate, this is a variable for joinDate customer
    */
   
   //inisialisasi konstruktor
   public Customer(int id, String name, String email, String password, Calendar joinDate){
       this.id=id; 
       this.name=name; 
       this.email=email; 
       this.password=password; 
       this.joinDate=joinDate; 
       setEmail(email); 
       setPassword(password); 
    }

    /**
     * this constructor method is used for add customer
     * contains private variable
     * @param id, this is a variable for id customer
     * @param name, this is a variable for name customer
     * @param email, this is a variable for email customer
     * @param password, this is a variable for customer's password
     * @param year, this is a variable for setting year
     * @param month, this is a variable for setting month
     * @param dayOfMonth, this is a variable for setting day
     */
   public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth){
       this.id=id; 
       this.name=name; 
       this.email=email; 
       this.password=password; 
       this.joinDate= new GregorianCalendar(year,month,dayOfMonth);
       setEmail(email); 
       setPassword(password);
       //this.year=year; 
       //this.month=month; 
       //this.dayOfmounth=dayOfmounth; 
    }

    /**
     * this constructor method is used for add customer
     * contains private variable
     * @param id, this is a variable for id customer
     * @param name, this is a variable for name customer
     * @param email, this is a variable for email customer
     * @param password, this is a variable for customer's password
     */
   public Customer(int id, String name, String email, String password){
       this.id=id; 
       this.name=name; 
       this.email=email; 
       this.password=password; 
       this.joinDate= Calendar.getInstance();
       setEmail(email); 
       setPassword(password);
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan Id
     */
   public int getId(){
         /*
         * @return id
         */
       return id;    
   }

    /*
     * metode class contraktor yang digunakan untuk mendapatkan nama customer
     */
   public String getName(){
       /*
        * @return name
        */
       return name; 
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan email customer
     */
   public String getEmail(){
       return email; 
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan password customer
     */
    public String getPassword(){
        return password; 
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan join date dari customer
     */
    public Calendar getJoinDate(){
        return joinDate; 
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan Id
     * @param Id, digunakan untuk mengset Id yang dibutuhkan
     */
    public void setId (int id){
        this.id=id; 
    }

    /*
     * metode constraktor yang digunakan untuk mengset nama customer
     * @param name, digunakan untuk menentukan nama dari customer
     */
    public void setName (String name){
        this.name=name; 
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan email
     * @param email, digunakan untuk menentukan nilai inputan email yang sesaui
     */
    public void setEmail(String email){
        String emailRegex =
                            "^[_A-Za-z0-9-\\+]+[\\w.&*_~]([_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.+)(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 

        Pattern pat = Pattern.compile(emailRegex);
        Matcher m = pat.matcher(email); 
        if (m.matches()){
            //System.out.println("Email : " + m.group()); 
            this.email=email; 
        }
        else{
            //System.out.println("Email : NULL"); 
            this.email=""; 
        }
        
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan password
     * @param password, digunakan untuk mengatur nilai password yang benar
     */
    public void setPassword(String password){
        String passwordRegex = //"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
                                "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z\\d]{6,}$";
        Pattern pat = Pattern.compile(passwordRegex); 
        Matcher m = pat.matcher(password); 
        if (m.matches()){
            //System.out.println("Password : " + m.group()); 
            this.password=password; 
        }
        else{
            //System.out.println("Password : NULL"); 
            this.password=""; 
        }
    }

    /*
     * metode constraktor yang digunakan untuk mendapatkan joinDate
     * @param joinDate, digunakan untuk mengeset nilai kalender
     */
    public void setJoinDate (Calendar joinDate){
        this.joinDate=joinDate; 
    }

    /*
     * metode constraktor yang digunakan menentukan tanggal join customer
     * @param year, variable integer yang digunakan untuk menentukan tahun
     * @param month, variable integer yang digunakan untuk menentukan bulan
     * @param dayOfMonth, variable integer yang digunakan untuk menentukan hari
     */
    public void setJoinDate (int year, int month, int dayOfmonth){
        this.joinDate= new GregorianCalendar(year, month-1, dayOfmonth); 
    }

    /*
     * metode constraktor yang digunakan untuk mencetak isi customer
     */
    public String toString(){
        String string = ""; 
        if (joinDate!=null)
        {
            Date date = joinDate.getTime(); 
            SimpleDateFormat format1 = new SimpleDateFormat ("dd-MM-yyyy"); 
            String date1 = format1.format(date); 
            string =  

                    "\n"+"Id : "+ id+ "\n"+
                    "Name : "+ name+ "\n"+
                    "Email : "+ email+ "\n"+
                    "Password : "+ password+ "\n"+
                    "Join Date : "+ date1+"\n"; 
                    //"Join Date : "+ format1.format(getJoinDate().getTime())+"\n"; 
                }
         else{
           
             string =  

                    "\n"+"Id : "+ id+ "\n"+
                    "Name : "+ name+ "\n"+
                    "Email : "+ email+ "\n"+
                    "Password : "+ password+ "\n";
                    //"Join Date : "+ format1.format(getJoinDate().getTime())+"\n"; 
                    //"Join Date : "+ joinDate+ "\n"; 
            }
            
        System.out.println(string); 
        return string; 

    }
    
    
    
   
   
    
    
    
}



