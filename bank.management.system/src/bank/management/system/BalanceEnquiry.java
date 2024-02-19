package bank.management.system;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        //getContentPane().setBackground(Color.white);
        setSize(800,800);
        setLocation(500,80);
        setUndecorated(true);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,790,760);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(290, 450, 170, 28);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);
            
        Conn c= new Conn(); 
        int balance = 0;
        try
        {
                      
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                
                System.out.println("Check First Step.");
                while (rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                        System.out.println("Check positive balance.");
                    }
                    else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                        
                        System.out.println("Check negative balance.");
                    }
                }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        JOptionPane.showMessageDialog(null, "Your balance is Rs. "+balance);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}