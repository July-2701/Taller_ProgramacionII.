package modelo.personas;

import modelo.hospital.Especialidad;
import java.time.LocalDate;

public class Cirujano extends Medico {

    private int cirugias;

    public Cirujano(int id, String nombre, String apellido,
                    LocalDate nacimiento, String email,
                    int legajo, LocalDate contratacion,
                    double salarioBase, Especialidad esp, int cirugias) {

        super(id, nombre, apellido, nacimiento, email, legajo, contratacion, salarioBase, esp);
        this.cirugias = cirugias;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + cirugias * 100;
    }
}