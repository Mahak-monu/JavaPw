package CrudOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;


public class Read {
    public static Connection getJdbcConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/EMPdatabase";
        String username="root";
        String password="Dashore1299@";
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
    public static void closeResourse(Connection connection, PreparedStatement preparedstatement, ResultSet resultset) throws SQLException {
        if(connection!=null)
            connection.close();
        if(preparedstatement!=null)
            preparedstatement.close();
        if(resultset!=null)
            resultset.close();
    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedstatement=null;
        ResultSet resultset=null;
        Scanner sc=new Scanner(System.in);


        try {
            connection = getJdbcConnection();
            if(connection!=null){
                String query="select * from student ;";
                preparedstatement=connection.prepareStatement(query);
                if(preparedstatement!=null){
                 //   System.out.println("enter rollno : ");
//                    int rollno=sc.nextInt();
//                    sc.close();
//                    preparedstatement.setInt(1,rollno);
                   resultset =  preparedstatement.executeQuery();
                   if(resultset !=null) {
                       System.out.println("rollno\tname\tmarks\tgrade\tcity");

//                       if(resultset.next())
                       while (resultset.next())
                            System.out.println(resultset.getInt("rollno") + "\t    " + resultset.getString("name") + "\t " + resultset.getInt("marks") + "\t     " + resultset.getString("grade") + "\t     " + resultset.getString("city"));


                   }

                }
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                closeResourse(connection, preparedstatement,resultset);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }




    }
}
