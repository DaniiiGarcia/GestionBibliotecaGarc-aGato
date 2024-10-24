import Autor.DAO_Autor;
import BBDD.JDBC;
import Libro.DAO_Libro;
import Libro_Autor.DAO_LibroAutor;
import Prestamo.DAO_Prestamo;
import Servicio.Servicio;
import Usuario.DAO_Usuario;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//hay que ver porque se repiten los mensajes
        JDBC jdbc = new JDBC();
        DAO_Usuario daoUsuario = new DAO_Usuario(jdbc);
        DAO_Autor daoAutor = new DAO_Autor(jdbc);
        DAO_Libro daoLibro = new DAO_Libro(jdbc);
        DAO_Prestamo daoPrestamo = new DAO_Prestamo(jdbc);
        DAO_LibroAutor daoLibroAutor = new DAO_LibroAutor(jdbc);
        Servicio ser = new Servicio(jdbc);
        ser.menu();
    }
}
