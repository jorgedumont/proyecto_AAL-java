package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ControladorVAAnadirPaciente {

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnChat;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnAyuda;

    @FXML
    private Button btnVerInfo;
    
    @FXML
    private Button bttnVerPac;
    
    //Panel izq (Datos Personales)
    @FXML
    private Label lblApellidos;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblDatosPersonales;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblNumTlfn;
    
    private Button bttnAltaPac;
    
    @FXML
    private Button btnVerPacientes;
    
    @FXML 
    private TextField txtApellidos;
    @FXML
    private TextField txtNombre;
    @FXML 
    private TextField txtDatosPersonales;
    @FXML 
    private TextField txtNumTlfn;
    @FXML 
    private TextField txtDireccion;
    
    //Panel dcha (Sensores)
    @FXML
    private Label lblHabitSens;
    @FXML
    private Label lblSensiSens;
    @FXML
    private Label lblDatosSensores;
    @FXML
    private Label lblTipoSens;
    
    private Button bttnAltaSens;
    
    @FXML 
    private TextField txtTipoSens;
    @FXML
    private TextField txtSensiSens;
    @FXML 
    private TextField txtHabitSens;

    @FXML
    void AbrirInicio(ActionEvent event) {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VAInicio.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            
            stage.setMinWidth(450);
            stage.setMinHeight(300);
            
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            
            stage.setMaximized(true);
            stage.setTitle("Inicio");
            stage.setScene(scene);
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }  	
    }

    @FXML
    void AbrirAnadirPaciente(ActionEvent event) {
    	
    }
    
    @FXML
    void AbrirVerPacientes(ActionEvent event) {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VAVerPacientes.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            
            stage.setMinWidth(450);
            stage.setMinHeight(300);
            
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            
            stage.setMaximized(true);
            stage.setTitle("Ver Pacientes");
            stage.setScene(scene);
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }  	
    }

    @FXML
    void AbrirChat(ActionEvent event) {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VAChat.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            
            stage.setMinWidth(450);
            stage.setMinHeight(300);
            
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            
            stage.setMaximized(true);
            stage.setTitle("Chat");
            stage.setScene(scene);
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }  	
    }


    @FXML
    void AbrirAyuda(ActionEvent event) {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VAAyuda.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            
            stage.setMinWidth(450);
            stage.setMinHeight(300);
            
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            
            stage.setMaximized(true);
            stage.setTitle("Ayuda");
            stage.setScene(scene);
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }  	
    }
    @FXML
    void AbrirLogIn() {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("VentanaLogin.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            
            stage.setMinWidth(450);
            stage.setMinHeight(300);
            
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            
            stage.setMaximized(true);
            stage.setTitle("Login");
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


