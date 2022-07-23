import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener
{
    Dashboard()
    {
       setBounds(0,0,1920,1080);
       setLayout(null);
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));  
       Image i2  = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);                                                                
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1920,1080);
       add(image);

       JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
       text.setBounds(650,80,1000,50);
       text.setFont(new Font("Tahoma",Font.PLAIN,46));
       text.setForeground(Color.WHITE);
       image.add(text);

       JMenuBar mb = new JMenuBar();
       mb.setBounds(0,0,1920,30);
       image.add(mb);

       JMenu hotel = new JMenu("HOTEL MANAGEMENT");
       hotel.setForeground(Color.red);
       mb.add(hotel);

       JMenuItem reception = new JMenuItem("RECEPTION");
       reception.addActionListener(this);
       hotel.add(reception);

       JMenu admin = new JMenu("ADMIN");
       admin.setForeground(Color.blue);
       mb.add(admin);

       JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
       addemployee.addActionListener(this);
       admin.add(addemployee);
       JMenuItem addriver = new JMenuItem("ADD DRIVER");
       addriver.addActionListener(this);
       admin.add(addriver);
       JMenuItem addrooms = new JMenuItem("ADD ROOMS");
       addrooms.addActionListener(this);
       admin.add(addrooms);
       setVisible(true);     
        
    }
    public static void main(String[] args) {
           new Dashboard();  
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
  
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee();
        }
        if(ae.getActionCommand().equals("ADD ROOMS"))
        {
            new Addrooms();
        }
        if(ae.getActionCommand().equals("ADD DRIVER"))
        {
            new Addriver();
        }
        if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception();
        }
    }
    
}
