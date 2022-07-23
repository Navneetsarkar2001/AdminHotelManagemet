

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import net.proteanit.sql.*;

public class Searchrooms extends JFrame implements ActionListener {
    JTable table;
    JButton b1,b2;
    JComboBox bedtype;
    JCheckBox available;  
    Searchrooms() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300, 200, 1050, 600);

        JLabel text = new JLabel("Search for Rooms");
        text.setFont(new Font("serif",Font.PLAIN,20));;
        text.setBounds(400,30,200,30);
        add(text);  
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        String arr[] = {"Single","Double"};
        bedtype = new JComboBox(arr);
        bedtype.setBounds(150,100,200,25);   
        bedtype.setBackground(Color.WHITE);
        add(bedtype);  

        available = new JCheckBox("Only display available");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.WHITE);   
        add(available); 
        JLabel l1 = new JLabel("Room No");
        l1.setBounds(30, 150, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Avaliability");
        l2.setBounds(200, 150, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(400, 150, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(600, 150, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(800, 150, 100, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(200, 500, 120, 30);
        add(b1);
        setVisible(true);

        b2= new JButton("Submit");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(350, 500, 120, 30);
        b2.addActionListener(this);
        add(b2);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Searchrooms();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Reception();
        }
        if(ae.getSource()==b2)
        {
              try 
              {
                   Conn c = new Conn();
                   String Query1 = "select * from room where bed_type='"+bedtype.getSelectedItem()+"'";
                   String Query2 = " select * from room where availability='Available' AND bed_type='"+bedtype.getSelectedItem()+"'";
                   ResultSet rs;
                   if(available.isSelected())
                   {
                        rs = c.s.executeQuery(Query2);   
                   }
                   else
                   {
                         rs = c.s.executeQuery(Query1);    
                   }

                   table.setModel(DbUtils.resultSetToTableModel(rs));
              } 
              catch (Exception e) {
                   e.printStackTrace();
              }
        }
    }

}
