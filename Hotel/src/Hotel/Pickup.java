package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back ,submit;
    Choice typeofcar;
    JCheckBox available;

    Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

       typeofcar = new Choice();
       typeofcar.setBounds(150,100,200,25);
       add(typeofcar);

       try{

           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from driver");
           while (rs.next()) {
               typeofcar.add(rs.getString("model"));
           }

       } catch (Exception e) {
           e.printStackTrace();
       }


        JLabel l1 = new JLabel("Name");
        l1.setBounds(50,170,100,20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200,170,100,20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330,170,100,20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460,170,100,20);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(630,170,100,20);
        add(l5);

        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740,170,100,20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(890,170,100,20);
        add(l7);


        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));       // to display all the data from sql

        } catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(450,520,120,30);
        add(back);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);


        setBounds(250,140,1050,600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            try{
                String query = "select * from driver where model = '"+typeofcar.getSelectedItem()+"'";    // for selection of single and double bed

                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Pickup();
    }

}

