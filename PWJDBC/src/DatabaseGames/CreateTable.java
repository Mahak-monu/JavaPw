package DatabaseGames;

import java.sql.*;

public class CreateTable {
    public static Connection getJdbcConnection()throws SQLException {
        String url="jdbc:mysql://localhost:3306/games";
        String username="root";
        String password="Dashore1299@";

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void closeResourse(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        if(connection!=null)
            connection.close();
        if(preparedStatement!=null)
            preparedStatement.close();
    }
    public static  void main(String [] args)
    {
        Connection connection=null;
       PreparedStatement preparedStatement=null;
       try
        {
            connection = getJdbcConnection();
            if(connection!=null){
                String query="create table cricket (id int primary key, name varchar(20))";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
            }
        }
       catch (SQLException e){
           e.printStackTrace();
       }
       finally {
           try {
               closeResourse(connection, preparedStatement);
           }
           catch (SQLException e) {
               e.printStackTrace();
           }
       }

    }

}
