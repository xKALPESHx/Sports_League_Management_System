package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class Sponsor_Info extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    
    Sponsor_Info(){
        
        t1 = new JTable();
        t1.setBounds(10,30,905,410);
        t1.setBackground(Color.white);
        t1.setForeground(Color.red);
        add(t1);
        
        l1= new JLabel("Name");
        l1.setBounds(60,5,100,20);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Ariel",Font.BOLD,14));
        add(l1);
        
        l2= new JLabel("Sponsorship");
        l2.setBounds(190,5,100,20);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Ariel",Font.BOLD,14));
        add(l2);
        
        l3= new JLabel("Email");
        l3.setBounds(360,5,100,20);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Ariel",Font.BOLD,14));
        add(l3);
        
        l4= new JLabel("Sport");
        l4.setBounds(510,5,100,20);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Ariel",Font.BOLD,14));
        add(l4);
        
        l5= new JLabel("Funds");
        l5.setBounds(660,5,100,20);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Ariel",Font.BOLD,14));
        add(l5);
        
        l6= new JLabel("Payment");
        l6.setFont(new Font("Ariel",Font.BOLD,14));
        l6.setForeground(Color.BLACK);
        l6.setBounds(800,5,100,20);
        add(l6);
        
        b1 = new JButton("Load Data");
        b1.setBounds(200,460,100,25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.yellow);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(620,460,100,25);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.yellow);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.cyan);
                
        setLayout(null);
        setBounds(330,120,940,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            try{
                conn c = new conn();
                String str = "select * from sponsor";
                ResultSet r = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(r) );
                
            }catch(Exception e){}
            
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
        
    }
    
    

  
    public static void main(String[] args) {
        new Sponsor_Info();
    }
    
}
