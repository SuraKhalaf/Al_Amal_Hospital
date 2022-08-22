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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class AdminUpController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField fname;
    @FXML
    private TextField mname;
    @FXML
    private TextField lname;
    @FXML
    private TextField email;
    @FXML
    private TextField ofc;
    @FXML
    private TextField phone;
    @FXML
    private TextField salary;

    /**
     * Initializes the controller class.
     */
    public void Referesh() { 
        this.id.setText("");
        this.fname.setText("");
        this.mname.setText("");
        this.lname.setText("");
        this.email.setText("");
        this.ofc.setText("");
        this.phone.setText("");
        this.salary.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changepass_butt(ActionEvent event) {
          //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminPass.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Change my password");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

   @FXML
    private void update_butt(ActionEvent event) {
          try {
              if (this.id.getText().isEmpty() || this.fname.getText().isEmpty() || this.mname.getText().isEmpty() || this.lname.getText().isEmpty()
                      || this.email.getText().isEmpty() || this.ofc.getText().isEmpty() || this.phone.getText().isEmpty() || this.salary.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          String sql = "Select * from ADMIN_TABLE where ADMIN_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, this.id.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Statement stm = con.createStatement();
                String insQury = "UPDATE \"C##SURAS\".\"ADMIN_TABLE\" SET FIRST_NAME = '"+this.fname.getText()+"', SECOND_NAME ='"+this.mname.getText()+"', LAST_NAME ='"
                       +this.lname.getText()+"', EMAIL ='"+this.email.getText()+"', ADMIN_OFFICE ='"+this.ofc.getText()+"', ADMIN_NUMBER ='"+this.phone.getText()+"', SALARY ='"+this.salary.getText()+"' WHERE ADMIN_ID = '" + this.id.getText() + "'";
              
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
}
