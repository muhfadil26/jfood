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
    private static ArrayList<Promo> PROMO_DATABASE =  new ArrayList<Promo>(0);
    private static int lastId=0;

    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Promo getPromoById(int id)
    {
        for (int i = 0; i < PROMO_DATABASE.size(); i++) {
            if(id==PROMO_DATABASE.get(i).getId()){
                return PROMO_DATABASE.get(i);
            }
        }
        return null;
    }

    public static Promo getPromoByCode(String code)
    {
        for (int i = 0; i < PROMO_DATABASE.size(); i++) {
            if(code==PROMO_DATABASE.get(i).getCode()){
                return PROMO_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo)
    {
        if( PROMO_DATABASE.size()>0)
        {
            boolean existingCode=false;
            for (int i = 0; i < PROMO_DATABASE.size(); i++) {
                if(promo.getCode()==PROMO_DATABASE.get(i).getCode()){
                    existingCode=true;
                }
            }

            if(!existingCode){
                PROMO_DATABASE.add(promo);
                lastId=promo.getId();
                return true;
            }
            else return false;
        }
        else
        {
            PROMO_DATABASE.add(promo);
            lastId=promo.getId();
            return true;
        }
    }

    public static boolean activatePromo(int id)
    {
        for (int i = 0; i < PROMO_DATABASE.size(); i++) {
            if(id==PROMO_DATABASE.get(i).getId()){
                //PROMO_DATABASE.get(i).setActive(true);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivatePromo(int id)
    {
        for (int i = 0; i < PROMO_DATABASE.size(); i++) {
            if(id==PROMO_DATABASE.get(i).getId()){
               // PROMO_DATABASE.get(i).setActive(false);
                return true;
            }
        }
        return false;
    }

    public static boolean removePromo(int id)
    {
        for (int i = 0; i < PROMO_DATABASE.size(); i++) {
            if(id==PROMO_DATABASE.get(i).getId()){
                PROMO_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

}
