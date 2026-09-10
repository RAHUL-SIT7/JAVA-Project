package Experiment18;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp18a extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton b1, b2;

    Exp18a() {
        setTitle("Simple Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");
        JLabel l3 = new JLabel("Result:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t3.setEditable(false);

        b1 = new JButton("Addition");
        b2 = new JButton("Subtraction");

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double n1 = Double.parseDouble(t1.getText());
        double n2 = Double.parseDouble(t2.getText());
        double result;

        if (e.getSource() == b1) {
            result = n1 + n2;
        } else {
            result = n1 - n2;
        }

        t3.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new Exp18a();
    }
}
