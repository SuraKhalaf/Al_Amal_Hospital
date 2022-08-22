/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author zaytona
 */
public class conn {
    Connection con = null;
    public static Connection conData() {
        try {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
         String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
        Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
        return con ; } 
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
    public static ObservableList<Patient> getdata(){
    Connection con = conData();
    ObservableList<Patient>list = FXCollections.observableArrayList();
   
    try {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM patient_table");
         ResultSet rs = ps.executeQuery(); 
         while (rs.next()){
              list.add(new Patient (rs.getString("ssn"), rs.getString("fname"),  rs.getString("mname"),  rs.getString("lname"),  rs.getString("email"),  rs.getString("pass"),  rs.getString("gender"), rs.getString("add"),  rs.getString("phone"),rs.getString("bd")));
          }
    } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
     return list;
}
}
