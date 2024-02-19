package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
    JButton back, change;
    JPasswordField repin, pin;
    String pinnumber;
    PinChange(String pinchange)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        setSize(800,800);
        setLocation(500,80);
        setUndecorated(true);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,790,760);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(210, 210, 700, 45);
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 18));
        pintext.setBounds(110, 260, 300, 45);
        image.add(pintext);
        
        pin= new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(350,260,100,35);
        pin.setForeground(Color.BLACK);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-enter your PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 18));
        repintext.setBounds(110, 300, 300, 45);
        image.add(repintext);
        
        repin= new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(350,300,100,35);
        repin.setForeground(Color.BLACK);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(100, 348, 170, 28);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("Raleway", Font.BOLD, 16));
        change.addActionListener(this);
        image.add(change);
                
        back = new JButton("Back");
        back.setBounds(290, 450, 170, 28);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == change)
        {
            try 
            {
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Pin dosen't match.");
                    return;
                }
                else if (rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter Pin Please.");
                    return;
                }
                else if (rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter Pin Please.");
                    return;
                }
                Conn conn = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                //String q2 = "update login set pin = '"+repin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                
                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "Pin Changed.");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            }
            catch (Exception e)
            {
            System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
        
    }
    
    public static void main(String args[])
    {
        new PinChange("");
    }
}
