package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Registration_2 extends JFrame implements ActionListener{
    JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11;
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1;
    JButton b1;
    Choice c2,c3;
    
    Registration_2(){
        
        L1 = new JLabel("New Team Details");
        L1.setBounds(40,20,300,40);
        L1.setFont(new Font("Times New Roman",Font.BOLD,20));
        L1.setForeground(Color.red);
        add(L1);
        
        L2 = new JLabel("Full Name");
        L2.setBounds(50, 90, 150, 20);
        add(L2);
        
        t1 = new JTextField();  
        t1.setBounds(200,90,150,20);
        t1.setForeground(Color.blue);
        add(t1);
                     
        L3 = new JLabel("Team / Institution Name");
        L3.setBounds(50,140, 150, 20);
        add(L3);
        
        t2 = new JTextField();
        t2.setBounds(200,140,150,20);
        t2.setForeground(Color.blue);
        add(t2);
        
        L4 = new JLabel("Email ID");
        L4.setBounds(50, 190,150, 20);
        add(L4);
        
        t3 = new JTextField();
        t3.setBounds(200,190,150,20);
        t3.setForeground(Color.blue);
        add(t3);
        
        L5 = new JLabel("Phone NO.");
        L5.setBounds(50, 240,150, 20);
        add(L5);
        
        t4 = new JTextField();
        t4.setBounds(200,240,150,20);
        t4.setForeground(Color.blue);
        add(t4);
        
        L6 = new JLabel("City");
        L6.setBounds(50,290,150, 20);
        add(L6);
        
        t5 = new JTextField();
        t5.setBounds(200,290,150,20);
        t5.setForeground(Color.blue);
        add(t5);
        
        L7 = new JLabel("Arriving Status");
        L7.setBounds(450, 240,150, 20);
        add(L7);        
        
        c1 = new JComboBox(new String[]{"Arrived","Arriving","Not Arriving"} );
        c1.setBounds(600,240,150,20);
        c1.setForeground(Color.blue);
        c1.setBackground(Color.WHITE);
        add(c1);
               
        L9 = new JLabel("Pending Fees");
        L9.setBounds(450, 190, 150, 20);
        add(L9);
        
        t6 = new JTextField();
        t6.setBounds(600,190,150,20);     
        t6.setForeground(Color.blue);
        add(t6);
        
        L10 = new JLabel("Event");
        L10.setBounds(450, 90, 150, 20);
        add(L10);
        
        c2 = new Choice();
        c2.setBounds(600,90,150,20);
        c2.setForeground(Color.blue);
         try{
            conn c = new conn();
            String s = "select * from newsport";
            ResultSet r = c.s.executeQuery(s);
            while(r.next()){
                c2.add(r.getString("sport"));
            }
        }catch(Exception e){}
        add(c2);
        
                
        L11 = new JLabel("Assign Spot");
        L11.setBounds(450, 140, 150, 20);
        add(L11);
        
        
        c3 = new Choice();
        c3.setBounds(600,140,150,20);
        c3.setForeground(Color.blue);
         try{
            conn c = new conn();
            String s = "select * from team_spots where available = 'Available'";
            ResultSet r = c.s.executeQuery(s);
            while(r.next()){
                c3.add(r.getString("spotname"));
            }
        }catch(Exception e){}
        add(c3);
        
        
        b1 = new JButton("Next");
        b1.setBounds(330,380,140,30);
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.cyan);
        b1.addActionListener(this);
        add(b1);      
                           
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(400,160,800,480);        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
            String name = t1.getText();
            String team = t2.getText();
            String email = t3.getText();
            String phone = t4.getText();
            String city = t5.getText();
            String arrival = (String)c1.getSelectedItem();
            String fee = t6.getText();
            String event = (String)c2.getSelectedItem();
            String spot = (String)c3.getSelectedItem();        
            
             conn c = new conn();
            try{
                String s = "insert into team_registration values('"+name+"','"+team+"','"+email+"','"+phone+"','"+city+"','"+arrival+"','"+fee+"','"+event+"','"+spot+"')";
                c.s.executeUpdate(s);             
                                             
            }catch(Exception e) {}
            try{
                String r = "insert into customer values('"+name+"','"+email+"','"+phone+"','"+city+"')";
                c.s.executeUpdate(r);
                
            }catch(Exception e){}
            try{
                String t = "update team_spots set available = 'Occupied' where spotname = '"+spot+"'";
                c.s.executeUpdate(t);
                
            }catch(Exception e){}
                    
            JOptionPane.showMessageDialog(null,"New Team Added");
        this.setVisible(false);
    }
    

    public static void main(String[] args) {
        new Registration_2();
    }
    
}
