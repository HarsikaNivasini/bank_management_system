
package bank_management_system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        
        try { 
            
             
              c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Sql@02");
              s=c.createStatement();
        }
        catch(Exception e){
           
            System.out.println(e);
        }
    }
    
}
