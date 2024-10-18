package Usuario;

import BBDD.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Usuario {
    private Connection conexion;

    public DAO_Usuario(JDBC jdbc) throws SQLException {
        conexion = jdbc.getConextion();
    }




}
