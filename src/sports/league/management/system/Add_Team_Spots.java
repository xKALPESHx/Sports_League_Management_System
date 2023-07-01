package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Add_Team_Spots extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2;
    Choice c1;
    JComboBox c2,c3,c4;
    JButton b1,b2;
    
    Add_Team_Spots(){
        
        l1 = new JLabel("Add New Team Spots");
        l1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l1.setBounds(50,15,300,30);
        add(l1);
        
        l7 = new JLabel("Fee Status");
        l7.setFont(new Font("Tahoma",Font.PLAIN,12));
        l7.setBounds(30,240,100,25);
        add(l7);
        
        c4 = new JComboBox(new String[]{"Paid","Pending"} );
        c4.setBounds(150,240,100,25);
        c4.setBackground(Color.WHITE);
        add(c4);
                        
        l2 = new JLabel("Spot Name");
        l2.setFont(new Font("Tahoma",Font.PLAIN,12));
        l2.setBounds(30,65,100,25);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150,65,100,25);
        add(t1);
        
        l3 = new JLabel("Spot Type");
        l3.setFont(new Font("Tahoma",Font.PLAIN,12));
        l3.setBounds(30,100,100,25);
        add(l3);
        
        c1 = new Choice( );
        c1.setBounds(150,100,100,25);
        c1.setBackground(Color.WHITE);
        try{
            conn c = new conn();
            String s = "select * from newsport";
            ResultSet r = c.s.executeQuery(s);
            while(r.next()){
                c1.add(r.getString("sport"));
            }
        }catch(Exception e){}
        add(c1);
        
        l4 = new JLabel("Availability");
        l4.setFont(new Font("Tahoma",Font.PLAIN,12));
        l4.setBounds(30,135,100,25);
        add(l4);
        
        c2 = new JComboBox(new String[]{"Available","Occupied"} );
        c2.setBounds(150,135,100,25);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        l5 = new JLabel("Spot Status");
        l5.setFont(new Font("Tahoma",Font.PLAIN,12));
        l5.setBounds(30,170,100,25);
        add(l5);
        
        c3 = new JComboBox(new String[]{"Arrived","Not Arrived yet"} );
        c3.setBounds(150,170,100,25);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        l6 = new JLabel("Entry Fees");
        l6.setFont(new Font("Tahoma",Font.PLAIN,12));
        l6.setBounds(30,205,100,25);
        add(l6);
        
        t2 = new JTextField();
        t2.setBounds(150,205,100,25);
        add(t2);
        
        b1 = new JButton("Add Spot");
        b1.setBounds(30,290,100,25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.CYAN);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(150,290,100,25);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.CYAN);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sports/league/management/system/Icon/3.jpg"));
        Image i2= i1.getImage().getScaledInstance(250,230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel L1 = new JLabel(i3);
        L1.setBounds(270,65,250,230);
        add(L1);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(550,200,550,380);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            String spotname =t1.getText();
            String spottype = (String)c1.getSelectedItem();
            String available = (String)c2.getSelectedItem();
            String spotstatus = (String)c3.getSelectedItem();
            String fee =t2.getText();
            String feestatus = (String)c4.getSelectedItem();
            
            conn c = new conn();
            try{
                String str = "insert into team_spots values('"+spotname+"','"+spottype+"','"+available+"','"+spotstatus+"','"+fee+"','"+feestatus+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Spot Added");
            }catch(Exception e) {}
            this.setVisible(false);
            
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
     new Add_Team_Spots();
    }
    
}
