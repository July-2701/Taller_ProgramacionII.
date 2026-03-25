package modelo.personas;

import modelo.abstractas.Empleado;
import modelo.hospital.Especialidad;
import java.time.LocalDate;

public class Medico extends Empleado {

    private Especialidad especialidad;

    public Medico(int id, String nombre, String apellido,
                  LocalDate nacimiento, String email,
                  int legajo, LocalDate contratacion,
                  double salarioBase, Especialidad especialidad) {

        super(id, nombre, apellido, nacimiento, email, legajo, contratacion, salarioBase);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonoAntiguedad() + especialidad.getCostoConsulta() * 0.1;
    }
}