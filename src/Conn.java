import java.sql.*;



public class Conn 
{
    Connection  con;
    Statement s;
    Conn()
    {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","pa$$word");
            s = con.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
    
}
