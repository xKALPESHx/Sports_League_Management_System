package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class New_Sponsor extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3;
    JComboBox c1,c3;
    Choice c2;
    JButton b1,b2;
    
    
    New_Sponsor(){
        
        l1 = new JLabel("SPONSORS");
        l1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l1.setForeground(Color.RED);
        l1.setBounds(50,15,300,30);
        add(l1);
        
        l2 = new JLabel("Sponsor Name");
        l2.setFont(new Font("Tahoma",Font.PLAIN,12));
        l2.setBounds(30,65,100,25);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150,65,100,25);
        add(t1);
        
        l3 = new JLabel("Sponsorship Type");
        l3.setFont(new Font("Tahoma",Font.PLAIN,12));
        l3.setBounds(30,100,100,25);
        add(l3);
        
        c1 = new JComboBox(new String[]{"One Time","Mutiple"} );
        c1.setBounds(150,100,100,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        l4 = new JLabel("Email ID");
        l4.setFont(new Font("Tahoma",Font.PLAIN,12));
        l4.setBounds(30,135,100,25);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(150,135,100,25);
        add(t2);
        
        l5 = new JLabel("Event");
        l5.setFont(new Font("Tahoma",Font.PLAIN,12));
        l5.setBounds(30,170,100,25);
        add(l5);
        
        c2 = new Choice();
        c2.setBounds(150,170,100,25);
        try{
            conn c = new conn();
            String s = "select * from newsport";
            ResultSet r = c.s.executeQuery(s);
            while(r.next()){
                c2.add(r.getString("sport"));
            }
        }catch(Exception e){}
        c2.setBackground(Color.WHITE);
        add(c2);
        
        l6 = new JLabel("Amount");
        l6.setFont(new Font("Tahoma",Font.PLAIN,12));
        l6.setBounds(30,205,100,25);
        add(l6);
        
        t3 = new JTextField();
        t3.setBounds(150,205,100,25);
        add(t3);
        
        l7 = new JLabel("Payment Method");
        l7.setFont(new Font("Tahoma",Font.PLAIN,12));
        l7.setBounds(30,240,100,25);
        add(l7);
        
        c3 = new JComboBox(new String[]{"Cash","Bank Transfer","Paytm","GPay"} );
        c3.setBounds(150,240,100,25);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        b1 = new JButton("Add");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sports/league/management/system/Icon/Sponsor.png"));
        JLabel L1 = new JLabel(i1);
        L1.setBounds(270,65,250,230);
        add(L1);
        
                
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(550,200,550,380);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            String sponsorname =t1.getText();
            String sponsorship = (String)c1.getSelectedItem();
            String Email = (String)t2.getText();
            String event = (String)c2.getSelectedItem();
            String amount =t3.getText();
            String payment = (String)c3.getSelectedItem();
            
            conn c = new conn();
            try{
                String str = "insert into sponsor values('"+sponsorname+"','"+sponsorship+"','"+Email+"','"+event+"','"+amount+"','"+payment+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"Sponsor Added Successfully");
            }catch(Exception e) {}
            this.setVisible(false);
            
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
       new New_Sponsor();
    }
    
}
