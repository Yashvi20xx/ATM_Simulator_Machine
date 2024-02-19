package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton deposit, fastCash, pinChange, cashWithdraw, miniStatement, balanceEnquiry, exit;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
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
        
        JLabel text = new JLabel("Select withdrawal amount.");
        text.setBounds(140, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(text);
        
        deposit = new JButton("100");
        deposit.setBounds(100, 348, 170, 28);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway", Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        fastCash = new JButton("500");
        fastCash.setBounds(100, 382, 170, 28);
        fastCash.setForeground(Color.BLACK);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 16));
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        pinChange = new JButton("1000");
        pinChange.setBounds(100, 415, 170, 28);
        pinChange.setForeground(Color.BLACK);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 16));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        cashWithdraw = new JButton("2000");
        cashWithdraw.setBounds(290, 348, 170, 28);
        cashWithdraw.setForeground(Color.BLACK);
        cashWithdraw.setFont(new Font("Raleway", Font.BOLD, 16));
        cashWithdraw.addActionListener(this);
        image.add(cashWithdraw);
        
        miniStatement = new JButton("5000");
        miniStatement.setBounds(290, 382, 170, 28);
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        balanceEnquiry = new JButton("10000");
        balanceEnquiry.setBounds(290, 416, 170, 28);
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 16));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Back");
        exit.setBounds(290, 450, 170, 28);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Raleway", Font.BOLD, 16));
        exit.addActionListener(this);
        image.add(exit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            System.out.println("Back.");
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText(); 
            System.out.println(amount);
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                System.out.println("Check First Step.");
                while(rs.next())
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
                if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient  Balance");
                    return;
                }
                else
                {
                    Date date = new Date();
                    System.out.println("Check query row.");
                    String query = ("insert into bank values('"+pinnumber+"', '"+date+"', 'Withrawal', '"+amount+"')");
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+"  Debited succcesfully.");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String args[])
    {
        new FastCash("");
    }
}
