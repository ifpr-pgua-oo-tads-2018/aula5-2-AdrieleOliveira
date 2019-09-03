package jogo.model;


public class Jogador {

    private int codigo;
    private int numJogadas;
    private int pontos;
    private String nome;
    private String email;
    private String senha;

    public Jogador(){

    }

    public Jogador(int codigo, int numJogadas, int pontos, String nome, String email, String senha) {
        this.codigo = codigo;
        this.numJogadas = numJogadas;
        this.pontos = pontos;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Jogador(int numJogadas, int pontos, String nome, String email, String senha) {
        this.numJogadas = numJogadas;
        this.pontos = pontos;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getNumJogadas() {
        return numJogadas;
    }

    public int getPontos() {
        return pontos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNumJogadas(int numJogadas) {
        this.numJogadas = numJogadas;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", numJogadas=" + numJogadas +
                ", pontos=" + pontos +
                '}';
    }
}
