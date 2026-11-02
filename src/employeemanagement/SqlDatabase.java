package employeemanagement;


import java.sql.Connection;
import java.sql.DriverManager;

public class SqlDatabase {
    public static SqlDatabase instance;

    private final String user = "avnadmin";
    private final String sqlPassword = System.getenv("DB_PASSWORD");
    private final String url = "jdbc:mysql://sqlprojects-sqlprojects.g.aivencloud.com:25293/";


     public static SqlDatabase getInstance() {
        if(instance == null) {
            instance = new SqlDatabase();
        }
        
        return instance;
    }
    protected void ConnectToSql()
    {
        try (Connection myConn0 = DriverManager.getConnection(url, user, sqlPassword)) {
            System.out.println("Connected Successfully!");
            
                 
            
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


