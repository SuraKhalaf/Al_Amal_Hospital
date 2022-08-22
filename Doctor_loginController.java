/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author zaytona
 */

public class Doctor_loginController implements Initializable {
    /**
     * Initializes the controller class.
     */   
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }   
      @FXML
    private void changepass_butt(ActionEvent event){
    //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("docPassChange.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }} 
    @FXML
    private void Logout_butt(ActionEvent event){
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               scene.setFill(Color.TRANSPARENT);
                stage.initStyle(StageStyle.TRANSPARENT);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
   @FXML
    private void about_butt(ActionEvent event){ 
        //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("abouthospital.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("About hospital");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void info_butt(ActionEvent event){  
           //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("docInfoUp.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Update my information");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void addpat_butt(ActionEvent event){
        //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DocAddPatient.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Add patient");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
    @FXML
    private void updatePat_butt(ActionEvent event){  
           //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DocpatInfo.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Update Patient information");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    private void removePat_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("RemovePat.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Remove Patient ");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void removemed_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Removemed.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Remove medicien ");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void searchpat_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("searchPat.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Searching for patient");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void searchmed_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("SearchMed.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Searching for medicien");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    private void showop_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("showop.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Show operation");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       @FXML
    private void showdis_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("showdis.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Show Diseases");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    
    


