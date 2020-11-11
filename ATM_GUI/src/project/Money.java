package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Money extends JFrame implements ActionListener
{
    atm cus = new atm();
    String str1 = "";
    String str2 = "";
    private JButton button;
    private JLabel label;
    private JTextField money;

    Money(String s1 , String  s2)
    {
        str1 = s1;
        str2 = s2;

        money = new JTextField("0");
        money.setFont(new Font("Consolas" , Font.BOLD , 25));
        money.setForeground(Color.green);
        money.setBackground(Color.BLACK);
        money.setCaretColor(Color.magenta);
        money.setPreferredSize(new Dimension(300,50));
        money.setBounds(200,50,150,50);

        button = new JButton("Proceed");
        button.setFocusable(false);
        button.addActionListener(this);
        // button.setVerticalAlignment(JButton.BOTTOM);

        button.setBounds(235,110,100,30);
        button.setHorizontalAlignment(JButton.CENTER);
        // button.setVerticalTextPosition(JButton.BOTTOM);

        label = new JLabel("Enter how much money you want to transfer");


        label.setFont(new Font("some" , Font.BOLD , 20));
        label.setBounds(50,10,600,30);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(label);
        this.add(money);
        this.add(button);
        this.setSize(600,210);
        this.setLayout(null);
        this.setVisible(true);

    }

   public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            String temp = money.getText();
            int cash = Integer.parseInt(temp);

            int bal = cus.balance(str1);
            this.dispose();
            if(cash<=0)
            {
                JOptionPane.showMessageDialog(null,"Not valid input" , "Failed" , JOptionPane.WARNING_MESSAGE);
                new MyFrame();
            }
            else if(cash>bal)
            {
                JOptionPane.showMessageDialog(null,"InSufficient balance" , "Failed" , JOptionPane.WARNING_MESSAGE);
                new MyFrame();
            }
            else
            {

                data.change(str1 , cash , 0);
                data.change(str2 , 0 , cash);
                JOptionPane.showMessageDialog(null,"Successfully Transfered" , "Done" , JOptionPane.INFORMATION_MESSAGE);
                new MyFrame();
            }
        }
    }
}
