
package employee_management_project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Print_Data implements ActionListener {

    JFrame f;
    JLabel id8, id, aid, id1, aid1, id2, aid2, id3, aid3, id4, aid4, id5, aid5, id6, aid6, id7, aid7, id9, id10, id11, id12, id13, id14, id15, id16, id17, lab;

    String name, email, password, designation, band, reporting_manager, allocated_project, phone_number, skill;

    JButton b1, b2;
    ImageIcon icon;

    Print_Data(String mail) {

        try {
            conn con = new conn();
            String str = "select * from employee_details where email = '" + mail + "'";
            ResultSet rs = con.s.executeQuery(str);

            while (rs.next()) {

                name = rs.getString("name");
                email = rs.getString("email");
//                password = rs.getString("password");
                designation = rs.getString("designation");
                band = rs.getString("band");
                reporting_manager = rs.getString("reporting_manager");
                allocated_project = rs.getString("allocated_project");
                phone_number = rs.getString("phone_number");
                skill = rs.getString("skill");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        f = new JFrame("Print Data");
        f.setVisible(true);
        f.setSize(595, 642);
        f.setLocation(450, 200);
        f.setBackground(Color.white);
        f.setLayout(null);

        id9 = new JLabel();
        id9.setBounds(0, 0, 595, 642);
        id9.setLayout(null);
        id8 = new JLabel("Employee Details");
        id8.setBounds(50, 10, 250, 30);
        f.add(id8);
        id8.setFont(new Font("serif", Font.BOLD, 25));
        id9.add(id8);
        f.add(id9);

        id1 = new JLabel("Name:");
        id1.setBounds(50, 120, 300, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(id1);

        aid1 = new JLabel(name);
        aid1.setBounds(400, 120, 300, 30);
        aid1.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(aid1);

        id2 = new JLabel("Email:");
        id2.setBounds(50, 170, 300, 30);
        id2.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(id2);

        aid2 = new JLabel(email);
        aid2.setBounds(400, 170, 300, 30);
        aid2.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(aid2);

        id3 = new JLabel("Designation:");
        id3.setBounds(50, 220, 300, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(id3);

        aid3 = new JLabel(designation);
        aid3.setBounds(400, 220, 300, 30);
        aid3.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(aid3);

        id4 = new JLabel("Band:");
        id4.setBounds(50, 270, 300, 30);
        id4.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(id4);

        aid4 = new JLabel(band);
        aid4.setBounds(400, 270, 300, 30);
        aid4.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(aid4);

        id5 = new JLabel("Reporting_manager:");
        id5.setBounds(50, 320, 300, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(id5);

        aid5 = new JLabel(reporting_manager);
        aid5.setBounds(400, 320, 300, 30);
        aid5.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(aid5);

        id6 = new JLabel("Allocated_project:");
        id6.setBounds(50, 370, 300, 30);
        id6.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(id6);

        aid6 = new JLabel(allocated_project);
        aid6.setBounds(400, 370, 300, 30);
        aid6.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(aid6);

        id7 = new JLabel("phone_number:");
        id7.setBounds(50, 420, 300, 30);
        id7.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(id7);

        aid7 = new JLabel(phone_number);
        aid7.setBounds(400, 420, 300, 30);
        aid7.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(aid7);

        b1 = new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100, 520, 100, 30);
        b1.addActionListener(this);
        id9.add(b1);

        b2 = new JButton("cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 520, 100, 30);
        b2.addActionListener(this);
        id9.add(b2);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            f.setVisible(false);
            details d = new details();
        }
        if (ae.getSource() == b2) {
            f.setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new Print_Data("Print Data");
    }

}
