import java.sql.*;

public class StudentDB {
    public void studentCreat(String id) {
        Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
    
          stmt = c.createStatement();
          String sql = "CREATE TABLE COMPANY " + "(ID INT PRIMARY KEY     NOT NULL)";
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        } catch (Exception e) {
          System.err.println(e.getClass().getName() + ": " + e.getMessage());
          System.exit(0);
        }
        System.out.println("Table created successfully");
      }
      
      public boolean judgeAccount(String id, String password) {
        Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:SRS.db");
          c.setAutoCommit(false);
    
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT;");
          while (rs.next()) {
            if (rs.getString("id").equals(id)) {
              if (password.equals(rs.getString("password"))) {
                return true;
              } else {
                return false;
              }
            }
          }
          rs.close();
          stmt.close();
          c.close();
        } catch (Exception e) {
          System.err.println(e.getClass().getName() + ": " + e.getMessage());
          System.exit(0);
        } finally {
          try {
            stmt.close();
            c.close();
          } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
          }
        }
        return false;
      }
}