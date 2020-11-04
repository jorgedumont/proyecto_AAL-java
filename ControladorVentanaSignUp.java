package application;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorVentanaSignUp extends ControladorFicheros{
	ObservableList<String> ListaSexo = FXCollections.observableArrayList("Mujer", "Hombre");
	

    @FXML
    private Button BtnSignUp;

    @FXML
    private Button BtnLogin;

    @FXML
    private TextField TxtFNickname1;

    @FXML
    private TextField TxtFNickname;

    @FXML
    private TextField TxtFGenero;

    @FXML
    private TextField TxtFDNI;

    @FXML
    private ComboBox ComboBoxGenero;
    @FXML
    private void initialize() {
    	ComboBoxGenero.setValue("Hombre");
    	ComboBoxGenero.setItems(ListaSexo);
    }
    @FXML
    private PasswordField TxtFPassword;

    @FXML
    public void IniciarSesion(ActionEvent event) {
    	Stage stageclose = (Stage) BtnLogin.getScene().getWindow();
		stageclose.close();
    	abrirVentana("VentanaLogin.fxml","VentanaLogin");
    }
    
    @FXML
    public void AnadirPaciente(ActionEvent event) {
    try {
		anadirPaciente(this.TxtFNickname.getText(), this.TxtFNickname1.getText(), this.TxtFPassword.getText(), this.TxtFDNI.getText(),this.ComboBoxGenero.getValue().toString().toLowerCase());
	} catch (Exception e) {
		//mostrar cuadrode dialogo con el error
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText("Signup Error");
		alert.setContentText(e.getMessage());
		alert.showAndWait();
	}
    }
    @FXML
    public void ValidarDNI(ActionEvent event) {
    	validarDNI(this.TxtFDNI.getText());
    }
    @FXML
    void a8484(ActionEvent event) {

    }

    @FXML
    void a2a2a2(ActionEvent event) {

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
		stage.setTitle(titulo);
		// Y ahora dentro del Stage me metes la escena que anteriormente hemos
		// le�do y metido en root1
		stage.setScene(new Scene(root1));

		// Y ahora le digo que me muestres el stage
		stage.show();

	}
	

}
