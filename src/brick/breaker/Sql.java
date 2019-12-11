/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick.breaker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GaUrAv
 */
public class Sql {
    public long high(int high_score){
//    public static void main(String[] args) {
        
//        int high_score = 10;
        long max_retrun=0;
        try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/brick","root","");  
        Statement stmt=con.createStatement();  
        stmt.executeUpdate("insert into score(score) values("+high_score+")");
        ResultSet rs=stmt.executeQuery("select MAX(score) as max_score from score");  
        if(rs != null)
            {         
                while(rs.next())
                {
                    max_retrun =rs.getInt("max_score");
                   // System.out.println(max_retrun);
                }
            }
      con.close();
    }catch(Exception e){
            System.out.println(e);
    }
    return max_retrun;   
 }

   
}
