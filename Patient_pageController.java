/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Patient_pageController implements Initializable {

   @FXML
    private Button bar1;

    @FXML
    private Button bar2;

    @FXML
    private AnchorPane pareslide;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          pareslide.setTranslateX(-250);
            bar1.setVisible(false);
       bar2.setVisible(true);
    }    

    @FXML
    private void run2(javafx.scene.input.MouseEvent event) {
               TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pareslide);
        slide.setToX(-250);
        slide.play();
        
        
        pareslide.setTranslateX(0);
        slide.setOnFinished((ActionEvent e) -> {
   bar1.setVisible(false);
       bar2.setVisible(true);
       
    });
    }

    @FXML
    private void run1(javafx.scene.input.MouseEvent event) {
         TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pareslide);
        slide.setToX(0);
        slide.play();
        
        
        pareslide.setTranslateX(-250);
        slide.setOnFinished((ActionEvent e) -> {
   bar1.setVisible(true);
       bar2.setVisible(false);
       
    });     
    }

    @FXML
    void ha(ActionEvent event) throws IOException {

       Parent scondparent = FXMLLoader.load(getClass().getResource("Patient_updating.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    }

    @FXML
    void list(ActionEvent event) throws IOException {
       Parent scondparent = FXMLLoader.load(getClass().getResource("list_of_doctor_for_patient.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    }

    @FXML
    private void log_out(ActionEvent evt) throws IOException {
        
 

       Parent scondparent = FXMLLoader.load(getClass().getResource("patient_1.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)evt.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
      }

  @FXML
    private void aboutt(ActionEvent evt) throws IOException {
           Parent scondparent = FXMLLoader.load(getClass().getResource("abouttt.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)evt.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
        
    }   
     @FXML
    private void appo(ActionEvent evt) throws IOException {
           Parent scondparent = FXMLLoader.load(getClass().getResource("patient_appointment.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)evt.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
        
    } 
    @FXML
    void dis(ActionEvent event) throws IOException {
      Parent scondparent = FXMLLoader.load(getClass().getResource("pat_dis.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    }
   
    }
