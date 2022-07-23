import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Addcustomer extends JFrame implements ActionListener
{
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JComboBox jcgender;
    Choice  croom;
    JButton add,back;
    JLabel chktime;
    Addcustomer()
    {
        setBounds(350,200,800,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);

        JLabel id = new JLabel("ID");
        id.setBounds(60,90,100,30);
        id.setFont(new Font("Raleway",Font.PLAIN,17));
        add(id);

        String options[] = {"Aadhar card","Driving Liscense","Voter id","Passport","Islander Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,90,150,25); 
        comboid.setBackground(Color.WHITE);
        add(comboid);     
        
        JLabel number = new JLabel("Number");
        number.setBounds(60,130,100,30);
        number.setFont(new Font("Raleway",Font.PLAIN,17));
        add(number);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,130,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,170,100,30);
        lblname.setFont(new Font("Raleway",Font.PLAIN,17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,170,150,25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,210,100,30);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,17));
        add(lblgender);

        String g[] = {"Male","Female"};
        jcgender = new JComboBox(g);
        jcgender.setBounds(200,210,150,25); 
        jcgender.setBackground(Color.WHITE);
        add(jcgender);  

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60,250,100,30);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,17));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,250,150,25);  
        add(tfcountry); 

        JLabel lblroomno = new JLabel("Room No");
        lblroomno.setBounds(60,290,100,30);
        lblroomno.setFont(new Font("Raleway",Font.PLAIN,17));      
        add(lblroomno);
        
        croom = new Choice();
        croom.setBounds(200,290,150,25);
        try {
            Conn c = new Conn();
            String query = "select * from room where availability='Available'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(croom);

        JLabel lbltime = new JLabel("Checkin time");
        lbltime.setFont(new Font("Raleway",Font.PLAIN,17));
        lbltime.setBounds(60,330,150,30);
        add(lbltime);
        
        Date date  = new Date(); 
        
        chktime = new JLabel(""+ date );
        chktime.setBounds(200,330,220,30);
        add(chktime);

        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(60,370,100,30);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,17));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,370,150,25);
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBounds(60,440,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(230,440,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,300,400);
        add(image);  

        setVisible(true);
    }

    public static void main(String[] args) 
    {

        new Addcustomer();

        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
           if(ae.getSource()==add)
           {
                 String id =  (String)comboid.getSelectedItem();  
                 String number = tfnumber.getText();
                 String name = tfname.getText();
                 String gender = (String)jcgender.getSelectedItem();
                 String country = tfcountry.getText();
                 String roomno = (String)croom.getSelectedItem();
                 String time = chktime.getText();
                 String deposit = tfdeposit.getText();

                 try {

                    String query = "insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomno+"','"+time+"','"+deposit+"')";
                    String query2 = "update room set availability='occupied' where roomnumber='"+roomno+"'";

                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "New Customer added successfully");
                    setVisible(false);
                    new Reception();
                     
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

           }   
           else if(ae.getSource()==back)
           {
               setVisible(false);
           }    
    }
    
}
