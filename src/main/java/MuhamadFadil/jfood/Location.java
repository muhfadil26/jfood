package MuhamadFadil.jfood;
/**
* This class is Location
*
* @author  Muhamad Fadil
* @version   2020-02-27 
*/

public class Location{
    private String province; 
    private String description; 
    private String city; 
    
    /**
    * this method is used for location
    * 
    * @param province, this variable is used for name province
    * @param city, this is used for name city
    * @param description, this is used for decription city
    */

    //metode konstraktor
    public Location (String city, String province, String description){
        this.city=city; 
        this.province=province; 
        this.description=description; 
        
    }

    //metode getProvince
    public String getProvince(){
         /*
         * @return province
         */
        return province; 
    }

    //metode getCity
    public String getCity(){
         /*
         * @return city
         */
        return city; 
    }

    //metode getDescription
    public String getDescription(){
         /*
         * @return description
         */
        return description; 
    }

    //metode setProvince
    public void setProvince(String province){
        this.province=province; 
       
    }

    //metode setCity
    public void setCity(String city){
        this.city=city; 
       
    }

    //metode setDescription
    public void setDescription(String description){
        this.description=description; 
    }

    //metode cetak class location
    public String toString(){
         return "\n"+"Province = "+ province+ "\n"+
        "City = "+ city+ "\n"+
        "Description = "+ description+ "\n";
    }
}
