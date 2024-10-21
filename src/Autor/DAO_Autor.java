package Autor;

import BBDD.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO_Autor {
    Connection conexion;


    public DAO_Autor(JDBC jdbc) throws SQLException {
        this.conexion = jdbc.getConnection();
        //PARA INSERTAR LOS DATOS PREDEFINIDOS
        //insertarDatos();
    }

    public void insertarDatos() {
        String insert = """
                INSERT INTO Autor (nombre)
                VALUES
                    ('Gabriel García Márquez'),
                    ('Isabel Allende'),
                    ('Mario Vargas Llosa'),
                    ('Jorge Luis Borges'),
                    ('Julio Cortázar');
                """;

        try (Statement s = conexion.createStatement()) {
            s.executeUpdate(insert);
            System.out.println("Tabla Autor creada con exito");

        } catch (SQLException e) {
            System.out.println("Error al crear la tabla Autor");
        }
    }

    public void añadirAutor(Integer id, String Nombre) {
        String add = "INSERT INTO Autor values(?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(add)) {
            ps.setInt(1, id);
            ps.setString(2, Nombre);
            ps.executeUpdate();
            System.out.println("Autor creado con exito");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla Autor");
        }
    }

    public void eliminarAutor(Integer id) {
        String del = "DELETE FROM Autor WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(del)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error al borrar el autor");
        }
    }
}


