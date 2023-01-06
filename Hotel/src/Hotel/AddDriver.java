package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

    JButton add , cancel;
    JTextField tfname, tfcompany, tfage, tfmodel, tflocation;
    JComboBox availablecombo, gendercombo ;

    AddDriver (){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Driver");         //ADD driver font
        heading.setFont(new Font("Tahoma", Font.BOLD, 15));
        heading.setBounds(150,10,200,20);
        add(heading);

        JLabel lblroomno = new JLabel("Name");         //ADD driver name
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblroomno.setBounds(60,70,120,30);
        add(lblroomno);

        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);

        JLabel lblage = new JLabel("Age");           //  Age
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblage.setBounds(60,110,120,30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);

        JLabel gender = new JLabel("Gender");         //  Gender
        gender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gender.setBounds(60,150,120,30);
        add(gender);

        String[] genderOptions = { "Male", "Female"};
        gendercombo = new JComboBox(genderOptions);    // gender drop box
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblmodel = new JLabel("Car Model");         // car model
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblmodel.setBounds(60,230,120,30);
        add(lblmodel);

        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);

        JLabel lblcompany = new JLabel("Car Company ");         // car company
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblcompany.setBounds(60,190,120,30);
        add(lblcompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);

        JLabel lblavailable = new JLabel("Available");         // available
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblavailable.setBounds(60,270,120,30);
        add(lblavailable);

        String[] avaliableOptions = { "Available", "Busy"};
        availablecombo = new JComboBox(avaliableOptions);    // available drop box
        availablecombo.setBounds(200,270, 150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lbllocation = new JLabel("Location");         // location
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);

        add = new JButton("Add Driver");    //Add button
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");    //Add button
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));   //bg image
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);    //crop image
        add(image);

        setBounds(250,200,980,470);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == add ) {

            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem(); ;
            String location = tflocation.getText();

            try {
                Conn conn = new Conn();
                String str = "insert into driver values ('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+available+"', '"+location+"')";

                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}

