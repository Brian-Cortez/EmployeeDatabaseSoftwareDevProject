package employeemanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlDatabase {
    public static SqlDatabase instance;

    private final String user = "avnadmin";
    private final String sqlPassword = System.getenv("DB_PASSWORD");
    private final String url = "jdbc:mysql://sqlprojects-sqlprojects.g.aivencloud.com:25293/employeeData2";


     public static SqlDatabase getInstance() {
        if(instance == null) {
            instance = new SqlDatabase();
        }
        
        return instance;
    }

    protected void ConnectToSql(String id, char[] password)
    {   
        String sqlCredencialsCommand = "SELECT e.empID, e.empPassword " +
                "FROM employees e ; ";
        try (Connection myConn0 = DriverManager.getConnection(url, user, sqlPassword)) {
            System.out.println("Connected Successfully!");

            Statement myStmt = myConn0.createStatement();

            ResultSet stm = myStmt.executeQuery(sqlCredencialsCommand);
            
            while(stm.next())
            {
                if(!id.equals(stm.getString("e.empID")) || 
                   !String.valueOf(password).equals(stm.getString("e.empPassword")))
                {
                    System.out.println("Incorrect ID or Password Please Try Again!");
                    myConn0.close();
                    break;
                }
                System.out.println(stm.getString("e.empID") + stm.getString("e.empPassword"));
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
}


