package DatabaseLibrary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Createstatement {
    public static Connection getJdbcConnection() throws SQLException{
        String url="jdbc:mysql://localhost:3306/library";
        String username="root";
        String password = "Dashore1299@";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void closeResourse (Connection connection , Statement statement )throws SQLException{
        if(connection != null)
            connection.close();
        if(statement != null)
            statement.close();

    }
    public static void main(String [] args) {
        Connection connection = null;
        Statement statement  = null;
        try {
            connection = getJdbcConnection();

            if (connection != null) {

             statement =  connection.createStatement();
             String query = "insert into book (id, bookName , writer, rating , price)  values (1002,'Dragon', 'john casey','B',2500 ),(1003,'Shopkeeper','adom musk','A',10000);";
             int rowAffected = statement.executeUpdate(query);
             System.out.println("number of rows affected : "+rowAffected);
             if(rowAffected != 0){
                 System.out.println("row inserted successfully");
             }
             else{
                 System.out.println("row not inserted");
             }

            }
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        finally{
            try {
                closeResourse(connection, statement);
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        }

    }



}
