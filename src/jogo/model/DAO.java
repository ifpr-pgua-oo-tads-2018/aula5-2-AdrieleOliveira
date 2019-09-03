package jogo.model;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    long insere(T t) throws SQLException;
    List<T> buscaTodos() throws SQLException;
}
