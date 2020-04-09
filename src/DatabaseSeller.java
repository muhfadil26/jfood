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

    public static ArrayList<Seller> getSellerDatabase(){
        return SELLER_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }

    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        Seller value = null;
        for(Seller seller : SELLER_DATABASE)
        {
            if(seller.getId()==lastId)
            {
                value=seller;
            }
            else
            {
                return value;
            }
        }
        throw new SellerNotFoundException(id);
    }

    public static boolean addSeller(Seller seller) throws SellerNotFoundException
    {
        SELLER_DATABASE.add(seller);
        lastId = SELLER_DATABASE.indexOf(seller);
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
