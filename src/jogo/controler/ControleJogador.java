package jogo.controler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jogo.model.Jogador;
import jogo.model.JogadorDAO;
import jogo.model.SqliteJogadorDAO;

import java.sql.SQLException;

public class ControleJogador {

    private static ControleJogador instance = new ControleJogador();

    private ObservableList<Jogador> jogadores;

    private JogadorDAO jogadorDAO = new SqliteJogadorDAO();

    private ControleJogador(){
        jogadores = FXCollections.observableArrayList();
    }

    public static ControleJogador getInstance(){
        return instance;
    }

    public ObservableList<Jogador> listaJogadores() throws SQLException{
        jogadores.clear();
        jogadores.addAll(jogadorDAO.buscaTodos());
        return jogadores;
    }

    public void cadastraJogador(Jogador j) throws SQLException{

        long codigo = jogadorDAO.insere(j);
        j.setCodigo((int) codigo);
        jogadores.add(j);
    }

    public ObservableList<Jogador> listaRanking() throws SQLException{
        jogadores.clear();
        jogadores.addAll(jogadorDAO.ranking());
        return jogadores;
    }

}
