package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener
{
    JButton deposit, fastCash, pinChange, cashWithdraw, miniStatement, balanceEnquiry, exit;
    String pinnumber;
    Transactions(String pinnumber)
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
        
        JLabel text = new JLabel("Please select your transaction.");
        text.setBounds(140, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(100, 348, 170, 28);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway", Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(100, 382, 170, 28);
        fastCash.setForeground(Color.BLACK);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 16));
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(100, 415, 170, 28);
        pinChange.setForeground(Color.BLACK);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 16));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        cashWithdraw = new JButton("Cash Withdrawal");
        cashWithdraw.setBounds(290, 348, 170, 28);
        cashWithdraw.setForeground(Color.BLACK);
        cashWithdraw.setFont(new Font("Raleway", Font.BOLD, 16));
        cashWithdraw.addActionListener(this);
        image.add(cashWithdraw);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(290, 382, 170, 28);
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(290, 416, 170, 28);
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 16));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
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
            System.exit(0);
        }
        else if (ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == cashWithdraw)
        {
            setVisible(false);
            new Withrawal(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == fastCash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == pinChange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == balanceEnquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == miniStatement)
        {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Transactions("");
    }
}
