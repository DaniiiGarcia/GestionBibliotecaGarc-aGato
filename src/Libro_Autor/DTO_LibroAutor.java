package Libro_Autor;

import BBDD.JDBC;
import Libro.DTO_Libro;

import java.sql.Connection;
import java.util.Objects;

public class DTO_LibroAutor {
    private Integer idLibro;
    private Integer idAutor;

    public DTO_LibroAutor(Integer idLibro, Integer idAutor) {
        this.idLibro = idLibro;
        this.idAutor = idAutor;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTO_LibroAutor that = (DTO_LibroAutor) o;
        return Objects.equals(idLibro, that.idLibro) && Objects.equals(idAutor, that.idAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLibro, idAutor);
    }

    @Override
    public String toString() {
        return String.format("""
                |  %-14s| %-17s |
                +-----------+------------------------+""",
                this.idLibro,
                this.idAutor);

    }
/*
    public static void main(String[] args) {
        DTO_LibroAutor libroAutor = new DTO_LibroAutor(1,1);
        DTO_LibroAutor libroAutor1 = new DTO_LibroAutor(1,2);
        DTO_LibroAutor libroAutor2 = new DTO_LibroAutor(2,1);

        System.out.println(libroAutor);
        System.out.println(libroAutor1);
        System.out.println(libroAutor2);
    }
 */
}
