package jogo.model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SqlitePartidaDAO implements PartidaDAO {

    private QueryRunner dbAccess = new QueryRunner();

    public long insere(Partida partida) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        int codigo = dbAccess.insert(con,
                "INSERT INTO partida(jogador1, jogador2, palpite1, palpite2, soma) VALUES(?,?,?,?,?)",
                new ScalarHandler<Integer>(), partida.getJogador1().getCodigo(), partida.getJogador2().getCodigo(), partida.getPalpite1(), partida.getPalpite2(), partida.getSoma());

        partida.setCodigo(codigo);

        con.close();

        return codigo;
    }


    public List<Partida> buscaTodos() throws SQLException{

        Connection con = FabricaConexao.getConnection();

        List<Jogador> lista = dbAccess.query(con, "SELECT * FROM jogador",
                new BeanListHandler<Jogador>(Jogador.class));

        con.close();

        return null;
    }
}
