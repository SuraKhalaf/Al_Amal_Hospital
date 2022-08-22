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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class AdminSOController implements Initializable {

    @FXML
    private TableView t;
    @FXML
    private TextField op_id;
    private ObservableList<ObservableList> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void  Referesh(){
    this.op_id.setText("");
}
 @FXML
    private void remove_butt(ActionEvent event) {
        try {
              if (this.op_id.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null, "Fill all fields!");
                  Referesh();
              } else {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          String sql = "Select * from OPERATION_TABLE where OPERATION_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, this.op_id.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Statement stm = con.createStatement();
                
               String insQury = "DELETE FROM \"C##SURAS\".\"OPERATION_TABLE\"  WHERE OPERATION_ID = '"+this.op_id.getText()+ "'";
              
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
          String insQury = "SELECT * FROM OPERATION_TABLE";
          ResultSet rs = stm.executeQuery(insQury); 
     
                data = FXCollections.observableArrayList();
        

           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
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
        //open new window
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
     
    }

