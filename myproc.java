/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author zaytona
 */
public class myproc extends Preloader {
    private Stage load ;
    private Scene scene;
 public myproc() {
        
    }
    public void init() throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("loading.fxml"));
        scene = new Scene (root1);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.load =primaryStage;
        load.setScene(scene);
        load.initStyle(StageStyle.UNDECORATED);
        load.show();
        
    }
    public void handleApplicationNotification(PreloaderNotification info){
        if (info instanceof ProgressNotification ){
            FXML2Controller.label.setText("Loading  "+ ((ProgressNotification )info).getProgress()+"%");
        }
        
    }
   public void handleStateChangeNotification(StateChangeNotification info){
       StateChangeNotification.Type type = info.getType();
       switch (type){
           case BEFORE_START:
               System.out.println("BEFORE START");
               load.hide();
               break;
       }
   }
}
