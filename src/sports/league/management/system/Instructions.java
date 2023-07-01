package sports.league.management.system;
import javax.swing.*;
import java.awt.*;

public class Instructions extends JFrame{
    
    Instructions(){
        JTextArea t1 = new JTextArea(" 1. Steps to Follow After First Login\n"
                + "   i.  Click on Admin Section then go to add new Sport and add at least 1 sport (Can add only 1 sport at a time Repeat process to add multiple sports in system).\n "
                + " ii. Click again on Admin section then go to add team spots and create spots for teams to register ('Ex.Cricket-1,c1,Cri-1').\n"
                + "       Only one team at a time can hold specified spot(Can create muliple spots when neededby repeating process  ii  ).\n"
                + "  iii. Click again on Admin section then go to Add sponsor and add the (self sponsored) sponsor you can add more sponsors by repeating the process(iii)\n\n"
                + " 2.New Team Registration\n"
                + "    i.Register teams for conducted tournament, team can be assigned with available spots only.\n"
                + "   ii.Information of cutomer will be stored in Customer Info Tab.\n\n"
                + " 3.Team Information\n"
                + "   i.Registered team's Information will be displayed over here after clicking on Load data button.\n"
                + "  ii.Delete butoon will delete the data of all the registered teams but the contach info will be available in customer info tab for future.\n"
                + "    (Delete button should use at the end of tournament to clear all the spots for next tournament)\n\n"
                + " 4.TOURNAMENTS\n"
                + "   i.Tournaments can be create here after filling required information and then use 'Create' button to register tournament into the system.\n"
                + "  ii.Click on the 'Load Data' Button to load the registered tournament's data\n"
                + "  iii.To delete the tournament which is over or to update status of tournament select the sponsor from choice box and click on 'Check' and then 'Delete' to delete the tournament.\n"
                + "  iv.To update the tournament you must delete the previous by using step above and can create new tournament with same status will be available on datafields after 'Check'.\n\n"
                + " 5.Sponsor Information\n"
                + "   Information of all sponsors will be available after using 'Load Data' button.\n\n"
                + " 6.Update Sponsor Information \n"
                + "  i.Select Sponsor's name and click on Check Button to see sponsor's already available information use 'Delete' button to delete sponsor after using 'Check' Button.\n"
                + "  ii.To update sponsors's info use 'Check' function refill the updated data and click on 'Update' Button.\n\n"
                + " 7.SPOTS\n"
                + "  i.Information of all spots will be in this tab after using 'Load Data' button and 'Reset' Button is use to reset status of all the spots to default.\n"
                + "  ii.To update spot status use the steps that we've used in updating sponsor info which can be found in 'Update Spot Stauts' tab.\n");
        t1.setBounds(10,10,1010,540);
        t1.setBackground(Color.white);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(t1);
        
        getContentPane().setBackground(Color.cyan);
        
        setLayout(null);
        setBounds(280,95,1050,600);
        setVisible(true);
        
    }

    public static void main(String[] args) {
       new Instructions();
    }
    
}
