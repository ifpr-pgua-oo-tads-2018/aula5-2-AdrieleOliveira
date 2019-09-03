package jogo.controler;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jogo.NavegadorJanelas;
import jogo.model.Jogador;

import java.sql.SQLException;

public class JanelaJogador extends Controlador{

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    @FXML
    private void acaoSalvar() throws SQLException {
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();

        if(nome.equals("")){
           mensagem("Nome não informado");
           return;
        }

        if(email.equals("")){
            mensagem("E-mail não informado");
            return;
        }

        if(senha.equals("")){
            mensagem("Senha não informada");
            return;
        }

        Jogador j = new Jogador(0, 0, nome, email, senha);
        ControleJogador.getInstance().cadastraJogador(j);

        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }

    @FXML
    private void acaoCancelar(){
        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }
}
