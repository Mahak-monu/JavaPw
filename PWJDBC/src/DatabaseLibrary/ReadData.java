package DatabaseLibrary;
import java.sql.*;
public class ReadData {
    public static Connection getJdbcConnection() throws SQLException{
        String url="jdbc:mysql://localhost:3306/library";
        String username="root";
        String password = "Dashore1299@";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void closeResourse(Connection connection, PreparedStatement preparedstatement, ResultSet resultset) throws SQLException{
        if(connection != null)
            connection.close();
        if(preparedstatement != null)
            preparedstatement.close();
        if(resultset != null)
            resultset.close();

    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet rs = null;
        try {
            connection = getJdbcConnection();
            if(connection != null){
                String q="select * from book ;";
               preparedstatement =  connection.prepareStatement(q);
               if(preparedstatement != null) {
                   rs = preparedstatement.executeQuery();
                   if(rs != null){
                       System.out.println("id     bookName            writer                   rating          price ");
                       while(rs.next()){
                           System.out.println(rs.getInt("id")+"\t"+rs.getString("bookName")+"\t        "+rs.getString("writer")+"\t           "+rs.getString("rating")+"\t    "+rs.getInt("price"));
                       }
                   }
               }
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                closeResourse(connection, preparedstatement, rs);
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

}
