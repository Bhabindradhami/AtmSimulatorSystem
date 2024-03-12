package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;                               
    JLabel text,pintext,repintext;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        image.add(text);
        
        pintext = new JLabel("New PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        repintext = new JLabel("Re-Enter New PIN:");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,405,150,30);
        image.add(change);
        change.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
        
        setLayout(null);
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change) { 
            try {        
                String npin = pin.getText();
                String rpin = repin.getText();
         
                if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(npin.equals("")){
               JOptionPane.showMessageDialog(null, "Please Enter PIN");
               return;
            }   
            if (rpin.equals("")){
                JOptionPane.showMessageDialog(null, " Please Re-Enter new PIN");
                return;
                }
            
            Conn conn = new Conn();
            // update pinnumber from all table when user update pinnumber 
            String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
            String q2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
            String q3 = "update signup3 set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";

            conn.s.executeUpdate(q1);
            conn.s.executeUpdate(q2);
            conn.s.executeUpdate(q3);
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);// put updated pin rather than old pin, bcoz pin is updated every table
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        } else {
            setVisible(false);//close curent frame and goes to back frame
            new Transactions(pinnumber).setVisible(true);
            }
    }
    

    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}