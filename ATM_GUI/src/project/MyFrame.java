package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener
{
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JTextField acc;
    private JTextField pin;
    private JButton button;
    MyFrame()
    {


        label1 = new JLabel("Welcome to our ATM");
        label2 = new JLabel("Please enter your account no. and pin");

        label1.setBounds(120,10 , 350,90);
        label2.setBounds(130,40,400,90);
        label1.setForeground(Color.RED);
        label1.setVerticalAlignment(JLabel.TOP);
        label2.setVerticalAlignment(JLabel.BOTTOM);
        label1.setHorizontalAlignment(JLabel.CENTER);

        label1.setFont(new Font("Some" , Font.BOLD , 30));
        label2.setForeground(Color.BLUE);
        label2.setFont(new Font("Some" , Font.ITALIC , 20));

        JLabel label3 = new JLabel("ACC.No ");
        label3.setBounds(100,10,200,50);
        label3.setFont(new Font("some" , Font.ROMAN_BASELINE , 20));
        label3.setForeground(Color.GREEN);

        JLabel label4 = new JLabel("Pin");
        label4.setBounds(100,70,200,50);
        label4.setFont(new Font("some" , Font.ROMAN_BASELINE , 20));
        label4.setForeground(Color.BLACK);

        acc = new JTextField("0");
        pin = new JTextField("0");
        acc.setPreferredSize(new Dimension(200,50));
        acc.setBackground(Color.BLACK);
        acc.setForeground(Color.GREEN);
        acc.setBounds(200,10,200,50);
        acc.setCaretColor(Color.magenta);
        acc.setFont(new Font("some" , Font.BOLD , 25));

        pin.setPreferredSize(new Dimension(200,50));
        pin.setBackground(Color.GREEN);
        pin.setForeground(Color.BLACK);
        pin.setBounds(200,70,200,50);
        pin.setCaretColor(Color.RED);
        pin.setFont(new Font("some" , Font.BOLD , 25));

        button = new JButton("Submit");
        button.setBounds(250,130,100,40);
        button.setFocusable(false);
        button.addActionListener(this);

        panel1 = new JPanel();
        panel1.add(label1);
        panel1.add(label2);
        panel1.setBounds(0 , 0 , 600,180);
        //panel1.setBackground(Color.cyan);
        panel1.setLayout(null);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.add(acc);
        panel2.add(pin);
        panel2.add(button);
        panel2.add(label3);
        panel2.add(label4);
       // panel2.setBackground(Color.green);
        panel2.setBounds(0 ,190 , 600 , 320);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,500);
        this.setResizable(false);
        this.setLayout(null);
        this.add(panel1);
        this.add(panel2);
        this.setVisible(true);
        //this.pack();

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            this.dispose();
            String str =acc.getText();
            String temp = pin.getText();
            int p =  Integer.parseInt(temp);

            atm cus = new atm();
            boolean check = cus.validate(str , p);

            if(p<=0)
            {
                new Wrong();
                new MyFrame();
            }

            else if(check)
            {
                new Otp(str , p);
            }
            else
            {
                new Wrong();
                new MyFrame();
            }
        }
    }
}
