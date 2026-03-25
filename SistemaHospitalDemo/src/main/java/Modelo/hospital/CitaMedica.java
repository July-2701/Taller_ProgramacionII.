package modelo.hospital;

import modelo.enums.EstadoCita;
import modelo.personas.Medico;
import modelo.personas.Paciente;

import java.time.LocalDateTime;

public class CitaMedica {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fecha;
    private EstadoCita estado;

    public CitaMedica(int id, Paciente paciente, Medico medico, LocalDateTime fecha) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.estado = EstadoCita.PENDIENTE;
    }

    public double calcularCosto() {
        return medico.getEspecialidad().getCostoConsulta();
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }
}