
package application;	

import java.awt.TextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("/application/VentanaLogin.fxml"));
            Scene scene = new Scene(root);
            
           primaryStage.setMinWidth(450);
           primaryStage.setMinHeight(300);
           
           Screen screen = Screen.getPrimary();
           Rectangle2D bounds = screen.getVisualBounds();
           primaryStage.setWidth(bounds.getWidth());
           primaryStage.setHeight(bounds.getHeight());
            
           primaryStage.setMaximized(true);
           primaryStage.setTitle("Login");
           primaryStage.setScene(scene);
            
            scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
            
            //((TextField)primaryStage.getScene().getProperties().get("TxtFNickname")).setText(""+ControladorFicheros.contar_numero_lineas_fichero("./data/usuarios2.txt"));
            
            primaryStage.show();
     
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

/*
 * @FXML
void VerHora(ActionEvent event) {
	
System.out.println("Button Clicked!");
    
    Date now= new Date();
   
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
   
   
     // Model Data
     String dateTimeString = df.format(now);
     
     // Show in VIEW
     txtfHora.setText(dateTimeString);

} 

*/
