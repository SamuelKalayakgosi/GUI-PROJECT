import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField tfName;
    private JPanel loginPanel;
    private JLabel Name;
    private JLabel Password;
    private JButton btnOk;
    private JPasswordField pfPassword;
    private JButton btnCancel;

    public LoginForm(){
       JFrame frame= new JFrame("Login");
       frame.setSize(600, 700);
       frame.setLocation(0, 0);
       frame.pack();
       frame.add(loginPanel);
       frame.setMinimumSize(new Dimension( 450, 474));
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frame.setResizable(true);
       frame.setVisible(true);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
                    String query = ("Select * from systemuser where username = ?  and password = ?");
                    PreparedStatement prest = conn.prepareStatement(query);
                    prest.setString(1, tfName.getText());
                    prest.setString(2, pfPassword.getText());
                    ResultSet rs = prest.executeQuery();


                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Login successfully");
                        frame.setVisible(false);
                        registar registar=new registar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Login unsuccessful");
                    }
                    prest.close();
                }catch(Exception error){
                    error.printStackTrace();
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }

    public static void main(String[] args) {
    LoginForm loginForm= new LoginForm();}
}
