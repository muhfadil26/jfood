package MuhamadFadil.jfood;
import java.util.ArrayList;

/**
 * this class is for DatabaseSeller
 *
 * @author Muhamad Fadil
 * @version 28 Februai 2020
 */
public class DatabaseSeller
{
    // instance variables - replace the example below with your own
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public DatabaseSeller(){

    }

    public static ArrayList<Seller> getSellerDatabase(){
        return SELLER_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }

    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        for (Seller seller: SELLER_DATABASE)
        {
            if (seller.getId() == id)
            {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
        // return null;
    }

    public static boolean addSeller(Seller seller)
    {
        //SELLER_DATABASE.add(seller);
        //lastId = seller.getId();
        //return true;
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    public static boolean removeSeller(int id) throws SellerNotFoundException{
        Seller seller = SELLER_DATABASE.get(id);
        if (seller != null) {
            SELLER_DATABASE.remove(seller);
            return true;
        }
        throw new SellerNotFoundException(id);
    }
}
