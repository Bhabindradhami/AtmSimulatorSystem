package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel text;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(210,300,700,35);
        image.add(text);
        
       
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);
        
        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(355,450,150,30);
        image.add(ministatement);
        ministatement.addActionListener(this);
        
        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(170,485,150,30);
        image.add(pinchange);
        pinchange.addActionListener(this);
        
        balanceenquiry = new JButton("BALANCE ENQUIRY");
        balanceenquiry.setBounds(355,485,150,30);
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);
        
        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        image.add(exit);
        exit.addActionListener(this);
        
        setLayout(null);
        setSize(900,900);
        setLocation(500,0);
        setUndecorated(true);// remove top white line
        setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== exit){ 
            System.exit(0);
        } else if(ae.getSource()== deposit){ 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()== withdrawl ){ 
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource()== fastcash ){ 
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource()== pinchange ){ 
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource()== balanceenquiry ){ 
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource()== ministatement ){ 
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}