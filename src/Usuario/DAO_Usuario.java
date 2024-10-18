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

    public void crearTabla(){
        try{
            String CREATE_USUARIO = "CREATE TABLE IF NOT EXISTS Usuario (id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL);";
            Statement st = conexion.createStatement();
            st.executeUpdate(CREATE_USUARIO);
            System.out.println("Tabla usuario creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al crear el tabla de usuario");
        }
    }
}
