package Hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login,cancel;

    Login() {
        getContentPane().setBackground(Color.white);     //bgcolour of slide

        setLayout(null);

        JLabel user = new JLabel("Username");        //username button
        user.setBounds(40,20,100,30);
        add(user);

        username = new JTextField();          //username text field
        username.setBounds(150,20,150,30);
        add(username);


        JLabel pass = new JLabel("Password");        //password button
        pass.setBounds(40,70,100,30);
        add(pass);

        password = new JPasswordField();      //password text field
        password.setBounds(150,70,150,30);
        add(password);

        login = new JButton("Login");      //login button
        login.setBounds(40,150,120,30);
        login.setBackground(Color.cyan);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");      //login button
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.cyan);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/loginbg.png"));    //background image
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1003,604);
        add(image);




        setBounds(500,200,500,300);    //size of page
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){          // action performed by buttons
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();

            try{
                Conn c = new Conn();

                String query = "select * from login where username  = '"+ user +"' and password = '" + pass +"'";   //to check whether username and password are same

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()) {
                    setVisible(false);
                    new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                    new Login();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Login();

    }
}
