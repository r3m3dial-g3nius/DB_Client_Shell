package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbc_URL = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER";  // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver";    // Driver reference
    private static final String userName = "sqlUser";                   // Username
    private static final String password = "Passw0rd!";                 // Password
    public static Connection connection;                                // Connection Interface

    public static void openConnection()
    {
        try
        {
            Class.forName(driver); // Locate Driver
            connection = DriverManager.getConnection(jdbc_URL, userName, password); // Reference Connection object
            System.out.println("Connection successful!");
        }

        catch(SQLException | ClassNotFoundException e)
        {
            // System.out.println("Error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }

    public static void closeConnection()
    {
        try
        {
            connection.close();
            System.out.println("Connection closed!");
        }
        catch(Exception e)
        {
            // do nothing!
            // System.out.println("Error:" + e.getMessage());
        }
    }
}
