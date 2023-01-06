package Hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard(){     // constructor
        setBounds(0,0,1366,786);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg2.png"));   //bg image
        Image i2 = i1.getImage().getScaledInstance(1366,786,Image.SCALE_DEFAULT);     // size and position
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1366,786);
        add(image);

        JLabel text = new JLabel("THE ELEPHANT ROUTE WELCOMES YOU ");     // txt
        text.setBounds(300,50,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN, 45));         //text size and font
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();         //menubar
        mb.setBounds(0,0,1366,35);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL CHECK-IN");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");   //admin menu
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddriver = new JMenuItem("ADD DRIVER");
        adddriver.addActionListener(this);
        admin.add(adddriver);


        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new addemployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new ADDRooms();
        } else if (ae.getActionCommand().equals("ADD DRIVER")) {
            new AddDriver();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
