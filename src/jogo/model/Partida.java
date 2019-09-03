package jogo.model;

public class Partida {
    private int codigo;
    private Jogador jogador1;
    private Jogador jogador2;
    private int palpite1;
    private int palpite2;
    private int soma;

    public Partida(){

    }

    public Partida(Jogador jogador1, Jogador jogador2, int palpite1, int palpite2, int soma) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.palpite1 = palpite1;
        this.palpite2 = palpite2;
        this.soma = soma;
    }

    public Partida(int codigo, Jogador jogador1, Jogador jogador2, int palpite1, int palpite2, int soma) {
        this.codigo = codigo;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.palpite1 = palpite1;
        this.palpite2 = palpite2;
        this.soma = soma;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public void setPalpite1(int palpite1) {
        this.palpite1 = palpite1;
    }

    public void setPalpite2(int palpite2) {
        this.palpite2 = palpite2;
    }

    public int getSoma() {
        return soma;
    }

    public int getPalpite1() {
        return palpite1;
    }

    public int getPalpite2() {
        return palpite2;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
