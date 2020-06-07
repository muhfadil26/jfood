package MuhamadFadil.jfood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * kelas DatabaseCustomerPostgre digunakan untuk melakukan koneksi ke database postgre
 * menggantikan DatabaseCustomer
 *
 * @author Muhamad Fadil
 * @version 6 Juni 2020
 */


public class DatabaseCustomerPostgre extends DatabaseConnectionPostgre{

    /**
     * metode ini digunakan untuk mendapatkan id cutomer terakhir
     *
     * @return
     */
    public static int getLastCustomerId() throws CustomerNotFoundException
    {

        //lastId dimualai dari 0 (default)
        int lastCustomerId = 0;
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "SELECT MAX(id) FROM customer";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                int lastId = rs.getInt("max");
                lastCustomerId = lastId;
            }

            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return lastCustomerId;
    }

    /**
     * metode yang digunakan untuk mendapatkan customer dengan menggunakan Id
     *
     * @param id, variable yang digunakan untuk mendapatkan id customer
     * @return
     */
    public static Customer getCustomer(int id)
    {
        Customer customer = null;
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "SELECT * FROM customer WHERE id =" + id + ";";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                int currentId = rs.getInt("id");
                String currentName = rs.getString("name");
                String currentEmail = rs.getString("email");
                String currentPassword = rs.getString("password");
                Date currentJoinDate = rs.getDate("joinDate");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fixedJoinDate = sdf.parse(String.valueOf(currentJoinDate));
                Calendar cal = Calendar.getInstance();
                cal.setTime(fixedJoinDate);

                Customer tmpCustomer = new Customer(
                        currentId,
                        currentName,
                        currentEmail,
                        currentPassword,
                        cal);

                customer = tmpCustomer;
            }

            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return customer;
    }

    /**
     * metode yang digunakan untuk menambahkan customer
     *
     * @param id, variable yang digunakan untuk mendapatkan id dari customer
     * @param name, variable yang digunakan untuk mendapatkan name customer
     * @param email, variable yang digunakan untuk mendapatkan email dari customer
     * @param password, variable yang digunakan untuk mendaptkan password dari customer
     */
    public static Customer insertCustomer(int id, String name, String email, String password) throws EmailAlreadyExistException
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(date);
        Connection c = DatabaseConnectionPostgre.connection();

        try
        {
            Statement stmt = c.createStatement();
            String query = "INSERT INTO customer (id, name, email, password, joinDate)"
                    + "VALUES (" + id + ",'" + name + "','"+ email + "','"+ password + "','" + date1 + "');";

            stmt.executeUpdate(query);
            stmt.close();
            c.close();
            return new Customer(id, name, email, password);
        }
        catch (SQLException e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    /**
     * metode yang digunakan untuk menghapus customer berdasarkan idnya
     *
     * @param id, variable yang digunakan untuk mendaptkan id customer
     * @return
     */
    public static void removeCustomer(int id) throws CustomerNotFoundException
    {
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "DELETE FROM customer WHERE id =" + id + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
            System.out.println("deleted customer with id: " + id );
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * metode yang digunakan untuk login dengan menggunakan email dan password
     *
     * @param email, variable yang digunakan untuk mendapatkan email
     * @param password, variable yang digunakan untuk mendaptkan password
     * @return null
     */
    public static Customer getLogin(String email, String password)
    {
        String checkPassword = "";
        Customer customer = null;
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "SELECT * FROM customer WHERE email = '" + email + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                int currentId = rs.getInt("id");
                String currentName = rs.getString("name");
                String currentEmail = rs.getString("email");
                String currentPassword = rs.getString("password");
                Date currentJoinDate = rs.getDate("joinDate");
                checkPassword = currentPassword;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fixedJoinDate = sdf.parse(String.valueOf(currentJoinDate));
                Calendar cal = Calendar.getInstance();
                cal.setTime(fixedJoinDate);

                Customer tmpCustomer = new Customer(
                        currentId,
                        currentName,
                        currentEmail,
                        currentPassword,
                        cal);

                customer = tmpCustomer;
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        if(password.equals(checkPassword))
        {
            return customer;
        }

        return null;
    }

    /**
     * metode yang digunakan untuk koneksi
     *
     * @return
     */
    public static Connection connection() {
        return null;
    }

}
