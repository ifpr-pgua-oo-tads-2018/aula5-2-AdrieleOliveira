package jogo.controler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import jogo.NavegadorJanelas;

import java.io.IOException;

public class JanelaPrincipal {

    @FXML
    private void cadastrarJogador(){
        NavegadorJanelas.loadJanela(NavegadorJanelas.JOGADOR);
    }

    @FXML
    private void acaoIniciar(){
        NavegadorJanelas.loadJanela(NavegadorJanelas.JOGO);
    }

    @FXML
    private void mostraRanking(){
       NavegadorJanelas.loadJanela(NavegadorJanelas.RANKING);
    }
}
