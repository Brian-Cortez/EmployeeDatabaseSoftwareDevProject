package employeemanagement;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
public class EmployeeDashboard extends JPanel implements BaseGraphics
{
    public static EmployeeDashboard instance;

    private JButton vpInfoBtn; //View Personal Information Button
    private JButton vPayInfobtn; //View Pay History Button
    private JButton vNewHireReport; //View New Hire Report

    private JPanel fillPanel;

    private GridBagConstraints gbc;

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
        
        setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.NORTHWEST;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 20, 10, 10);

        // View Personal Information
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        vpInfoBtn.setMargin(new Insets(50, 50, 50, 50));
        add(vpInfoBtn, gbc);

        // View Pay History
        gbc.gridx = 0;
        gbc.gridy = 1;
        vPayInfobtn.setMargin(new Insets(50, 50, 50, 50));
        add(vPayInfobtn, gbc);

        // View New Hire Report
        gbc.gridx = 0;
        gbc.gridy = 2;
        vNewHireReport.setMargin(new Insets(50, 50, 50, 50));
        add(vNewHireReport, gbc);


        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        // Empty space pushes buttons to the top-left
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        add(fillPanel, gbc);
    }

    private void InitComponents()
    {
<<<<<<< HEAD
        vpInfoBtn = new JButton("View Personal Info");
        vPayInfobtn = new JButton("View Pay History");
        vNewHireReport = new JButton("View New Hire Report");
=======
        setLayout(new BorderLayout());

        // ---------- buttons ----------
        vpInfoBtn = new JButton("View Personal Information");
        vPayInfobtn = new JButton("View Pay History");
        vNewHireReport = new JButton("View New Hire Report");

        
>>>>>>> origin/main

        fillPanel = new JPanel();
    }
}