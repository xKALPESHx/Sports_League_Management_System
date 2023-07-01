
package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class Team_Information extends JFrame implements ActionListener{
    
    JTable t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2;
    
    Team_Information(){
        
        t1 = new JTable();
        t1.setBounds(10,30,905,410);
        t1.setBackground(Color.white);
        t1.setForeground(Color.red);
        add(t1);
        
        l1= new JLabel("Name");
        l1.setBounds(40,5,100,20);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Ariel",Font.BOLD,13));
        add(l1);
        
        l2= new JLabel("Team Name");
        l2.setBounds(122,5,100,20);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Ariel",Font.BOLD,13));
        add(l2);
        
        l3= new JLabel("Email");
        l3.setBounds(243,5,100,20);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Ariel",Font.BOLD,13));
        add(l3);
        
        l4= new JLabel("Phone NO");
        l4.setBounds(330,5,100,20);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Ariel",Font.BOLD,13));
        add(l4);
        
        l5= new JLabel("City");
        l5.setBounds(450,5,100,20);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Ariel",Font.BOLD,13));
        add(l5);
        
        l6= new JLabel("Status");
        l6.setBounds(540,5,100,20);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Ariel",Font.BOLD,13));
        add(l6);
        
        l7= new JLabel("Fees Status");
        l7.setBounds(622,5,100,20);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Ariel",Font.BOLD,13));
        add(l7);
        
        l8= new JLabel("Event");
        l8.setBounds(740,5,100,20);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Ariel",Font.BOLD,13));
        add(l8);
        
        l9= new JLabel("Spots");
        l9.setBounds(840,5,100,20);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Ariel",Font.BOLD,13));
        add(l9);
        
        
        b1 = new JButton("Load Data");
        b1.setBounds(200,460,100,25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.yellow);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Delete");
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
        conn c = new conn();
        
        if(ae.getSource()==b1){
            try{                
                String str = "select * from team_registration";
                ResultSet r = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(r) );
                
            }catch(Exception e){}
            
        }else if(ae.getSource()==b2){
            try{                
                String str = "delete from team_registration";
                c.s.executeUpdate(str);              
                JOptionPane.showMessageDialog(null,"Deleted Data Successfully");
            }catch(Exception e){}
            
        }
        
    }

  
    public static void main(String[] args) {
       new Team_Information();
    }
    
}
