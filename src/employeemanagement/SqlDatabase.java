package employeemanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class SqlDatabase {
    public static SqlDatabase instance;

    private final String user = "avnadmin";
    private final String sqlPassword = System.getenv("DB_PASSWORD");
    private final String url = "jdbc:mysql://sqlprojects-sqlprojects.g.aivencloud.com:25293/employeeData2";

    protected String empID;
    protected char[] empPassword;

    public static SqlDatabase getInstance() 
    {
        if(instance == null) {
            instance = new SqlDatabase();
        }
        
        return instance;
    }

    protected void ConnectToSql(String id, char[] password)
    {   
        //! SQL Command
        String sqlCredencialsCommand = "SELECT e.empID, e.empPassword FROM employees e;";

        //!Testing out the connection
        try (Connection myConn0 = DriverManager.getConnection(url, user, sqlPassword)) {
            System.out.println("Connected Successfully!");

            //Create a connection statment
            Statement myStmt = myConn0.createStatement();

            //Execute SQL Command 
            ResultSet result = myStmt.executeQuery(sqlCredencialsCommand);
            
            //Loop through the result from the SQL command
            while(result.next())
            {   
                //Compare the ID and Password from the database
                if(id.equals(result.getString("e.empID")) &&
                   String.valueOf(password).equals(result.getString("e.empPassword")))
                {
                    empID = id;
                    empPassword = password;
                    System.out.println("Successfully Stored ID and Password " + String.valueOf(empPassword) + empID);
                    break;
                }
                else if(result.isLast())
                {
                    System.out.println("Incorrect ID or Password Please Try Again!");
                    myConn0.close();
                    break;
                }
                
                System.out.println(result.getString("e.empID") + " " + result.getString("e.empPassword"));

            }
            
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


