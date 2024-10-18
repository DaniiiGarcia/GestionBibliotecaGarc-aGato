package Autor;

import BBDD.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DAO_Autor {

    private Connection conexion;
    JDBC jdbc = new JDBC();
    public DAO_Autor() throws SQLException {
        conexion = jdbc.getConextion();
        createAutor();
        insert();
        addAutor(1, "Daniel");

    }

    public void createAutor(){
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

    public void insert(){
        String insert = """
                INSERT INTO Autor (nombre)
                VALUES
                    ('Gabriel García Márquez'),
                    ('Isabel Allende'),
                    ('Mario Vargas Llosa'),
                    ('Jorge Luis Borges'),
                    ('Julio Cortázar');
                """;

        try (Statement s = conexion.createStatement()){
            s.executeUpdate(insert);
            System.out.println("Tabla Autor creada con exito");

        } catch (SQLException e) {
            System.out.println("Error al crear la tabla Autor");
        }
    }

    public void addAutor(Integer id, String Nombre){
        String add = "INSERT INTO Autor values(?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(add)){

            System.out.println("Introduzca un nombre");
            ps.setInt(1, id);
            ps.setString(2, Nombre);
            ps.executeUpdate();
            System.out.println("Autor creado con exito");

        } catch (SQLException e) {
            System.out.println("Error al crear la tabla Autor");
        }
    }
}


