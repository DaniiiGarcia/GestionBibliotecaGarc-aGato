package Prestamo;

public class DTO_Prestamo {
    private Integer id;
    private String fechaInicio;
    private String fechaFin;
    private int usuarioId;
    private int libroId;
    private static int cont = 0;

    public DTO_Prestamo(Integer id, String fechaInicio, String fechaFin, int usuarioId, int libroId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public DTO_Prestamo(String fechaInicio, String fechaFin, int usuarioId, int libroId) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    @Override
    public String toString() {
        return String.format("""
              |  %-9s| %-22s | %-22s | %-22s | %-17s |
              +-----------+------------------------+------------------------+------------------------+-------------------+""",
        this.id,
        this.fechaInicio,
        this.fechaFin,
        this.usuarioId,
        this.libroId);
    }

    public static void main(String[] args) {
        DTO_Prestamo d = new DTO_Prestamo( "21-02-02","21-02-02", 1,12 );
        DTO_Prestamo dd = new DTO_Prestamo( "21-02-02","21-02-02", 1,12 );

        System.out.println(d);
        System.out.println(dd);

    }

}
