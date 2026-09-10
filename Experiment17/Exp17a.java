package Experiment17;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp17a extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3;
    JComboBox<String> c1;
    JButton b1;

    Exp17a() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        l1 = new JLabel("Student ID:");
        l2 = new JLabel("Name:");
        l3 = new JLabel("Course:");
        l4 = new JLabel("Gender:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        c1 = new JComboBox<>(new String[]{"Male", "Female", "Other"});

        b1 = new JButton("Register");
        b1.addActionListener(this);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(c1);
        add(new JLabel(""));
        add(b1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String id = t1.getText();
        String name = t2.getText();
        String course = t3.getText();
        String gender = (String) c1.getSelectedItem();

        JOptionPane.showMessageDialog(this,
                "Student Registration Successful!\n\n" +
                "Student ID: " + id +
                "\nName: " + name +
                "\nCourse: " + course +
                "\nGender: " + gender);
    }

    public static void main(String[] args) {
        new Exp17a();
    }
}
