package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame implements ActionListener
{
    atm cus = new atm();
    String str = "";
    private JLabel label1;
    private JLabel label2;
    private JTextField textField;
    private JButton button;
    Deposit(String temp)
    {
        str = temp;

        label1 = new JLabel("Enter how much money, you want to deposit");
        label1.setBounds(160,0,400,30);
        label1.setForeground(Color.DARK_GRAY);
        label1.setFont(new Font("some" ,Font.HANGING_BASELINE , 18));
        label1.setHorizontalTextPosition(JLabel.CENTER);

        label2 = new JLabel("depositing money should be a multiple of 100");
        label2.setBounds(150,40,400,30);
        label2.setForeground(Color.DARK_GRAY);
        label2.setFont(new Font("some" ,Font.HANGING_BASELINE , 18));
        label2.setHorizontalTextPosition(JLabel.CENTER);

        textField = new JTextField("0");
        textField.setForeground(Color.green);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.magenta);
        textField.setPreferredSize(new Dimension(200,50));
        textField.setBounds(180,90,300,50);

        button = new JButton("Proceed");
        button.addActionListener(this);
        button.setVerticalAlignment(JButton.BOTTOM);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setBounds(270,150,100,30);
        button.setFocusable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650,250);
        this.setResizable(false);
        this.setLayout(null);

        this.add(label1);
        this.add(label2);
        this.add(textField);
        this.add(button);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            this.dispose();
            String temp = textField.getText();
            int add_amount = Integer.parseInt(temp);
            if(add_amount % 100 != 0)
            {
                JOptionPane.showMessageDialog(null , "add. amount is not a multiple of 100. UnSuccessful . Try Again" , "Can't proceed" , JOptionPane.ERROR_MESSAGE);
                new MyFrame();
            }
            else if(add_amount <= 0)
            {
                JOptionPane.showMessageDialog(null , "not valid input" , "Can't proceed" , JOptionPane.WARNING_MESSAGE);
                new MyFrame();
            }
            else
            {

                data.change(str , 0 , add_amount);
                cus.totalChange(add_amount);
                JOptionPane.showMessageDialog(null,"Deposit of money is Successful" , "Success" , JOptionPane.INFORMATION_MESSAGE);
                new MyFrame();
            }
        }
    }
}
