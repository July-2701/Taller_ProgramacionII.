package modelo.abstractas;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;

    public Persona(int id, String nombre, String apellido,
                   LocalDate fechaNacimiento, String email) {

        if (id <= 0) throw new IllegalArgumentException();
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException();
        if (apellido == null || apellido.isBlank()) throw new IllegalArgumentException();
        if (fechaNacimiento.isAfter(LocalDate.now())) throw new IllegalArgumentException();
        if (!email.contains("@")) throw new IllegalArgumentException();

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String obtenerTipo() {
        return getClass().getSimpleName();
    }
}
