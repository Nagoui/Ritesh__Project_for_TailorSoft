package employee_management_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Update_user extends Add_Employee implements ActionListener {

    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id15, lab, lab1;
    JTextField t, t1, t2, t3;
    JButton b, b1;
    String id_emp;

    Update_user(String mail) {
        super(0);
        f = new JFrame("update details");
        f.setVisible(true);
        f.setSize(900, 500);
        f.setLocation(450, 250);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_emp = mail;
        id15 = new JLabel();
        id15.setBounds(0, 0, 900, 500);
        id15.setLayout(null);

        id8 = new JLabel("Update Employee Detail:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id1 = new JLabel("Name:");
        id1.setBounds(50, 100, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id1);

        t1 = new JTextField();
        t1.setBounds(200, 100, 150, 30);
        id15.add(t1);

        id2 = new JLabel("Skill:");
        id2.setBounds(400, 100, 200, 30);
        id2.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id2);

        t2 = new JTextField();
        t2.setBounds(600, 100, 150, 30);
        id15.add(t2);

        id3 = new JLabel("Phone_number:");
        id3.setBounds(50, 150, 100, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id3);

        t3 = new JTextField();
        t3.setBounds(200, 150, 150, 30);
        id15.add(t3);

        b = new JButton("update");
        b.setBounds(250, 400, 100, 30);
        b.addActionListener(this);
        id15.add(b);

        b1 = new JButton("Cancel");
        b1.setBounds(450, 400, 100, 30);
        b1.addActionListener(this);
        id15.add(b1);

        showData(mail);
    }

    int i = 0;

    void showData(String s) {
        try {
            conn con = new conn();
            String str = "select * from employee_details where email = '" + s + "'";
            ResultSet rs = con.s.executeQuery(str);

            if (rs.next()) {
                f.setVisible(true);
                i = 1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(9));
                t3.setText(rs.getString(8));

            }
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Id not found");
            }
            new User_Details(id_emp);
        } catch (Exception ex) {
        }
        f.setVisible(true);
        f.setSize(900, 500);
        f.setLocation(400, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b && i == 1) {
            try {
                conn con = new conn();
                String str = "update employee_details set name='" + t1.getText() + "',skill='" + t2.getText() + "',phone_number='" + t3.getText() + "'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "successfully updated");
                f.setVisible(false);
                new User_Details(id_emp);
            } catch (Exception e) {
                System.out.println("The error is:" + e);
            }
        }
        if (ae.getSource() == b1) {
            f.setVisible(false);
            details d = new details();
        }
    }

    public static void main(String[] arg) {
        new Update_user("Update Employee");
    }
}
