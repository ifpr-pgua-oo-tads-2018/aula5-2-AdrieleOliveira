package jogo.controler;

import jogo.model.*;

import java.sql.SQLException;
import java.util.Random;

public class ControleJogo {

    private static ControleJogo instance = new ControleJogo();

    private Partida partidaAtual = null;
    private JogadorDAO jogadorDAO = new SqliteJogadorDAO();
    private PartidaDAO partidaDAO = new SqlitePartidaDAO();

    public static ControleJogo getInstance(){
        return instance;
    }

    public Partida getPartida(){
        if(partidaAtual == null){
            partidaAtual = new Partida();
        }

        return partidaAtual;
    }

    public void sairPartida(){
        partidaAtual = null;
    }

    public boolean adicionarJogador(String email, String senha, int palpite) throws SQLException {

        Jogador j = jogadorDAO.buscaJogador(email, senha);

        if(j != null) {
            if (partidaAtual.getJogador1() == null) {

                partidaAtual.setJogador1(j);
                partidaAtual.setPalpite1(palpite);
            } else {
                partidaAtual.setJogador2(j);
                partidaAtual.setPalpite2(palpite);
            }

            return true;
        }

        return false;
    }

    public void sortear() throws SQLException{
        Random rand = new Random();
        int dado1 = rand.nextInt(6)+1;
        int dado2 = rand.nextInt(6)+1;

        int soma = dado1 + dado2;

        partidaAtual.setSoma(soma);

        partidaDAO.insere(partidaAtual);

        Jogador j1 = partidaAtual.getJogador1();
        Jogador j2 = partidaAtual.getJogador2();

        int palpite1 = partidaAtual.getPalpite1();
        int palpite2 = partidaAtual.getPalpite2();

        if(palpite1 == palpite2 && palpite1 == soma){
            j1.setNumJogadas(j1.getNumJogadas() + 1);
            j2.setNumJogadas(j2.getNumJogadas() + 1);

            j1.setPontos(j1.getPontos() + 2);
            j2.setPontos(j2.getPontos() + 2);
        } else if(palpite1 == soma){
            j1.setNumJogadas(j1.getNumJogadas() + 1);
            j2.setNumJogadas(j2.getNumJogadas() + 1);

            j1.setPontos(j1.getPontos() + 3);
        } else {
            j1.setNumJogadas(j1.getNumJogadas() + 1);
            j2.setNumJogadas(j2.getNumJogadas() + 1);

            j2.setPontos(j2.getPontos() + 3);
        }

        jogadorDAO.atualiza(j1);
        jogadorDAO.atualiza(j2);
    }
}
