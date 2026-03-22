/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class databaseConnection {

    
    
    public static Connection connect(){
        Connection conn=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tablemanagement","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        return conn;
    }

    
}
