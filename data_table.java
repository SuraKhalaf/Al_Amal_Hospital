/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author zaytona
 */
public class data_table {
Connection conn;
   public static Connection Connectiondb(){
      try{
          DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@192.168.1.10:1521:xe";
        Connection conn=DriverManager.getConnection(url,"CC##SuraS","11819597");
          JOptionPane.showMessageDialog(null,"er");
          return conn;
      }
       catch(Exception e){
            JOptionPane.showMessageDialog(null,"er");
            return null;
            
       }
      
   }
   
    
    public static ObservableList<class_for_tableview>getdata(){
       Connection conn=Connectiondb();
        ObservableList<class_for_tableview>list=FXCollections.observableArrayList();
        try{
            

          ResultSet rs=conn.createStatement().executeQuery("Select * from DOCTOR_TABLE");
          while(rs.next()){
              System.out.println("Helloooo");

              list.add(new class_for_tableview(rs.getString("DOC_NUMBER"),rs.getString("DOC_TITLE"),rs.getString("FULL_NAME"),rs.getString("JOB_COMPETENCE"),rs.getString("MED_ID"),rs.getString("PASSWORD"),rs.getString("SALARY"),rs.getString("EMAIL"),rs.getString("SALARY")));
              
          }
          
          
          System.out.println(list.size());
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return list;
        
    }
}