package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration_1 extends JFrame implements ActionListener{
    JLabel L1,L2,L3;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    
    Registration_1(){
        
        L1 = new JLabel("Registraton for New Managers");
        L1.setBounds(30, 20, 350, 50);
        L1.setFont(new Font("Times New Roman",Font.PLAIN,22));
        L1.setForeground(Color.red);
        add(L1);
        
        L2 = new JLabel("Username");
        L2.setBounds(30, 100, 100, 25);
        add(L2);
        
        t1 = new JTextField();
        t1.setBounds(150,100,150,25);
        t1.setForeground(Color.BLUE);
        add(t1);
        
        L3 = new JLabel("Password");
        L3.setBounds(30, 150, 100, 25);
        add(L3);
        
        p1 = new JPasswordField();
        p1.setBounds(150,150,150,25);
        p1.setForeground(Color.BLUE);
        add(p1);
        
        b1 = new JButton("Next");
        b1.setBounds(40,220,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(190,220,100,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(250,110,380,330);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String Username = t1.getText();
            String Password = p1.getText();
            
            String str = "insert into login values('"+Username+"','"+Password+"') ";
            try{
                conn c = new conn();
                c.s.executeUpdate(str);
            }catch(Exception e){}
            
            JOptionPane.showMessageDialog(null,"New Manager Registered");
            
            new Login().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b2){
           new Login().setVisible(true);
            this.setVisible(false); 
        }
    }

   
    public static void main(String[] args) {
        new Registration_1();
        
    }
    
}
