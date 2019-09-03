package jogo.model;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SqliteJogadorDAO implements JogadorDAO{

    private QueryRunner dbAccess = new QueryRunner();

    public long insere(Jogador jogador) throws SQLException{
        Connection con = FabricaConexao.getConnection();

        int codigo = dbAccess.insert(con,
                "INSERT INTO jogador(nome, email, senha, numJogadas, pontos) VALUES(?,?,?,?,?)",
                new ScalarHandler<Integer>(), jogador.getNome(), jogador.getEmail(), jogador.getSenha(), jogador.getNumJogadas(), jogador.getPontos());

        jogador.setCodigo(codigo);

        con.close();

        return codigo;
    }

    public boolean atualiza(Jogador jogador) throws SQLException{
        Connection con = FabricaConexao.getConnection();

        dbAccess.update(con, "UPDATE jogador SET numJogadas=?, pontos=? where codigo=?",
                jogador.getNumJogadas(), jogador.getPontos(), jogador.getCodigo());

        con.close();

        return true;
    }

    @Override
    public Jogador buscaJogador(String email, String senha) throws SQLException{
        Connection con = FabricaConexao.getConnection();

        Jogador j = dbAccess.query(con, "select * from jogador where email=? and senha=?",
                new BeanHandler<Jogador>(Jogador.class), email, senha);

        con.close();

        return j;
    }

    public List<Jogador> buscaTodos() throws SQLException{

        Connection con = FabricaConexao.getConnection();

        List<Jogador> lista = dbAccess.query(con, "SELECT * FROM jogador",
                new BeanListHandler<Jogador>(Jogador.class));

        con.close();

        return lista;
    }

    public List<Jogador> ranking() throws SQLException{

        Connection con = FabricaConexao.getConnection();

        List<Jogador> lista = dbAccess.query(con, "select * from jogador order by pontos desc, numJogadas",
                new BeanListHandler<Jogador>(Jogador.class));

        con.close();

        return lista;
    }
}
