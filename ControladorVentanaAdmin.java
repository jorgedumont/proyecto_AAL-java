package application;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorVentanaAdmin {

    @FXML
    private Button btnProbando;

    @FXML
    private TextField txtfHora;

    @FXML
    private Text lblInicio;
    
    @FXML
    private Button btnLogOut;
    
    @FXML
    private Button btnSalir;



    @FXML
    void VerHora1(ActionEvent event) {
    	
    	System.out.println("Button Clicked!");
        
        Date now= new Date();
       
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
       
       
         // Model Data
         String dateTimeString = df.format(now);
         
         // Show in VIEW
         txtfHora.setText(dateTimeString);
		   

    }

    @FXML
    void VerHora(ActionEvent event) {
    	
    	
	System.out.println("Button Clicked!");
        
        Date now= new Date();
       
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
       
       
         // Model Data
         String dateTimeString = df.format(now);
         
         // Show in VIEW
         txtfHora.setText(dateTimeString);

    }
    @FXML
    void AbrirLogIn() {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VentanaLogin.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setMaximized(true);
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();
            
           // ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }    	
    }
    @FXML
    public void Logout (ActionEvent cerrarVentana) {//queremos cerrar la ventana de usuario y abrir la de login
    	
        //cerramos la ventana usuario
    	Stage stageclose = (Stage) btnLogOut.getScene().getWindow();
		stageclose.close();
        //abrimos la ventana login
		AbrirLogIn();
		
    }
    
    @FXML
    public void Salir (ActionEvent cerrarApp) {
    	Stage stageclose = (Stage) btnSalir.getScene().getWindow();
		stageclose.close();
    }
    
}

