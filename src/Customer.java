/**
* This class is used for Customer
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/
import java.util.*; 
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
    * this method is used for add customer
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
    
   public Customer(int id, String name, String email, String password){
       this.id=id; 
       this.name=name; 
       this.email=email; 
       this.password=password; 
       this.joinDate=joinDate; 
       setEmail(email); 
       setPassword(password);
    }
     
    
   public int getId(){
         /*
         * @return id
         */
       return id;    
   }
   
   public String getName(){
       /*
        * @return name
        */
       return name; 
    }
    
   public String getEmail(){
       return email; 
    }
   
    public String getPassword(){
        return password; 
    }
    
    public Calendar getJoinDate(){
        return joinDate; 
    }
    
    public void setId (int id){
        this.id=id; 
    }
    
    public void setName (String name){
        this.name=name; 
    }
    
    public void setEmail(String email){
        String emailRegex = /*"^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; */
                            //"^([a-z\\d\\.]+)@([a-z\\d-]+)\\.([a-z]{2,8}(\\.[a-z]{2,8}))?$";
                            "^[_A-Za-z0-9-\\+]+[\\w.&*_~]([_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.+)(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
                            //"^(?!\\.)(?!.\\.$)(?!.*\\.\\.$)[\\w.&*_~]+@(.+)+$"; 
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
    
    public void setJoinDate (Calendar joinDate){
        this.joinDate=joinDate; 
    }
    
    public void setJoinDate (int year, int month, int dayOfmonth){
        this.joinDate= new GregorianCalendar(year, month-1, dayOfmonth); 
    }
    
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
        
        /*return 
        "===================Customer================"+"\n"+
                    "Id : "+ id+ "\n"+
                    "Name : "+ name+ "\n"+
                    "Email : "+ email+ "\n"+
                    "Password : "+ password+ "\n"+
                    "Join Date : "+ joinDate+ "\n";*/
    }
    
    
    
   
   
    
    
    
}



