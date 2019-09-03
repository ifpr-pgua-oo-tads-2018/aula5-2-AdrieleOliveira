package jogo;

import jogo.controler.JanelaBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class NavegadorJanelas {

    public static final String BASE = "view/base.fxml";
    public static final String PRINCIPAL = "view/principal.fxml";
    public static final String JOGADOR = "view/jogador.fxml";
    public static final String JOGO = "view/jogo.fxml";
    public static final String RANKING = "view/ranking.fxml";

    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador){
        NavegadorJanelas.controlador = controlador;
    }

    public static void loadJanela(String fxml){
        try{
            controlador.setJanela(
                    (Node) FXMLLoader.load(
                            NavegadorJanelas.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
