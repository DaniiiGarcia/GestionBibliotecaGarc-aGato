package Servicio;

import Autor.DAO_Autor;
import BBDD.JDBC;
import Libro.DAO_Libro;
import Libro_Autor.DAO_LibroAutor;
import Prestamo.DAO_Prestamo;
import Usuario.DAO_Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Servicio {

    ConsoleColors letraColores = new ConsoleColors();
    Scanner sc = new Scanner(System.in);
    DAO_Autor daoAutor;
    DAO_Usuario daoUsuario;
    DAO_Prestamo daoPrestamo;
    DAO_Libro daoLibro;
    DAO_LibroAutor daoLibroAutor;

    public Servicio(JDBC jdbc) throws SQLException {
        daoAutor = new DAO_Autor(jdbc);
        daoUsuario = new DAO_Usuario(jdbc);
        daoPrestamo = new DAO_Prestamo(jdbc);
        daoLibro = new DAO_Libro(jdbc);
        daoLibroAutor = new DAO_LibroAutor(jdbc);
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
            System.out.printf("%-35s", letraColores.GREEN + "13. Crear prestamo" + letraColores.RESET);
            System.out.println(letraColores.GREEN + "17. Crear asignación Libro-Autor" + letraColores.RESET);

            System.out.printf("%-35s", letraColores.ORANGE + "2. Ver autores" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.ORANGE + "6. Ver libros" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.ORANGE + "10. Ver usuarios" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.ORANGE + "14. Ver prestamos" + letraColores.RESET);
            System.out.println(letraColores.ORANGE + "18. Ver asignaciones" + letraColores.RESET);

            System.out.printf("%-35s", letraColores.RED + "3. Eliminar autor" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.RED + "7. Eliminar libro" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.RED + "11. Eliminar usuario" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.RED + "15. Eliminar prestamo" + letraColores.RESET);
            System.out.println(letraColores.RED + "19. Eliminar asignacion" + letraColores.RESET);


            System.out.printf("%-35s", letraColores.PURPLE + "4. Actualizar autor" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.PURPLE + "8. Actualizar libro" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.PURPLE + "12. Actualizar usuario" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.PURPLE + "16. Actualizar prestamo" + letraColores.RESET);
            System.out.println(letraColores.PURPLE + "20. Actualizar asignación" + letraColores.RESET);


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
                //CREAR AUTOR
                case "1":
                    saltoLinea();
                    pedirDato("nombre", "autor");
                    String nombre = sc.next();
                    saltoLinea();
                    daoAutor.addAutor(nombre);
                    daoAutor.readAll();
                    bucleTecla();
                    break;
                case "2":
                    //VER AUTORES
                    saltoLinea();
                    daoAutor.verLista();
                    bucleTecla();
                    break;
                case "3":
                    //ELIMINAR AUTOR
                    saltoLinea();
                    daoAutor.verLista();
                    bucleTecla();
                    saltoLinea();
                    pedirDato("id", "autor");
                    Integer id = sc.nextInt();
                    saltoLinea();
                    daoAutor.eliminarAutor(id);
                    bucleTecla();
                    break;
                case "4":
                    //MODIFICAR AUTOR
                    saltoLinea();
                    daoAutor.verLista();
                    bucleTecla();
                    pedirDato("id", "autor");
                    Integer idAutor = sc.nextInt();
                    saltoLinea();
                    pedirDato("nombre", "autor");
                    String nombreAutor = sc.next();
                    saltoLinea();
                    daoAutor.modificarAutor(idAutor, nombreAutor);
                    bucleTecla();
                    break;
                case "5":
                    //CREAR LIBRO
                    saltoLinea();
                    pedirDato("titulo", "libro");
                    String titulo = sc.next();
                    saltoLinea();
                    pedirDato("isbn", "libro");
                    String isbn = sc.next();
                    saltoLinea();
                    daoLibro.addLibro(titulo, isbn);
                    bucleTecla();
                    break;
                case "6":
                    //VER LIBROS
                    saltoLinea();
                    daoLibro.verLista();
                    bucleTecla();
                    break;
                case "7":
                    //ELIMINAR LIBROS
                    saltoLinea();
                    daoLibro.verLista();
                    bucleTecla();
                    saltoLinea();
                    pedirDato("id", "libro");
                    Integer id1 = sc.nextInt();
                    saltoLinea();
                    daoLibro.eliminarLibro(id1);
                    bucleTecla();
                    break;
                case "8":
                    //MODIFICAR LIBRO
                    saltoLinea();
                    daoLibro.verLista();
                    bucleTecla();
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
                    bucleTecla();
                    break;
                case "9":
                    //CREAR USUARIO
                    saltoLinea();
                    pedirDato("nombre", "usuario");
                    String nombre1 = sc.next();
                    saltoLinea();
                    daoUsuario.addUsuario(nombre1);
                    bucleTecla();
                    break;
                case "10":
                    //VER USUARIOS
                    saltoLinea();
                    daoUsuario.verLista();
                    bucleTecla();
                    break;
                case "11":
                    //ELIMINAR USUARIOS
                    saltoLinea();
                    daoUsuario.verLista();
                    bucleTecla();
                    saltoLinea();
                    pedirDato("id", "usuario");
                    Integer id2 = sc.nextInt();
                    saltoLinea();
                    daoUsuario.eliminarUsuario(id2);
                    bucleTecla();
                    break;
                case "12":
                    //MODIFICAR USUARIO
                    saltoLinea();
                    daoUsuario.verLista();
                    bucleTecla();
                    saltoLinea();
                    pedirDato("id", "usuario");
                    Integer idUsuario = sc.nextInt();
                    saltoLinea();
                    pedirDato("nombre", "autor");
                    String nombreUsuario = sc.next();
                    saltoLinea();
                    daoUsuario.modificarUsuario(idUsuario, nombreUsuario);
                    bucleTecla();
                    break;
                case "13":
                    //CREAR PRESTAMO
                    saltoLinea();
                    pedirDato("id", "Prestamo");
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
                    daoPrestamo.addPrestamo(idPrestamo, fechaInicio, fechaFinal, usuarioId, libroId);// Creamos el prestamo
                    bucleTecla();
                    break;
                case "14":
                    //VER PRESTAMOS
                    saltoLinea();
                    daoPrestamo.verLista();
                    bucleTecla();
                    break;
                case "15":
                    //ELIMINAR PRESTAMOS
                    saltoLinea();
                    daoPrestamo.verLista();
                    bucleTecla();
                    saltoLinea();
                    pedirDato("id", "Prestamo");
                    Integer idPrestamo2 = sc.nextInt();
                    saltoLinea();
                    daoPrestamo.eliminarPrestamo(idPrestamo2);
                    bucleTecla();
                    break;
                case "16":
                    //MODIFICAR PRESTAMO
                    saltoLinea();
                    daoPrestamo.verLista();
                    bucleTecla();
                    saltoLinea();
                    pedirDato("id", "Prestamo");
                    Integer idPrestamo3 = sc.nextInt(); //Pedimos el id del prestamo
                    saltoLinea();
                    Integer opcionUpdate = pedirOpcion(); //Pedimos en un método aparte la opción que desea actualizar
                    System.out.println("Inserte el nuevo valor a actualizar");//Pedimos el valor a actualizar
                    String valorNuevo = sc.next();
                    saltoLinea();
                    daoPrestamo.modificarPrestamo(idPrestamo3, opcionUpdate, valorNuevo);
                    bucleTecla();
                    break;
                case "17":
                    //CREAR ASIGNACIÓN
                    saltoLinea();
                    daoLibro.verLista();
                    pedirDato("id", "Libro");
                    Integer idLibro2 = sc.nextInt();
                    saltoLinea();
                    daoAutor.verLista();
                    pedirDato("id", "Autor");
                    Integer idAutor2 = sc.nextInt();
                    saltoLinea();
                    daoLibroAutor.addLibro_Autor(idLibro2, idAutor2);
                    bucleTecla();
                    break;
                case "18":
                    saltoLinea();
                    daoLibroAutor.verLista();
                    bucleTecla();
                    break;
                case "19":
                    //ELIMINAR ASIGNACIONES
                    saltoLinea();
                    daoLibroAutor.verLista();
                    bucleTecla();
                    saltoLinea();
                    //NO UTILIZO EL METODO PORQUE NO CONCUERDA EL TEXTO
                    System.out.println("Introduce el id de una asignación");
                    Integer idAsig = sc.nextInt();
                    saltoLinea();
                    daoLibroAutor.eliminarLibro_Autor(idAsig);
                    bucleTecla();
                    break;
                case "20":
                    //MODIFICAR PRESTAMO
                    saltoLinea();
                    daoLibroAutor.verLista();
                    bucleTecla();
                    saltoLinea();
                    System.out.println("Introduce el id de una asignación");
                    Integer idAsignacion = sc.nextInt();
                    saltoLinea();
                    System.out.println("Qué quieres cambiar: ");
                    System.out.println("1.ID del Autor");
                    System.out.println("2.ID del Libro");
                    Integer opcion2 = sc.nextInt();
                    saltoLinea();
                    System.out.println("Introduce el nuevo valor: ");
                    String valorNuevo2 = sc.next();
                    daoLibroAutor.modificarLibro_Autor(idAsignacion, opcion2, valorNuevo2);
                    bucleTecla();
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
        String menuActualizar = """
                ¿Qué desea actualizar?
                  1. Fecha de Inicio del Préstamo
                  2. Fecha de Finalización del Préstamo
                  3. Id del usuario del Préstamo
                  4. Id del Libro en Préstamo
                """;
        opcion = sc.nextInt();
        return opcion;
    }

    public void pedirDato(String opcion1, String opcion2) {
        System.out.println("Introduce el " + opcion1 + " de un " + opcion2);
    }

    public Boolean presionarEnter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Presiona \"Enter\" para continuar...");
        String resultado = sc.nextLine();
        if (resultado.isEmpty()) {
            return true;
        }
        return false;
    }

    public void bucleTecla() {
        while (!presionarEnter()) {
        }
    }
}
