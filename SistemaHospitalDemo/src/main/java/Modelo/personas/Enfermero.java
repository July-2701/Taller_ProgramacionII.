package modelo.personas;

import modelo.abstractas.Empleado;
import modelo.enums.Turno;
import java.time.LocalDate;

public class Enfermero extends Empleado {

    private Turno turno;

    public Enfermero(int id, String nombre, String apellido,
                     LocalDate nacimiento, String email,
                     int legajo, LocalDate contratacion,
                     double salarioBase, Turno turno) {

        super(id, nombre, apellido, nacimiento, email, legajo, contratacion, salarioBase);
        this.turno = turno;
    }

    private double bonoTurno() {
        return switch (turno) {
            case NOCHE -> 300;
            case TARDE -> 150;
            default -> 0;
        };
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonoAntiguedad() + bonoTurno();
    }
}