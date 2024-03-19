
package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
        
        JButton log;
        JButton clear;
        JButton signup;
        JTextField cardTextField;
        JPasswordField pinTextField;
        
        
        public Login(){
            
            setTitle("Automated Teller Machine");
            setLayout(null);
                                                 
            
            ImageIcon i1 = new ImageIcon("icons/logo.jpg");
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);  
            JLabel label = new JLabel(i3);
            label.setBounds(70, 10, 100, 1000);
            add(label);      
                  
            JLabel text = new JLabel("Welcome to ATM");
            text.setFont(new Font("Osward", Font.BOLD, 38));
            text.setBounds(200, 40, 400, 40);
            add(text);
            
            JLabel cardno = new JLabel("Card no: ");
            cardno.setFont(new Font("Raleway", Font.BOLD, 28));
            cardno.setBounds(120, 150, 150, 30);
            add(cardno);
            
            cardTextField = new JTextField();
            cardTextField.setBounds(300, 150, 230, 30);
            cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
            add(cardTextField);
            
            JLabel pin = new JLabel("PIN: ");
            pin.setFont(new Font("Raleway", Font.BOLD, 30));
            pin.setBounds(120, 220, 250, 30);
            add(pin);
            
            pinTextField = new JPasswordField();
            pinTextField.setBounds(300, 220, 230, 30);
            pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
            add(pinTextField);
            
            log = new JButton("SIGN IN");
            log.setBounds(300, 300, 100, 30);
            log.setBackground(Color.BLACK);
            log.setForeground(Color.WHITE);
            log.addActionListener(this);
            add(log);
            
            clear = new JButton("CLEAR");
            clear.setBounds(430, 300, 100, 30);
            clear.setBackground(Color.BLACK);
            clear.setForeground(Color.WHITE);
            clear.addActionListener(this);
            add(clear);
            
            signup = new JButton("SIGNUP");
            signup.setBounds(300, 350, 230, 30);
            signup.setBackground(Color.BLACK);
            signup.setForeground(Color.WHITE);
            signup.addActionListener(this);
            add(signup);
            
            getContentPane().setBackground(Color.WHITE);
            setSize(800,480);
            setVisible(true);
            setLocation(350,200);
        }
      
        public void actionPerformed(ActionEvent ae){
            System.out.println("source:"+ae.getSource());
            if(ae.getSource() == clear ){
                
                cardTextField.setText("");
                pinTextField.setText("");
            }
             
            else if(ae.getSource() == log ){
              
               try{ 
                   Conn conn = new Conn();
                 if(conn!=null){
               
                 String cardnumber = cardTextField.getText();
                 String pinnumber = pinTextField.getText();
                 String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
               
                   ResultSet rs = conn.s.executeQuery(query);
                   if(rs.next()){
                       setVisible(false);
                       new Transactions(pinnumber).setVisible(true);
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "Incorrect card no or pin");
                   }
                       
               }
                else {
                JOptionPane.showMessageDialog(null, "Database connection is not available.");
                }
               }
               catch(Exception e){
//                   System.out.println(e);
                    e.printStackTrace();
               }
            }
            
            else if(ae.getSource() == signup ){
                
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        }
    public static void main(String args[]){
        Login login  = new Login();
    }

   
}
