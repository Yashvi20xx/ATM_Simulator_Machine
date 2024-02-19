
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withrawal extends JFrame implements ActionListener
{
    JTextField amount;
    JButton Withrawal, back;
    String pinnumber;
    Withrawal(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,790,760);
        add(image);
        
        JLabel text = new JLabel("Please enter the amount to Withrawal.");
        text.setBounds(110, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(110, 270, 335, 25);
        add(amount);
        
        Withrawal = new JButton("Withrawal");
        Withrawal.setBounds(290, 416, 170, 28);
        Withrawal.setForeground(Color.BLACK);
        Withrawal.setFont(new Font("Raleway", Font.BOLD, 16));
        Withrawal.addActionListener(this);
        image.add(Withrawal);
        
        back = new JButton("Back");
        back.setBounds(290, 450, 170, 28);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);
        
        setLayout(null);
        //getContentPane().setBackground(Color.white);
        setSize(800,800);
        setLocation(500,80);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Withrawal)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter amount.");
            }
            else
            {
                try 
                {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withrawal','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withrawal successfully.");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                
            }
        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Withrawal("");
    }
}
