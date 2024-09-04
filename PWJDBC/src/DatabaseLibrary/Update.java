package DatabaseLibrary;
import java.sql.*;
public class Update {
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
            connection = getJdbcConnection();
            if(connection != null){
                String q= "update book set price = ? where writer = ? ;";
                preparedstatement = connection.prepareStatement(q);
                if(preparedstatement != null) {
                    preparedstatement.setInt(1, 20000);
                    preparedstatement.setString(2, "mahak");
                    int row = preparedstatement.executeUpdate();
                    if (row != 0) {
                        System.out.println("updation successfull");
                    } else
                        System.out.println("updation unsuccessfull");
                }

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                closeResourse(connection, preparedstatement);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
