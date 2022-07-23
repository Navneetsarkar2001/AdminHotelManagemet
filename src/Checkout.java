import java.awt.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener
{

    Choice customer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkoutbtn,back;
    Checkout()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,200,800,400);


        JLabel checkout = new JLabel("Checkout");
        checkout.setBounds(100,20,100,30);
        checkout.setForeground(Color.BLUE);
        checkout.setFont(new Font("serif",Font.PLAIN,20));
        add(checkout);


        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        customer = new Choice();
        customer.setBounds(150,80,150,25);
        add(customer);

        
        
        JLabel lblroom = new JLabel("Room Number:");
        lblroom.setBounds(30,130,110,30);
        add(lblroom);
        
        
        lblroomnumber = new JLabel("");
        lblroomnumber.setBounds(150,130,100,30);
        lblroomnumber.setFont(new Font("serif",Font.BOLD,14));
        add(lblroomnumber);
        
        
        JLabel lblcheckin = new JLabel("Checkin Time:");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel("");
        lblcheckintime.setBounds(150,180,200,30);
        add(lblcheckintime);
        try 
        {
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from customer");   
             while(rs.next())
             {
                   customer.add(rs.getString("number"));
                   lblroomnumber.setText(rs.getString("room"));
                   lblcheckintime.setText(rs.getString("checkintime")); 
             } 
        } 
        catch (Exception e) 
        {
             e.printStackTrace();          
        }
        
        
        JLabel lblcheckout = new JLabel("Checkout Time:");
        lblcheckout.setBounds(30,230,110,30);
        add(lblcheckout);
        
        Date date = new Date();
        
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,200,30);
        add(lblcheckouttime);
        
        
        checkoutbtn = new JButton("Checkout");
        checkoutbtn.setBackground(Color.black);
        checkoutbtn.setForeground(Color.white);
        checkoutbtn.setBounds(30,280,120,30);
        checkoutbtn.addActionListener(this);
        add(checkoutbtn); 
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back); 

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,50,400,250);
        add(image);

        setVisible(true);

    }
    public static void main(String[] args) {
        new Checkout();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
             if(ae.getSource()==checkoutbtn)
             {
                   String query1 = "delete from customer where number='"+customer.getSelectedItem()+"'";
                   String query2 = "update room set availability='Available' where roomnumber='"+lblroomnumber+"'";     
                   
                   try 
                   {
                      Conn c = new Conn();
                      c.s.executeUpdate(query1);
                      c.s.executeUpdate(query2);
                      
                      JOptionPane.showMessageDialog(null,"Checkout done");
                   } 
                   catch (Exception e) 
                   {
                        e.printStackTrace();
                   }
             } 
             else if(ae.getSource()==back)
             {

             }    
    }    
}