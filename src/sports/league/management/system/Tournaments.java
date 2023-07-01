package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class Tournaments extends JFrame implements ActionListener{
    JTable T1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,L,L1,L2,L3,L4,L5,L6;
    JTextField t1,t2,t3,t4,t5;
    Choice c1,c2;
    JButton b1,b2,b3,b4;
    
    Tournaments(){
        T1 = new JTable();
        T1.setBounds(330,30,670,495);
        T1.setBackground(Color.white);
        T1.setForeground(Color.red);
        add(T1);
        
        L= new JLabel("Tournaments");
        L.setBounds(40,20,200,20);
        L.setForeground(Color.red);
        L.setFont(new Font("Ariel",Font.BOLD,20));
        add(L);
        
        l1= new JLabel("Name");
        l1.setBounds(40,70,80,20);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Ariel",Font.BOLD,12));
        add(l1);
        
        t1 = new JTextField();  
        t1.setBounds(150,70,150,20);
        t1.setForeground(Color.blue);
        add(t1);
        
        l2= new JLabel("Sport");
        l2.setBounds(40,120,80,20);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Ariel",Font.BOLD,12));
        add(l2);
        
        c1 = new Choice();  
        c1.setBounds(150,120,150,25);
        c1.setForeground(Color.blue);
        try{
            conn c = new conn();
            String s = "select * from newsport";
            ResultSet r = c.s.executeQuery(s);
            while(r.next()){
                c1.add(r.getString("sport"));
            }
        }catch(Exception e){}
        add(c1);
        
        l3= new JLabel("Date");
        l3.setBounds(40,170,80,20);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Ariel",Font.BOLD,12));
        add(l3);
        
        t2 = new JTextField();  
        t2.setBounds(150,170,150,20);
        t2.setForeground(Color.blue);
        add(t2);
        
        l4= new JLabel("Place");
        l4.setBounds(40,220,80,20);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Ariel",Font.BOLD,12));
        add(l4);
        
        t3 = new JTextField();  
        t3.setBounds(150,220,150,20);
        t3.setForeground(Color.blue);
        add(t3);
        
        l5= new JLabel("Prize");
        l5.setBounds(40,270,80,20);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Ariel",Font.BOLD,12));
        add(l5);
        
        t4 = new JTextField();  
        t4.setBounds(150,270,150,20);
        t4.setForeground(Color.blue);
        add(t4);
        
        l7= new JLabel("Sponsor");
        l7.setBounds(40,320,80,20);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Ariel",Font.BOLD,12));
        add(l7);
        
        c2 = new Choice();  
        c2.setBounds(150,320,150,25);
        c2.setForeground(Color.blue);
        try{
            conn c = new conn();
            String s = "select * from sponsor";
            ResultSet r = c.s.executeQuery(s);
            while(r.next()){
                c2.add(r.getString("sponsorname"));
            }
        }catch(Exception e){}
        add(c2);
        
        l8= new JLabel("Max Teams");
        l8.setBounds(40,370,80,20);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Ariel",Font.BOLD,12));
        add(l8);
        
        t5 = new JTextField();  
        t5.setBounds(150,370,150,20);
        t5.setForeground(Color.blue);
        add(t5);
        
        l9= new JLabel("Name");
        l9.setBounds(360,5,100,20);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Ariel",Font.BOLD,14));
        add(l9);
        
        L1= new JLabel("Sport");
        L1.setBounds(450,5,100,20);
        L1.setForeground(Color.BLACK);
        L1.setFont(new Font("Ariel",Font.BOLD,14));
        add(L1);
        
        L2= new JLabel("Date");
        L2.setBounds(550,5,100,20);
        L2.setForeground(Color.BLACK);
        L2.setFont(new Font("Ariel",Font.BOLD,14));
        add(L2);
       
        L3= new JLabel("Place");
        L3.setBounds(645,5,100,20);
        L3.setForeground(Color.BLACK);
        L3.setFont(new Font("Ariel",Font.BOLD,14));
        add(L3);
        
        L4= new JLabel("Prize");
        L4.setBounds(740,5,100,20);
        L4.setForeground(Color.BLACK);
        L4.setFont(new Font("Ariel",Font.BOLD,14));
        add(L4);
        
        L5= new JLabel("Sponsor");
        L5.setBounds(825,5,100,20);
        L5.setForeground(Color.BLACK);
        L5.setFont(new Font("Ariel",Font.BOLD,14));
        add(L5);
        
        L6= new JLabel("Max Teams");
        L6.setBounds(915,5,100,20);
        L6.setForeground(Color.BLACK);
        L6.setFont(new Font("Ariel",Font.BOLD,14));
        add(L6);       
                
        b1 = new JButton("Create");
        b1.setBounds(35,420,100,25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.yellow);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Delete");
        b2.setBounds(200,420,100,25);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.yellow);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Load Data");
        b3.setBounds(35,470,100,25);
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.yellow);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("Check");
        b4.setBounds(200,470,100,25);
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.YELLOW);
        b4.addActionListener(this);
        add(b4);
        
        getContentPane().setBackground(Color.cyan);
        
        setLayout(null);
        setBounds(280,95,1050,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            String name =t1.getText();
            String sport = (String)c1.getSelectedItem();
            String date = (String)t2.getText();
            String place = (String)t3.getText();
            String prize = (String)t4.getText();
            String sponsor = (String)c2.getSelectedItem();
            String teams =t5.getText();
            
            
            conn c = new conn();
            try{
                String str = "insert into tournament values('"+name+"','"+sport+"','"+date+"','"+place+"','"+prize+"','"+sponsor+"','"+teams+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"Tournament Added Successfully");
            }catch(Exception e) {}            
            
        }
        else if(ae.getSource()==b2){
            try{
                conn c = new conn();
                String s = c2.getSelectedItem();
                String u = "delete from tournament where sponsor = '"+s+"'";
                c.s.executeUpdate(u);
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
                
            }catch(Exception e){}
        }
        else if(ae.getSource()==b3){
            try{
                conn c = new conn();
                String str = "select * from tournament";
                ResultSet r = c.s.executeQuery(str);
                
                T1.setModel(DbUtils.resultSetToTableModel(r) );
                
            }catch(Exception e){}
            
        }
        else if(ae.getSource()==b4){
            conn c = new conn();
            String s1 = c2.getSelectedItem();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from tournament where sponsor = '"+s1+"'");
                while(rs.next()){
                    t1.setText(rs.getString("name"));
                    t2.setText(rs.getString("date"));
                    t3.setText(rs.getString("place"));
                    t4.setText(rs.getString("prize"));
                    t5.setText(rs.getString("teams"));
                    
                }
            }catch(Exception e){}
        }
    }

    public static void main(String[] args) {
        new Tournaments();
      
    }
    
}
