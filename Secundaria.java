package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.String.valueOf;


public class Secundaria {

    @FXML
    TextField txletras;

    @FXML
    Button bt_volver;


    public void setTotal(int t) {
        txletras.setText(Integer.toString(t));
    }

    public void volver(MouseEvent mouseEvent) {
        Stage stage = (Stage) bt_volver.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Principal.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de Aplicacion");
            alerta.setHeaderText("Mira, hubo un error...");
            alerta.setContentText("Lo siento. Llama al administrador.");
            alerta.showAndWait();
            Platform.exit();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
