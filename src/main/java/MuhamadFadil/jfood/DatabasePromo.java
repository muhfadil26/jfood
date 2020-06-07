package MuhamadFadil.jfood;
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

    /**
     * konstraktor yang digunakan untuk database promo
     */
    public DatabasePromo()
    {
        //isi dari database promo
    }

    /**
     * metode yang digunakan untuk mendapatkan list dari dari database promo
     * @return
     */
    public static ArrayList<Promo>  getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    /**
     * metode yang digunakan untuk mendapatkan id terakhir
     *
     * @return
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * metode yang digunakan untuk mendapatkan promo berdasarkan idnya
     *
     * @param id, digunakan untuk id promo
     * @return
     * @throws PromoNotFoundException, mengecek ada tidaknya promo berdasakan idnya
     */
    public static Promo getPromoById(int id) throws PromoNotFoundException {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                return promo;
            }
        }
            throw new PromoNotFoundException(id);
    }

    /**
     * metodeyang digunakan untuk mendapatkan promo berdasarkan codenya
     *
     * @param code, digunakan untuk mendapatkan code promo berupa string
     * @return
     */
    public static Promo getPromoByCode(String code)
    {
        for (Promo promo: PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    /**
     * metode yang digunakan untuk menambahkan promo
     *
     * @param promo, digunakan untuk terhubung ke class promo
     * @return
     * @throws PromoCodeAlreadyExistException, mengecek apakah promo sudah ada atau tidak
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistException
    {
        // put your code here
        boolean samePromoCode = false;
        for (Promo i: PROMO_DATABASE) {
            if (promo.getCode().equals(i.getCode())) {
                samePromoCode = true;
                break;
            }
        }

        if (!samePromoCode) {
            PROMO_DATABASE.add(promo);
            lastId = promo.getId();
            return true;
        }
        throw new PromoCodeAlreadyExistException(promo);

    }


    /**
     * metode yang digunakan untuk mengaktifkan promo
     *
     * @param id, id dari promo bertipe integer
     * @return
     */
    public static boolean activePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * metode yang digunakan untuk menonaktifkan promo
     *
     * @param id, digunakan untuk id promo
     * @return
     */
    public static boolean deactivePromo(int id)
    {
        Promo promo = PROMO_DATABASE.get(id);
        if (promo != null) {
            promo.setActive(false);
            return true;
        }
        return false;
    }

    /**
     * metode yang digunakan untuk menghapus promo
     *
     * @param id, digunakan untuk id promo
     * @return
     * @throws PromoNotFoundException, mengecek ada tidaknya promo
     */
    public static boolean removePromo(int id) throws PromoNotFoundException
    {
        for (Promo promo: PROMO_DATABASE) {
            if (promo.getId() == id) {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }

}
