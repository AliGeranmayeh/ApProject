package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    public static void Insert(Storage storage) {

        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into page(userid, passid) values(?,?)");

            ps.setString(1, storage.getUserName());
            ps.setString(2, storage.getPassword());

            ps.execute();
            System.out.println("Inserted!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error do not inserted!");
        }
    }

    public static List<Storage> getAllStorage(){
        List<Storage> storages = new ArrayList<Storage>();

        try {
            // PreparedStatement ps = DBConnector.getConnection().prepareStatement("insert into public.page(username,password"
            // + " values("+storage.getUserName()+","+storage.getPassword()+")");

            Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from page");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Storage result = new Storage();
                //result.setId(rs.getInt("id"));
                result.setUserName(rs.getString("userid"));
                result.setPassword(rs.getString("passid"));
                storages.add(result);
            }

            //ps.execute();
            rs.close();
            ps.close();
            System.out.println("Read from DB!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error !");
        }

        return storages;
    }


    public static boolean isLogin(String u, String p) throws SQLException {
        Connection conn = DBConnector.getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM page WHERE userid=? and passid=?";

        try {
            preparedStatement = conn.prepareStatement(query);
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

    }
   public static void Update(Storage storage) {

        try {

            Connection conn = DBConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement("update page set userid=? , passid=?");

            ps.setString(1, storage.getUserName());
            ps.setString(2, storage.getPassword());

            ps.execute();
            System.out.println("Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error do not updated!");
        }
    }

}
