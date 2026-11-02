package employeemanagement;


import java.awt.*;
import javax.swing.*;
public final class LoginGUI
{
    private JFrame windowFrame;
    private JPanel loginPanel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel employeeLabel;
    private JButton submitButton;
    private GridBagConstraints gbc; //adds a layout to the panel
    
    //Credentials
    private String empID = "";
    private char[] empPassword;

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

        SetupButton();
    }

    private void SetupButton() {
        submitButton.addActionListener((e) -> {
            //todo
            if(textField.getText().isEmpty() || passwordField.getPassword().length == 0)
            {
                System.out.println("Please enter your credencials!");
                return;
            }
            else
            {
                empID = textField.getText();
                empPassword = passwordField.getPassword();

                System.out.println(empID);
                System.out.println(empPassword);

                //login to sql database
                SqlDatabase.getInstance().ConnectToSql(empID, empPassword);

            }

            
        });
    }

    

    private void InitComponents() {
        loginPanel = new JPanel(new GridBagLayout());
        employeeLabel = new JLabel("Employee Login");
        textField = new JTextField(textColumnSize);
        passwordField = new JPasswordField(textColumnSize);
        submitButton = new JButton("Submit");
        gbc = new GridBagConstraints();
    }

}