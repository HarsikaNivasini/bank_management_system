
package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
        JButton deposit, withdrawl, pinchange, ministatement, fastcash, balanceenquiry, exit;
        String pinnumber;
        
       Transactions(String pinnumber) {
           
           this.pinnumber = pinnumber;
           setLayout(null);
           
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
          Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(0, 0, 900, 900);
           add(image);
           
           JLabel text = new JLabel("Please select your transaction");
           text.setBounds(200, 300, 700, 35);
           text.setForeground(Color.WHITE);
           text.setFont(new Font("Raleway", Font.BOLD, 16));
           add(text);
           
           deposit = new JButton("Deposit");
           deposit.setBounds(170, 415, 150, 30);
           deposit.addActionListener(this);
           add(deposit);
           
           withdrawl = new JButton("Cash withdrawl");
           withdrawl.setBounds(355, 415, 150, 30);
           withdrawl.addActionListener(this);
           add(withdrawl);
           
           fastcash = new JButton("Fast cash");
           fastcash.setBounds(170, 450, 150, 30);
           fastcash.addActionListener(this);
           add(fastcash);
           
           ministatement = new JButton("Ministatement");
           ministatement.setBounds(355, 450, 150, 30);
           ministatement.addActionListener(this);
           add(ministatement);
           
           pinchange = new JButton("Pin change");
           pinchange.setBounds(170, 485, 150, 30);
           pinchange.addActionListener(this);
           add(pinchange);
           
           balanceenquiry = new JButton("Balance enquiry");
           balanceenquiry.setBounds(355, 485, 150, 30);
           balanceenquiry.addActionListener(this);
           add(balanceenquiry);
           
           exit = new JButton("Exit");
           exit.setBounds(355, 520, 150, 30);
           exit.addActionListener(this);
           add(exit);
           
           setSize(900, 900);
           setLocation(300, 0);
           setUndecorated(true);
           setVisible(true);
           
       }
       
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }   
       
    public static void main(String args[]){
        
        new Transactions("");
    }   
}
