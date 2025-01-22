/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author computer world
 */
public class SearchRoom extends JFrame{
    Choice choice;
    JTable table;
     SearchRoom(){
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,154,163));
        panel.setLayout(null);
        add(panel);
        
        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        For.setForeground(Color.white);
        panel.add(For);
        
        JLabel Status = new JLabel("Status :");
        Status.setBounds(70,70,80,20);
        Status.setFont(new Font("Tahoma",Font.BOLD,14));
        Status.setForeground(Color.white);
        panel.add(Status);
        
        Choice choice = new Choice();
        choice.setBounds(170,72,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);
        
        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);
        
        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23,162,150,20);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        Roomno.setForeground(Color.white);
        panel.add(Roomno);
        
        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.white);
        panel.add(available);
        
        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.white);
        panel.add(price);
        
        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(580,162,150,20);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        Bed.setForeground(Color.white);
        panel.add(Bed);
        
        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,25);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.white);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String q = "select * from Room where Availablity = '"+choice.getSelectedItem()+"'";
              try{
                 conn c = new conn();
                 ResultSet resultSet = c.statement.executeQuery(q);
                 table.setModel(DbUtils.resultSetToTableModel(resultSet));
              }catch(Exception E){
                  E.printStackTrace();
              }
            }
        
        });
        
        JButton Back = new JButton("Back");
        Back.setBounds(380,420,120,25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              setVisible(false);  
            }
        
        });
        
        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }
    
   public static void main(String[] args){
       new SearchRoom();
   }
}
