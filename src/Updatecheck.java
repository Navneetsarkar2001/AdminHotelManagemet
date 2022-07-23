import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Updatecheck extends JFrame implements ActionListener
{
    Choice customer;
    JTextField tfname,tfchktime,tfpaid,tfpending,tfroom;
    JButton check,update,back;
    Updatecheck()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,200,980,500);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("serif",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,70,150,30);        
        add(lblid);

        
       customer = new Choice();
       customer.setBackground(Color.WHITE);
       customer.setBounds(200,80,200,25);
       add(customer);
 
       try {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from customer");
         while(rs.next())
         {
            customer.add(rs.getString("number"));
         }
       } catch (Exception e) {
            e.printStackTrace();
       }

       JLabel lblroomno = new JLabel("Room no");
       lblroomno.setBounds(30,120,100,20);
       add(lblroomno);
       
       tfroom = new JTextField();
       tfroom.setBounds(150,120,150,20); 
       add(tfroom);

       JLabel lblname = new JLabel("Name");
       lblname.setBounds(30,160,100,20);
       add(lblname);
 
       tfname = new JTextField();
       tfname.setBounds(150,160,150,20);
       add(tfname);
 
        JLabel lblchktime = new JLabel("Checkin time");
       lblchktime.setBounds(30,200,100,20);
       add(lblchktime);
 
       tfchktime = new JTextField();
       tfchktime.setBounds(150,200,150,20);
       add(tfchktime);

       JLabel lblpaid = new JLabel("Amount Paid");
       lblpaid.setBounds(30,240,100,20);
       add(lblpaid);
 
       tfpaid = new JTextField();
       tfpaid.setBounds(150,240,150,20);
       add(tfpaid);

       JLabel lblpending = new JLabel("Pending amount");
       lblpending.setBounds(30,280,150,20);
       add(lblpending);
 
       tfpending = new JTextField();
       tfpending.setBounds(150,280,150,20);
       add(tfpending);

       check = new JButton("Check");
       check.setBounds(30,350,120,30);
       check.setBackground(Color.BLACK);
       check.setForeground(Color.white);
       check.addActionListener(this);
       add(check);
       

       update = new JButton("Update");
       update.setBounds(170,350,120,30);
       update.setBackground(Color.BLACK);
       update.setForeground(Color.white);
       update.addActionListener(this);
       add(update);


       back = new JButton("Back");
       back.setBounds(310,350,120,30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.white);
       back.addActionListener(this);
       add(back);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(400,50,500,300);
       add(image);

       setVisible(true); 



    }  
    public static void main(String[] args) {
       new Updatecheck();   
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {

        if(ae.getSource()==check)
        {
             String id = customer.getSelectedItem();
             String query1 = "select * from customer where number='"+id+"'";
             try 
             {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query1);
                while(rs.next())
                {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfchktime.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                    
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next())
                {
                    String price = rs2.getString("price");

                    int amountpending = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountpending);
                }

             } 
             catch (Exception e) {
                 e.printStackTrace();
             }       
        }
        else if(ae.getSource()==update)
        {
            String number = customer.getSelectedItem();
            String roomno = tfroom.getText();
            String name = tfname.getText();
            String checkintime = tfchktime.getText();
            String amountpaid = tfpaid.getText();
             
            try 
            {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room='"+roomno+"',name='"+name+"',checkintime='"+checkintime+"',deposit='"+amountpaid+"' where number='"+number+"'");
                JOptionPane.showMessageDialog(null, "Customer details updated");
                this.setVisible(false);
                new Reception();
            } 
            catch (Exception e) {
               e.printStackTrace(); 
            }
           
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
        
    }
}
