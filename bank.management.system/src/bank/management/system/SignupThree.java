package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener
{
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno)
    {
        this.formno = formno;
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(800,800);
        setVisible(true);
        setLocation(500,80);
        
        
        JLabel l1 = new JLabel("Page 3 : Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1= new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 180, 20);
        add(r1);
        
        r2= new JRadioButton("Fixed Depost Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 260, 20);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 180, 20);
        add(r3);
        
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 260, 20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel l2 = new JLabel("Card Number");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(100, 300, 200, 30);
        add(l2);
        
        JLabel l3 = new JLabel("XXXX-XXXX-XXXX-4129");
        l3.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.setBounds(330, 300, 250, 30);
        add(l3);
        
        JLabel l35 = new JLabel("Your 16 digit card number.");
        l35.setFont(new Font("Raleway", Font.BOLD, 12));
        l35.setBounds(100, 330, 300, 20);
        add(l35);
        
        JLabel l4 = new JLabel("PIN : ");
        l4.setFont(new Font("Raleway", Font.BOLD, 22));
        l4.setBounds(100, 370, 200, 30);
        add(l4);
        
        JLabel l45 = new JLabel("Your 4 digit PIN");
        l45.setFont(new Font("Raleway", Font.BOLD, 12));
        l45.setBounds(100, 400, 300, 20);
        add(l45);
        
        JLabel l5 = new JLabel("XXXX");
        l5.setFont(new Font("Raleway", Font.BOLD, 22));
        l5.setBounds(330, 370, 250, 30);
        add(l5);
        
        JLabel l6 = new JLabel("Services Required : ");
        l6.setFont(new Font("Raleway", Font.BOLD, 22));
        l6.setBounds(100, 450, 400, 30);
        add(l6);
        
        c1= new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        
        c4= new JCheckBox("E-mail/SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        
        c5= new JCheckBox("Chque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6= new JCheckBox("E-statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        
        c7= new JCheckBox("I accept the terms and conditions.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100, 680, 600, 30);
        add(c7);
        
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== submit)
        {
            String accountType = null;
            if(r1.isSelected())
            {
                accountType = "Saving Account";
            }
            else if(r2.isSelected())
            {
                accountType = "Fixed Deposit Account";
            }
            else if(r3.isSelected())
            {
                accountType = "Current Account";
            }
            else if(r4.isSelected())
            {
                accountType = "Recurring Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)) + 5040936000000000L;
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if (c1.isSelected())
            {
                facility = facility + "ATM Card";
            }
            else if (c2.isSelected())
            {
                facility = facility + " Internet Banking";
            }
            else if (c3.isSelected())
            {
                facility = facility + " Mobile Banking";
            }
            else if (c4.isSelected())
            {
                facility = facility + " Email/SMS Alerts";
            }
            else if (c5.isSelected())
            {
                facility = facility + " Cheque Book";
            }
            else if (c6.isSelected())
            {
                facility = facility + " E-Statement";
            }
            
            try
            {
                if(accountType.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Account Type is required.");
                }
                else
                {
                    Conn conn = new Conn();
                    String query =  "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:"+ pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == cancel)
        {
            JOptionPane.showMessageDialog(null, "Process Cancelled Successsfully");
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new SignupThree("");
    }
}
