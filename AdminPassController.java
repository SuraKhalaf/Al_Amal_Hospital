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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class AdminPassController implements Initializable {

    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField pass1;
    @FXML
    private Label label;
     @FXML
    private PasswordField pass2;
     @FXML
    private TextField id;
     
    @FXML
public void Referesh() {  
    this.pass1.setText("");  
    this.pass2.setText("");
    this.pass.setText("");
    this.id.setText("");
   
    
}  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update_butt(ActionEvent event) {
        String s1 = pass1.getText() ;
        String s2 = pass2.getText() ;
      if (pass.getText().isEmpty() || pass1.getText().isEmpty()|| id.getText().isEmpty()){
           label.setText("Please Fill fields");
      }
     else if (s1.equals(s2)) {
           try {  
        // establish connection    Connection
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            Connection con = DriverManager.getConnection(url,"C##SuraS","11819597"); 
             String sql = "Select * from ADMIN_TABLE where ADMIN_ID=? and ADMIN_PASSWORD=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id.getText());
            pst.setString(2, pass.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
        Statement stmt = con.createStatement();  
        stmt.execute("UPDATE \"C##SURAS\".\"ADMIN_TABLE\" SET ADMIN_PASSWORD = " + "'" +pass1.getText()+"'" + "WHERE ADMIN_PASSWORD = "+ "'" +pass.getText()+"' and ADMIN_ID =" + "'"+ id.getText() + "'" );
       label.setText("Password is update"); 
        stmt.close();  
        con.close();  
        Referesh(); //Calling Referesh() method  
            } 
             else {
                 JOptionPane.showMessageDialog(null, "The ID is not exist or the old password wrong!");
                  Referesh();
            }
    } catch (Exception ex) {
            Logger.getLogger(Sign_inController.class.getName()).log(Level.SEVERE, null, ex);
    } 
      } 
      else {
        
             label.setText("Not matched password, please try agian ");
         pass1.setText("");  
    pass2.setText("");
    pass.setText("");
    id.setText("");
      }
} 

  @FXML
    private void back_butt(ActionEvent event) {
          //open new window
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
    private void info_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminUp.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Update my information");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
