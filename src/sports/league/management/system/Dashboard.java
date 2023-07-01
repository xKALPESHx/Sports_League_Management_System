package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
     
    
    Dashboard(){
        
        b1 = new JButton("Tournaments");
        b1.setBounds(20,200,200,30);
        b1.setForeground(Color.cyan);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Spots");
        b2.setBounds(20,410,200,30);
        b2.setForeground(Color.cyan);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Team Information");
        b3.setBounds(20,130,200,30);
        b3.setForeground(Color.cyan);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("Sponsor Information");
        b4.setBounds(20,270,200,30);
        b4.setForeground(Color.cyan);
        b4.setBackground(Color.BLACK);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Update Sponsor Information");
        b5.setBounds(20,340,200,30);
        b5.setForeground(Color.cyan);
        b5.setBackground(Color.BLACK);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Update Spot Status");
        b6.setBounds(20,480,200,30);
        b6.setForeground(Color.cyan);
        b6.setBackground(Color.BLACK);
        b6.addActionListener(this);
        add(b6);
        
        b7 = new JButton("New Team Registration");
        b7.setBounds(20,60,200,30);
        b7.setForeground(Color.cyan);
        b7.setBackground(Color.BLACK);
        b7.addActionListener(this);
        add(b7);
        
        b8 = new JButton("All Customer Info");
        b8.setBounds(20,550,200,30);
        b8.setForeground(Color.cyan);
        b8.setBackground(Color.BLACK);
        b8.addActionListener(this);
        add(b8);
        
        b9 = new JButton("Logout");
        b9.setBounds(20,620,200,30);
        b9.setForeground(Color.cyan);
        b9.setBackground(Color.BLACK);
        b9.addActionListener(this);
        add(b9);
        
        
        mb = new JMenuBar();
        mb.setBackground(Color.cyan);
        mb.setBounds(0,0,1450,30);
        add(mb);
                   
                               
        m1 = new JMenu("Admin Section");
        m1.setForeground(Color.red);
        m1.setFont(new Font("Tahoma",Font.BOLD,16));
        mb.add(m1);
                              
        i1 = new JMenuItem("Add Sport");
        i1.addActionListener(this);
        m1.add(i1);
                      
        i2= new JMenuItem("Add Team Spots");
        i2.addActionListener(this);
        m1.add(i2);
                        
        i3 = new JMenuItem("Add New Sponsor");
        i3.addActionListener(this);
        m1.add(i3);
        
        m2 = new JMenu("Instructions");
        m2.setForeground(Color.BLUE);
        m2.setFont(new Font("Tahoma",Font.BOLD,16));
        mb.add(m2);
        
        i4 = new JMenuItem("How to Use (i)");
        i4.addActionListener(this);
        m2.add(i4);
              
                           
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sports/league/management/system/Icon/Dashboard.jpg"));
        Image i2= i1.getImage().getScaledInstance(1050,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel L1 = new JLabel(i3);
        L1.setBounds(280,60,1050,600);
        add(L1);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(-10,0,1450,780);
        setVisible(true);
        
           
                      
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Sport") ){
            new NewSport().setVisible(true);
           }
        else if(ae.getActionCommand().equals("Add Team Spots") ){
            new Add_Team_Spots().setVisible(true);            
           }
        else if(ae.getActionCommand().equals("Add New Sponsor") ){
            new New_Sponsor().setVisible(true);
           } 
        else if(ae.getActionCommand().equals("How to Use (i)") ){
            new Instructions().setVisible(true);            
           }
        
        else if(ae.getSource()==b9){
            new Login().setVisible(true);
            this.setVisible(false);                        
        }
        else if(ae.getSource()==b4){
            new Sponsor_Info().setVisible(true);                                   
        }
        else if(ae.getSource()==b3){
            new Team_Information().setVisible(true);                                   
        }
        else if(ae.getSource()==b1){
            new Tournaments().setVisible(true);                                   
        }
        else if(ae.getSource()==b2){
            new Spots().setVisible(true);                                   
        }
        else if(ae.getSource()==b5){
            new Update_Sponsor().setVisible(true);                                   
        }
        else if(ae.getSource()==b7){
            new Registration_2().setVisible(true);                                   
        }
        else if(ae.getSource()==b8){
            new CustomerInfo().setVisible(true);                                   
        }
        else if(ae.getSource()==b6){
            new Update_spot().setVisible(true);                                   
        }
       
        
    }

  
    public static void main(String[] args) {
        new Dashboard().setVisible(true);

    }
    
}
