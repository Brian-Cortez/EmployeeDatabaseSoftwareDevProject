package employeemanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;

public class LoginError implements ActionListener, SqlCommand{

    LoginGUI login;
    public static LoginError instance;

    //! SQL Command
    private final String loginSqlCommand = "SELECT e.empID, e.empPassword FROM employees e;";

    LoginError(LoginGUI login)
    {
        this.login = login;
    }

    public LoginError getInstance()
    {
        if(instance == null && login != null)
        {
            instance = new LoginError(login);
        }

        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //! Set THIS classes execute method
        SqlDatabase.getInstance().SetCommandDelegate(this);

        //Write down the code here (e.g. if your collecting)
        if(login.textField.getText().isEmpty() || login.passwordField.getPassword().length == 0)
            {
                login.errorOutputLabel.setText("Please enter your credencials!");
                return;
            }
            else
            {
                login.empID = login.textField.getText();
                login.empPassword = login.passwordField.getPassword();

                System.out.println(login.empID);
                System.out.println(login.empPassword);

                //login to sql database
                SqlDatabase.getInstance().ExecuteSqlCommand(loginSqlCommand);
            }
    }
    
    @Override
    public void Execute() throws SQLException {
        //Loop through the result from the SQL command
        System.out.println("Login command Executed");
        while(SqlDatabase.getInstance().result.next())
        {   
            //Compare the ID and Password from the database
            if(login.empID.equals(SqlDatabase.getInstance().result.getString("e.empID")) &&
               String.valueOf(login.empPassword).equals(SqlDatabase.getInstance().result.getString("e.empPassword")))
            {
                
                login.errorOutputLabel.setText("Logging in!");
                ScreenManager.getInstance().setPanel(EmployeeDashboard.getInstance());
                break;
            }
            else if(SqlDatabase.getInstance().result.isLast())
            {
                login.errorOutputLabel.setText("Incorrect ID or Password Please Try Again!");
                //myConn0.close();
                break;
            }
            
            System.out.println(SqlDatabase.getInstance().result.getString("e.empID") + " " + SqlDatabase.getInstance().result.getString("e.empPassword"));

        }
    }
}
