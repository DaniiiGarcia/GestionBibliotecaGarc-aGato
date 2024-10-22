package Libro;


import BBDD.JDBC;

import java.sql.*;
import java.util.ArrayList;


public class DAO_Libro {
    Connection conexion;
    ArrayList<DTO_Libro> libros;
    public DAO_Libro(JDBC jdbc) throws SQLException {
        this.conexion = jdbc.getConnection();
        this.libros = new ArrayList<>();
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

            ps.setInt(1, id);
            ps.setString(2, titulo);
            ps.setString(3, ISBN);
            ps.executeUpdate();
            System.out.println("Libro creado con exito");

        } catch (SQLException e) {
            System.out.println("Error al crear el Libro");
        }
    }

    public void addLibro(String titulo, String ISBN) {
        String add = "INSERT INTO Libro(titulo, isbn) values(?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(add)) {
            ps.setString(1, titulo);
            ps.setString(2, ISBN);
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


    //Revisar
    public void modificarLibro(Integer id, Integer opcion, String nuevoValor) {
        String mod = "";
        try (PreparedStatement ps = conexion.prepareStatement(mod)) {
            switch (opcion) {
                case 1:
                    mod = "UPDATE Libro SET titulo = ? WHERE id = ?";
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
                case 2:
                    mod = "UPDATE Libro SET isbn = ? WHERE id = ?";
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
           }
            ps.executeUpdate();
            System.out.println("Libro modificado con exito");
        } catch (SQLException e) {
            System.out.println("Error al modificar el Libro");
        }
    }

    public ArrayList<DTO_Libro> readAll(){
        String readAll = "Select * from Libro";
        libros.clear();
        try(PreparedStatement ps = conexion.prepareStatement(readAll)){

            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String isbn = rs.getString(3);


                libros.add(new DTO_Libro(id,titulo,isbn));
            }

        } catch (SQLException e) {
            System.out.println("Error al recoger los datos");
        }
        return libros;
    }

    public void verLista() {
        String mensaje = "LIBROS";
        int longitudBarra = 15;
        System.out.println("╔" + "═".repeat(longitudBarra) + " " + mensaje + " " + "═".repeat(longitudBarra) + "╗");
        System.out.println("╚" + "═".repeat(2 * longitudBarra + mensaje.length() + 2) + "╝");
        for (DTO_Libro libro : readAll()) {
            System.out.println(libro);
        }
    }

}