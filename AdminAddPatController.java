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
public class AdminAddPatController implements Initializable {

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
    private TextField dis;
    @FXML
    private TextField doc_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML 
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
   this.dis.setText("");
   this.doc_id.setText("");
}  
    @FXML
    private void back_buttt(ActionEvent event) {
        try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("admin_login.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Admin profile");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void add_buttt(ActionEvent event) { 
         try { 
             if (this.SSN.getText().isEmpty() || this.F_Name.getText().isEmpty() || this.M_Name.getText().isEmpty()|| this.L_Name.getText().isEmpty()|| 
                    this.email.getText().isEmpty() || this.pass.getText().isEmpty() || this.gender.getText().isEmpty() || this.address.getText().isEmpty() 
                     || this.phone.getText().isEmpty() || this.b_D.getText().isEmpty() || this.doc_id.getText().isEmpty()){
                 
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            try (Connection con = DriverManager.getConnection(url,"C##SuraS","11819597")) {
                Statement stm = con.createStatement();
                String insQury = "INSERT INTO \"C##SURAS\".\"PATIENT_TABLE\" (SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, PASS, GENDER, PAT_ADDRESS, PAT_NUMBER, DATE_OF_BIRTH, DISEASE, Doc_ID) VALUES("+"'"+this.SSN.getText()+"'"+", '"+this.F_Name.getText()+"'"+", '"+this.M_Name.getText()+"'"
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
    
}
