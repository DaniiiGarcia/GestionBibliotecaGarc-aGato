package Libro;

import java.util.Objects;

public class DTO_Libro {
    private Integer id;
    private String titulo;
    private String ISBN;
    private static int cont = 0;

    public DTO_Libro(Integer id, String titulo, String ISBN) {
        this.id = id;
        this.titulo = titulo;
        this.ISBN = ISBN;
    }

    public DTO_Libro(String titulo, String ISBN) {
        this.titulo = titulo;
        this.ISBN = ISBN;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTO_Libro dtoLibro = (DTO_Libro) o;
        return Objects.equals(id, dtoLibro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("""
    |  %-9s| %-22s | %-17s |
    +-----------+------------------------+-------------------+""",
                this.id,
                this.titulo,
                this.ISBN);
    }

    public static void main(String[] args) {
        DTO_Libro l = new DTO_Libro(1, "dfgh","ertyyu");
        DTO_Libro li = new DTO_Libro(1, "wertyuioiuyt","ertyyu");

        System.out.println(l);
        System.out.println(li);
    }
}
