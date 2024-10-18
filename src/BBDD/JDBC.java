package BBDD;

import java.sql.*;

public class JDBC {

    //Para mysql
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String pasw = "210205";

    //BBDD biblioteca
    private final String bd = "Biblioteca";
    Connection connection;

    public JDBC() throws SQLException {
        conectarBD();
        crearBD();
        useDB();
        crearTablaAutor();
        crearTablaLibro();
        crearTablaUsuario();
        crearTablaPrestamo();
        crearTablaLibro_Autor();
    }

    public void useDB() {
        String USE = "use " + bd;
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(USE);
        } catch (SQLException e) {
            System.out.println("Error al usar la bbdd");
        }
    }

    public Connection getConextion() {
        return connection;
    }

    private void conectarBD() throws SQLException {
        connection = DriverManager.getConnection(url, user, pasw);
    }

    public void crearBD() {
        String crear = "CREATE DATABASE IF NOT EXISTS " + bd;
        try (Statement s = connection.createStatement()) {
            s.executeUpdate(crear);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearTablaUsuario() {
        String CREATE_USUARIO = """
                        CREATE TABLE IF NOT EXISTS Usuario (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nombre VARCHAR(100) NOT NULL
                        );
                """;
        try (Statement s = connection.createStatement()) {
            s.executeUpdate(CREATE_USUARIO);
            System.out.println("Tabla Usuario creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al crear el tabla de usuario");
        }
    }

    public void crearTablaAutor() {
        String CREATE_AUTOR = """
                CREATE TABLE IF NOT EXISTS Autor (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nombre VARCHAR(100) NOT NULL
                );
                """;

        try (Statement s = connection.createStatement()) {
            s.executeUpdate(CREATE_AUTOR);
            System.out.println("Tabla Autor creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla del usuario");
        }
    }

    public void crearTablaPrestamo() {
        String CREATE_PRESTAMO = """
                CREATE TABLE IF NOT EXISTS Prestamo (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    fechaInicio DATE NOT NULL,
                    fechaFin DATE NOT NULL,
                    usuarioId INT NOT NULL,
                    libroId INT NOT NULL,
                    FOREIGN KEY (usuarioId) REFERENCES Usuario(id) ON DELETE CASCADE,
                    FOREIGN KEY (libroId) REFERENCES Libro(id) ON DELETE CASCADE
                );
                """;

        try (Statement s = connection.createStatement()) {
            s.executeUpdate(CREATE_PRESTAMO);
            System.out.println("Tabla Prestamo creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla del Prestamo");
        }
    }

    public void crearTablaLibro() {
        String CREATE_PRESTAMO = """
                CREATE TABLE IF NOT EXISTS Libro (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      titulo VARCHAR(100) NOT NULL,
                      isbn VARCHAR(20) NOT NULL
                  );
                """;

        try (Statement s = connection.createStatement()) {
            s.executeUpdate(CREATE_PRESTAMO);
            System.out.println("Tabla Prestamo creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla del Prestamo");
        }
    }

    public void crearTablaLibro_Autor() {
        String CREATE_LIBRO_AUTOR= """
                CREATE TABLE IF NOT EXISTS Libro_Autor (
                    idLibro INT NOT NULL,
                    idAutor INT NOT NULL,
                    PRIMARY KEY (idLibro, idAutor),
                    FOREIGN KEY (idLibro) REFERENCES Libro(id) ON DELETE CASCADE,
                    FOREIGN KEY (idAutor) REFERENCES Autor(id) ON DELETE CASCADE
                );
                """;
        System.out.println("Tabla Libro_Autor creada correctamente");
        try (Statement s = connection.createStatement()) {
            s.executeUpdate(CREATE_LIBRO_AUTOR);
        }catch (SQLException e) {
            System.out.println("Error al crear la tabla Libro_Autor");
        }


    }
}
