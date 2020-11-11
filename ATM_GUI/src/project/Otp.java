package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Otp extends JFrame implements ActionListener
{
    String str="";
    int p=0;

    private  JTextField textField;
    private  JButton button;
    private JLabel label;

    atm cus = new atm();

    Random ran = new Random();
    int otp = 1000 + ran.nextInt(9000);

    Otp(String a , int b)
    {
        str = a;
        p=b;



        label = new JLabel("Enter the OTP sent to the console");
        label.setBounds(150,0,650,50);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("some" ,Font.HANGING_BASELINE , 18));
        label.setHorizontalTextPosition(JLabel.CENTER);

        textField = new JTextField("0");
        textField.setForeground(Color.green);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.magenta);
        textField.setPreferredSize(new Dimension(200,50));
        textField.setFont(new Font("Consolas" , Font.BOLD , 25));
        textField.setBounds(230,70,150,50);

        button = new JButton("Proceed");
        button.addActionListener(this);
        button.setVerticalAlignment(JButton.BOTTOM);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setBounds(260,140,100,30);
        button.setFocusable(false);
        button.setBackground(Color.MAGENTA);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650,230);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        this.add(label);
        this.add(textField);
        this.add(button);
        this.setLayout(null);
        this.setVisible(true);

        System.out.println(otp);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            this.dispose();
            String temp = textField.getText();
            int k = Integer.parseInt(temp);

            if(k == otp)
            {
                int b = cus.getBlock(str);
                if(b==0)
                {
                    new Options(str , p);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Your card is blocked." , "Blocked" , JOptionPane.WARNING_MESSAGE);
                    new MyFrame();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Wrong OTP" , "Otp check" , JOptionPane.WARNING_MESSAGE);
                new MyFrame();
            }
        }
    }
}
