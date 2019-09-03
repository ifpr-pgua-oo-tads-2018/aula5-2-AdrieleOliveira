package jogo.controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jogo.NavegadorJanelas;

import java.sql.SQLException;

public class JanelaJogo extends Controlador{

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfAposta;

    @FXML
    private Label lbTitulo;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbSenha;

    @FXML
    private Label lbAposta;

    @FXML
    private Button btAcao;

    @FXML
    private Label lbResultado;

    @FXML
    private Label lbJogador1;

    @FXML
    private Label lbJogador2;

    @FXML
    private void initialize(){
        lbResultado.setVisible(false);
        lbJogador1.setVisible(false);
        lbJogador2.setVisible(false);
    }

    @FXML
    private void acaoNext() throws SQLException {

        if(ControleJogo.getInstance().getPartida().getJogador1() == null ||
                ControleJogo.getInstance().getPartida().getJogador2() == null) {

            String email = tfEmail.getText();
            String senha = tfSenha.getText();
            String palpite = tfAposta.getText();

            if (email.equals("")) {
                mensagem("E-mail não informado");
                return;
            }

            if (senha.equals("")) {
                mensagem("Senha não informada");
                return;
            }

            if (palpite.equals("")) {
                mensagem("Aposta não informada");
                return;
            }

            int aposta = Integer.valueOf(palpite);

            if (ControleJogo.getInstance().adicionarJogador(email, senha, aposta)) {
                if (ControleJogo.getInstance().getPartida().getJogador2() == null) {
                    lbTitulo.setText("Jogador 2");
                    tfEmail.clear();
                    tfSenha.clear();
                    tfAposta.clear();
                } else {
                    lbTitulo.setVisible(false);
                    tfAposta.setVisible(false);
                    tfSenha.setVisible(false);
                    tfEmail.setVisible(false);
                    lbAposta.setVisible(false);
                    lbEmail.setVisible(false);
                    lbSenha.setVisible(false);
                    btAcao.setVisible(false);

                    ControleJogo.getInstance().sortear();

                    lbResultado.setText("A SOMA DOS DADOS É: " + ControleJogo.getInstance().getPartida().getSoma());

                    if (ControleJogo.getInstance().getPartida().getPalpite1() == ControleJogo.getInstance().getPartida().getSoma())
                        lbJogador1.setText("" + ControleJogo.getInstance().getPartida().getJogador1().getNome() + ": PARABÉNS!");
                    else
                        lbJogador1.setText("" + ControleJogo.getInstance().getPartida().getJogador1().getNome() + ": Não foi desta vez!");

                    if (ControleJogo.getInstance().getPartida().getPalpite2() == ControleJogo.getInstance().getPartida().getSoma())
                        lbJogador2.setText("" + ControleJogo.getInstance().getPartida().getJogador2().getNome() + ": PARABÉNS!");
                    else
                        lbJogador2.setText("" + ControleJogo.getInstance().getPartida().getJogador2().getNome() + ": Não foi desta vez!");

                    lbResultado.setVisible(true);
                    lbJogador1.setVisible(true);
                    lbJogador2.setVisible(true);
                }
            } else {
                mensagem("Jogador não encontrado!");
            }
        }
    }

    @FXML
    private void acaoSair(){
        ControleJogo.getInstance().sairPartida();

        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }
}
