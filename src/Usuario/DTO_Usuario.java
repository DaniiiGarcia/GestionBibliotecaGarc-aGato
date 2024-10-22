package Usuario;

public class DTO_Usuario {
    private Integer id;
    private String Nombre;

    public DTO_Usuario(String nombre) {
        Nombre = nombre;
    }

    public DTO_Usuario(Integer id,String nombre) {
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
        return String.format(
                """
                +-----------+------------------------+
                |    ID     |         Nombre         | 
                +-----------+------------------------+ 
                |  %-9s| %-22s | 
                +-----------+------------------------+
                """,
                this.id,
                this.Nombre
                );
    }

    public static void main(String[] args) {
        DTO_Usuario u = new DTO_Usuario(1, "Daniel");
        System.out.println(u);
    }
}
