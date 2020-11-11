package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame implements ActionListener
{
    private  JRadioButton balance;
    private JRadioButton deposit;
    private JRadioButton withdraw;
    private JRadioButton change;
    private JRadioButton transfer;
    private JRadioButton block;
    String str = "";
    int p=0;
    atm cus = new atm();
    Options(String a , int b)
    {
        str = a;
        p = b;
        balance = new JRadioButton("Check balance");
        withdraw = new JRadioButton("Withdraw Cash");
        deposit = new JRadioButton("Deposit Cash");
        change = new JRadioButton("Change pin");
        transfer = new JRadioButton("Transfer to another account");
        block = new JRadioButton("Block my card");

        balance.addActionListener(this);
        withdraw.addActionListener(this);
        deposit.addActionListener(this);
        change.addActionListener(this);
        transfer.addActionListener(this);
        block.addActionListener(this);


        ButtonGroup group = new ButtonGroup();
        group.add(balance);
        group.add(withdraw);
        group.add(deposit);
        group.add(change);
        group.add(transfer);
        group.add(block);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLayout(new GridLayout(6,1));

        this.add(balance);
        this.add(withdraw);
        this.add(deposit);
        this.add(change);
        this.add(transfer);
        this.add(block);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == balance)
        {
            this.dispose();
            new Balance(str , p);
            new MyFrame();
        }
        else if(e.getSource() == withdraw)
        {
            this.dispose();
            new Withdraw(str , p);
            //new MyFrame();
        }
        else if(e.getSource() == deposit)
        {
            this.dispose();
            new Deposit(str);
        }
        else if(e.getSource() == change)
        {
            this.dispose();
            new Change(str);
        }
        else if(e.getSource() == transfer)
        {
            this.dispose();
            new Transfer(str);
        }
        else if(e.getSource() == block)
        {
            this.dispose();
            cus.setBlock(str);
            JOptionPane.showMessageDialog(null,"Your acc. is blocked. Visit bank to unblock" , "Blocked" , JOptionPane.WARNING_MESSAGE);
            new MyFrame();
        }
    }
}
