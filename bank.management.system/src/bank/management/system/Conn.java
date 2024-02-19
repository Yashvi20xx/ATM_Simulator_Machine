package bank.management.system;
import java.sql.*;

public class Conn
{
    Connection c;
    Statement s;
    public Conn()
    {
        try 
        {
            //Class.forName(com.mysql.c.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Gamer@5507");
            s=c.createStatement();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
