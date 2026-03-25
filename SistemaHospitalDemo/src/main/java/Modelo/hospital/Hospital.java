package modelo.hospital;

import modelo.abstractas.Empleado;
import modelo.enums.EstadoCita;
import modelo.personas.Medico;
import modelo.personas.Paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private List<Empleado> empleados = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<CitaMedica> citas = new ArrayList<>();

    public void contratarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void registrarPaciente(Paciente p) {
        pacientes.add(p);
    }

    public Paciente buscarPaciente(int id) {
        return pacientes.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Medico buscarMedico(int id) {
        return empleados.stream()
                .filter(e -> e instanceof Medico && e.getLegajo() == id)
                .map(e -> (Medico) e)
                .findFirst()
                .orElse(null);
    }

    private int generarId() {
        return citas.size() + 1;
    }

    private boolean disponible(Medico m, LocalDateTime fecha) {
        return citas.stream()
                .noneMatch(c -> c.getMedico().equals(m)
                        && c.getFecha().equals(fecha)
                        && c.getEstado() != EstadoCita.CANCELADA);
    }

    public CitaMedica agendarCita(Paciente p, Medico m, LocalDateTime fecha) {
        if (!disponible(m, fecha)) {
            throw new IllegalArgumentException("No disponible");
        }

        CitaMedica c = new CitaMedica(generarId(), p, m, fecha);
        citas.add(c);
        return c;
    }

    public double calcularNomina() {
        return empleados.stream()
                .mapToDouble(Empleado::calcularSalario)
                .sum();
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }
}
