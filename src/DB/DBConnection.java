package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
  private static Connection conn;

  public static Connection getConnection() throws SQLException{
      String dbName = "web-scraper";
      String url    = "jdbc:mysql://localhost:3306/" + dbName;
      String userName = "root";
      String password = "";

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(url, userName, password);
          
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }


        return conn;
  }
  
}
