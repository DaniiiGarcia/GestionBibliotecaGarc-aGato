package Prestamo;

import BBDD.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DAO_Prestamo {
    Connection conexion;
    ArrayList<DTO_Prestamo> prestamos;


    public DAO_Prestamo(JDBC jdbc) {
        this.conexion = jdbc.getConnection();
        this.prestamos = new ArrayList<>();
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
            e.printStackTrace();
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
        String update = "";
        try (PreparedStatement ps = conexion.prepareStatement(update)) {
            switch (opcion) {
                case 1:
                    //CAMBIAR LA FECHA DE INICIO
                    update = "UPDATE Prestamo SET fechaInicio = ? WHERE id = ?";
                    //PONER FORMATO PARA FECHAS!
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
                case 2:
                    //CAMBIAR LA FECHA DE FIN
                    update = "UPDATE Prestamo SET fechaFin = ? WHERE id = ?";
                    //PONER FORMATO PARA FECHAS!
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
                case 3:
                    //CAMBIAR EL USUARIO ID
                    update = "UPDATE Prestamo SET usuarioId = ? WHERE id = ?";
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
                case 4:
                    //CAMBIAR EL LIBRO ID
                    update = "UPDATE Prestamo SET libroId = ? WHERE id = ?";
                    ps.setString(1, nuevoValor);
                    ps.setInt(2, id);
                    break;
            }
            ps.executeUpdate();
            System.out.println("Prestamo modificado con exito");
        } catch (SQLException e) {
            System.out.println("Error al modificar el prestamo");
        }
    }

    public ArrayList<DTO_Prestamo> readAll(){
        String readAll = "Select * from Prestamo";
         prestamos.clear();
        try(PreparedStatement ps = conexion.prepareStatement(readAll)){

            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String fechaInicio = rs.getString(2);
                String fechaFin = rs.getString(3);
                int idU = rs.getInt(4);
                int idL = rs.getInt(5);

                prestamos.add(new DTO_Prestamo(id,fechaInicio, fechaFin, idU, idL));
            }

        } catch (SQLException e) {
            System.out.println("Error al recoger los datos");
        }
        return prestamos;
    }
}
