import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener
{

    JButton newCustomer,rooms,department,allEmployee,manager,customer,searchroom,update,roomstatus,pickup,checkout;
    Reception()
    {
        setBounds(350,160,800,570);
        setLayout(null);
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,160,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,160,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(10,110,160,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);

         allEmployee = new JButton("ALL Employee");
        allEmployee.setBounds(10,150,160,30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.white);
        allEmployee.addActionListener(this);
        add(allEmployee); 

        
        
         customer = new JButton("All Customer");
        customer.setBounds(10,190,160,30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        add(customer);
        
         manager = new JButton("Manager Info");
        manager.setBounds(10,230,160,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);

        checkout = new JButton("checkout");
        checkout.setBounds(10,270,160,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton("Update");
        update.setBounds(10,310,160,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        roomstatus = new JButton("Room Status");
        roomstatus.setBounds(10,350,160,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.white);
        roomstatus.addActionListener(this);
        add(roomstatus);

         pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,160,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
 
        searchroom = new JButton("Search Room");
        searchroom.setBounds(10,430,160,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);

        JButton logout = new JButton("Logout");
        logout.setBounds(10,470,160,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.white);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,570,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,570);
        add(image); 
 
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    public static void main(String args[])
    {
        new Reception();

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
             if(ae.getSource()==newCustomer)  
             {
                 setVisible(false);
                 new Addcustomer();
                 
             }  
             if(ae.getSource()==rooms)
             {
                 setVisible(false);
                 new Room();  
             } 
             if(ae.getSource()==department)
             {
                 setVisible(false);
                 new Department();
             } 
             if(ae.getSource()==allEmployee)
             {
                 setVisible(false);
                 new EmployeeInfo();
             }
             if(ae.getSource()==manager)
             {
                 setVisible(false);
                 new ManagerInfo();
             }
             if(ae.getSource()==customer)
             {
                 setVisible(false);
                 new CustomerInfo();
             }
             if(ae.getSource()==searchroom)
             {
                 setVisible(false);
                 new Searchrooms();
             }
             if(ae.getSource()==update)
             {
                setVisible(false);
                new Updatecheck();
             }
             if(ae.getSource()==roomstatus)
             {
                setVisible(false);
                new Updateroom();
             }
             if(ae.getSource()==pickup)
             {
                setVisible(false);
                new Pickup();
             }
             if(ae.getSource()==checkout)
             {
                setVisible(false);
                new Checkout();
             }
    }

    
}
