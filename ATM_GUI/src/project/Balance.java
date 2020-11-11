package project;

import javax.swing.*;

public class Balance extends JFrame
{
    Balance(String str , int p)
    {
        atm cus = new atm();
        int amount = cus.balance(str);

       JOptionPane.showMessageDialog(null,"Your account has a balance of " + amount , "Balance Information" , JOptionPane.INFORMATION_MESSAGE);
    }
}
