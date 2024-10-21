import Autor.DAO_Autor;
import BBDD.JDBC;
import Usuario.DAO_Usuario;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//hay que ver porque se repiten los mensajes
        JDBC jdbc = new JDBC();
        DAO_Usuario daoUsuario = new DAO_Usuario();
        DAO_Autor daoAutor = new DAO_Autor();

    }
}
