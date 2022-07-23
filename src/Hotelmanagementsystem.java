import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hotelmanagementsystem extends JFrame implements ActionListener
{
    Hotelmanagementsystem()
    {
        // setSize(1366,565);
        // setLocation(100,100);
        setBounds(100,100,1366,565); 
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        image.setBounds(0,0,1366,565);
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20,430,1000,90); 
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.BOLD,50));
        image.add(text); 

        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.white);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("serif",Font.PLAIN,20));
        next.addActionListener(this);
        image.add(next);    

        

        setVisible(true);  

        while(true)
        {
            text.setVisible(false);
            try {
                Thread.sleep(500);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) 
    {
     
        new Hotelmanagementsystem();
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login(); 
        
    }
    
}
