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

    public static int getLastId(){
        return lastId;
    }

    public static Seller getSellerById(int id) {
        for (int i = 0; i < SELLER_DATABASE.size(); i++) {
            if(id==SELLER_DATABASE.get(i).getId()){
                return SELLER_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addSeller(Seller seller) {

        SELLER_DATABASE.add(seller);
        lastId = SELLER_DATABASE.indexOf(seller);
        return true;
    }

    public static boolean removeSeller(int id) {
        for (int i = 0; i < SELLER_DATABASE.size(); i++) {
            if(id==SELLER_DATABASE.get(i).getId()){
                SELLER_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }
}
