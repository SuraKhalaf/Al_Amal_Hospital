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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class AdminAddDisController implements Initializable {

    @FXML
    private TextField dis_id;
    @FXML
    private TextField dis_name;
    @FXML
    private TextField syn;
    @FXML
    private TextField med_id;

    /**
     * Initializes the controller class.
     */
    @FXML
public void Referesh() { 
this.dis_id.setText("");
this.dis_name.setText("");
this.med_id.setText("");
this.syn.setText("");
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back_butt(ActionEvent event) {
          try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("admin_login.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Admin login");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @FXML
    private void addDis_butt(ActionEvent event){
      try { 
             if (this.dis_id.getText().isEmpty() || this.dis_name.getText().isEmpty() || this.med_id.getText().isEmpty() || this.syn.getText().isEmpty()){
                 
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh(); 
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            try (Connection con = DriverManager.getConnection(url,"C##SuraS","11819597")) {
                Statement stm = con.createStatement();
                String insQury = "INSERT INTO \"C##SURAS\".\"DISEASE_TABLE\" (DIS_ID, DIS_NAME, DIS_SYRNDOM, MED_ID) VALUES("+"'"+this.dis_id.getText()+"'"
                 +", '"+this.dis_name.getText()+"'"+", '"+this.syn.getText()+"'"+", '"+this.med_id.getText()+"')";
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
