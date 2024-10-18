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

    public void create(){
        String CREATE_AUTOR= """
                CREATE TABLE IF NOT EXISTS Autor (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nombre VARCHAR(100) NOT NULL
                );
                """;

        try (Statement s = conexion.createStatement()){

            s.executeUpdate(CREATE_AUTOR);
            System.out.println("Tabla Autor creada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al crear la tabla del usuario");
        }
    }
}
