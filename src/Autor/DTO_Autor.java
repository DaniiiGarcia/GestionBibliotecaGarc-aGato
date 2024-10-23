package Autor;

import java.sql.SQLException;
import java.util.Objects;

public class DTO_Autor{

    private Integer id;
    private String Nombre;
    private static int cont = 0;

    public DTO_Autor(Integer id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTO_Autor dtoAutor = (DTO_Autor) o;
        return Objects.equals(id, dtoAutor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        if (cont == 0) {
            System.out.println("+-----------+------------------------+");
            System.out.println("|    ID     |         Nombre         |");
            System.out.println("+-----------+------------------------+");
        }
        cont ++;
        return String.format("""
                |  %-9s| %-22s |
                +-----------+------------------------+""",
                this.id,
                this.Nombre);
    }

    public static void main(String[] args) {
        DTO_Autor auor = new DTO_Autor(1, "Miguel_de_Cervantes ");
        DTO_Autor auTor = new DTO_Autor(2, "Shakespeare ");

        System.out.println(auor);
        System.out.println(auTor);
    }

}
