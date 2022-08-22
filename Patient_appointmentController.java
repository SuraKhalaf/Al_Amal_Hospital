/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import oracle.net.aso.q;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Patient_appointmentController implements Initializable {
    @FXML 
    private javafx.scene.control.TextField SSN;
     @FXML 
    private javafx.scene.control.TextField F_Name;
    @FXML 
    private javafx.scene.control.TextField M_Name;
     @FXML 
    private javafx.scene.control.TextField L_Name;
    @FXML 
    private javafx.scene.control.TextField email; 
   @FXML 
    private PasswordField pass; 
    @FXML 
    private javafx.scene.control.TextField gender; 
    @FXML 
    private javafx.scene.control.TextField address;
    @FXML 
    private javafx.scene.control.TextField phone;
     @FXML 
    private javafx.scene.control.TextField b_D;
     @FXML 
    private javafx.scene.control.TextField dis;
    
    @FXML 
    private javafx.scene.control.TextField doc_id;
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public int v() throws SQLException, IOException{
        int c = 0;
       int stop=0;
            System.out.println("Heoo");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            String url ="jdbc:oracle:thin:@192.168.1.10:1521:xe";
            Connection con=DriverManager.getConnection(url,"C##SuraS","11819597");
            Statement stm=con.createStatement();
            String q="select * from patient_acount where email= ' " +this.email.getText()+"'"+
                "and passwordd= '"+this.pass.getText()+"'";
            System.out.println(q);
           // con.setAutoCommit(true);
            System.out.println(stm.executeUpdate(q));
             PreparedStatement gP=con.prepareStatement(q);
             ResultSet re= gP.executeQuery();
            while (re.next()) {

                c++;
                System.out.println("Helloooo");


            }

           
            if(c<0){
               JOptionPane.showMessageDialog(null,"The password or email not matched"); 
           return 1;
            }
    return 0;      
    }
public void Referesh() {  
   this.SSN.setText("");
   this.F_Name.setText("");
   this.M_Name.setText("");
   this.L_Name.setText("");
   this.email.setText("");
   this.pass.setText("");
   this.gender.setText("");
   this.address.setText("");
   this.phone.setText("");
   this.b_D.setText("");
   this.doc_id.setText("");
}  
     @FXML
    private void add_butt(ActionEvent event) throws SQLException, IOException { 
   boolean t=true;
     
        /*      boolean flag=false;
        boolean t=true;
      int i=1;
        while(t){
     
        try{
          DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
           Connection con = DriverManager.getConnection(url,"C##SuraS","11819597") ;
                Statement stm = con.createStatement();
        String temp="select * from patient_acount where email=' " +this.email.getText()+"'"+
                "and passwordd='"+this.pass.getText()+"'";
         PreparedStatement gP=con.prepareStatement(temp);
             ResultSet re= gP.executeQuery();
            while (re.next()) {
                flag=true;
            }
if(flag==false)
{    JOptionPane.showMessageDialog(null,"The password or email not matched");
t=false;
break;
 
}
        }
        catch (Exception e ){
            
        }
        
*/        
    int e=    v();
       
        
        
        
         try { 
             if (this.SSN.getText().isEmpty() || this.F_Name.getText().isEmpty() || this.M_Name.getText().isEmpty()|| this.L_Name.getText().isEmpty()|| 
                    this.email.getText().isEmpty() || this.pass.getText().isEmpty() || this.gender.getText().isEmpty() || this.address.getText().isEmpty() 
                     || this.phone.getText().isEmpty() || this.b_D.getText().isEmpty()){
                 
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            try (Connection con = DriverManager.getConnection(url,"C##SuraS","11819597")) {
                Statement stm = con.createStatement();
                String insQury = "INSERT INTO \"C##SURAS\".\"PATIENT_TABLE\" (SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, PASS, GENDER, PAT_ADDRESS, PAT_NUMBER, DATE_OF_BIRTH, DISEASE, DOC_ID) VALUES("+"'"+this.SSN.getText()+"'"+", '"+this.F_Name.getText()+"'"+", '"+this.M_Name.getText()+"'"
                        +", '"+this.L_Name.getText()+"'"+", '"+this.email.getText()+"'"+", '"+this.pass.getText()+"'"+", '"+this.gender.getText()+"'"+", '"+this.address.getText()+"'"+", '"+this.phone.getText()+"'"+", '"+this.b_D.getText()+"'"+", '"+this.dis.getText()+"'"+", '"+this.doc_id.getText()+"')";
                stm.executeQuery(insQury);
                con.setAutoCommit(false);
                con.commit();
                con.close();
                JOptionPane.showMessageDialog(null, "Done !"); 
                 Referesh() ; 
            } }
        } catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }
    } 
      @FXML
    private void back_butt(ActionEvent event) 
{
        try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Patient_page.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("About us");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
}}}
    

/* int c = 0;
        try {
            System.out.println("Heoo");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            String url ="jdbc:oracle:thin:@localhost:1521:xe";
            Connection con=DriverManager.getConnection(url,"C##rx","123321");
            Statement stm=con.createStatement();
            String q="select * from PATIENTS WHERE EMAIL=" + "'" + this.e.getText() + "'" + "and" + " PASSWORDD=" + "'" + this.password.getText() + "'";
            System.out.println(q);
           // con.setAutoCommit(true);
            System.out.println(stm.executeUpdate(q));
             PreparedStatement gP=con.prepareStatement(q);
             ResultSet re= gP.executeQuery();
            while (re.next()) {

                c++;
                System.out.println("Helloooo");


            }

            if (c > 0) {
                Parent scondparent = FXMLLoader.load(getClass().getResource("three.fxml"));
                Scene scene2 = new Scene(scondparent);
                S
int c = 0;
        try {
            System.out.println("Heoo");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            String url ="jdbc:oracle:thin:@localhost:1521:xe";
            Connection con=DriverManager.getConnection(url,"C##rx","123321");
            Statement stm=con.createStatement();
            String q="select * from PATIENTS WHERE EMAIL=" + "'" + this.e.getText() + "'" + "and" + " PASSWORDD=" + "'" + this.password.getText() + "'";
            System.out.println(q);
           // con.setAutoCommit(true);
            System.out.println(stm.executeUpdate(q));
             PreparedStatement gP=con.prepareStatement(q);
             ResultSet re= gP.executeQuery();
            while (re.next()) {

                c++;
                System.out.println("Helloooo");


            }

            if (c > 0) {
                Parent scondparent = FXMLLoader.load(getClass().getResource("three.fxml"));
                Scene scene2 = new Scene(scondparent);
  */