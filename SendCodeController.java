/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

//import com.sun.org.glassfish.external.statistics.annotations.Reset;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
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
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class SendCodeController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField email1;
   Connection con = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;
    int randomCode;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void send_Butt(ActionEvent event) {
        try {
        Random r = new Random() ;
        randomCode = r.nextInt(999999);
        String host = "smtp.gmail.com"; 
        String user = "tsnemailsndr@gmail.com";
        String pass = "vQ#Tgez@=KRFM2E4";
        String to = email.getText();
        String subject = "Resting code";
        String message = "Your rest code is"+randomCode;
        boolean sessionDebug = false;
        Properties procs = System.getProperties();
        procs.put("mail.smtp.starttls.enable", "true"); 
        procs.put("mail.smtp.host", "host");
        procs.put("mail.smtp.port", "587");
        procs.put("mail.smtp.auth", "true");
        procs.put("mail.smtp.starttls.required", "true");
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(procs, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(user));
        InternetAddress [] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setText(message);
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(host, user, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        JOptionPane.showMessageDialog(null, "code has been send to the email");} 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    private void verify_Butt(ActionEvent event){
        if(Integer.valueOf(this.email1.getText())== randomCode){
             try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Reset.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
              
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
                } 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
   

    @FXML
    private void loginButt(ActionEvent event) {
    }
}
