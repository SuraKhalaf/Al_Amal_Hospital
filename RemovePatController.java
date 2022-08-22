/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import static java.sql.Types.VARCHAR;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import static oracle.jdbc.driver.Representation.VARCHAR;


/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class RemovePatController implements Initializable   {
@FXML 
private TextArea a ;
 @FXML
private TextField SSN; 
    @FXML
    private TableView <Patient> patTable;
    @FXML
    private TableColumn <Patient, String>Cssn;
     @FXML
    private TableColumn <Patient,String> Cfname;
     @FXML
    private TableColumn <Patient,String> Cmname;
     @FXML
    private TableColumn <Patient,String> Clname;
     @FXML
    private TableColumn <Patient,String> Cemail;
      @FXML
    private TableColumn <Patient,String> Cpass;
      @FXML
    private TableColumn <Patient,String> Cgender;
      @FXML
    private TableColumn <Patient,String> Cadd;
      @FXML
    private TableColumn <Patient,String> Cphone;
      @FXML
    private TableColumn <Patient,String> Cbd;
          private ObservableList<ObservableList> data;
          @FXML
          private TableView t;
    /**
     * Initializes the controller class.
     */
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
    
      
    }  
public void  Referesh(){
    this.SSN.setText("");
}
@FXML
     private void remove_butt(ActionEvent event)   {
          try {
              if (this.SSN.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          String sql = "Select * from PATIENT_TABLE where SSN=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, this.SSN.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Statement stm = con.createStatement();
                
               String insQury = "DELETE FROM \"C##SURAS\".\"PATIENT_TABLE\"  WHERE SSN = '"+this.SSN.getText()+ "'";
              
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
    private void show_butt(ActionEvent event) {
       try {
             t.getColumns().clear();
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          Statement stm = con.createStatement();
          String insQury = "SELECT * FROM patient_table";
          ResultSet rs = stm.executeQuery(insQury); 
                data = FXCollections.observableArrayList();

           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                t.getColumns().addAll(col); 
              
            }
           while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
              
                
                    row.add(rs.getString(i));
                }
                
              
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            t.setItems(data);
       
        }
        catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }  
    }
      @FXML
    private void back_butt(ActionEvent event) {
        try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Doctor_login.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Doctor profile");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            Logger.getLogger(DocPassChangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/*  try {
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          Statement stm = con.createStatement();
      
          String insQury = "SELECT * FROM patient_table";
          ResultSet rs = stm.executeQuery(insQury); 
          while (rs.next()){
              list.add(new Patient (rs.getString("ssn"), rs.getString("fname"),  rs.getString("mname"),  rs.getString("lname"),  rs.getString("email"),  rs.getString("pass"),  rs.getString("gender"), rs.getString("add"),  rs.getString("phone"),rs.getString("bd")));
          }
          
          
          Cssn.setCellFactory(new PropertyValueFactory<Patient,String>("ssn"));
          Cfname.setCellFactory(new PropertyValueFactory<>("fname"));
          Cmname.setCellFactory(new PropertyValueFactory<>("mname"));
          Clname.setCellFactory(new PropertyValueFactory<>("lname"));
          Cemail.setCellFactory(new PropertyValueFactory<>("email"));
          Cpass.setCellFactory(new PropertyValueFactory<>("pass"));
          Cgender.setCellFactory(new PropertyValueFactory<>("gender"));
          Cadd.setCellFactory(new PropertyValueFactory<>("add"));
          Cphone.setCellFactory(new PropertyValueFactory<>("phone"));
          Cbd.setCellFactory(new PropertyValueFactory<>("bd"));
        }
        catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }  */