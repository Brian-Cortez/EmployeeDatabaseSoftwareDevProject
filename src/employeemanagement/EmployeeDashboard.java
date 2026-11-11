package employeemanagement;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmployeeDashboard extends JPanel implements BaseGraphics
{
    public static EmployeeDashboard instance;
    private JButton btn;
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
        add(btn);
    }
    private void InitComponents()
    {
        btn = new JButton("Click me!");
    }
}