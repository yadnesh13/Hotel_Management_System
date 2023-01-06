package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADDRooms extends JFrame implements ActionListener {

    JButton add , cancel;
    JTextField tfroom, tfprice;
    JComboBox typecombo, availablecombo, cleancombo ;

    ADDRooms (){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms");         //ADD rooms font
        heading.setFont(new Font("Tahoma", Font.BOLD, 15));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblroomno = new JLabel("Rooms Number");         //ADD room number
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailable = new JLabel("Available");         //Available status
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);

        String[] avaliableOptions = { "Available", "Occupied"};
        availablecombo = new JComboBox(avaliableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lblclean = new JLabel("Cleaning Status");         //Clean status
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String[] cleanOptions = { "Cleaned", "Dirty"};
        cleancombo = new JComboBox(cleanOptions);    // clean drop box
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lbltype = new JLabel("Bed Type");         //Bed type
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbltype.setBounds(60,230,120,30);
        add(lbltype);

        String[] typeOptions = { "Single Bed", "Double bed"};
        typecombo = new JComboBox(typeOptions);    // Bed type drop box
        typecombo.setBounds(200,230,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

        JLabel lblprice = new JLabel("Price");         //Price of room
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblprice.setBounds(60,280,120,30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,280,150,30);
        add(tfprice);

        add = new JButton("Add Rooms");    //Add button
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");    //Add button
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));   //bg image
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);    //crop image
        add(image);

        setBounds(250,200,940,470);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == add ) {

            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

            try {
                Conn conn = new Conn();
                String str = "insert into room values ('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";

                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New room added successfully");

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ADDRooms();
    }
}
