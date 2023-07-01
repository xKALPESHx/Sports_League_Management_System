
package sports.league.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewSport extends JFrame implements ActionListener{
    JTextField t1;
    
    NewSport(){
        JLabel l1= new JLabel("Add New Sport");
        l1.setBounds(30,10,150,30);
        l1.setFont(new Font("Times New Roman",Font.PLAIN,18));
        add(l1);
    
        JLabel l2= new JLabel("Sport Name");
        l2.setBounds(30,60,100,30);
        add(l2);
        
        t1 =new JTextField();
        t1.setBounds(130,60,100,30);
        add(t1);
        
        JButton b1 = new JButton("Add");
        b1.setBounds(100,120,80,25);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.CYAN);
        b1.addActionListener(this);
        add(b1);
        
        getContentPane().setBackground(Color.WHITE);
    
        setLayout(null);
        setBounds(600,200,300,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sport = t1.getText();
        conn c = new conn();
        try{
                String str = "insert into newsport values('"+sport+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Sport Added");
            }catch(Exception e) {}
            this.setVisible(false);
    }

    public static void main(String[] args) {
        new NewSport();
            
    }
    
}
