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

/**
 *
 * @author computer world
 */
public class update_patient_details extends JFrame{
    
    update_patient_details(){
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,154,163));
        panel.setLayout(null);
        add(panel);
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Hospital/icon/HMS6.jpeg"));
        Image i1 = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);
        
        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);
        
        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.white);
        panel.add(label2);
        
        Choice choice = new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);
        
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info");
            while(resultSet.next()){
              choice.add(resultSet.getString("Name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,140,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.white);
        panel.add(label3);
        
        JTextField textfieldR= new JTextField();
        textfieldR.setBounds(248,129,140,20);
        panel.add(textfieldR);
        
        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.white);
        panel.add(label4);
        
        JTextField textfieldInTime= new JTextField();
        textfieldInTime.setBounds(248,174,140,20);
        panel.add(textfieldInTime);
        
        JLabel label5 = new JLabel("Amount Paid (RS) :");
        label5.setBounds(25,216,160,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.white);
        panel.add(label5);
        
        JTextField textfieldAmount= new JTextField();
        textfieldAmount.setBounds(248,216,140,20);
        panel.add(textfieldAmount);
        
        JLabel label6 = new JLabel("Panding Amount(RS) :");
        label6.setBounds(25,261,160,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.white);
        panel.add(label6);
        
        JTextField textfieldPanding= new JTextField();
        textfieldPanding.setBounds(248,261,140,20);
        panel.add(textfieldPanding);
        
        JButton Check = new JButton("Check");
        Check.setBounds(281,378,89,23);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.white);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String id = choice.getSelectedItem();
               String q = "select * from Patient_Info where Name = '"+id+"'";
               try{
                   conn c =new conn();
                   ResultSet resultSet = c.statement.executeQuery(q);
                   while(resultSet.next()){
                       textfieldR.setText(resultSet.getString("Room_Number"));
                       textfieldInTime.setText(resultSet.getString("Time"));
                       textfieldAmount.setText(resultSet.getString("Deposite"));
                       
                   }
                   
                   ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no= '"+textfieldR.getText()+"'");
                   while(resultSet1.next()){
                       String price = resultSet1.getString("Price");
                       int amountPaid = Integer.parseInt(price)-Integer.parseInt(textfieldAmount.getText());
                       textfieldPanding.setText(""+amountPaid);
                       
                   }
               }catch(Exception E){
                   E.printStackTrace();
               }
                
            }
        
        });
        
        JButton Update = new JButton("Update");
        Update.setBounds(56,378,89,23);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.white);
        panel.add(Update);
        Update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                  conn c = new conn();
                  String q = choice.getSelectedItem();
                  String room = textfieldR.getText();
                  String time = textfieldInTime.getText();
                  String amount = textfieldAmount.getText();
                  
                  c.statement.executeUpdate("Update Patient_Info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
                  JOptionPane.showMessageDialog(null, "Update Successfully");
                  setVisible(true);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
         });
        
        JButton Back = new JButton("Back");
        Back.setBounds(168,378,89,23);
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
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
        
        
        
    }
    
    public static void main(String[] args){
        new update_patient_details();
    }
}
