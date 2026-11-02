package employeemanagement;


import javax.swing.SwingUtilities;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            CreateLoginWindow();
        });
    }

    private static LoginGUI CreateLoginWindow() {
        return new LoginGUI();
    }
}