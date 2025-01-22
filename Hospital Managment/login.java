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
public class login extends JFrame implements ActionListener{
    JTextField textfield;
    JPasswordField jPasswordfield;
    JButton b1,b2;
    login(){
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);
        
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);
        
        textfield = new JTextField();
        textfield.setBounds(150,20,150,30);
        textfield.setFont(new Font("Tahoma",Font.PLAIN,16));
        textfield.setBackground(new Color(255,179,0));
        add(textfield);
        
        jPasswordfield = new JPasswordField();
        jPasswordfield.setBounds(150,70,150,30);
        jPasswordfield.setFont(new Font("Tahoma",Font.PLAIN,16));
        jPasswordfield.setBackground(new Color(255,179,0));
        add(jPasswordfield);
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Hospital/icon/HMS6.jpeg"));
        Image i1 = imageIcon.getImage().getScaledInstance(370,280,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(350,-30,400,300);
        add(label);
        
        b1= new JButton("Login");
        b1.setBounds(30,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,16));
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,16));
        b2.setBackground(Color.red);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLayout(null);
        setVisible(true);
        setLocation(400,270);
        
    }
    
    public static void main(String[] args){
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1){
            
            try{
                conn c = new conn();
                String user = textfield.getText();
                String Pass = jPasswordfield.getText();
                
                String q = "select * from login where ID = '"+user+"' and PW='"+Pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                
                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }
            }catch(Exception E){
                E.printStackTrace();
            }
            
        }else{
            
            System.exit(10);
        }
        
    }
}
