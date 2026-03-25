package modelo.abstractas;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado extends Persona {

    private int legajo;
    private LocalDate fechaContratacion;
    private double salarioBase;

    public Empleado(int id, String nombre, String apellido,
                    LocalDate nacimiento, String email,
                    int legajo, LocalDate contratacion, double salarioBase) {

        super(id, nombre, apellido, nacimiento, email);

        if (legajo <= 0) throw new IllegalArgumentException();
        if (contratacion.isAfter(LocalDate.now())) throw new IllegalArgumentException();
        if (salarioBase <= 0) throw new IllegalArgumentException();

        this.legajo = legajo;
        this.fechaContratacion = contratacion;
        this.salarioBase = salarioBase;
    }

    public int getLegajo() {
        return legajo;
    }

    protected int antiguedad() {
        return Period.between(fechaContratacion, LocalDate.now()).getYears();
    }

    protected double bonoAntiguedad() {
        return salarioBase * 0.05 * antiguedad();
    }

    protected double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();
}