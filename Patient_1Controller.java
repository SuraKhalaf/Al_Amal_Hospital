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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Patient_1Controller implements Initializable {
     @FXML
    private TextField e;

    @FXML
    private PasswordField password;
    
    
    
      @FXML
     private void register(ActionEvent event) throws IOException {
     Parent scondparent = FXMLLoader.load(getClass().getResource("sign_in_P.fxml"));
                Scene scene2 = new Scene(scondparent);
                Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
                Window.setScene(scene2);

                Window.show();
     }
    
    
    @FXML
     private void sign(ActionEvent event) {
        int c = 0;
        String q;
        try {
            System.out.println("Heoo");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            String url ="jdbc:oracle:thin:@192.168.1.10:1521:xe";
            Connection con=DriverManager.getConnection(url,"C##SuraS","11819597");
            Statement stm=con.createStatement();
             q="select * from PATIENT_ACOUNT WHERE EMAIL=" + "'" + this.e.getText() + "'" + "and" + " PASSWORDD=" + "'" + this.password.getText() + "'";
            System.out.println(q);
           // con.setAutoCommit(true);
            System.out.println(stm.executeUpdate(q));
             PreparedStatement gP=con.prepareStatement(q);
             ResultSet re= gP.executeQuery();
            while (re.next()) {

                c++;
                System.out.println("Helloooo");


            }

            if (c > 0) {
            System.out.println("yeas");  
            
 Notifications not;
        not = Notifications.create();
        not.title("Log-in Complete");
        not.text("Thank You For Choosing Us");
        
        not.hideAfter(Duration.seconds(8));
        not .position(Pos.BOTTOM_RIGHT);
        
        not.onAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }     });
        not.showInformation();
       
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                Parent scondparent = FXMLLoader.load(getClass().getResource("Patient_page.fxml"));
                Scene scene2 = new Scene(scondparent);
                Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
                Window.setScene(scene2);

                Window.show();
            }
else{
                
                
                
                
                
                
                
 
  Notifications not;
        not = Notifications.create();
        not.title("Warning");
        not.text("Invalid email or password please try again");
        
        not.hideAfter(Duration.seconds(8));
        not .position(Pos.BOTTOM_RIGHT);
        
        not.onAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }     });
        not.showError();
            
            
            
            
            
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        
        
        
       
        
        
        
    
        
       
    }
   
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
//sign
