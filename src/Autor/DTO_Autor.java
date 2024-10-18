package Autor;

import java.util.Objects;

public class DTO_Autor{

    private Integer id;
    private String Nombre;

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
        return "DTO_Autor{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }

}
