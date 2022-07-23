import java.awt.Color;
import java.awt.Font;
import java.util.function.ToDoubleBiFunction;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
public class Addrooms extends JFrame implements ActionListener
{
    JTextField tfroom,tfprice;
    JButton addroom,addcancel;
    JComboBox availablecombo,tfclean,jcbed;
    Addrooms()
    {
         setBounds(330,200,940,470);
         getContentPane().setBackground(Color.WHITE);

         setLayout(null);

         JLabel  heading  = new JLabel("Add Rooms");
         heading.setFont(new Font("serif",Font.BOLD,20));
         heading.setBounds(150,20,200,20); 
         add(heading);

         JLabel  lblroomno  = new JLabel("Room Number");
         lblroomno.setFont(new Font("serif",Font.PLAIN,15));
         lblroomno.setBounds(60,80,200,20); 
         add(lblroomno);


         tfroom = new JTextField();
         tfroom.setBounds(200,80,150,20);
         add(tfroom);

         JLabel  roomavailable  = new JLabel("Available");
         roomavailable.setFont(new Font("serif",Font.PLAIN,15));
         roomavailable.setBounds(60,140,200,20); 
         add(roomavailable);

         String availableOption[] = {"Available","Occupied"}; 


        availablecombo = new JComboBox(availableOption);
         availablecombo.setBounds(200,140,150,20);
         availablecombo.setBackground(Color.WHITE);
         add(availablecombo);    

         JLabel  lblcleaned  = new JLabel("Ceaning Status");
         lblcleaned.setFont(new Font("serif",Font.PLAIN,15));
         lblcleaned.setBounds(60,200,200,20); 
         add(lblcleaned);

         String Cleaning[] = {"Cleaned","Uncleaned"};

         tfclean = new JComboBox(Cleaning);
         tfclean.setBounds(200,200,150,20);
         tfclean.setBackground(Color.WHITE);
         add(tfclean);

         JLabel  lblPrice  = new JLabel("Price");
         lblPrice.setFont(new Font("serif",Font.PLAIN,15));
         lblPrice.setBounds(60,260,200,20); 
         add(lblPrice);


         tfprice = new JTextField();
         tfprice.setBounds(200,260,150,20);
         add(tfprice);

         JLabel  lblBedtype  = new JLabel("Bed Type");
         lblBedtype.setFont(new Font("serif",Font.PLAIN,15));
         lblBedtype.setBounds(60,320,200,20); 
         add(lblBedtype);

         String Bed[] = {"Single","Double"};
         jcbed = new JComboBox(Bed);
         jcbed.setBounds(200,320,150,20); 
         jcbed.setBackground(Color.WHITE);
         add(jcbed);

         addroom = new JButton("Add Rooms");
         addroom.setBackground(Color.BLACK);
         addroom.setForeground(Color.WHITE);
         addroom.setBounds(60,380,130,30);
         addroom.addActionListener(this);
         add(addroom);

         addcancel = new JButton("Cancel");
         addcancel.setBackground(Color.BLACK);
         addcancel.setForeground(Color.WHITE);
         addcancel.setBounds(220,380,130,30);
         addcancel.addActionListener(this);
         add(addcancel);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
         JLabel image = new JLabel(i1);
         image.setBounds(400,60,500,300);
         add(image);
         setVisible(true);    


    }
    public static void main(String[] args) 
    {
        new Addrooms();
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==addroom)
        {
            String roomnumber = tfroom.getText();
            String available =(String) availablecombo.getSelectedItem();
            String status    =(String) tfclean.getSelectedItem();
            String price = tfprice.getText();
            String type = (String)jcbed.getSelectedItem();

            try 
            {
                Conn c = new Conn();

                String query = "insert into room values('"+roomnumber+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==addcancel)
        {
            setVisible(false);
        }
        
    }

    
}
