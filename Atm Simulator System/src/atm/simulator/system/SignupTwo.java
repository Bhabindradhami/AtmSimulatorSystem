 
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JLabel additionalDetails,name,fname,dob,gender,email,marital,address,city,state,pin;
    JTextField pan,aadhar;
    JRadioButton syes, sno, eyes ,eno;
    JButton next;
    JComboBox religion, category,occupation,income, education;
    String formno;
   
    SignupTwo(String formno) {
        this.formno = formno;// formno primary also needed for signupTwo form
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
     
        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
       
        
        name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setFont(new Font("Raleway", Font.BOLD, 14));
        religion.setBounds(300,140,400,30);
        add(religion);
        
       
        fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        category.setFont(new Font("Raleway", Font.BOLD, 14));
        add(category);
       
        
        dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        income.setFont(new Font("Raleway", Font.BOLD, 14));
        add(income);
       
        
        gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        email = new JLabel("Qualificaton:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationValues[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        education.setFont(new Font("Raleway", Font.BOLD, 14));
        add(education);
        
     
        
        marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        occupation.setFont(new Font("Raleway", Font.BOLD, 14));
        add(occupation);
        
        
        address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
         
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        
        
        city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
      
        
        state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Raleway", Font.BOLD, 14));
        syes.setBackground(Color.WHITE);
        syes.setBounds(300,540,100,30);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setFont(new Font("Raleway", Font.BOLD, 14));
        sno.setBackground(Color.WHITE);
        sno.setBounds(450,540,100,30);
        add(sno);
       
        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(syes);
        maritialgroup.add(sno);
        
        pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,590,200,30);
        add(pin);
        
        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway", Font.BOLD, 14));
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300,590,100,30);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway", Font.BOLD, 14));
        eno.setBackground(Color.WHITE);
        eno.setBounds(450,590,100,30);
        add(eno);
       
        ButtonGroup emaritialgroup = new ButtonGroup();
        emaritialgroup.add(eyes);
        emaritialgroup.add(eno);
       
       
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
        String sreligion = (String)religion.getSelectedItem();// value taken from dropdown combo box and convert into string 
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        String seniorcitizen = null;
        if(syes.isSelected()) {
         seniorcitizen ="Yes";
        }
        else if(sno.isSelected()) {
         seniorcitizen ="No";
        }
         
           
        String existingaccount = null;
        if(eyes.isSelected()){ 
            existingaccount = "Yes";
        }else if(eno.isSelected()){ 
            existingaccount = "No";
        }
        
        try{
             Conn c = new Conn();
              String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
             c.s.executeUpdate(query);
             
             setVisible(true);//close current frame
             new SignupThree(formno).setVisible(true);        
             
             
        } catch (Exception e)  {
             e.printStackTrace();
        }
     }
   
    public static void main(String[] args){
        new SignupTwo("").setVisible(true);
    }
}
