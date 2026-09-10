package Experiment18;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp18b extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton b1, b2;

    Exp18b() {
        setTitle("Bank Balance Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel l1 = new JLabel("Initial Balance:");
        JLabel l2 = new JLabel("Transaction Amount:");
        JLabel l3 = new JLabel("Updated Balance:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t3.setEditable(false);

        b1 = new JButton("Deposit");
        b2 = new JButton("Withdraw");

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
        double balance = Double.parseDouble(t1.getText());
        double amount = Double.parseDouble(t2.getText());
        double updatedBalance;

        if (e.getSource() == b1) {
            updatedBalance = balance + amount;
        } else {
            updatedBalance = balance - amount;
        }

        t3.setText(String.valueOf(updatedBalance));
    }

    public static void main(String[] args) {
        new Exp18b();
    }
}
