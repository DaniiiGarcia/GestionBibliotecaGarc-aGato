package Prestamo;

public class DTO_Prestamo {
    private Integer id;
    private String fechaInicio;
    private String fechaFin;
    private String usuarioId;
    private String libroId;

    public DTO_Prestamo(Integer id, String fechaInicio, String fechaFin, String usuarioId, String libroId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public DTO_Prestamo(String fechaInicio, String fechaFin, String usuarioId, String libroId) {
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

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    @Override
    public String toString() {
        return String.format(
                "id=%s, fechaInicio=%s, fechaFin=%s, usuarioId=%s, libroId=%s]",
                this.id,
                this.fechaInicio,
                this.fechaFin,
                this.usuarioId,
                this.libroId);
    }
}
