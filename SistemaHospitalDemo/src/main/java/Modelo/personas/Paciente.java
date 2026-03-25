package modelo.personas;

import modelo.abstractas.Persona;
import java.time.LocalDate;

public class Paciente extends Persona {

    public Paciente(int id, String nombre, String apellido,
                    LocalDate nacimiento, String email) {
        super(id, nombre, apellido, nacimiento, email);
    }
}
