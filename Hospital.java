
package hospital;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Hospital extends Application {   
    private static final int count=50000;
    public Hospital(){
        
    }
    public void inti() throws Exception{
        
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        Scene scene = new Scene(root);
        String css = Hospital.class.getResource("mystyle.css").toExternalForm();
        scene.getStylesheets().add(css);
       
        stage.setScene(scene);
      
        stage.setTitle("Main Page");
        stage.show();
    }
    public void init() throws Exception{
        for(int i =350 ; i<count ;i++){
            double prog = (100*i)/count;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(prog));
        }
    }

    public static void main(String[] args) {
         LauncherImpl.launchApplication(Hospital.class, myproc.class, args);
       
    }
    
}
