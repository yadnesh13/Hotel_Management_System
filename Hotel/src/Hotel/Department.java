package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back;

    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dept.png"));   //bg image
        JLabel image = new JLabel(i1);
        image.setBounds(550,10,450,600);    //crop image
        add(image);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(80,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(370,10,100,20);
        add(l2);

        table = new JTable();
        table.setBounds(0,50,500,300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));       // to display all the data from sql

        } catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);


        setBounds(200,100,1050,600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {

        new Department();
    }

}
