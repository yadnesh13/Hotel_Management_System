package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class Intro extends JFrame implements ActionListener {

    Intro(){
        setSize(1051,662);     //parameters for background image
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bg1.png"));     //importing image from files
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1051,662);       //loctn x, loctn y, length , breadth
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");     //for text addition
        text.setBounds(20,10,1000,80);
        text.setForeground(Color.WHITE);               // text colour
        text.setFont(new Font("Gotham", Font.PLAIN,45));     //font name & size
        image.add(text);

        JButton next = new JButton("Next");    //button & txt on it
        next.setBounds(850,550,120,40);        // position of button
        next.setBackground(Color.WHITE);               // button colour
        next.setForeground(Color.BLACK);               // text colour
        next.addActionListener(this);
        next.setFont(new Font("Gotham", Font.PLAIN,15));
        image.add(next);


        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);            //closes intro page & open login page
        new Login();
    }

    public static void main(String[] args) {
        Intro screen=new Intro();
    }
}
