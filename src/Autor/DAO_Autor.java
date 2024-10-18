package Autor;

import BBDD.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Autor {

    private Connection conexion;
    JDBC jdbc = new JDBC();
    public DAO_Autor() throws SQLException {
        conexion = jdbc.getConextion();
        create();
    }
}
