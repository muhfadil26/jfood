/**
* This class is Customer
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class Customer{
    //inisialisasi atribut
     /**
    * this method is used for add customer
    * contains private variable
    * @param id, this is a variable 
    * @param name, this is a variable  
    * @param email, this is a variable 
    * @param password, this is a variable 
    * @param joinDate, this is a variable 
    */
   private int id; 
   private String name; 
   private String email; 
   private String password; 
   private String joinDate; 
   
   //inisialisasi konstruktor
   public Customer(int id, String name, String email, String password, String joinDate){
       this.id=id; 
       this.name=name; 
       this.email=email; 
       this.password=password; 
       this.joinDate=joinDate; 
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
    
    public String getJoinDate(){
        return joinDate; 
    }
    
    public void setId (int id){
    
    }
    
    public void setName (String name){
    
    }
    
    public void setEmail(String email){
    
    }
    
    public void setPassword(String password){
    
    }
    
    public void serJoinDate (String joinDate){
    
    }
    
    public void printData(){
           System.out.println(name);
    }
    
    
    
   
   
    
    
    
}



