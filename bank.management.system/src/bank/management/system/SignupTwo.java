package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener
{
    long random;
    JTextField pan, aadhar;
    JButton next;
    JComboBox religion, category, occupation, education, income;
    JRadioButton syes, sno, eyes, eno;
    String formno;
    SignupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        getContentPane().setBackground(Color.white);
        setSize(800,800);
        setVisible(true);
        setLocation(500,80);
        //System.out.println(formno);
        
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valcategory[] = {"General", "OBC", "SC", "ST"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String valIncome[] = {"Null", "<1,50,000", "1,50,000<2,50,000", "2,50,000<5,00,000", ">5,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification : ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String educationVal[] = {"Non Grad", "Grad", "Post Grad", "Mastery", "Other"};
        education = new JComboBox(educationVal);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel Marital = new JLabel("Occupation : ");
        Marital.setFont(new Font("Raleway", Font.BOLD, 22));
        Marital.setBounds(100, 390, 200, 30);
        add(Marital);
        
        String occupationVal[] = {"Salaried", "Self Employed", "Business", "Retired", "Other"};
        occupation = new JComboBox(occupationVal);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address = new JLabel("PAN No. : ");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar No. : ");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        
        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);        
        
        sno = new JRadioButton("No");
        sno.setBackground(Color.WHITE);
        sno.setBounds(450, 540, 100, 30);
        add(sno);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(syes);
        senior.add(sno);
                
        JLabel pincode = new JLabel("Exisitng Account? : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);        
        
        eno = new JRadioButton("No");
        eno.setBackground(Color.WHITE);
        eno.setBounds(450, 590, 100, 30);
        add(eno);
        
        ButtonGroup exist = new ButtonGroup();
        exist.add(eyes);
        exist.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
    }
    public void actionPerformed(ActionEvent ae)
    {
        //String formno = ""+ random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String sseniorcitizen = null;
        if(syes.isSelected())
        {
            sseniorcitizen = "Yes";
        }
        else if (sno.isSelected())
        {
            sseniorcitizen = "No";
        }
        
        String sexisting = null;
        if (eyes.isSelected())
        {
            sexisting = "Yes";
        }
        else if (eno.isSelected())
        {
            sexisting = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try // validation
        {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexisting+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }   

    public static void main(String args[])
    {
        new SignupTwo("");
    }
}