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
public class DocAddOpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private TextField op_id; 
    @FXML 
    private TextField room;
    @FXML 
    private TextField st; 
    @FXML 
    private TextField et; 
    @FXML 
    private TextField doc_id; 
     @FXML 
    private TextField dt; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML 
    public void  Referesh() {
    this.doc_id.setText("");
    this.op_id.setText("");
    this.room.setText("");
    this.st.setText("");
    this.et.setText("");
    this.dt.setText("");
}
    @FXML
    private void back_butt(ActionEvent event) {
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
    private void add_butt(ActionEvent event) {
         try {
              if (this.doc_id.getText().isEmpty() || this.op_id.getText().isEmpty() || this.room.getText().isEmpty()|| this.st.getText().isEmpty() || 
                    this.et.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
            try (Connection con = DriverManager.getConnection(url,"C##SuraS","11819597")) {
                Statement stm = con.createStatement();
                String insQury = "INSERT INTO \"C##SURAS\".\"OPERATION_TABLE\" (OPERATION_ID, ROOM_NUM, START_TIME, END_TIME, DOC_ID, DATEE) VALUES("+"'"+this.op_id.getText()+"'"+", '"+this.room.getText()+"'"+
                      ", '"+this.st.getText()+"'"+", '"+this.et.getText()+"'"+", '"+this.doc_id.getText()+"'"+", '"+this.dt.getText()+"')";
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
