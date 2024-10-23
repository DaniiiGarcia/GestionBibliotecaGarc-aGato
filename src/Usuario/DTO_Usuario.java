package Usuario;

public class DTO_Usuario {
    private Integer id;
    private String Nombre;

    public DTO_Usuario(String nombre) {
        Nombre = nombre;
    }

    public DTO_Usuario(Integer id, String nombre) {
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
    public String toString() {
        return String.format("""
                        %s, %s
                        """,
                this.id,
                this.Nombre
        );
    }

}
