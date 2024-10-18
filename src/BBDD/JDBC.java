package BBDD;

import java.sql.*;

public class JDBC {

    //Para mysql
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String pasw="210205";

    //BBDD biblioteca
    private final String bd = "Biblioteca";
    Connection conextion;
    public JDBC() throws SQLException {
        conectarBD();
        crearBD();
    }

    public Connection getConextion() {
        return conextion;
    }

    private void conectarBD() throws SQLException {
        conextion = DriverManager.getConnection(url,user,pasw);
    }

    public void crearBD(){
        String crear = "CREATE DATABASE IF NOT EXISTS "+bd;
        try (Statement s = conextion.createStatement()){

            s.executeUpdate(crear);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
