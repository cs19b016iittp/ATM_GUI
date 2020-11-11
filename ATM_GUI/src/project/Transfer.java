package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transfer extends JFrame implements ActionListener
{
    atm acc = new atm();
    String str1 = "";
    String str2 = "";

    private JPanel panel1;

    private JLabel label1;

    private JTextField account;

    private JButton button;
    Transfer(String s)
    {
        str1 = s;

        account = new JTextField();
        account.setFont(new Font("Consolas" , Font.BOLD , 25));
        account.setForeground(Color.green);
        account.setBackground(Color.BLACK);
        account.setCaretColor(Color.magenta);
        account.setPreferredSize(new Dimension(300,50));
        account.setBounds(200,50,150,50);

        button = new JButton("Proceed");
        button.setFocusable(false);
        button.addActionListener(this);
       // button.setVerticalAlignment(JButton.BOTTOM);

        button.setBounds(235,110,100,30);
        button.setHorizontalAlignment(JButton.CENTER);
       // button.setVerticalTextPosition(JButton.BOTTOM);

        label1 = new JLabel("Enter the Acc.No. to which you want to transfer Money");


        label1.setFont(new Font("some" , Font.BOLD , 20));
        label1.setBounds(20,10,600,30);

       // panel1 = new JPanel();


        //panel1.setBounds(0,0,600,180);

       // panel1.setBackground(Color.cyan);




      //  panel1.add(label1);
       // panel1.add(account);
        //panel1.add(button);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // this.add(panel1);
       this.setResizable(false);
       this.add(label1);
       this.add(account);
       this.add(button);
        this.setSize(600,210);
        this.setLayout(null);
        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            str2 = account.getText();
            boolean check = acc.validate(str2 , 0);

            if(check)
            {
                this.dispose();
                new Money(str1 , str2);
            }
            else
            {
                this.dispose();
                JOptionPane.showMessageDialog(null , "Account doesn't exist" , "Invalid Account" ,JOptionPane.ERROR_MESSAGE );
                new MyFrame();
            }
        }
    }
}
