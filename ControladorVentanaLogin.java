package application;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
//import modelo.Usuario; Esta dentro del mismo paquete, si lo dividimos, descomentar
import javafx.stage.Stage;

public class ControladorVentanaLogin {

	@FXML
	private TextField TxtFNickname;

	@FXML
	private Button BtnIniciar;

	@FXML
	private Label LblBienvenido;

	@FXML
	private PasswordField TxtFPassword;
	
	@FXML
	private Button BtnSignUp;

	public Vector<Usuario> ListaLogin;
	ControladorFicheros cf = new ControladorFicheros();
	
	public void SignUp(ActionEvent event) {
		Stage stageclose = (Stage) BtnSignUp.getScene().getWindow();
		stageclose.close();
		abrirVentana("VentanaSignUp.fxml", "VentanaSignUp");
	}
	

	public void IniciarSesion(ActionEvent e) {

		ListaLogin = new Vector<Usuario>();
		if (TxtFNickname.getText().isEmpty() || TxtFPassword.getText().isEmpty()) {
			
			/*JOptionPane.showMessageDialog(null, "Error. Introduzca su usaurio y contrase�a", "Faltan datos",
					JOptionPane.ERROR_MESSAGE);*/
			
			
			//Website para las alertas: https://code.makery.ch/blog/javafx-dialogs-official/
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Inicio de Sesion");
			alert.setHeaderText("Error en el Inicio de sesion");
			alert.setContentText("Por favor, introduzca tanto Username como Password");

			alert.showAndWait();
		}
		this.Verificar(TxtFNickname.getText(), TxtFPassword.getText());

		/*
		 * Date now= new Date();
		 * 
		 * DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
		 * 
		 * 
		 * // Model Data String dateTimeString = df.format(now);
		 * 
		 * // Show in VIEW TxtFNickname.setText(dateTimeString);
		 * 
		 * 
		 * 
		 */

	}

	public void Verificar(String login, String password) {
		
		
		Vector<Usuario> ListaLogin = cf.leerUsuarios();
		
		
		Usuario Real = null;

		for (int i = 0; i < ListaLogin.size(); i++) {
			
			

			if (ListaLogin.get(i).getNickname().equals(login) && ListaLogin.get(i).getPassword().equals(password)) {

				
				
				Real = ListaLogin.get(i);
				
				
				
				//Dialogs.create().message("Hi!").showInformation(); //ir a esta pagina https://code.makery.ch/blog/javafx-2-dialogs/ para sustituir los optionpanel que no funcionan en mac
				
				/* Dialogs.create()
		        .owner(stage)
		        .title("Information Dialog")
		        .masthead("Look, an Information Dialog")
		        .message("I have a great message for you!")
		        .showInformation(); */
		        
				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setTitle("Inicio de Sesion");
				alert1.setHeaderText(null);
				alert1.setContentText("Username y password correctos!");

				alert1.showAndWait();

				
				Stage stageclose = (Stage) BtnIniciar.getScene().getWindow();
				stageclose.close();
				if (Real.getRol().equals(Usuario.ROL_ADMIN)) {
					abrirVentana("VAInicio.fxml", "VAInicio");
				} else { // Real.getRol().equals(Usuario.ROL_USUARIO)
					abrirVentana("VUVerDatos.fxml", "VUVerDatos"); //Cambiado para probar
				}
				return;
			}
			// String texto = Real.getNickname(); Esto vale para confirmar rol,
			// y pasar metodo especifico
		}
		if (Real == null) {
			
			/*JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrecta");
			return;*/
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Inicio de Sesion");
			alert.setHeaderText("Error en Inicio de Sesion");
			alert.setContentText("Username o Password incorrectos");

			alert.showAndWait();
		}

	}

	public void abrirVentana(String ventana, String titulo) {

		// Te lo comento para que lo comprendamos t� y yo
		// L�eme el source del archivo que te digo fxml y te pongo el path

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ventana));
		Parent root1;
		try {
			root1 = (Parent) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// Creame un nuevo Stage o para que nos entendamos una nueva ventana
		// windows vac�a
		Stage stage = new Stage();
		
		stage.setMinWidth(450);
        stage.setMinHeight(300);
		
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        
		stage.setTitle(titulo);
		stage.setMaximized(true);
		// Y ahora dentro del Stage me metes la escena que anteriormente hemos
		// le�do y metido en root1
		stage.setScene(new Scene(root1));

		// Y ahora le digo que me muestres el stage
		stage.show();

	}
	

}
