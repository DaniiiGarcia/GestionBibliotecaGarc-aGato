package Servicio;

import Autor.DAO_Autor;
import BBDD.JDBC;
import Libro.DAO_Libro;
import Prestamo.DAO_Prestamo;
import Usuario.DAO_Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Servicio {

    ConsoleColors letraColores = new ConsoleColors();
    Scanner sc = new Scanner(System.in);
    DAO_Autor daoAutor;
    DAO_Usuario daoUsuario;
    DAO_Prestamo daoPrestamo;
    DAO_Libro daoLibro;

    public Servicio(JDBC jdbc) throws SQLException {
        daoAutor = new DAO_Autor(jdbc);
        daoUsuario = new DAO_Usuario(jdbc);
        daoPrestamo = new DAO_Prestamo(jdbc);
        daoLibro = new DAO_Libro(jdbc);
    }

    public void cuentaAtras(Integer segundos) {
        try {
            for (int i = segundos; i >= 0; i--) {
                System.out.print("\r" + i + "s");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void saltoLinea() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public void menu() {
        String opcion = "0";
        System.out.println("\n" +
                "┌─┐┌─┐┌─┐┌─┐┌─┐┌─┐  ┌─┐  ┌┬┐┌─┐┌┬┐┌─┐┌─┐\n" +
                "├─┤│  │  ├┤ └─┐│ │  ├─┤   ││├─┤ │ │ │└─┐\n" +
                "┴ ┴└─┘└─┘└─┘└─┘└─┘  ┴ ┴  ─┴┘┴ ┴ ┴ └─┘└─┘\n");
        cuentaAtras(1);
        do {
            saltoLinea();
            String mensaje = "INTRODUCE UNA OPCIÓN";
            int longitudBarra = 25;
            System.out.println("╔" + "═".repeat(longitudBarra) + " " + mensaje + " " + "═".repeat(longitudBarra) + "╗");
            System.out.println("╚" + "═".repeat(2 * longitudBarra + mensaje.length() + 2) + "╝");
            System.out.println();


            System.out.printf("%-35s", letraColores.GREEN + "1. Crear autor" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.GREEN + "5. Crear libro" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.GREEN + "9. Crear usuario" + letraColores.RESET);
            System.out.println(letraColores.GREEN + "13. Crear prestamo" + letraColores.RESET);

            System.out.printf("%-35s", letraColores.ORANGE + "2. Ver autores" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.ORANGE + "6. Ver libros" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.ORANGE + "10. Ver usuarios" + letraColores.RESET);
            System.out.println(letraColores.ORANGE + "14. Ver prestamos" + letraColores.RESET);

            System.out.printf("%-35s", letraColores.RED + "3. Eliminar autor" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.RED + "7. Eliminar libro" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.RED + "11. Eliminar usuario" + letraColores.RESET);
            System.out.println(letraColores.RED + "15. Eliminar prestamo" + letraColores.RESET);


            System.out.printf("%-35s", letraColores.PURPLE + "4. Actualizar autor" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.PURPLE + "8. Actualizar libro" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.PURPLE + "12. Actualizar usuario" + letraColores.RESET);
            System.out.println(letraColores.PURPLE + "16. Actualizar prestamo" + letraColores.RESET);

            System.out.println();
            mensaje = "X -> SALIR";
            longitudBarra = 30;
            System.out.println("╔" + "═".repeat(longitudBarra) + " " + mensaje + " " + "═".repeat(longitudBarra) + "╗");
            System.out.println("╚" + "═".repeat(2 * longitudBarra + mensaje.length() + 2) + "╝");

            System.out.print("Acción -> ");
            opcion = sc.next();
            System.out.println();
            System.out.println();

            switch (opcion) {
                case "1":
                    saltoLinea();
                    pedirDato("nombre", "autor");
                    String nombre = sc.next();
                    saltoLinea();
                    daoAutor.addAutor(nombre);
                    daoAutor.readAll();
                    cuentaAtras(3);
                    break;
                case "2":
                    saltoLinea();
                    daoAutor.verLista();
                    cuentaAtras(5);
                    break;
                case "3":
                    saltoLinea();
                    daoAutor.verLista();
                    cuentaAtras(3);
                    saltoLinea();
                    pedirDato("id", "autor");
                    Integer id = sc.nextInt();
                    saltoLinea();
                    daoAutor.eliminarAutor(id);
                    cuentaAtras(5);
                    break;
                case "4":
                    saltoLinea();
                    pedirDato("id", "autor");
                    Integer idAutor = sc.nextInt();
                    saltoLinea();
                    pedirDato("nombre", "autor");
                    String nombreAutor = sc.next();
                    saltoLinea();
                    daoAutor.modificarAutor(idAutor, nombreAutor);
                    cuentaAtras(3);
                    break;
                case "5":
                    saltoLinea();
                    pedirDato("titulo", "libro");
                    String titulo = sc.next();
                    saltoLinea();
                    pedirDato("isbn", "libro");
                    String isbn = sc.next();
                    saltoLinea();
                    daoLibro.addLibro(titulo, isbn);
                    cuentaAtras(3);
                    break;
                case "6":
                    saltoLinea();
                    daoLibro.verLista();
                    cuentaAtras(5);
                    break;
                case "7":
                    saltoLinea();
                    daoLibro.verLista();
                    cuentaAtras(3);
                    saltoLinea();
                    pedirDato("id", "libro");
                    Integer id1 = sc.nextInt();
                    saltoLinea();
                    daoLibro.eliminarLibro(id1);
                    cuentaAtras(5);
                    break;
                case "8":
                    saltoLinea();
                    pedirDato("id", "libro");
                    Integer idLibro = sc.nextInt();
                    saltoLinea();
                    System.out.println("Elije una opción: ");
                    System.out.println("1. Titulo");
                    System.out.println("2. ISBN");
                    Integer opcion1 = sc.nextInt();
                    saltoLinea();
                    System.out.println("Introduce el nuevo valor");
                    String nuevoValor = sc.next();
                    saltoLinea();
                    daoLibro.modificarLibro(idLibro, opcion1, nuevoValor);
                    cuentaAtras(3);
                    break;
                case "9":
                    saltoLinea();
                    pedirDato("nombre", "usuario");
                    String nombre1 = sc.next();
                    saltoLinea();
                    daoUsuario.addUsuario(nombre1);
                    cuentaAtras(3);
                    break;
                case "10":
                    saltoLinea();
                    daoUsuario.verLista();
                    cuentaAtras(5);
                    break;
                case "11":
                    saltoLinea();
                    daoUsuario.verLista();
                    cuentaAtras(3);
                    saltoLinea();
                    pedirDato("id", "usuario");
                    Integer id2 = sc.nextInt();
                    saltoLinea();
                    daoUsuario.eliminarUsuario(id2);
                    cuentaAtras(5);
                    break;
                case "12":
                    saltoLinea();
                    pedirDato("id", "usuario");
                    Integer idUsuario = sc.nextInt();
                    saltoLinea();
                    pedirDato("nombre", "autor");
                    String nombreUsuario = sc.next();
                    saltoLinea();
                    daoUsuario.modificarUsuario(idUsuario, nombreUsuario);
                    cuentaAtras(3);
                    break;
                case "13":
                    saltoLinea();
                    pedirDato("id", "Prestamo");//Pedimos id del prestamo
                    daoPrestamo.verLista();
                    Integer idPrestamo = sc.nextInt();
                    saltoLinea();
                    pedirDato("Fecha de Inicio", "Prestamo");//Pedimo fecha de inicio
                    String fechaInicio = sc.next();
                    pedirDato("Fecha de Final", "Prestamo");//Pedimos fecha final
                    String fechaFinal = sc.next();
                    pedirDato("ID de Usuario", "Prestamo");//Pedimos id del usuario
                    daoUsuario.verLista();
                    Integer usuarioId = sc.nextInt();
                    pedirDato("ID del Libro", "Prestamo");//Pedimos id del libro
                    daoLibro.verLista();
                    Integer libroId = sc.nextInt();
                    saltoLinea();
                    daoPrestamo.addPrestamo(idPrestamo,fechaInicio,fechaFinal,usuarioId,libroId);//Creamos el prestamo
                    cuentaAtras(3);
                    break;
                case "14":
                    saltoLinea();
                    daoPrestamo.verLista();
                    cuentaAtras(5);
                    break;
                case "15":
                    saltoLinea();
                    daoPrestamo.verLista();
                    cuentaAtras(3);
                    saltoLinea();
                    pedirDato("id", "Prestamo");
                    Integer idPrestamo2 = sc.nextInt();
                    saltoLinea();
                    daoPrestamo.eliminarPrestamo(idPrestamo2);
                    cuentaAtras(5);
                    break;
                case "16":
                    saltoLinea();
                    pedirDato("id", "Prestamo");
                    Integer idPrestamo3 = sc.nextInt(); //Pedimos el id del prestamo
                    saltoLinea();
                    Integer opcionUpdate = pedirOpcion(); //Pedimos en un método aparte la opción que desea actualizar
                    System.out.println("Inserte el nuevo valor a actualizar");//Pedimos el valor a actualizar
                    String valorNuevo = sc.next();
                    saltoLinea();
                    daoPrestamo.modificarPrestamo(idPrestamo3,opcionUpdate,valorNuevo);
                    cuentaAtras(3);
                    break;
                case "X":
                case "x":
                    saltoLinea();
                    System.out.println("\n" +
                            "┌─┐┌─┐┬  ┬┌─┐┌┐┌┌┬┐┌─┐ \n" +
                            "└─┐├─┤│  │├┤ │││ │││ │ \n" +
                            "└─┘┴ ┴┴─┘┴└─┘┘└┘─┴┘└─┘\n");
                    opcion = "X";
                    break;
            }
        } while (opcion != "X");
    }

    private int pedirOpcion() {
        int opcion = 0;
        String menuActualizar= """
                ¿Qué desea actualizar?
                  1. Fecha de Inicio del Préstamo
                  2. Fecha de Finalización del Préstamo
                  3. Id del usuario del Préstamo
                  4. Id del Libro en Préstamo
                """ ;
        opcion = sc.nextInt();
        return opcion;
    }

    public void pedirDato(String opcion1, String opcion2) {
        System.out.println("Introduce el " + opcion1 + " de un " + opcion2);
    }
}
