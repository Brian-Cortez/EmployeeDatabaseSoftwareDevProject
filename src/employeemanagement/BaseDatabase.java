package employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class BaseDatabase {
    protected final String user = "avnadmin";
    protected final String sqlPassword = System.getenv("DB_PASSWORD");
    protected final String url = "jdbc:mysql://sqlprojects-sqlprojects.g.aivencloud.com:25293/employeeData2";

    protected String empID;
    protected char[] empPassword;
    
    protected ResultSet ExecuteSqlCommand(String command)
    {
    
        try (Connection myConn0 = DriverManager.getConnection(url, user, sqlPassword)) {
            System.out.println("Connected Successfully!");

            //Create a connection statment
            Statement myStmt = myConn0.createStatement();

            //Execute SQL Command 
            ResultSet result = myStmt.executeQuery(command);
            
            myConn0.close();
            return result;
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } 
        finally 
        {

        }
        return null;
    }
}
