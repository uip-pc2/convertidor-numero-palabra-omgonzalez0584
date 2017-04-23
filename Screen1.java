package sample;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


/**
 * Created by Omar on 23/4/17.
 */
public class screen1 {

    @FXML
    TextField txnum;

    @FXML
    Button btconv;

public void enviar_datos(ActionEvent actionEvent){

    int num;
    String st = txnum.getText();

    num = Integer.parseInt(st);

    Stage stage = (Stage) btconv.getScene().getWindow();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screen2.fxml"));
    Parent root = null;

    try {
        root = (Parent) fxmlLoader.load();
    } catch (Exception e) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error de Aplicacion");
        alerta.setHeaderText("Mira, hubo un error...");
        alerta.setContentText("Lo siento. Llama al administrador.");
        alerta.showAndWait();
        Platform.exit();
    }

    Screen2 sc fxmlLoader.<Screen2>getController();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();





}



}
