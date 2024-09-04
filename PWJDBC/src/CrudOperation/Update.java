package CrudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Update {
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
        Scanner sc=new Scanner(System.in);

        try {
            connection = getJdbcConnection();
            if(connection!=null){
                String query="update student set marks= ? where name =  ? ";
                preparedstatement=connection.prepareStatement(query);
                if(preparedstatement!=null){
                    System.out.println("enter name whose record you want to update : ");
                    String name=sc.next();
                    System.out.println("enter the updated marks : ");
                    int marks=sc.nextInt();
                    preparedstatement.setInt(1,marks);
                    preparedstatement.setString(2,name);

                    int rowEffected = preparedstatement.executeUpdate();

                    if(rowEffected!=0)
                        System.out.println("your database is updated");
                    else
                        System.out.println("your database is not updated ");

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
