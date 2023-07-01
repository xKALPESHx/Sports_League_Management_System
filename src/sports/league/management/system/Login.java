
package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel L1,L2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2,b3;
    
    
    Login(){
        
        t1 = new JTextField();
        t1.setBounds(140,25,130,20);
        t1.setForeground(Color.BLUE);
        add(t1);
        
        p1 = new JPasswordField();
        p1.setBounds(140,75,130,20);
        p1.setForeground(Color.BLUE);
        add(p1);
        
        L1 = new JLabel("Username");
        L1.setBounds(30,20,100,30);
        add(L1);
        
        L2 = new JLabel("Password");
        L2.setBounds(30,70,100,30);
        add(L2);
        
        b1 = new JButton("Login");
        b1.setBounds(30,120,100,30);
        b1.addActionListener(this);
        add(b1);
                
        b2 = new JButton("Register");
        b2.setBounds(100,175,100,30);
        b2.setForeground(Color.RED);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Cancel");
        b3.setBounds(170,120,100,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sports/league/management/system/Icon/5.jpg"));
        JLabel L1 = new JLabel(i1);
        L1.setBounds(300,40,130,130);
        add(L1);
        
        
        getContentPane().setBackground(Color.WHITE);
       
        setLayout(null);
        setBounds(500,200,460,250);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String Username=t1.getText();
            String Password=p1.getText();
            conn c = new conn();
            
            String str = "select* from login where Username = '"+Username+"' and Password = '"+Password+"'";
            try{
                ResultSet rs = c.s.executeQuery(str); 
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    this.setVisible(true);
                }
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource()==b3){
            System.exit(0);
        }else if(ae.getSource()==b2){
            new Registration_1().setVisible(true);
            this.setVisible(false);
            
        }

    }

    
    public static void main(String[] args) {
        new Login();
        
        
      }
    
}
