package sample;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;



/**
 * Created by Omar on 23/4/17.
 */
public class Principal {

    @FXML
    TextField txnum;

    @FXML
    Button btconv;

public void enviar(ActionEvent actionEvent){

    int num;
    String st = txnum.getText();

    if (st.isEmpty()) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error en Sub-total");
        alerta.setHeaderText("Mira, hubo un error...");
        alerta.setContentText("El sub-total no debe estar vacio.");
        alerta.showAndWait();
        txnum.setText("");
        return;
    }
    num = Integer.parseInt(st);



    Stage stage = (Stage) btconv.getScene().getWindow();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Secundaria.fxml"));
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

    Secundaria sc = fxmlLoader.<Secundaria>getController();
    sc.setTotal(num);

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();





}



}
