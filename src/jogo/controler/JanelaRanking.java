package jogo.controler;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jogo.NavegadorJanelas;
import jogo.model.Jogador;

import java.sql.SQLException;


public class JanelaRanking {

    @FXML
    private TableView<Jogador> tbJogadores;

    @FXML
    private TableColumn<Jogador, String> tcJogadorNome;

    @FXML
    private TableColumn<Jogador, String> tcJogadorEmail;

    @FXML
    private TableColumn<Jogador, Integer> tcJogadorPontos;

    @FXML
    private TableColumn<Jogador, Integer> tcJogadorNumJogadas;

    public void initialize() throws SQLException {
        tcJogadorNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcJogadorEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcJogadorPontos.setCellValueFactory(new PropertyValueFactory<>("pontos"));
        tcJogadorNumJogadas.setCellValueFactory(new PropertyValueFactory<>("numJogadas"));

        tbJogadores.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        try{
            tbJogadores.setItems(ControleJogador.getInstance().listaRanking());
        } catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Problema ao buscar jogadores \n" + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void acaoSair(){
        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }




}
