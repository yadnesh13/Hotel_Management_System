package Hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;

public class addemployee extends JFrame implements ActionListener {

    JTextField tfname, tfemail, tfphone, tfage , tfsalary , tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox<String> cbjob;

    addemployee () {
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);    //size & position of name
        lblname.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);   //text field of name
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);    //size & position of age
        lblage.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);    //text field of age
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);    //size & position of gender
        lblgender.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lblgender);

        rbmale = new JRadioButton("MALE");    //male button
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");    //female button
        rbfemale.setBounds(270,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);


        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);    //size & position of job
        lbljob.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lbljob);

        String[] str = { "Front Desk Clerk" , "Porters", "HouseKeeping" , "Kitchen  Staff" , "Room Service" , "Chefs" , "Waiters" , "Manager" , "Accountant"};
        cbjob = new JComboBox<>(str);
        cbjob.setBounds(200,180,150,30);     //dropbox
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);    //size & position of salary
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);    //size & position of phone
        lblphone.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);     ////text field of phone
        add(tfphone);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);    //size & position of email
        lblemail.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);     //text field of email
        add(tfemail);

        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(60,380,120,30);    //size & position of email
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN, 15));            //font of label
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);     //text field of email
        add(tfaadhar);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpeg"));   //bg image
        Image i2 = i1.getImage().getScaledInstance(850,540,Image.SCALE_DEFAULT);     // size and position
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,540);    //crop image
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300,170,850,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        String gender = null;

        if (name.equals ("")) {
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }

        if(rbmale.isSelected()) {
            gender = "Male";
        }
        else if(rbfemale.isSelected()){
            gender = "female";
        }

        String job = (String) cbjob.getSelectedItem();

        try{
            Conn conn = new Conn();

            String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"' , '"+job+"' , '"+salary+"' , '"+phone+"' , '"+email+"' , '"+aadhar+"')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employee added successfully");

            setVisible(false);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new addemployee();
    }
}
