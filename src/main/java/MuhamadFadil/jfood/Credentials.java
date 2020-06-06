package MuhamadFadil.jfood;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Credentials {
    public static Connection connection(){
        Connection c = null;
        /*try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jfood", "postgres", "1998");
            System.out.println("Opened database successfully");
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }*/
        return c;
    }
}
