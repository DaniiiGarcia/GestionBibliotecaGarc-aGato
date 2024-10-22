package Libro_Autor;

import Autor.DAO_Autor;
import BBDD.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_LibroAutor {
    Connection conexion;

    public DAO_LibroAutor(JDBC jdbc) {
        this.conexion = jdbc.getConnection();
    }

    public void insertarDatos() {
        String insert = """
                INSERT INTO Libro_Autor (idLibro, idAutor)
                   VALUES
                   (1, 1),
                   (2, 2),
                   (3, 3),
                   (4, 4),
                   (5, 5),
                   (5, 4);
                """;

        try (Statement s = conexion.createStatement()) {
            s.executeUpdate(insert);
            System.out.println("Libros_Autores insertados correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar los datos de Libros_Autores");
        }
    }

    public void addLibro_Autor(Integer idLibro, Integer idAutor) {
        String add = "INSERT INTO Libro_Autor values(?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(add)) {
            ps.setInt(1, idLibro);
            ps.setInt(2, idAutor);
            ps.executeUpdate();
            System.out.println("Libro_Autor creado con exito");
        } catch (SQLException e) {
            System.out.println("Error al añadir el Libro_Autor");
        }
    }

    public void eliminarLibro_Autor(Integer id) {
        String del = "DELETE FROM Libro_Autor WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(del)) {
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Libro_Autor eliminado con exito");
        } catch (SQLException e) {
            System.out.println("Error al borrar el Libro_Autor");
        }
    }

    public void modificarLibro_Autor(Integer id, Integer opcion, String nuevoValor) {
        String update = "";
        try (PreparedStatement ps = conexion.prepareStatement(update)) {
            switch (opcion) {
                case 1:
                    //CAMBIAR EL IDLIBRO
                    update = "UPDATE Libro_Autor SET idLibro = ? WHERE id = ?";
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
                case 2:
                    //CAMBIAR EL IDAUTOR
                    update = "UPDATE Libro_Autor SET idAutor = ? WHERE id = ?";
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
            }
            ps.executeUpdate();
            System.out.println("Libro_Autor modificado con exito");
        } catch (SQLException e) {
            System.out.println("Error al modificar el Libro_Autor");
        }
    }
}
