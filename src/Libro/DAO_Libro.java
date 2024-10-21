package Libro;

import BBDD.JDBC;
import Servicio.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DAO_Libro {
    Connection conexion;

    public DAO_Libro(JDBC jdbc) throws SQLException {
        this.conexion = jdbc.getConnection();
        //PARA INSERTAR LOS DATOS PREDEFINIDOS
        //insertarDatos();
    }

    public void insertarDatos() {
        String insert = """
                INSERT INTO Libro (titulo, isbn)
                 VALUES
                    ('Cien Años de Soledad', '978-8437604947'),
                    ('La Casa de los Espíritus', '978-8497592200'),
                    ('La Ciudad y los Perros', '978-0679733038'),
                    ('El Aleph', '978-8420658728'),
                    ('Rayuela', '978-8466332525');
                """;

        try (Statement s = conexion.createStatement()) {
            s.executeUpdate(insert);
            System.out.println("Registros insertados en tabla Libro");

        } catch (SQLException e) {
            System.out.println("Error al insertar datos en tabla Libro");
        }
    }

    public void addLibro(int id, String titulo, String ISBN) {
        String add = "INSERT INTO Libro values(?,?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(add)) {

            ps.setInt(1,id);
            ps.setString(2, titulo);
            ps.setString(3, ISBN);
            ps.executeUpdate();
            System.out.println("Libro creado con exito");

        } catch (SQLException e) {
            System.out.println("Error al crear el Libro");
        }
    }

    public void eliminarLibro(int id) {
        String del = "DELETE FROM Libro WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(del)) {
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Libro eliminado con exito");
        } catch (SQLException e) {
            System.out.println("Error al borrar el libro");
        }
    }


    public void modificarLibro(Integer id) {
        String modTitulo = "UPDATE Libro SET titulo = ? WHERE id = ?";
        String modISBN = "UPDATE Libro SET isbn = ? WHERE id = ?";
        Scanner s = new Scanner(System.in);
        Integer decision;
        String tituloIntroducido;
        Integer idIntroducido;
        String isbnIntroducido;

            System.out.println("""
                    ¿Qué desea hacer? 
                        1. Modificar el Título del libro 
                        2. Modificar el ISBN del libro 
                    """);

                    decision = s.nextInt();

                    switch (decision){
                        case 1:
                            try(PreparedStatement ps = conexion.prepareStatement(modTitulo)){
                                System.out.println("Introduzca el nombre del libro a modificar");
                                tituloIntroducido = s.next();

                                System.out.println("Introduzca el id del libro a modificar");
                                idIntroducido = s.nextInt();
                                ps.setString(1, tituloIntroducido);
                                ps.setInt(2, idIntroducido);

                                ps.execute();
                                System.out.println("Libro con id "+ id +" modificadao correctamente");
                            } catch (SQLException e) {
                                System.out.println("Error al modificar el libro");
                            }
                            break;

                        case 2:
                            try(PreparedStatement ps = conexion.prepareStatement(modISBN)){
                                System.out.println("Introduzca el isbn del libro a modificar");
                                isbnIntroducido = s.next();

                                System.out.println("Introduzca el id del libro a modificar");
                                idIntroducido = s.nextInt();
                                ps.setString(1, isbnIntroducido);
                                ps.setInt(2, idIntroducido);

                                ps.execute();
                                System.out.println("Libro con id "+ id +" modificadao correctamente");

                            } catch (SQLException e) {
                                System.out.println("Error al modificar el libro");
                            }
                            break;
                    }
    }


}
