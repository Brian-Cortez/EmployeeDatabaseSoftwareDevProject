import java.awt.*;
import javax.swing.*;

public class LoginGUI
{
    private JFrame windowFrame;

    // x, y, width, height
    private final Rectangle WINDOWSIZE = new Rectangle(500, 500, 500, 500);

    public LoginGUI()
    {

    }



    /*
        Creates a new window of the rectangle size
        Sets the frame visible for the window frame to be seen
    */
    public void InitializeWindow()
    {
        windowFrame = new JFrame("Employee Login");

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        windowFrame.setBounds(WINDOWSIZE);

        windowFrame.setVisible(true);
    }
    
}