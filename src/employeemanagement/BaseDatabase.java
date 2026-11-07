package employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatabase{
    protected final String user = "avnadmin";
    protected final String sqlPassword = System.getenv("DB_PASSWORD");
    protected final String url = "jdbc:mysql://sqlprojects-sqlprojects.g.aivencloud.com:25293/employeeData2";

    protected String empID;
    protected char[] empPassword;

    protected Statement myStmt;
    protected ResultSet result;

    private SqlCommand commandDelegate;
    
    protected void ExecuteSqlCommand(String command)
    {
    
        try (Connection myConn0 = DriverManager.getConnection(url, user, sqlPassword)) {
            System.out.println("Connected Successfully!");

            //Create a connection statment
            myStmt = myConn0.createStatement();

            //Execute SQL Command 
            result = myStmt.executeQuery(command);

            commandDelegate.Execute();

            myConn0.close();
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } 
        finally 
        {

        }
    }
    public void SetCommandDelegate(SqlCommand commandDelegate)
    {
        this.commandDelegate = commandDelegate;
    }
    
}
