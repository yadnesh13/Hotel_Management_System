package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;


    AddCustomer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("New Customer Form");      // new customer form
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Bradely Hand ITC",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        add(text);

        JLabel lblid = new JLabel("ID");          // ID
        lblid.setBounds(30,80,100,20);
        lblid.setForeground(Color.WHITE);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);

        String options [] = {"Aadhar Card", "Driving License", "Voter -Id Card"};     // id
        comboid = new JComboBox(options);
        comboid.setBackground(Color.WHITE);
        comboid.setForeground(Color.black);
        comboid.setBounds(200,80,150,25);
        add(comboid);

        JLabel number = new JLabel("Phone Number");          // number
        number.setBounds(35,120,150,20);
        number.setFont(new Font("Raleway",Font.PLAIN,20));
        number.setForeground(Color.WHITE);
        add(number);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");          // name
        lblname.setBounds(35,160,100,20);
        lblname.setForeground(Color.WHITE);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");          // gender
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        lblgender.setForeground(Color.WHITE);
        add(lblgender);

        rmale= new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,70,20);
        add(rmale);

        rfemale= new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,20);
        add(rfemale);

        JLabel lblcountry = new JLabel("Country");          // name
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setForeground(Color.WHITE);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);


        JLabel lblroom = new JLabel("Room Number");          // name
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        lblroom.setForeground(Color.WHITE);
        add(lblroom);

        croom = new Choice();

        try {

            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime = new JLabel("Check-in Time ");          // time
        lbltime.setBounds(35,360,150,20);
        lbltime.setForeground(Color.WHITE);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);

        Date date = new Date();

        checkintime = new JLabel("" +date);          // Date
        checkintime.setBounds(200,360,170,20);
        checkintime.setForeground(Color.WHITE);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,13));
        add(checkintime);


        JLabel lbldeposit = new JLabel("Deposit");          // deposit
        lbldeposit.setBounds(35,320,100,20);
        lbldeposit.setForeground(Color.WHITE);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,320,150,25);
        add(tfdeposit);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bg3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(00,0,800,550);
        add(image);

        setBounds(350,200,800,550);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae){



            if(ae.getSource() == add) {

                String id = (String) comboid.getSelectedItem();
                String number = tfnumber.getText();
                String name = tfname.getText();
                String gender =  null;

                if (rmale.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                String country = tfcountry.getText();
                String room = croom.getSelectedItem();
                String time = checkintime.getText();
                String deposit = tfdeposit.getText();

                try {
                    String query = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"','"+deposit+"')";
                    String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"' " ;

                    Conn conn = new Conn();
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "New Customer Added Successfully");

                    setVisible(false);
                    new Reception();


                } catch (Exception e){
                    e.printStackTrace();
                }


            } else if (ae.getSource() == back) {
                setVisible(false);
                new Reception();
            }
          }


    public static void main(String[] args) {


        new AddCustomer();

    }


}
