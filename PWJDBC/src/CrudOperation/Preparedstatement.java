package CrudOperation;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class Preparedstatement {
    public static Connection getJdbcConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/EMPdatabase";
        String username="root";
        String password="Dashore1299@";
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
    public static void closeResourse(Connection connection, PreparedStatement preparedstatement) throws SQLException {
        if(connection!=null)
            connection.close();
        if(preparedstatement!=null)
            preparedstatement.close();
    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedstatement=null;

        try {
            connection = getJdbcConnection();
            if(connection!=null){
                String query="insert into student (rollno, name, marks, grade, city) values(?,?,?,?,?);";
                preparedstatement=connection.prepareStatement(query);
                if(preparedstatement!=null){
                    preparedstatement.setInt(1,106);
                    preparedstatement.setString(2,"sumit");
                    preparedstatement.setInt(3,45);
                    preparedstatement.setString(4,"D");
                    preparedstatement.setString(5,"Bhopal");

                    int rowEffected = preparedstatement.executeUpdate();

                    if(rowEffected==1)
                        System.out.println("row inserted successfully");
                    else
                        System.out.println("row not inserted");

                }
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                closeResourse(connection, preparedstatement);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }




    }
}
