package DatabaseMySchool;


import java.sql.Connection;

// create statement
public class CreateTable {
    public static Connection getJdbcConnection(){
        String url = "jdbc:mysql://localhost:3306/My";
         Connection connetion= null;
         return connetion;
    }
    public static void main(String[] args) {

    }

}
