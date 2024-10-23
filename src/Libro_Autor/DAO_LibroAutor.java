package Libro_Autor;

import BBDD.JDBC;
import Usuario.DTO_Usuario;

import java.sql.*;
import java.util.ArrayList;

public class DAO_LibroAutor {
    Connection conexion;

    ArrayList<DTO_LibroAutor> libroAutor = new ArrayList<>();

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
            System.out.println("Se ha asignado el libro al autor correctamente");
        } catch (SQLException e) {
            System.out.println("Error al asignar el libro al autor");
        }
    }

    public void eliminarLibro_Autor(Integer id) {
        String del = "DELETE FROM Libro_Autor WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(del)) {
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Asignación eliminada con exito");
        } catch (SQLException e) {
            System.out.println("Error al borrar la asignación");
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
            System.out.println("Asignación modificada con exito");
        } catch (SQLException e) {
            System.out.println("Error al modificar la asignación");
        }
    }

    public ArrayList<DTO_LibroAutor> readAll() {
        String select = "Select * from Libro_Autor";
        try (PreparedStatement ps = conexion.prepareStatement(select)) {

            ps.executeQuery();

            ResultSet rs = ps.executeQuery();
            Integer idLibro;
            Integer idAutor;
            while (rs.next()) {
                idLibro = rs.getInt(1);
                idAutor = rs.getInt(2);

                libroAutor.add(new DTO_LibroAutor(idLibro, idAutor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return libroAutor;
    }

    public void verLista() {
        String mensaje = "LIBROS-AUTORES";
        int longitudBarra = 15;
        System.out.println("╔" + "═".repeat(longitudBarra) + " " + mensaje + " " + "═".repeat(longitudBarra) + "╗");
        System.out.println("╚" + "═".repeat(2 * longitudBarra + mensaje.length() + 2) + "╝");
        for (DTO_LibroAutor la : readAll()) {
            System.out.println(la);
        }
    }
}
