/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class DocInfoUpController implements Initializable {

    /**
     * Initializes the controller class.
     */
  
    @FXML 
    private TextField email; 
    @FXML 
    private PasswordField pass;
    @FXML 
    private TextField id;
    @FXML 
    private TextField title;
    @FXML 
    private TextField comp; 
    @FXML 
    private TextField phone;
     @FXML 
    private TextField med; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void Referesh() {
this.email.setText("");
this.pass.setText("");
this.id.setText("");
this.title.setText("");
this.comp.setText("");
this.phone.setText("");
this.med.setText("");
}
    @FXML
    private void update_butt(ActionEvent event) {
          try {
              if (this.email.getText().isEmpty() || this.pass.getText().isEmpty() || this.id.getText().isEmpty() || this.title.getText().isEmpty() || 
                      this.comp.getText().isEmpty()|| this.phone.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          String sql = "Select * from DOCTOR_TABLE where DOC_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Statement stm = con.createStatement();
                String insQury = "UPDATE \"C##SURAS\".\"DOCTOR_TABLE\" SET MED_ID = '"+this.med.getText()+"', DOC_NUMBER ='"+this.phone.getText()+"', JOB_COMPETENCE ='"
                       +this.comp.getText()+"', DOC_TITLE ='"+this.title.getText()+"', Email ='"+this.email.getText()+"' WHERE DOC_ID = '" + this.id.getText() + "'";
              
                stm.executeQuery(insQury);
                con.setAutoCommit(false);
                con.commit();
                con.close();
                JOptionPane.showMessageDialog(null, "Done !");
            Referesh();} 
            else {
                 JOptionPane.showMessageDialog(null, "The ID is not exist!");
                 Referesh();
            }
              }
        } catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }
          
    }

    @FXML
    private void about_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("abouthospital.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("About hospital");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void changepass_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("docPassChange.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @FXML
    private void back_butt(ActionEvent event) {
       //open new window
       try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Doctor_login.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Doctor profile");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } }
