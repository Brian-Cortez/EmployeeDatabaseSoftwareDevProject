package employeemanagement;


import java.awt.*;
import javax.swing.*;
public final class LoginGUI
{
    private JFrame windowFrame;
    private JPanel loginPanel;
    protected  JTextField textField;
    protected  JPasswordField passwordField;
    private JLabel employeeLabel;
    protected JLabel errorOutputLabel;
    private JButton submitButton;
    private GridBagConstraints gbc; //adds a layout to the panel
    private LoginError loginError;
    
    //Credentials
    protected  String empID = "";
    protected  char[] empPassword;

    private final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
    // x, y, width, height
    private final Rectangle WINDOWSIZE = new Rectangle(0, 0, SCREENSIZE.width, SCREENSIZE.height);
    private final int textColumnSize = 25;
    public LoginGUI()
    {
        InitializeWindow();
        LoadLoginGraphics();
    }

    /*
        Creates a new window of the rectangle size
        Sets the frame visible for the window frame to be seen
    */
    private void InitializeWindow()
    {
        windowFrame = new JFrame("Employee Login");

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        windowFrame.setBounds(WINDOWSIZE);

        windowFrame.setLocationRelativeTo(null);

        windowFrame.setVisible(true);

    }

    public void LoadLoginGraphics()
    {   
        InitComponents();

        SetupGrid();
        
        windowFrame.add(loginPanel);
    }



    private void SetupGrid() {
        // Common defaults
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 20, 20, 20); // 10px margins

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        loginPanel.add(employeeLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        loginPanel.add(textField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        loginPanel.add(submitButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        loginPanel.add(errorOutputLabel, gbc);

        submitButton.addActionListener(loginError);
    }

    

    private void InitComponents() {
        loginPanel = new JPanel(new GridBagLayout());
        employeeLabel = new JLabel("Employee Login");
        textField = new JTextField(textColumnSize);
        passwordField = new JPasswordField(textColumnSize);
        submitButton = new JButton("Submit");
        loginError = new LoginError(this);
        errorOutputLabel = new JLabel("");
        gbc = new GridBagConstraints();
    }

}