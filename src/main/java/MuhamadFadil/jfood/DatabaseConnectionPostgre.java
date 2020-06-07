package MuhamadFadil.jfood;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * class DatabaseConnectionPostgre digunakan untuk mengkoneksikan intellij dengan database postgre
 * alamat database:
 * alamat: localhost
 * port: 5432
 * nama database: jfood
 * username: postgres
 * password: 1998
 *
 * @author Muhamad Fadil
 * @version 6 Juni 2020
 */

public class DatabaseConnectionPostgre {
    /**
     * metode yang digunakan untuk mengkoneksikan
     *
     * @return c
     */
    public static Connection connection(){
        Connection c = null;
        try{

            //mencocokan database
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jfood", "postgres", "1998");
            System.out.println("Opened database successfully");
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }

}
