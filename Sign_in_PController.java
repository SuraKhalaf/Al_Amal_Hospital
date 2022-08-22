/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

//import cbcb.TwoController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Sign_in_PController implements Initializable {

    @FXML
    private PasswordField b;
    @FXML
    private TextField aa;
    @FXML
    private TextField c;
    @FXML
    private TextField d;
    @FXML
    private TextField e;
    @FXML
    private TextField f;
    @FXML
    private TextField g;
    @FXML
    private TextField h;
    @FXML
    private TextField i;
   

    
    
    
    
    
    
    
    
    
    
    @FXML
     private void go_to_Patient_page(ActionEvent event) {
  
      try{   
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@192.168.1.10:1521:xe";
        Connection con=DriverManager.getConnection(url,"C##SuraS","11819597");
        Statement stm=con.createStatement();
        String insQry="INSERT INTO PATIENT_ACOUNT values(" +"'"+ this.aa.getText() + "'"+",'"+this.b.getText()+"'"+",'"+ this.c.getText()+ "'"+",'"+ this.d.getText()+ "'"+",'"+ this.e.getText()+"'"+",'"+ this.f.getText()+"'"+",'"+ this.g.getText()+ "'"+",'"+ this.h.getText()+"'"+",'"+ this.i.getText() +"')";
        System.out.print(insQry);
        
        stm.executeUpdate(insQry);
        con.setAutoCommit(false);
        con.commit();
        con.close();
        
        
        
        
        
   
      
    } catch (Exception ex) {
       System.out.print(ex.toString());
    }
      
      
  Notifications not;
        not = Notifications.create();
        not.title("Creating acount => Done Successflly");
        not.text("Saved to Oracle-Sql-Developer");
        
        not.hideAfter(Duration.seconds(8));
        not .position(Pos.BOTTOM_RIGHT);
        
        not.onAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }     });
        not.showInformation();
               

      
      
      
      
      
      
      
      
      
      
      
      
         
         
         
         
         
         
         
         
        
       try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("patient_1.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
              stage.setTitle("Patient_page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    @FXML
    void back(ActionEvent event) {
  try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("patient_1.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
              stage.setTitle("Patient_page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
