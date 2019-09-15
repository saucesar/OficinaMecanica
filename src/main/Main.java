package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    private static Parent root;
    private static Stage palco;

    public static void main(String args[]) {
        try {
            launch(args);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO!!!");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            e.printStackTrace();
            alert.showAndWait();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        palco = primaryStage;
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getClassLoader().getResource("gui/telaCadastroCliente.fxml")));
        palco.setScene(new Scene(root));
        palco.show();
    }

    public static void setJanela(Parent janela) {
        try {
            root = janela;
            palco.setScene(new Scene(root));
            palco.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
