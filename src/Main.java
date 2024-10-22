import Autor.DAO_Autor;
import BBDD.JDBC;
import Libro.DAO_Libro;
import Prestamo.DAO_Prestamo;
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

        daoUsuario.addUsuario(1, "Alberto");
        daoAutor.addAutor(1, "Pedro");
        daoLibro.addLibro(1, "El quijote", "9348DHFU");
        daoPrestamo.addPrestamo(1,"2005-03-10", "2005-03-11", 1,1);


    }
}
