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

    /**
     * konstraktor yang digunakan untuk database seller
     */
    public DatabaseSeller(){

    }

    /**
     * metode yang digunakan untuk mendapatkan seller database berupa array
     * @return
     */
    public static ArrayList<Seller> getSellerDatabase(){
        return SELLER_DATABASE;
    }

    /**
     * metode yang digunakan mendapatkan id terakhir
     * @return
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * metode yang digunakan untuk mendaptkan seller berdasarkan idnya
     *
     * @param id, digunakan untuk id seller
     * @return
     * @throws SellerNotFoundException, mengecek ada tidaknya seller
     */
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

    /**
     * metode yang digunakan untuk menambahkan seller
     *
     * @param seller, digunakan untuk mengkoneksikan ke class seller
     * @return
     */
    public static boolean addSeller(Seller seller)
    {
        //SELLER_DATABASE.add(seller);
        //lastId = seller.getId();
        //return true;
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    /**
     * metode yang digunakan untuk menghapus seller
     *
     * @param id, digunakan untuk id seller
     * @return
     * @throws SellerNotFoundException, mengecek ada tidaknya seller
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException{
        Seller seller = SELLER_DATABASE.get(id);
        if (seller != null) {
            SELLER_DATABASE.remove(seller);
            return true;
        }
        throw new SellerNotFoundException(id);
    }
}
