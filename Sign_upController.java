/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Sign_upController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private TextField FullName;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
       
    }    
    @FXML
    private void exitButtonOnAction(ActionEvent event) {
         int c =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
    if (c == JOptionPane.YES_OPTION) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();  
} else {
    
}
    }
    @FXML
    private void signUp(ActionEvent event){
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            try (Connection con = DriverManager.getConnection(url,"C##SuraS","11819597")) {
                Statement stm = con.createStatement();
                String insQury = "INSERT INTO \"C##SURAS\".\"DOCTOR_TABLE\" (DOC_ID, DOC_NUMBER, FULL_NAME, JOB_COMPETENCE, DOC_TITLE, EMAIL, PASSWORD) VALUES("+"'"+this.id.getText()+"'"+", '"+this.phone.getText()+"'"+", '"+this.FullName.getText()+"'"
                        +", '"+this.comp.getText()+"'"+", '"+this.title.getText()+"'"+", '"+this.email.getText()+"'"+", '"+this.pass.getText()+"')";
                stm.executeQuery(insQury);
                con.setAutoCommit(false);
                con.commit();
                con.close();
                JOptionPane.showMessageDialog(null, "Done !"); 
                this.FullName.setText("");
                this.comp.setText("");
                this.email.setText("");
                this.id.setText("");
                this.pass.setText("");
                this.phone.setText("");
                this.title.setText("");
            }
        } catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
     @FXML
    private void back_butt(ActionEvent event) {
        //open new window
       try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("first.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
              
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
