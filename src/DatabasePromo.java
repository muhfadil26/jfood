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

    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public DatabasePromo()
    {
    }

    public static ArrayList<Promo>  getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }
    public static Promo getPromoById(int id) throws PromoNotFoundException
    {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            return promo;
        }
        throw new PromoNotFoundException(id);
    }

    public static Promo getPromoByCode(String code)
    {
        for (Promo promo: PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistException
    {
        // put your code here
        boolean samePromoCode = false;
        for (Promo i: PROMO_DATABASE) {
            if (promo.getCode() == i.getCode()) {
                samePromoCode = true;
            }
        }

        if (!samePromoCode) {
            PROMO_DATABASE.add(promo);
            lastId = PROMO_DATABASE.indexOf(promo);
        }
        throw new PromoCodeAlreadyExistException(promo);
    }

    public static boolean activePromo(int id)
    {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            promo.setActive(true);
            return true;
        }
        return false;
    }
    public static boolean deactivePromo(int id)
    {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            promo.setActive(false);
            return true;
        }
        return false;
    }

    public static boolean removePromo(int id) throws PromoNotFoundException
    {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            PROMO_DATABASE.remove(promo);
            return true;
        }
        throw new PromoNotFoundException(id);
    }


}
