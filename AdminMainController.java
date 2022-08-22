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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class AdminMainController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField pass;
@FXML
    private Label invalid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            String sql = "Select * from ADMIN_TABLE where EMAIL=? and ADMIN_PASSWORD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email.getText());
            pst.setString(2, pass.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                //open new window
                Stage stage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("admin_login.fxml"));
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
    
}
