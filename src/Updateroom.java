import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Updateroom extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfavailable, tfstatus, tfpaid, tfpending, tfroom;
    JButton check, update, back;

    Updateroom() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300, 200, 980, 500);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("serif", Font.PLAIN, 20));
        text.setBounds(90, 20, 250, 30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 70, 120, 30);
        add(lblid);

        customer = new Choice();
        customer.setBackground(Color.WHITE);
        customer.setBounds(150, 80, 150, 25);
        add(customer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroomno = new JLabel("Room no");
        lblroomno.setBounds(30, 120, 100, 20);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(150, 120, 150, 20);
        add(tfroom);

        JLabel lblname = new JLabel("Availability ");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tfavailable = new JTextField();
        tfavailable.setBounds(150, 160, 150, 20);
        add(tfavailable);

        JLabel lblchktime = new JLabel("Cleaning Status");
        lblchktime.setBounds(30, 200, 150, 20);
        add(lblchktime);

        tfstatus = new JTextField();
        tfstatus.setBounds(150, 200, 150, 20);
        add(tfstatus);

        

        check = new JButton("Check");
        check.setBounds(30, 350, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(170, 350, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(310, 350, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Updateroom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == check) {
        
            String id = customer.getSelectedItem();
            String query1 = "select * from customer where number='"+id+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query1) ;
                while(rs.next())
                {
                    tfroom.setText(rs.getString("room"));
                }
                String query2 = "select * from room where roomnumber='"+tfroom.getText()+"'";
                ResultSet rs2 = c.s.executeQuery(query2);
                while(rs2.next())
                {
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                } 
            } catch (Exception e) {
                 e.printStackTrace();   
            } 



        } 
        else if (ae.getSource() == update) 
        {
               String Roomno = tfroom.getText();
               String Availability = tfavailable.getText();
               String status = tfstatus.getText();
               
               try 
               {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability='"+Availability+"',cleaning_status='"+status+"' where roomnumber='"+Roomno+"'");
                JOptionPane.showMessageDialog(null,"Room status updated");
               } 
               catch (Exception e) 
               {
                 e.printStackTrace();       
               }
        } 
        else if (ae.getSource() == back) 
        {
            setVisible(false);
            new Reception();
        }

    }
}
