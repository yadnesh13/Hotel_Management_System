package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener {

    JButton newCustomer , rooms, department, allEmployee, managerInfo, customers, searchRoom, update, roomStatus, pickup, checkout, logout;

    Reception() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer = new JButton ("New Guest");    // new customer button
        newCustomer.setBounds(10,30,200,30);    //size
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton ("Rooms");    // Rooms button
        rooms.setBounds(10,70,200,30);    //size
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton ("Departments");    // Department button
        department.setBounds(10,110,200,30);    //size
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton ("All Employees");    // All Employees button
        allEmployee.setBounds(10,150,200,30);    //size
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton ("Customer Info");    // All Customers button
        customers.setBounds(10,190,200,30);    //size
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton ("Manager Info");    // All Managers button
        managerInfo.setBounds(10,230,200,30);    //size
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout = new JButton ("Checkout");    // Checkout button
        checkout.setBounds(10,270,200,30);    //size
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        update = new JButton ("Pending Status");    // update button
        update.setBounds(10,310,200,30);    //size
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton ("Update Room Status");    // update room button
        roomStatus.setBounds(10,350,200,30);    //size
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup = new JButton ("Pickup Service");    // pickup button
        pickup.setBounds(10,390,200,30);    //size
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom = new JButton ("Search Room");    // search room button
        searchRoom.setBounds(10,430,200,30);    //size
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton ("Logout");    // Logout button
        logout.setBounds(10,470,200,30);    //size
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("Icons/recepbg.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,100,800,570);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae){

        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        }else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource () == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource()== roomStatus) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource() == pickup) {
            setVisible(false);
            new Pickup();
        }else if (ae.getSource() == checkout ) {
            setVisible(false);
            new CheckOut();
        }else if (ae.getSource() == logout) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {

        new Reception();

    }

}
