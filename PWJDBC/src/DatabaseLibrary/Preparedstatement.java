package DatabaseLibrary;
import java.sql.*;
import java.util.Scanner;
public class Preparedstatement {
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
          connection=  getJdbcConnection() ;
            if(connection != null){
                String query = "Insert into book (id, bookName, writer, rating  , price) values (?,?,?,?,?);";
                preparedstatement = connection.prepareStatement(query);
                if(preparedstatement != null) {
                    preparedstatement.setInt(1, 3002);
                    preparedstatement.setString(2, "Happiness");
                    preparedstatement.setString(3, "Jack Harry ");
                    preparedstatement.setString(4, "B");
                    preparedstatement.setInt(5, 5500);
                    int rowAffected = preparedstatement.executeUpdate();
                    if (rowAffected != 0)
                        System.out.println("insertion successfull");
                    else
                        System.out.println("insertion not successfull");
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
