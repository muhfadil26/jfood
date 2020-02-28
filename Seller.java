/**
* This class is Seller
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/
public class Seller{
    /**
    * this method is used to check Seller
    * 
    * @param id
    * @param name
    * @param email
    * @param phoneNumber   
    * @param location
    */
    private int id; 
    private String name; 
    private String email; 
    private String phoneNumber; 
    private Location location; 
    
    public Seller(int id, String name, String email, String phoneNumber, Location location){
        this.id=id;
        this.name=name; 
        this.email=email; 
        this.phoneNumber=phoneNumber; 
        this.location=location; 
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
         /*
         * @return email
         */
        return email; 
    }
    
    public String getphoneNumber(){
         /*
         * @return phoneNumber
         */
        return phoneNumber; 
    }
    
    public Location getlocation(){
         /*
         * @return locatio
         */
        return location; 
    }
    
    public void setId(int id){
        this.id=id; 
    }
    
    public void setName(String name){
        this.name=name; 
    }
    
    public void setEmail(String email){
        this.email=email; 
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber; 
    }
    
    public void setLocation(Location location){
        this.location=location; 
    }
    
    public void printData(){
        System.out.println(name);
    }
    
    
    
    
    
}
