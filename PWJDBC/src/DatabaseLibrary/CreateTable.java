package DatabaseLibrary;
import java.sql.*;
import java.util.Scanner;
public class CreateTable {
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
        //can also create table by create statement like this

        try {
            connection=  getJdbcConnection() ;
            if(connection != null){
                String query = "create table test (rollno int primary key, name varchar(20))";  // drop table query also run
                    preparedstatement = connection.prepareStatement(query);

                   preparedstatement.executeUpdate();



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
