/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital;

/**
 *
 * @author computer world
 */
import java.sql.*;
public class conn {
    Connection connection;
    Statement statement;
    
    public conn(){
       try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Aaabhishek.15");
          statement = connection.createStatement();
       }catch(Exception e){
           e.printStackTrace();
       } 
    }
    
}
