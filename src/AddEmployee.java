import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener
{
    JTextField tfname,tfage,tfemail,tfphone,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee()
    {
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         setBounds(350,200,850,540);

         JLabel lblname = new JLabel("NAME :");
         lblname.setBounds(60,30,120,30); 
         lblname.setFont(new Font("serif",Font.PLAIN,17));
         add(lblname);
         
         tfname = new JTextField();
         tfname.setBounds(200,35,150,20);
         add(tfname);
 
         JLabel lblage = new JLabel("AGE :");
         lblage.setBounds(60,70,120,30); 
         lblage.setFont(new Font("serif",Font.PLAIN,17));
         add(lblage);
         
         tfage = new JTextField();
         tfage.setBounds(200,75,150,20);
         add(tfage);
         
         JLabel lblgender = new JLabel("GENDER :");
         lblgender.setBounds(60,110,120,30); 
         lblgender.setFont(new Font("serif",Font.PLAIN,17));
         add(lblgender);
 
         rbmale = new JRadioButton("Male");
         rbmale.setBounds(200,110,70,30); 
         rbmale.setFont(new Font("serif",Font.BOLD,14));
         rbmale.setBackground(Color.white);
         add(rbmale);

         rbfemale = new JRadioButton("Female");
         rbfemale.setBounds(290,110,90,30); 
         rbfemale.setFont(new Font("serif",Font.BOLD,14));
         rbfemale.setBackground(Color.white);
         add(rbfemale);
         
         JLabel lbljobs = new JLabel("JOBS :");
         lbljobs.setBounds(60,150,120,30);
         lbljobs.setFont(new Font("serif",Font.PLAIN,17)); 
         add(lbljobs);  
         
         String str []= {"Front Desk Clerk","Porters","HouseKeeping","Kitchen Staff","Room service","Manager"};
         cbjob = new JComboBox(str);
         cbjob.setBounds(200,155,150,20);  
         cbjob.setBackground(Color.white);
         add(cbjob);

         JLabel lblsalary = new JLabel("SALARY :");
         lblsalary.setBounds(60,190,120,30); 
         lblsalary.setFont(new Font("serif",Font.PLAIN,17));
         add(lblsalary);
         
         tfsalary = new JTextField();
         tfsalary.setBounds(200,195,150,20);
         add(tfsalary);

         JLabel lblphone = new JLabel("PHONE :");
         lblphone.setBounds(60,230,120,30); 
         lblphone.setFont(new Font("serif",Font.PLAIN,17));
         add(lblphone);
         
         tfphone = new JTextField();
         tfphone.setBounds(200,235,150,20);
         add(tfphone);

         JLabel lblemail = new JLabel("EMAIL :");
         lblemail.setBounds(60,270,120,30); 
         lblemail.setFont(new Font("serif",Font.PLAIN,17));
         add(lblemail);
         
         tfemail = new JTextField();
         tfemail.setBounds(200,275,150,20);
         add(tfemail);

         JLabel lblaadhar = new JLabel("AADHAR NO:");
         lblaadhar.setBounds(60,310,120,30);
         lblaadhar.setFont(new Font("serif",Font.PLAIN,17));
         add(lblaadhar);

         tfaadhar = new JTextField();
         tfaadhar.setBounds(200,315,150,20);
         add(tfaadhar); 

         submit = new JButton("Submit");
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.setBounds(200,400,150,30);
         submit.addActionListener(this);
         add(submit);

         ButtonGroup bg = new ButtonGroup();
         bg.add(rbmale);
         bg.add(rbfemale);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
         Image i2  = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(380,30,450,380);
         add(image);   

         setVisible(true);     
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
      
      String name = tfname.getText();
      String phone = tfphone.getText();
      String age = tfage.getText();
      String email = tfemail.getText();
      String salary = tfsalary.getText();
      String aadhar = tfaadhar.getText();  
      
      String gender = null;
      if(rbmale.isSelected())
      {
          gender = "Male";
      }
      else if(rbfemale.isSelected()){
          gender = "Female";
      }

      String jobs = (String)cbjob.getSelectedItem();

      try 
      {
           Conn c = new Conn();
           String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+jobs+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";  
           c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Employee Details Added ");
      } 
      catch (Exception e) {
         e.printStackTrace();
      }


    }
    
}
