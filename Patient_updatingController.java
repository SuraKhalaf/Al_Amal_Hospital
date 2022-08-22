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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static oracle.net.aso.b.a;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Patient_updatingController implements Initializable {
@FXML
    private PasswordField bb;

    @FXML
    private TextField cc;

    @FXML
    private TextField dd;

    @FXML
    private TextField ff;

    @FXML
    private TextField ii;

    @FXML
    private TextField gg;

    @FXML
    private TextField hh;

    @FXML
    private TextField aa;

    @FXML
    private TextField ee;

      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        public void Pati(){
      
        this.aa.setText("");
         this.bb.setText("");
          this.cc.setText("");
           this.dd.setText("");
            this.ee.setText("");
             this.ff.setText("");
              this.hh.setText("");
               this.gg.setText("");
                this.ii.setText("");
          
    }  // TODO
        
     @FXML
    private void log_out(ActionEvent evt) throws IOException, SQLException {


       Parent scondparent = FXMLLoader.load(getClass().getResource("Patient_page.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)evt.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    
    
    
    
    
    
    
    
    
    
    }
        
        
     @FXML
    private void log(ActionEvent evt) throws IOException, SQLException {
        
    try {
               if (this.aa.getText().isEmpty() || this.bb.getText().isEmpty() || this.cc.getText().isEmpty()|| this.dd.getText().isEmpty()|| 
                    this.ee.getText().isEmpty() || this.ff.getText().isEmpty() || this.ii.getText().isEmpty() || this.gg.getText().isEmpty() 
                     || this.hh.getText().isEmpty()){
                 
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          String sql = "Select * from PATIENT_ACOUNT where PATIENT_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, this.aa.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Statement stm = con.createStatement();
                String insQury = "UPDATE \"C##SURAS\".\"PATIENT_ACOUNT\" SET FIRST_NAME = '"+this.ee.getText()+"', MIDDLE_NAME ='"+this.ff.getText()+"', LAST_NAME ='"
                       +this.gg.getText()+"', EMAIL ='"+this.cc.getText()+"', PASSWORDD ='"+this.bb.getText()+"', GENDER ='"+this.dd.getText()+"', PAT_ADDRESS ='"+this.ii.getText()+"', PAT_NUMBER ='"+this.hh.getText()
                       +"' WHERE PATIENT_ID = '" + this.aa.getText()+ "'";
              
                stm.executeQuery(insQury);
                con.setAutoCommit(false);
                con.commit();
                con.close();
                         
 Notifications not;
        not = Notifications.create();
        not.title("updating successflly");
        not.text("done upate your profile");
        
        not.hideAfter(Duration.seconds(8));
        not .position(Pos.CENTER);
        
        not.onAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }     });
        not.showInformation();
           } 
            else {
                 JOptionPane.showMessageDialog(null, "The ID is not exist!");
                 
            }
              }
        } catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }
      
 
   
    
  
    
    

    
    
    
  
       
                
                
                
                
                
     Pati();
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
    
    
    
    
    
    
    
    
    
    
  
    
}
