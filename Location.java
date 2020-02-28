/**
* This class is Location
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class Location{
    /**
    * this method is used for location
    * 
    * @param province
    * @param city
    * @param description
    */
    private String province; 
    private String description; 
    private String city; 
    
    public Location (String city, String province, String description){
        this.city=city; 
        this.province=province; 
        this.description=description; 
        
    }
    
    public String getProvince(){
         /*
         * @return province
         */
        return province; 
    }
    
    public String getCity(){
         /*
         * @return city
         */
        return city; 
    }
    
    public String getDescription(){
         /*
         * @return description
         */
        return description; 
    }
    
    public void setProvince(String province){
        this.province=province; 
       
    }
    
    public void setCity(String city){
        this.city=city; 
       
    }
    
    public void setDescription(String description){
        this.description=description; 
    }
    
    public void printData(){
        System.out.println(province);
    }
}
