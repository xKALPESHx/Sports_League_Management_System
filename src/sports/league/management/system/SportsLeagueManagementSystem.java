
package sports.league.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SportsLeagueManagementSystem extends JFrame implements ActionListener{
    
    SportsLeagueManagementSystem(){
        setBounds(400,150,365,370);
               
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sports/league/management/system/Icon/1.jpg"));
        JLabel L1 = new JLabel(i1);
        L1.setBounds(0,0,350,350);
        add(L1);
        
        JLabel L2 = new JLabel("Sport League Management System");
        L2.setBounds(47,20,350,70);
        L2.setForeground(Color.red);
        L2.setFont(new Font("Serif",Font.ROMAN_BASELINE,18));
        L1.add(L2);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.cyan);
        b1.setBounds(120,280,100,30);
        b1.addActionListener(this);
        L1.add(b1);
        
        setLayout(null);
        setVisible(true);
        
        while(true){
            L2.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
            L2.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}
            
        }
           
    }
    
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }

  
    public static void main(String[] args) {
        new SportsLeagueManagementSystem();
    
    }
    
}
