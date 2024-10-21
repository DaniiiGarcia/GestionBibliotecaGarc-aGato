package Prestamo;

import BBDD.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Prestamo {
    Connection conexion;

    public DAO_Prestamo(JDBC jdbc) {
        this.conexion = jdbc.getConnection();
    }

    public void insertarDatos() {
        String insert = """
                INSERT INTO Prestamo (fechaInicio, fechaFin, usuarioId, libroId)
                VALUES ('2023-10-01', '2023-10-15', 1, 1),
                ('2023-09-20', '2023-10-05', 2, 2),
                ('2023-10-05', '2023-10-20', 3, 3),
                ('2023-09-30', '2023-10-15', 4, 4),
                ('2023-10-01', '2023-10-10', 5, 5);
                """;

        try (Statement s = conexion.createStatement()) {
            s.executeUpdate(insert);
            System.out.println("Prestamos insertados correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar los datos de los prestamos");
        }
    }

    public void addPrestamo(Integer id, String fechaInicio, String fechaFin, Integer idUsuario, Integer idLibro) {
        String add = "INSERT INTO Prestamo values(?,?,?,?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(add)) {
            ps.setInt(1, id);
            ps.setString(2, fechaInicio);
            ps.setString(3, fechaFin);
            ps.setInt(4, idUsuario);
            ps.setInt(5, idLibro);
            ps.executeUpdate();
            System.out.println("Prestamo creado con exito");
        } catch (SQLException e) {
            System.out.println("Error al añadir el prestamo");
        }
    }

    public void eliminarPrestamo(Integer id) {
        String del = "DELETE FROM Prestamo WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(del)) {
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Prestamo eliminado con exito");
        } catch (SQLException e) {
            System.out.println("Error al borrar el prestamo");
        }
    }

    //Revisar
    public void modificarPrestamo(Integer id, Integer opcion, String nuevoValor) {
        String del = "";
        try (PreparedStatement ps = conexion.prepareStatement(del)) {
            switch (opcion) {
                case 1:
                    //CAMBIAR LA FECHA DE INICIO
                    del = "DELETE FROM Prestamo WHERE fechaInicio = ?";
                    //PONER FORMATO PARA FECHAS!
                    ps.setString(1, nuevoValor);
                    break;
                case 2:
                    //CAMBIAR LA FECHA DE FIN
                    del = "DELETE FROM Prestamo WHERE fechaFin = ?";
                    //PONER FORMATO PARA FECHAS!
                    ps.setString(1, nuevoValor);
                    break;
                case 3:
                    //CAMBIAR EL USUARIO ID
                    del = "DELETE FROM Prestamo WHERE usuarioid = ?";
                    ps.setString(1, nuevoValor);
                    break;
                case 4:
                    //CAMBIAR EL LIBRO ID
                    del = "DELETE FROM Prestamo WHERE libroid = ?";
                    ps.setString(1, nuevoValor);
                    break;
            }
            ps.executeUpdate();
            System.out.println("Prestamo modificado con exito");
        } catch (SQLException e) {
            System.out.println("Error al modificar el prestamo");
        }
    }
}
