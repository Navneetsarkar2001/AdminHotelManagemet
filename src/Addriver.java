import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.function.ToDoubleBiFunction;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
public class Addriver extends JFrame implements ActionListener
{

    JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
    JButton addriver,cancel;
    JComboBox tfgender,tfavailable;
    Addriver()
    {
         setBounds(330,200,940,600);
         getContentPane().setBackground(Color.WHITE);

         setLayout(null);

         JLabel  heading  = new JLabel("Add Driver");
         heading.setFont(new Font("serif",Font.BOLD,20));
         heading.setBounds(150,20,200,20); 
         add(heading);

         JLabel  lblroomno  = new JLabel("Name");
         lblroomno.setFont(new Font("serif",Font.PLAIN,15));
         lblroomno.setBounds(60,80,200,20); 
         add(lblroomno);


         tfname = new JTextField();
         tfname.setBounds(200,80,150,20);
         add(tfname);

         JLabel  roomavailable  = new JLabel("Age");
         roomavailable.setFont(new Font("serif",Font.PLAIN,15));
         roomavailable.setBounds(60,140,200,20); 
         add(roomavailable);

         tfage = new JTextField();
         tfage.setBounds(200,140,150,20);
         add(tfage);
         

         JLabel  lblcleaned  = new JLabel("Gender");
         lblcleaned.setFont(new Font("serif",Font.PLAIN,15));
         lblcleaned.setBounds(60,200,200,20); 
         add(lblcleaned);

         String Cleaning[] = {"Male","Female"};

         tfgender = new JComboBox(Cleaning);
         tfgender.setBounds(200,200,150,20);
         tfgender.setBackground(Color.WHITE);
         add(tfgender);

         JLabel  lblPrice  = new JLabel("Car Company");
         lblPrice.setFont(new Font("serif",Font.PLAIN,15));
         lblPrice.setBounds(60,260,200,20); 
         add(lblPrice);


         tfcompany = new JTextField();
         tfcompany.setBounds(200,260,150,20);
         add(tfcompany);

         JLabel  lblBedtype  = new JLabel("Car Model");
         lblBedtype.setFont(new Font("serif",Font.PLAIN,15));
         lblBedtype.setBounds(60,320,200,20); 
         add(lblBedtype);

         tfmodel = new JTextField();
         tfmodel.setBounds(200,320,150,20);
         add(tfmodel);

         JLabel  lblAvailable  = new JLabel("Availability");
         lblAvailable.setFont(new Font("serif",Font.PLAIN,15));
         lblAvailable.setBounds(60,380,200,20); 
         add(lblAvailable);

 
         String available [] = {"Available","Busy"};
         tfavailable = new JComboBox(available);
         tfavailable.setBounds(200,380,150,20); 
         tfavailable.setBackground(Color.white);
         add(tfavailable);
         
          JLabel  lblLoaction  = new JLabel("Loaction Alloted");
         lblLoaction.setFont(new Font("serif",Font.PLAIN,15));
         lblLoaction.setBounds(60,440,200,20); 
         add(lblLoaction);

         tflocation = new JTextField();
         tflocation.setBounds(200,440,150,20);
         add(tflocation);



         addriver = new JButton("Add Driver");
         addriver.setBackground(Color.BLACK);
         addriver.setForeground(Color.WHITE);
         addriver.setBounds(60,490,130,30);
         addriver.addActionListener(this);
         add(addriver);

         cancel = new JButton("Cancel");
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.setBounds(220,490,130,30);
         cancel.addActionListener(this);
         add(cancel);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3); 
         image.setBounds(400,60,500,300);
         add(image);
         setVisible(true);  
    }
    public static void main(String[] args) {
        new Addriver();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==addriver)
        {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)tfgender.getSelectedItem();
            String Company = tfcompany.getText();
            String Model = tfmodel.getText();
            String avail = (String) tfavailable.getSelectedItem();
            String location = tflocation.getText();

            try {
                Conn c = new Conn();
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+Company+"','"+Model+"','"+avail+"','"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Driver details added successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }             
    }
}
