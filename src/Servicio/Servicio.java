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
            System.out.println(letraColores.GREEN + "9. Crear prestamo" + letraColores.RESET);

            System.out.printf("%-35s", letraColores.ORANGE + "2. Ver autores" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.ORANGE + "6. Ver libros" + letraColores.RESET);
            System.out.println(letraColores.ORANGE + "10. Ver prestamos" + letraColores.RESET);

            System.out.printf("%-35s", letraColores.RED + "3. Eliminar autor" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.RED + "7. Eliminar libro" + letraColores.RESET);
            System.out.println(letraColores.RED + "11. Eliminar prestamo" + letraColores.RESET);


            System.out.printf("%-35s", letraColores.PURPLE + "4. Actualizar autor" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.PURPLE + "8. Actualizar libro" + letraColores.RESET);
            System.out.println(letraColores.PURPLE + "12. Actualizar prestamo" + letraColores.RESET);

            System.out.println();
            mensaje = "X -> SALIR";
            longitudBarra = 30;
            System.out.println("╔" + "═".repeat(longitudBarra) + " " + mensaje + " " + "═".repeat(longitudBarra) + "╗");
            System.out.println("╚" + "═".repeat(2 * longitudBarra + mensaje.length() + 2) + "╝");

            System.out.print("Acción -> ");
            opcion = sc.next();
            System.out.println();
            System.out.println();

            switch (opcion){
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
                    //ACABAR HACER SWITCH CON OPCIONES
                    saltoLinea();
                    daoAutor.modificarAutor(idAutor, nombreAutor);
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

    public void pedirDato(String opcion1, String opcion2){
        System.out.println("Introduce el " + opcion1 + " de un " + opcion2);
    }
}
