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
public class AdminAddDocController implements Initializable {

    @FXML
    private PasswordField pass;
    @FXML
    private TextField fullName;
    @FXML
    private TextField title;
    @FXML
    private TextField comp;
    @FXML
    private TextField phone;
    @FXML
    private TextField med;
    @FXML
    private TextField email;
    @FXML
    private TextField doc_id;
    @FXML
    private TextField salary;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
public void Referesh() {
    this.comp.setText("");
    this.doc_id.setText("");
    this.email.setText("");
    this.fullName.setText("");
    this.med.setText("");
    this.pass.setText("");
    this.phone.setText("");
    this.title.setText("");
    this.salary.setText("");
}
    @FXML
    private void add_butt(ActionEvent event) {
           try { 
             if (this.comp.getText().isEmpty() || this.doc_id.getText().isEmpty() || this.email.getText().isEmpty() || this.fullName.getText().isEmpty()
                    || this.pass.getText().isEmpty() || this.phone.getText().isEmpty() || this.title.getText().isEmpty() ||this.salary.getText().isEmpty() ){
                 
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            try (Connection con = DriverManager.getConnection(url,"C##SuraS","11819597")) {
                Statement stm = con.createStatement();
                String insQury = "INSERT INTO \"C##SURAS\".\"DOCTOR_TABLE\" (DOC_ID, DOC_NUMBER, FULL_NAME, JOB_COMPETENCE, DOC_TITLE, MED_ID, EMAIL, PASSWORD, SALARY) VALUES("+"'"+this.doc_id.getText()+"'"+", '"+this.phone.getText()+"'"+", '"+this.fullName.getText()+"'"
                        +", '"+this.comp.getText()+"'"+", '"+this.title.getText()+"'"+", '"+this.med.getText()+"'"+", '"+this.email.getText()+"'"+", '"+this.pass.getText()+"'"+", '"+this.salary.getText()+"')";
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
    }
    

