package MuhamadFadil.jfood;


/**
 * this class is used for class Promo
 *
 * @author Muhamad Fadil
 * @version 12 Maret 2020
 */
public class Promo
{
    //variable
    private int id; 
    private String code; 
    private int discount; 
    private int minPrice; 
    private boolean active; 
    
    /**
    * this method class invoice is used for getting information about food  
    * 
    * @param id, this variable is used for id invoice
    * @param code, this variable is used for id code
    * @param discount, this variable is used for discount
    * @param minPrice, this variable is used for minPrice
    * @param active, this variable is used for active
    */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        this.id=id; 
        this.code=code; 
        this.discount=discount; 
        this.minPrice=minPrice; 
        this.active=active; 
        
    }

    //metode getId
    public int getId(){
        /*
         *return id
         */
        return id; 
    }

    //metode getCode
    public String getCode(){
        /*
         *return code
         */
        return code; 
    }

    //metode getDiscount
    public int getDiscount(){

        /*
         *return discount
         */
        return discount; 
    }

    //metode getMinPrice
    public int getMinPrice(){
        /*
         *return minPrice
         */
        return minPrice; 
    }

    //metode getActive
    public boolean getActive(){

        /*
         *return active
         */
        return active;
    }

    //metode setId
    public void setId(int id){
        this.id=id;
    }

    //metode setCode
    public void setCode(String code){
     this.code=code;
    }

    //metode setDiscount
    public void setDiscount(int discount){
        this.discount=discount;
    }

    //metode setMinPrice
    public void setMinPrice(int minPrice){
        this.minPrice=minPrice;
    }

    //metode setActive
    public void setActive (boolean active){
        this.active=active;
    }

    //metode untuk cetak promo
    public String toString(){
         return 

        "\n"+"Id = "+ id+ "\n"+
        "Code = "+ code+ "\n"+
        "Discount = "+ discount+ "\n"+
        "MinPrice = "+ minPrice+ "\n"+
        "Active Status = "+ active+ "\n";
    }

}
