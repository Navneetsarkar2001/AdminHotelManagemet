
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

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton b1;

    Department() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300, 200, 1050, 600);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(10, 10, 100, 20);
        add(l1);


        JLabel l2 = new JLabel("Buget");
        l2.setBounds(300, 10, 100, 20);
        add(l2);

       
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
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
        new Department();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Reception();
        }
    }

}
