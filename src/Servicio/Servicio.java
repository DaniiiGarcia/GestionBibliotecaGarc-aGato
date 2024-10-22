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
            System.out.printf("%-35s", letraColores.GREEN + "1. Crear asignatura" + letraColores.RESET);
            System.out.printf("%-32s", letraColores.GREEN + "6. Crear alumno" + letraColores.RESET);
            System.out.println(letraColores.GREEN + "10. Matricular alumno" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.ORANGE + "2. Ver asignaturas" + letraColores.RESET);
            System.out.printf("%-32s", letraColores.ORANGE + "7. Ver alumnos" + letraColores.RESET);
            System.out.println(letraColores.ORANGE + "11. Ver matriculas" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.RED + "3. Eliminar asignatura" + letraColores.RESET);
            System.out.printf("%-32s", letraColores.RED + "8. Eliminar alumno" + letraColores.RESET);
            System.out.println(letraColores.RED + "12. Eliminar matricula" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.PURPLE + "4. Actualizar asignatura" + letraColores.RESET);
            System.out.println(letraColores.PURPLE + "9. Actualizar alumno" + letraColores.RESET);
            System.out.printf("%-35s", letraColores.YELLOW + "5. Ordenar asignaturas" + letraColores.RESET);
            System.out.println(letraColores.YELLOW + "0. Ordenar alumnos" + letraColores.RESET);
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
                    System.out.println("Introduce el nombre de un autor");
                    String nombre = sc.next();
                    daoAutor.addAutor(nombre);
                    daoAutor.readAll();
                    daoAutor.verLista();
                    break;
                case "2":
                    System.out.println("Hola");
                    break;
                case "3":
                    System.out.println("Hola");
                    break;
                case "4":
                    System.out.println("Hola");
                    break;
                case "5":
                    System.out.println("Hola");
                    break;
                case "6":
                    System.out.println("Hola");
                    break;
                case "7":
                    System.out.println("Hola");
                    break;
                case "8":
                    System.out.println("Hola");
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
}
