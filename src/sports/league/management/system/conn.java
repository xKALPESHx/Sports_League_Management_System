package sports.league.management.system;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/slms","root","");
            s = c.createStatement();
            
        }catch(Exception e){
        }
    }


    public static void main(String[] args) {

    }
    
}
