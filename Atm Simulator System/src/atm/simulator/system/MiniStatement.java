package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton exit;
    JLabel mini;
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
        
        
        mini = new JLabel();
        add(mini);
        mini.setBounds(20, 140, 400, 200);
        
        JLabel bank = new JLabel("Nepal Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();// dynamically card num comes
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel(); // this label for balance display
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{// fetch the card number
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        	 
        try{
            int bal = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html> "+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Total Balance is Rs " + bal);// balance display
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        exit = new JButton("Exit");
        add(exit);
        exit.setBounds(20, 500, 100, 25);
        exit.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){ 
        System.exit(0);
       }
    }
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}