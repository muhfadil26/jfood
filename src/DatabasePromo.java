import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * this class is used for databasepromo class
 *
 * @author Muhamad Fadil
 * @version 13 Maret 2020
 */
public class DatabasePromo
{
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static boolean addPromo(Promo promo) {

        boolean samePromoCode = false;
        for (Promo buff: PROMO_DATABASE) {
            if (promo.getCode() == buff.getCode()) {
                samePromoCode = true;
            }
        }

        if (!samePromoCode) {
            PROMO_DATABASE.add(promo);
            lastId = PROMO_DATABASE.indexOf(promo);
        }
        return false;
    }

    public boolean removePromo (int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            PROMO_DATABASE.remove(promo);
            return true;
        }
        return false;
    }

    public static boolean activatePromo(int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            //promo.setActive(true);
            return true;
        }
        return false;
    }

    public static boolean deactivatePromo(int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            //promo.setActive(false);
            return true;
        }
        return false;
    }

    public static Promo getPromoByCode(String code) {
        for (Promo promo: PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    public static Promo getPromoById(int id) {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            return promo;
        }
        return null;
    }

    public static ArrayList<Promo> getPromoDatabase() {
        return PROMO_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public DatabasePromo()
    {
        // initialise instance variables

    }

}
