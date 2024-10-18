package Autor;

public class DTO_Autor {

    private Integer id;
    private String Nombre;

    public DTO_Autor(Integer id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    public DTO_Autor(String nombre) {
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


}
