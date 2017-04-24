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

public class Principal {
    @FXML
    TextField numero;
    @FXML
    Button btn_conv;

    public void enviar(ActionEvent actionEvent) throws IOException {
        int st = 0;
        String st1 = numero.getText();
        if (st1.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error en Sub-total");
            alerta.setHeaderText("Mira, hubo un error...");
            alerta.setContentText("El espacio no debe estar vacio.");
            alerta.showAndWait();
            numero.setText("");
            return;

        } else {
            try {
                st = Integer.parseInt(st1);
                if (st >= 0 && st <= 9999){
                    Stage stage = (Stage) btn_conv.getScene().getWindow();
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
                    sc.conversión(st);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error en Sub-total");
                    alerta.setHeaderText("Mira, hubo un error...");
                    alerta.setContentText("El número debe ser de 0 a 9999.");
                    alerta.showAndWait();
                    numero.setText("");
                    return;}
            } catch (NumberFormatException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error en Sub-total");
                alerta.setHeaderText("Mira, hubo un error...");
                alerta.setContentText("Debe escribir un numero entero.");
                alerta.showAndWait();
                numero.setText("");
                return;
            }
        }
    }

    public void limpiar(ActionEvent actionEvent) {
        numero.setText("");
    }


}

