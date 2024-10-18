package Usuario;

import BBDD.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Usuario {
    private Connection conexion;
    JDBC jdbc = new JDBC();

    public DAO_Usuario() throws SQLException {
        conexion = jdbc.getConextion();
        crearTabla();
    }




}
