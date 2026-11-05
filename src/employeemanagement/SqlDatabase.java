package employeemanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDatabase extends BaseDatabase{
    public static SqlDatabase instance;

    public static SqlDatabase getInstance() 
    {
        if(instance == null) {
            instance = new SqlDatabase();
        }
        
        return instance;
    }

}


