package Usuario;

public class DTO_Usuario {
    private Integer id;
    private String Nombre;
    private static int cont = 0;


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
                |  %-9s| %-22s |
                +-----------+------------------------+""",
                this.id,
                this.Nombre
        );
    }

    public static void main(String[] args) {
        DTO_Usuario u1 = new DTO_Usuario(1, "Nombre");
        DTO_Usuario u2 = new DTO_Usuario(2, "oiuytdrfnmkloji");
        System.out.println(u1);
        System.out.println(u2);
    }

}
