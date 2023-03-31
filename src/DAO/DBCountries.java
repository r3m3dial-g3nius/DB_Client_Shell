package DAO;

import Helper.DBConnection;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class DBCountries {

    public static ObservableList<User> getAllCountries()
    {
        ObservableList<User> countryList = FXCollections.observableArrayList();    // here is where you left off
        try
        {
            String sql = "SELECT * FROM countries";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int countryId = rs.getInt("Country_ID");
                String countryName = rs.getString("Country");
                User c = new User(countryId, countryName);
                countryList.add(c);
            }
        }

        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return countryList;
    }

    public static User getCountry(int countryID)
    {
        try
        {
            System.out.println("Getting Country...");
            String sql = "SELECT * FROM countries WHERE Country_ID = " + countryID;
            String countryName = "";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                countryName = rs.getString("Country");
            }

            User c = new User(countryID, countryName);

            return c;
        }

        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void checkDateConversions()
    {
        System.out.println("Date test");
        String sql = "SELECT Create_Date FROM countries";
        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Timestamp ts = rs.getTimestamp("Create_Date");
                System.out.println("CD: " + ts.toLocalDateTime().toString());
            }
        }

        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}

