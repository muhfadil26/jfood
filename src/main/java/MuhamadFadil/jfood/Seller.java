package MuhamadFadil.jfood;


/**
* This class is Seller
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/
public class Seller{
    private int id; 
    private String name; 
    private String email; 
    private String phoneNumber; 
    private Location location; //make variable location to connect Location class
    
     /**
    * this method is used for getting Seller information
    * @param id, this variable is used for id seller
    * @param name, this variable is used for seller's name
    * @param email, this variable is used for seller's email
    * @param phoneNumber, this variable is used for phoneNumber seller   
    * @param location, this variable is used for location seller
    */
    
    public Seller(int id, String name, String email, String phoneNumber, Location location){
        this.id=id;
        this.name=name; 
        this.email=email; 
        this.phoneNumber=phoneNumber; 
        this.location=location; 
    }

    //metode getId
    public int getId(){
         /*
         * @return id
         */
        return id; 
    }

    //metode getName
    public String getName(){
         /*
         * @return name
         */
        return name; 
    }

    //metode getEmail
    public String getEmail(){
         /*
         * @return email
         */
        return email; 
    }

    //metode getPhoneNumber
    public String getPhoneNumber(){
         /*
         * @return phoneNumber
         */
        return phoneNumber; 
    }

    //metode getLocation
    public Location getLocation(){
         /*
         * @return location
         */
        return location; 
    }

    //metode setId
    public void setId(int id){
        this.id=id; 
    }

    //metode setName
    public void setName(String name){
        this.name=name; 
    }

    //metode setEmail
    public void setEmail(String email){
        this.email=email; 
    }

    //metode setPhoneNumber
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber; 
    }

    //metode setLocation
    public void setLocation(Location location){
        this.location=location; 
    }

    //metode untuk cetak seller
    public String toString(){
         return
        "\n"+"Id = "+ id+ "\n"+
        "Name = "+ name+ "\n"+
        "PhoneNumber = "+ phoneNumber+ "\n"+
        "Location = "+ location+ "\n"; 
    }
}
