package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Change extends JFrame implements ActionListener
{
    String str = "";
    JLabel label1;
    JLabel label2;
    JTextField textField;
    JButton button;
    Change(String k)
    {
        str = k;

        label1 = new JLabel("Enter the new pin");
        label1.setBounds(200,0,200,30);
        label1.setForeground(Color.DARK_GRAY);
        label1.setFont(new Font("some" ,Font.HANGING_BASELINE , 18));
        label1.setHorizontalTextPosition(JLabel.CENTER);

        label2 = new JLabel("The new Pin should be of 5 digits");
        label2.setForeground(Color.RED);
        label2.setBounds(170,32,250,30);
        label2.setFont(new Font("some" , Font.HANGING_BASELINE , 15));

        textField = new JTextField("0");
        textField.setForeground(Color.green);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.magenta);
        textField.setPreferredSize(new Dimension(250,50));
        textField.setBounds(200, 75,150,50);

        button = new JButton("Proceed");
        button.addActionListener(this);
        button.setVerticalAlignment(JButton.BOTTOM);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setFocusable(false);
        button.setBounds(210,135,120,30);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,220);
        this.setResizable(false);
        this.setLayout(null);
        this.add(label1);
        this.add(label2);

        this.add(textField);
        this.add(button);

        this.setVisible(true);
    }

    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            this.dispose();
            String temp = textField.getText();
            int nP = Integer.parseInt(temp);

            boolean check = data.pinChange(str , nP);
            if(check)
            {
                JOptionPane.showMessageDialog(null,"Pin change is Successful" , "Success" , JOptionPane.INFORMATION_MESSAGE);
                new MyFrame();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Pin change is UnSuccessful" , "UnSuccess" , JOptionPane.ERROR_MESSAGE);
                new MyFrame();
            }
        }
    }
}
