package Usuario;

import Autor.DTO_Autor;
import BBDD.JDBC;

import java.sql.*;
import java.util.ArrayList;

public class DAO_Usuario {
    Connection conexion;
    ArrayList<DTO_Usuario> usuarios;

    public DAO_Usuario(JDBC jdbc) {
        this.conexion = jdbc.getConnection();
        this.usuarios = new ArrayList<>();
    }

    public void insertarDatos() {
        String insert = """
                INSERT INTO Usuario (nombre)
                VALUES
                    ('Juan Pérez'),
                    ('María López'),
                    ('Carlos García'),
                    ('Ana Fernández'),
                    ('Luis Martínez');
                """;

        try (Statement s = conexion.createStatement()) {
            s.executeUpdate(insert);
            System.out.println("Usuarios insertados correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar los datos de los usuarios");
        }
    }

    public void addUsuario(Integer id, String Nombre) {
        String add = "INSERT INTO Usuario values(?,?)";

        try (PreparedStatement ps = conexion.prepareStatement(add)) {
            ps.setInt(1, id);
            ps.setString(2, Nombre);
            ps.executeUpdate();
            System.out.println("Usuario creado con exito");
        } catch (SQLException e) {
            System.out.println("Error al añadir el Usuario");
        }
    }

    public void eliminarUsuario(Integer id) {
        String del = "DELETE FROM Usuario WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(del)) {
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Usuario eliminado con exito");
        } catch (SQLException e) {
            System.out.println("Error al borrar el usuario");
        }
    }

    public void modificarUsuario(Integer id, String nombre) {
        String mod = "UPDATE Usuario SET nombre = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(mod)) {
            ps.setString(1, nombre);
            ps.execute();
            System.out.println("Usuario modificado con exito");
        } catch (SQLException e) {
            System.out.println("Error al modificar el usuario");
        }
    }

    public ArrayList<DTO_Usuario> readAll(){
        String readAll = "Select * from Usuario";
        usuarios.clear();
        try(PreparedStatement ps = conexion.prepareStatement(readAll)){

            ps.executeQuery();

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);


                usuarios.add(new DTO_Usuario(id,nombre));
            }

        } catch (SQLException e) {
            System.out.println("Error al recoger los datos");
        }
        return usuarios;
    }
}
