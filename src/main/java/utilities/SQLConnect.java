package utilities;

import java.sql.*;

public class SQLConnect {
    public static Connection connect() throws SQLException {
        Connection conn = null;
        // db parameters
        String url = "jdbc:sqlite:C:\\Users\\ingri\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
        // create a connection to the database
        return DriverManager.getConnection(url);
    }


    public static void main(String[] args) throws SQLException {
        //speciaala sintakse
        Connection connection = connect();
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM Artist");
//
//        while (rs.next()) {
//            //Display values
//            System.out.print("ID: " + rs.getInt("ArtistId"));
//            System.out.print(", Name: " + rs.getString("Name"));
//            System.out.println("\n");
//        }
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT *\n" +
                "FROM Customer c \n" +
                "ORDER BY CustomerId  DESC \n" +
                "LIMIT 1;");

        while (rs.next()) {
            //Display values
            System.out.print("CustomerID: " + rs.getInt("CustomerId"));
            System.out.print(", Name: " + rs.getString("FirstName"));
            System.out.print(", Surname: " + rs.getString("LastName"));
            System.out.println("\n");
        }

    }
    }
