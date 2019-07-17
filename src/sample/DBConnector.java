package sample;

import java.sql.*;

class DBConnector {
     // DB SETTINGS FOR POSTGRESQL
     private final static String db_driver = "org.postgresql.Driver";
     private final static String db_url = "jdbc:postgresql://localhost:5432/postgres";
     private final static String db_owner = "postgres";
     private final static String db_pass = "77997799";
     private final static String db_sqlite_url = "jdbc:sqlite:D:/chess.db";


     private static Connection connection = null;


     public static Connection getConnection(){
         if (connection == null) {
             try {
                 Class.forName(db_driver);
//                 connection = DriverManager.getConnection(db_url,db_owner,db_pass);
                 connection = DriverManager.getConnection(db_sqlite_url);
                 System.out.println("Connection is Created !");
             } catch (Exception e) {
                 e.printStackTrace();
                 System.out.println("error connection is failed!");
             }

         }
         return connection;
     }

     public static void createDB() throws SQLException {
         Connection conn = getConnection();
         Statement st = conn.createStatement();
         st.executeUpdate("CREATE TABLE page (id INTEGER PRIMARY KEY AUTOINCREMENT, userid varchar, passid varchar);");
         st.executeUpdate("INSERT INTO page (userid, passid) VALUES ('farbod', '123')");
         conn.commit();
     }

    public static void query() throws SQLException {
         Connection conn = getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM page");
         while(rs.next())
         {
             // read the result set
             System.out.println("name = " + rs.getString("userid"));
             System.out.println("pass = " + rs.getString("passid"));
         }
     }

    /*public static boolean isLogin(String u, String p) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM page WHERE userid=? and passid=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,u);
            preparedStatement.setString(2,p);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }else
            {
                return false;
            }
        }catch (Exception e){
            return false;
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }*/

   public static void main(String[] args) throws SQLException {
      //createDB();
        query();
   }

}
