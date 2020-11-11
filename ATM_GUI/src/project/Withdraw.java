package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw extends JFrame implements ActionListener
{
    atm cus = new atm();
    int req_amount=0;
    JLabel label1;
    JLabel label2;
    JTextField textField;
    JButton button;
    String str = "";
    int p = 0;
    Withdraw(String s , int k)
    {
        str = s;
        p = k;

        label1 = new JLabel("Enter how much money, you want to withdraw");
        label2 = new JLabel("The required amount must be a multiple of 100, else you will be directed to the main screen");

        label1.setBounds(80,0,430,30);
        label1.setForeground(Color.DARK_GRAY);
        label1.setFont(new Font("some" , Font.CENTER_BASELINE , 18));
        label2.setForeground(Color.RED);
        label2.setBounds(30,35,600,30);
        label2.setFont(new Font("some" , Font.HANGING_BASELINE , 15));

        textField = new JTextField("0");
        textField.setForeground(Color.green);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.magenta);
        textField.setPreferredSize(new Dimension(200,50));
        textField.setBounds(220,70,150,45);

        button = new JButton("Proceed");
        button.addActionListener(this);
        button.setVerticalAlignment(JButton.BOTTOM);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setFocusable(false);
        button.setBounds(250,130,100,25);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650,210);
        this.setResizable(false);
        this.setLayout(null);
        this.add(label1);
        this.add(label2);
        this.add(textField);
        this.add(button);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            this.dispose();
            String temp = textField.getText();
            int req_amount = Integer.parseInt(temp);
            int bal = cus.balance(str);
            if(req_amount % 100 != 0)
            {
                JOptionPane.showMessageDialog(null , "Req. amount is not a multiple of 100. UnSuccessful . Try Again" , "Can't proceed" , JOptionPane.ERROR_MESSAGE);
                new MyFrame();
            }
            else if(req_amount <= 0)
            {
                JOptionPane.showMessageDialog(null , "not valid input" , "Can't proceed" , JOptionPane.WARNING_MESSAGE);
                new MyFrame();
            }
            else if(req_amount <= bal && req_amount<=cus.total())
            {
                data.change(str , req_amount , 0);
                cus.totalChange(-1*req_amount);
                JOptionPane.showMessageDialog(null,"Withdraw of amount is successful" , "Success" , JOptionPane.INFORMATION_MESSAGE);
                //new ThankYou();
                new MyFrame();
            }
            else if(req_amount > bal)
            {
                JOptionPane.showMessageDialog(null, "Your account balance is insufficient", "UnSuccessful" , JOptionPane.ERROR_MESSAGE);
                new MyFrame();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"ATM doesn't have that much amount now. Sorry for the inconvinience" , "inConvinience" , JOptionPane.ERROR_MESSAGE);
                new MyFrame();
            }

        }
    }

}
