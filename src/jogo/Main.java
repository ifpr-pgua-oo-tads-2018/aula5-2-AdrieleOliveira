package jogo;

import jogo.controler.JanelaBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws Exception{
        Pane root = loadMainPane();

        stage.setScene(new Scene(root));

        stage.setTitle("Jogo de Dados");
        stage.show();
    }

    private Pane loadMainPane() throws IOException{
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        NavegadorJanelas.BASE
                )
        );

        JanelaBase controller = loader.getController();

        NavegadorJanelas.setControlador(controller);
        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);

        return mainPane;
    }
}
