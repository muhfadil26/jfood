package MuhamadFadil.jfood;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * class DatabaseConnectionPostgre digunakan untuk mengkoneksikan intellij dengan database postgre
 *
 * @author Muhamad Fadil
 * @version 6 Juni 2020
 */

public class DatabaseConnectionPostgre {
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

    /*protected void error_connection (Connection connection) throws Exception{
        connection.close();
    }*/
}
