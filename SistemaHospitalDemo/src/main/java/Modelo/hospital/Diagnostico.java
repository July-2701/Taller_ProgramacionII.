package modelo.hospital;

import java.time.LocalDate;

public class Diagnostico {

    private String descripcion;
    private String receta;
    private LocalDate fecha;

    public Diagnostico(String descripcion, String receta) {
        this.descripcion = descripcion;
        this.receta = receta;
        this.fecha = LocalDate.now();
    }
}
