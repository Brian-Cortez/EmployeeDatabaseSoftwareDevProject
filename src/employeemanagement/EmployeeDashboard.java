package employeemanagement;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmployeeDashboard extends JPanel implements BaseGraphics
{
    public static EmployeeDashboard instance;

    private JButton vpInfoBtn; //View Personal Information Button
    private JButton vPayInfobtn; //View Pay History Button
    private JButton vNewHireReport; //View New Hire Report

    public EmployeeDashboard() 
    {
        ShowGraphics();
    }
    public static EmployeeDashboard getInstance()
    {
        if(instance == null)
        {
            instance = new EmployeeDashboard();
        }
        return instance;
    }

    @Override
    public void ShowGraphics() {
        InitComponents();
    }
    private void InitComponents()
    {
        

    }
}