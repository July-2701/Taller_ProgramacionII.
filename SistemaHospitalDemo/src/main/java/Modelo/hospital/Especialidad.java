package modelo.hospital;

public class Especialidad {

    private String nombre;
    private double costoConsulta;

    public Especialidad(String nombre, double costoConsulta) {
        this.nombre = nombre;
        this.costoConsulta = costoConsulta;
    }

    public double getCostoConsulta() {
        return costoConsulta;
    }
}