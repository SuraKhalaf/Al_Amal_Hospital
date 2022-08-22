/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class List_of_doctor_for_patientController implements Initializable {
 private ObservableList<ObservableList> data;
          @FXML
          private TableView t;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 // TODO
         try {
          t.getColumns().clear();
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
          Connection con = DriverManager.getConnection(url,"C##SuraS","11819597");
          Statement stm = con.createStatement();
          String insQury = "SELECT DOC_ID, FULL_NAME, DOC_NUMBER, JOB_COMPETENCE, EMAIL FROM DOCTOR_TABLE";
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
        }      }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
        

       Parent scondparent = FXMLLoader.load(getClass().getResource("Patient_page.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
        
        
        
        
        
        
        
        
        
        
        
    }
  

}
/*    @FXML
    TextField id;

    @FXML
    TextField name;


    @FXML
    TextField number;

    @FXML
    TextField salary;

    @FXML
    TextField pass;

    @FXML
    TextField email;

    @FXML
    TextField medid;


    @FXML
    TextField job;

    @FXML
    TextField title;


	
    @FXML
    TableColumn<class_for_tableview, String> dr_id;
    @FXML
    TableColumn<class_for_tableview,String> dr_name;
    @FXML
    TableColumn<class_for_tableview,String> number;
    @FXML
    TableColumn<class_for_tableview, String> salary;
    @FXML
    TableColumn<class_for_tableview, String> pass;
    @FXML
    TableColumn<class_for_tableview, String> email;
    @FXML
    TableColumn<class_for_tableview, String> medid;
    @FXML
    TableColumn<class_for_tableview, String> title;
    @FXML
    TableColumn<class_for_tableview, String> dr_job;
    
    
    @FXML
    private TableView<class_for_tableview> table;
    @FXML // صح ؟  لازم نحط
    private TableColumn<class_for_tableview, String> id;
    private TableColumn<class_for_tableview, String> name;
    private TableColumn<class_for_tableview, String> dr_number;
    private TableColumn<class_for_tableview,String> dr_job;
    private TableColumn<class_for_tableview, String> dr_title;
    private TableColumn<class_for_tableview, String> med_id;
    private TableColumn<class_for_tableview,String> dr_email;
    private TableColumn<class_for_tableview, String> dr_pass;
    private TableColumn<class_for_tableview, String> dr_salary;
 ObservableList<class_for_tableview>listm=FXCollections.observableArrayList();
    
    
    
    int index=-1;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    
    
    
    
    public void add(){
        conn=data_table.Connectiondb();
        String ins="INSERT INTO PATIENT_TABLE (id,name,number,salary,pass,email,medid,title.job)values('?','?','?','?','?','?','?','?','?')";
        System.out.print(ins);
        try {
            pst = conn.prepareStatement(ins);
            pst.setString(1, this.id.getText());
            pst.setString(2, this.name.getText());
            pst.setString(3, this.number.getText());
            pst.setString(4, this.pass.getText());
            pst.setString(5, this.title.getText());
            pst.setString(6, this.job.getText());
            pst.setString(7, this.medid.getText()); 
                  pst.setString(8, this.email.getText());
            pst.setString(9, this.salary.getText());
            
            
            
            
            
            
            
            
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"SUCESS ADD");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"ER");
        }




        }
    
    
    
    
    
    
    
  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
    
    
    /*
    
     @FXML
    void back(ActionEvent event) throws IOException {
         Parent scondparent = FXMLLoader.load(getClass().getResource("sign_in_P.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    
    
    
    }
   
  @Override
    public void initialize(URL url, ResourceBundle rb) {
     dr_id.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("id"));
        dr_name.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("name"));
        dr_number.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("number"));
        dr_job.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("job"));     
        dr_salary.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("salary"));
        dr_pass.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("pass"));
          dr_email.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("email"));
        med_id.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("medid"));
           dr_title.setCellValueFactory(new PropertyValueFactory<class_for_tableview,String>("title"));
       
      listm = data_table.getdata();
        System.out.println(listm.size());
        table.setItems(listm);
    }    

    @FXML
    private void back(ActionEvent event) {
    }
     */