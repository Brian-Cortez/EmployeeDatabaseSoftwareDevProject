package employeemanagement;
public class EmployeeDashboard
{
    public static EmployeeDashboard instance;

    public static EmployeeDashboard getInstance()
    {
        if(instance == null)
        {
            instance = new EmployeeDashboard();
        }
        return instance;
    }
    
}