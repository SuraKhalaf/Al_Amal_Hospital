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
public class DocpatInfoController implements Initializable {

    @FXML
    private TextField SSN;
    @FXML 
    private TextField F_Name;
    @FXML
    private TextField M_Name;
    @FXML
    private TextField L_Name;
    @FXML
    private TextField email;
    @FXML
    private TextField gender;
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private TextField b_D;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField disease;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
public void Referesh() {
this.SSN.setText("");
this.F_Name.setText("");
this.M_Name.setText("");
this.L_Name.setText("");
this.email.setText("");
this.gender.setText("");
this.address.setText("");
this.phone.setText("");
this.b_D.setText("");
this.pass.setText("");
this.disease.setText("");
}

    @FXML
    private void back_butt(ActionEvent event) {
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
    }
@FXML
    private void updatepat_butt(ActionEvent event) {
          try {
               if (this.SSN.getText().isEmpty() || this.F_Name.getText().isEmpty() || this.M_Name.getText().isEmpty()|| this.L_Name.getText().isEmpty()|| 
                    this.email.getText().isEmpty() || this.pass.getText().isEmpty() || this.gender.getText().isEmpty() || this.address.getText().isEmpty() 
                     || this.phone.getText().isEmpty() || this.b_D.getText().isEmpty()|| this.disease.getText().isEmpty()){
                 
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          String sql = "Select * from PATIENT_TABLE where SSN=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, this.SSN.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Statement stm = con.createStatement();
                String insQury = "UPDATE \"C##SURAS\".\"PATIENT_TABLE\" SET FIRST_NAME = '"+this.F_Name.getText()+"', MIDDLE_NAME ='"+this.M_Name.getText()+"', LAST_NAME ='"
                       +this.L_Name.getText()+"', EMAIL ='"+this.email.getText()+"', PASS ='"+this.pass.getText()+"', GENDER ='"+this.gender.getText()+"', PAT_ADDRESS ='"+this.address.getText()+"', PAT_NUMBER ='"+this.phone.getText()
                       +"', DATE_OF_BIRTH ='"+this.b_D.getText()+"', Disease ='"+this.disease.getText()+"' WHERE SSN = '" + this.SSN.getText()+ "'";
              
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

   
    
}
