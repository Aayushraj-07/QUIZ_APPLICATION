package quiz;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Database {
    Connection c;
    Statement s;
    
    public Database () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // System.out.println("Driver loaded Successfully");
            
            String user = "root";
            String password = "Mysql@123";
            String url = "jdbc:mysql://localhost:3306/Quiz_Application";
            c = DriverManager.getConnection(url,user,password);
            s = c.createStatement();
           // System.out.println("Statement created");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new Database();
    }
    
    
}
