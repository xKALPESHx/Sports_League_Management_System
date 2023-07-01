package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update_spot extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1;
    JComboBox c2,c3,c4;
    Choice c1;
    JButton b1,b2,b3;
    
    Update_spot(){
        l1 = new JLabel("UPDATE SPOTS");
        l1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l1.setForeground(Color.RED);
        l1.setBounds(50,15,300,30);
        add(l1);
        
        l2 = new JLabel("Spot Name");
        l2.setFont(new Font("Tahoma",Font.PLAIN,12));
        l2.setBounds(30,65,100,25);
        add(l2);
        
        c1 = new Choice();
        c1.setBounds(150,65,100,25);
        try{
            conn c = new conn();
            String s = "select * from team_spots where available ='Occupied'";
            ResultSet r = c.s.executeQuery(s);
            while(r.next()){
                c1.add(r.getString("spotname"));
            }
        }catch(Exception e){}
        c1.setBackground(Color.WHITE);
        add(c1);
        
        l3 = new JLabel("Availability");
        l3.setFont(new Font("Tahoma",Font.PLAIN,12));
        l3.setBounds(30,105,100,25);
        add(l3);
        
        c2 = new JComboBox(new String[]{"Available","Occupied"} );
        c2.setBounds(150,105,100,25);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        l4 = new JLabel("Spot Status");
        l4.setFont(new Font("Tahoma",Font.PLAIN,12));
        l4.setBounds(30,145,100,25);
        add(l4);
        
        c3 = new JComboBox(new String[]{"Arrived","Not Arrived yet"} );
        c3.setBounds(150,145,100,25);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        l5 = new JLabel("Fee Status");
        l5.setFont(new Font("Tahoma",Font.PLAIN,12));
        l5.setBounds(30,225,100,25);
        add(l5);
        
        c4 = new JComboBox(new String[]{"Paid","Pending"} );
        c4.setBounds(150,225,100,25);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        l6 = new JLabel("Fees");
        l6.setFont(new Font("Tahoma",Font.PLAIN,12));
        l6.setBounds(30,185,100,25);
        add(l6);
        
        t1 = new JTextField();
        t1.setBounds(150,185,100,25);
        add(t1);
        
        b1 = new JButton("Update");
        b1.setBounds(30,265,100,25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.CYAN);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Delete");
        b2.setBounds(150,265,100,25);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.CYAN);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Check");
        b3.setBounds(90,305,100,25);
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.CYAN);
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(Color.white);
                
        setLayout(null);
        setBounds(550,200,300,380);
        setVisible(true);
    
}
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            try{
                conn c = new conn();
                String s = c1.getSelectedItem();
                String available = (String)c2.getSelectedItem();                
                String spotstatus = (String)c3.getSelectedItem();
                String fee = (String)t1.getText();
                String feestatus = (String)c4.getSelectedItem();
                
                
                String t = "update team_spots set available = '"+available+"',spotstatus = '"+spotstatus+"',fee = '"+fee+"',feestatus = '"+feestatus+"' where spotname ='"+s+"'";
                c.s.executeUpdate(t);
                JOptionPane.showMessageDialog(null,"Updated Successfully");
            }catch(Exception e){}
        }
        else if(ae.getSource()==b3){
            conn c = new conn();
            String s1 = c1.getSelectedItem();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from team_spots where spotname = '"+s1+"'");
                while(rs.next()){
                    t1.setText(rs.getString("fee"));
                                                           
                }
            }catch(Exception e){}
        }
         else if(ae.getSource()==b2){
            try{
                conn c = new conn();
                String s = c1.getSelectedItem();
                String u = "delete from team_spots where spotname = '"+s+"'";
                c.s.executeUpdate(u);
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
                
            }catch(Exception e){}
            this.setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new Update_spot();
    }
    
}
