
/**
 * Write a description of class DatabaseSeller here.
 *
 * @author Muhamad Fadil
 * @version 28 Februai 2020
 */
public class DatabaseSeller
{
    private String[] listSeller; 
    
    //tambahan untuk bonus
    private Seller seller; 
    
    
    /**
     * Constructor for objects of class DatabaseSeller
     */
    public DatabaseSeller()
    {
        
    }
 
    public boolean addSeller (Seller seller){
        return false; 
    }
    
    public boolean removeSeller(Seller seller){
        return false; 
    }
    
    public String[] getListSeller(){
        return listSeller; 
    }
    
    
    //tambahan untuk bonus
    public Seller setSeller(){
        return seller; 
    }
    //tambahan untuk bonus
    public Seller getSeller(){
        return seller; 
    }
    
}
