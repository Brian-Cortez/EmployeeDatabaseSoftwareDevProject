import javax.swing.SwingUtilities;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            LoginGUI gui = new LoginGUI();
            gui.InitializeWindow();
        });
    }
}