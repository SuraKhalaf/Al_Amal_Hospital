/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import oracle.jdbc.datasource.impl.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Admin_loginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    private void addpat_butt(ActionEvent event){
        //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("adminAddPat.fxml"));
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
    private void addop_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DocAddOp.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Add operation");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updatePat_butt(ActionEvent event) {
          //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminPatInfo.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("AdminRemPat.fxml"));
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
    private void addmed_butt(ActionEvent event){ 
        //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DocAddmed.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Add Mediciene");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addDis_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminAddDis.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Add Disease");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 @FXML
    private void addDoc_butt(ActionEvent event) { 
        //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminAddDoc.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Add Doctor");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void remDoc_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminRSDoc.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("control doctor / nurse");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(Doctor_loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @FXML
    void jasper(ActionEvent event) {
     try {
             OracleDataSource ods = new  OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@192.168.1.10:1521:xe");
            ods.setUser("C##SuraS");
            ods.setPassword("11819597");
            Connection con = ods.getConnection();
            InputStream input = new FileInputStream(new File("Hospital_Jasper.jrxml"));
            JasperDesign jd = JRXmlLoader.load(input);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null,con);
            JFrame f = new JFrame("Report");
            f.getContentPane().add(new JRViewer(jp));
            f.pack();
            f.setVisible(true);
            
           /* OutputStream output = new FileOutputStream(new File("Hospital.pdf"));
            JasperExportManager.exportReportToPdfStream(jp,output);
            output.close();*/
            input.close();
            con.close();
        } catch (Exception ex) {
          //  Logger.getLogger(JasperFram.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
@FXML
    void jasper2(ActionEvent event) {
  try {
             OracleDataSource ods = new  OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@192.168.1.10:1521:xe");
            ods.setUser("C##SuraS");
            ods.setPassword("11819597");
            Connection con = ods.getConnection();
            InputStream input = new FileInputStream(new File("tree.jrxml"));
            JasperDesign jd = JRXmlLoader.load(input);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null,con);
            OutputStream output = new FileOutputStream(new File("Hospital2.pdf"));
            JasperExportManager.exportReportToPdfStream(jp,output);
            output.close();
            input.close();
            con.close();
        } catch (Exception ex) {
          //  Logger.getLogger(JasperFram.class.getName()).log(Level.SEVERE, null, ex);
        } 
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

    @FXML
    private void Logout_butt(ActionEvent event) {
         //open new window
                Stage stage = new Stage();
               Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminMain.fxml"));
            Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Admin Log In");
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
            root = FXMLLoader.load(getClass().getResource("AdminSP.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("AdminSM.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("AdminSO.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("AdminSD.fxml"));
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
