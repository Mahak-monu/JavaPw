package CrudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Delete {
    public static Connection getJdbcConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/EMPdatabase";
        String username="root";
        String password="Dashore1299@";
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
    public static void closeResourse(Connection connection, java.sql.PreparedStatement preparedstatement) throws SQLException {
        if(connection!=null)
            connection.close();
        if(preparedstatement!=null)
            preparedstatement.close();
    }

    public static void main(String[] args) {
        Connection connection = null;

        PreparedStatement preparedstatement=null;
        Scanner sc=new Scanner(System.in);

        try {
            connection = getJdbcConnection();
            if(connection!=null){
                String query="delete from student where city = ? ";
                preparedstatement=connection.prepareStatement(query);
                if(preparedstatement!=null){
                    System.out.println("enter the city to delete  : ");
                    String city = sc.next();
                    preparedstatement.setString(1,city);

                    int rowEffected = preparedstatement.executeUpdate();

                    if(rowEffected!=0)
                        System.out.println(" deletion successfull ");
                    else
                        System.out.println(" deletion not successfull ");

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

