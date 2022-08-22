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
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Sign_inController implements Initializable {
     //Invalid login, please try again
    /**
     * Initializes the controller class.
     */
    @FXML 
    private TextField email; 
    @FXML 
    private PasswordField pass; 
    @FXML
    private Label invalid;
   
    
    ResultSet res ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           
}
    
     @FXML
private void exitButtonOnAction(ActionEvent event){

    int c =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
    if (c == JOptionPane.YES_OPTION) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();  
} else {
    
}
         }


@FXML 
private void loginButt (ActionEvent event){
    if (this.email.getText().isEmpty() || this.pass.getText().isEmpty() )
    {
        invalid.setText("Please Fill All Fields");
    }
    else {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            Connection con = DriverManager.getConnection(url,"C##SuraS","11819597"); 
            String sql = "Select * from DOCTOR_TABLE where EMAIL=? and PASSWORD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email.getText());
            pst.setString(2, pass.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                //open new window
                Stage stage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("Doctor_login.fxml"));
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Doctor profile");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            else {
                invalid.setText("Email or password is incorrect");
                email.setText("");
                pass.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(Sign_inController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
} }
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
@FXML
    private void forgot_butt(ActionEvent event){
       
         try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("SendCode.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
              
               stage.show();
                } 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

   
}    
    
   //   stm = con.prepareStatement("select * from DOCTOR_TABLE where EMAIL=? and PASSWORD=?");