
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton b1;

    CustomerInfo() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300, 200, 1050, 600);

     
        table = new JTable();
        table.setBounds(0, 40, 1050, 400);
        add(table);

        JLabel l1 = new JLabel("Document");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setBounds(150, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(290, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(430, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(570, 10, 100, 20);
        add(l5);

         JLabel l6 = new JLabel("Room no");
        l6.setBounds(690, 10, 100, 20);
        add(l6);

         JLabel l7 = new JLabel("Checkin");
        l7.setBounds(810, 10, 100, 20);
        add(l7);

         JLabel l8 = new JLabel("Deposit");
        l8.setBounds(930, 10, 100, 20);
        add(l8);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
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

    }

    public static void main(String[] args) {
        new CustomerInfo();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Reception();
        }
    }

}
