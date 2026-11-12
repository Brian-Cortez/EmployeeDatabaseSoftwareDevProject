package employeemanagement;
import javax.swing.*;
import java.awt.*;
public class ScreenManager 
{

    public static ScreenManager instance;

    private LoginGUI loginGui;
    private EmployeeDashboard empDashboard;
    private JFrame windowFrame;
    private JPanel guiPanel;


    private final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
    // x, y, width, height
    private final Rectangle WINDOWSIZE = new Rectangle(0, 0, SCREENSIZE.width, SCREENSIZE.height);

    public ScreenManager(JPanel panel)
    {   
        guiPanel = panel;
        InitializeWindow();
    }
    
    public static ScreenManager getInstance()
    {
        if(instance == null)
        {
            instance = new ScreenManager(new LoginGUI());
        }

        return instance;
    }

    public void InitializeWindow()
    {
        windowFrame = new JFrame("Employee Login");

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        windowFrame.setBounds(WINDOWSIZE);

        windowFrame.setLocationRelativeTo(null);

        windowFrame.setVisible(true);

        windowFrame.add(guiPanel);
    }

    public void setPanel(JPanel panel)
    {
        //removes the old panel
        windowFrame.remove(guiPanel);

        guiPanel = panel;

        //Adds the new panel
        windowFrame.add(panel);

        windowFrame.revalidate();
        windowFrame.repaint();
    }
}
