 
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JLabel formno,personDetails,name,fname,dob,gender,email,marital,address,city,state,pin;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    
   
    SignupOne(){
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
         Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L) + 1000L);// for 4 digit +ve random num
    
        
        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
       
        
        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        
        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
       
        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
	dateChooser.setForeground(new Color(105, 105, 105));
	dateChooser.setBounds(300, 240, 400, 30);
	add(dateChooser);
   
        
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBackground(Color.WHITE);
        male.setBounds(300,290,60,30);
        add(male);
        
        
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(450,290,90,30);
        add(female);
 
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(female);
        
        
        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14)); 
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
       
        
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 14));
        married.setBackground(Color.WHITE);
        married.setBounds(300,390,100,30);
        add(married);
        
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 14));
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450,390,100,30);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD, 14));
        other.setBackground(Color.WHITE);
        other.setBounds(630,390,100,30);
        add(other);
        
        
        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(married);
        maritialgroup.add(unmarried);
        maritialgroup.add(other);
        
       
        
        
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
         
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
      
        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField= new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        
        pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,590,200,30);
        add(pin);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
       
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        add(next);
        next.addActionListener(this); 
        
        

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // long converted into string
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }else if(female.isSelected()){ 
            gender = "Female";
        }
            
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){ 
            marital = "Married";
        }else if(unmarried.isSelected()){ 
            marital = "Unmarried";
        }else if(other.isSelected()){ 
            marital = "Other";
        }
            
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pin = pinTextField.getText();
        String state = stateTextField.getText();
        
         try{
           
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");// validation for name field only, can do similar other field also...
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);//current frame close
                new SignupTwo(formno).setVisible(true);// and open next frame
             // formno is primary key required for signupTwo form also
                
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
   
    public static void main(String[] args){
        new SignupOne().setVisible(true);
    }
}
