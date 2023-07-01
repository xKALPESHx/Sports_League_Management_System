package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1;
    JLabel l1,l2,l3,l4;
    
    CustomerInfo(){
        
        t1 = new JTable();
        t1.setBounds(10,30,605,410);
        t1.setBackground(Color.white);
        t1.setForeground(Color.red);
        add(t1);
        
        l1= new JLabel("Name");
        l1.setBounds(70,5,100,20);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Ariel",Font.BOLD,14));
        add(l1);
        
        l2= new JLabel("Email");
        l2.setBounds(220,5,100,20);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Ariel",Font.BOLD,14));
        add(l2);
        
        l3= new JLabel("Phone NO.");
        l3.setBounds(350,5,100,20);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Ariel",Font.BOLD,14));
        add(l3);
        
        l4= new JLabel("City");
        l4.setBounds(520,5,100,20);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Ariel",Font.BOLD,14));
        add(l4);
               
        b1 = new JButton("Load Data");
        b1.setBounds(260,460,100,25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.yellow);
        b1.addActionListener(this);
        add(b1);
        
                
        getContentPane().setBackground(Color.cyan);
                
        setLayout(null);
        setBounds(480,120,640,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
             try{
                conn c = new conn();
                String str = "select * from customer";
                ResultSet r = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(r) );
                
            }catch(Exception e){}
           
                
    }
    
    

  
    public static void main(String[] args) {
        new CustomerInfo();
    }
    
}
