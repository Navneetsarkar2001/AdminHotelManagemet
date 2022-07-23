import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JTextField username;
    JPasswordField passwords;
    JButton login,cancel;
    Login(){ 
        getContentPane().setBackground(Color.white);
        setBounds(500,200,600,300);
        setLayout(null);

        JLabel user = new JLabel("Username:");
        user.setBounds(40,20,100,30);
        add(user);         
        username = new JTextField();
        username.setBounds(160,30,200,20);
        add(username) ; 

        JLabel password = new JLabel("Password:");
        password.setBounds(40,70,100,30);         
        add(password);

        passwords = new JPasswordField();
        passwords.setBounds(160,70,200,20);
        add(passwords) ;

        login = new JButton("Login");
        login.setBounds(40,160,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);

        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,160,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image); 
        setVisible(true);
    }
   public static void main(String[] args) {
      new Login();  
   }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == login)
       {
            String user = username.getText();
            String pass = passwords.getText();
            
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '"+user+ "'and password = '"+pass+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                     setVisible(false);
                     new Dashboard();      
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
       }
       else if(ae.getSource()==cancel)
       {
           setVisible(false);
       }
        
    } 
}
