package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel pin,text,cardno;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton login,clear,signup;
  
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);
        
        cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField = new JTextField(15);
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField = new JPasswordField(15);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300,220,230,30);
        add( pinTextField);
                
        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300,300,100,30);
        add(login);
        login.addActionListener(this);

        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430,300,100,30);
        add(clear);
        clear.addActionListener(this);

        
        
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,230,30);
        add(signup);
        signup.addActionListener(this);
   
        
        setLayout(null);
      
      
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
      
        if(ae.getSource()== clear){
                cardTextField.setText("");
                pinTextField.setText("");
        } else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query  = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            
            if(cardnumber.equals("")){
               JOptionPane.showMessageDialog(null, "Please Enter Card number");
               return;
            }   
            if (pinnumber.equals("")){
                JOptionPane.showMessageDialog(null, " Please Enter PIN number");
                return;
                }
            
            // take data from database
            try {
               ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){ // if data got then user sucessfully login and close current frame and open other freme Transactions
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                 e.printStackTrace();
            }
            } else if(ae.getSource()== signup) {
                setVisible(false);// close current form 
                new SignupOne().setVisible(true);// and open signup form
                
            }
       
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}