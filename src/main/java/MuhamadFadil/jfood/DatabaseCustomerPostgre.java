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
 *
 * @author Muhamad Fadil
 * @version 6 Juni 2020
 */


public class DatabaseCustomerPostgre extends DatabaseConnectionPostgre{
    /**
     * this method is to insert a customer to Postgres Database
     * @param id is the customer's id
     * @param name is the customer's name
     * @param email is the customer's email
     * @param password is the customer's password
     */
    public static Customer insertCustomer(int id, String name, String email, String password)
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
     * this method is to return the last customer's id
     * @return an integer of the last customer added to customer database
     */
    public static int getLastCustomerId()
    {

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
     * this method is to return a Customer class object by it's id
     * @param id is the id of the expected customer that this method returns
     * @return a Customer object in respect to the id in the parameter id
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
     * this method is to remove the specified customer from the database
     * @param id is the customer's id to point to the customer that wanted to be removed
     * @return a boolean, true if the customer is succeeded to be removed from the database, otherwise false
     */
    public static void removeCustomer(int id)
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
     * this method is check if the email and the password match for any customer
     * @param email is the customer's email that wanted to be match to the password
     * @param password is the customer's password for the email in this method's parameter
     * @return a Customer Class object that represented by the email in the email parameter only if the password match, otherwise return null
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

    public static Connection connection() {
        return null;
    }

}
