package employee_management_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class User_Details implements ActionListener {

    JFrame f;
    JLabel l1, l2;
    JButton b1, b2, b3, b4;
    String logins;

    User_Details(String log) {
        logins = log;
        f = new JFrame("User Module");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 700, 500);
        l1.setLayout(null);
        f.add(l1);

        l2 = new JLabel("User Module");
        l2.setBounds(230, 20, 200, 40);
        l2.setFont(new Font("serif", Font.BOLD, 25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1 = new JButton("Search");
        b1.setBounds(130, 80, 100, 40);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("View");
        b2.setBounds(330, 80, 100, 40);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.addActionListener(this);
        l1.add(b2);

        b4 = new JButton("Edit Details");
        b4.setBounds(130, 140, 300, 40);
        b4.setFont(new Font("serif", Font.BOLD, 15));
        b4.addActionListener(this);
        l1.add(b4);

        f.setVisible(true);
        f.setSize(700, 300);
        f.setLocation(450, 200);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            new View_Employee();
        }
        if (ae.getSource() == b2) {
            f.setVisible(false);

            new Print_User(logins);
        }

        if (ae.getSource() == b4) {
            new Update_Employee(this.logins);
            f.setVisible(false);
        }
    }

    public static void main(String[] arg) {
        User_Details d = new User_Details("Login Details");
    }
}
