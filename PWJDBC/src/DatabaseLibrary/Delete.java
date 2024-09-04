package DatabaseLibrary;
import java.sql.*;
import java.util.Scanner;
public class Delete {
    public static Connection getJdbcConnection() throws SQLException{
        String url="jdbc:mysql://localhost:3306/library";
        String username="root";
        String password = "Dashore1299@";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void closeResourse(Connection connection, PreparedStatement preparedstatement) throws SQLException{
        if(connection != null)
            connection.close();
        if(preparedstatement != null)
            preparedstatement.close();

    }
    public static void main(String [] args){
        Connection connection = null;
        PreparedStatement preparedstatement = null;

        try {
           connection= getJdbcConnection();
           if(connection != null){
               String q= "delete from book where bookName = ? ;";
               preparedstatement = connection.prepareStatement(q);
               if(preparedstatement != null){
                   preparedstatement.setString(1,"pain");
                   int rowAffected = preparedstatement.executeUpdate();
                   if (rowAffected != 0)
                       System.out.println("deletion successfull");
                   else
                       System.out.println("deletion not successfull");
               }
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                closeResourse(connection, preparedstatement);
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        }

    }

}
