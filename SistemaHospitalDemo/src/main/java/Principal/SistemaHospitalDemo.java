package principal;

import modelo.enums.Turno;
import modelo.hospital.*;
import modelo.personas.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SistemaHospitalDemo {

    private static Hospital hospital = new Hospital();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> registrarPaciente();
                case 2 -> registrarEmpleado();
                case 3 -> buscarPaciente();
                case 4 -> buscarMedico();
                case 5 -> agendarCita();
                case 6 -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }

        System.out.println("Sistema finalizado");
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA HOSPITAL =====");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Registrar empleado");
        System.out.println("3. Buscar paciente");
        System.out.println("4. Buscar medico");
        System.out.println("5. Agendar cita");
        System.out.println("6. Salir");
        System.out.print("Seleccione: ");
    }

    private static void registrarPaciente() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        Paciente p = new Paciente(
                id, nombre, apellido,
                LocalDate.of(2000,1,1),
                "correo@mail.com"
        );

        hospital.registrarPaciente(p);
        System.out.println("Paciente registrado");
    }

    private static void registrarEmpleado() {

        System.out.println("\nTipo de empleado:");
        System.out.println("1. Medico");
        System.out.println("2. Cirujano");
        System.out.println("3. Enfermero");
        System.out.print("Seleccione: ");

        int tipo = sc.nextInt(); sc.nextLine();

        System.out.print("ID/Legajo: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        Especialidad esp = new Especialidad("General", 100);

        switch (tipo) {

            case 1 -> hospital.contratarEmpleado(
                    new Medico(id, nombre, "X",
                            LocalDate.of(1980,1,1), "a@a.com",
                            id, LocalDate.of(2010,1,1), 2000, esp)
            );

            case 2 -> hospital.contratarEmpleado(
                    new Cirujano(id, nombre, "X",
                            LocalDate.of(1975,1,1), "b@b.com",
                            id, LocalDate.of(2005,1,1), 3000, esp, 5)
            );

            case 3 -> hospital.contratarEmpleado(
                    new Enfermero(id, nombre, "X",
                            LocalDate.of(1990,1,1), "c@c.com",
                            id, LocalDate.of(2020,1,1), 1500, Turno.NOCHE)
            );

            default -> {
                System.out.println("Tipo inválido");
                return;
            }
        }

        System.out.println("Empleado registrado");
    }

    private static void buscarPaciente() {
        System.out.print("ID del paciente: ");
        int id = sc.nextInt();

        Paciente p = hospital.buscarPaciente(id);

        if (p != null)
            System.out.println("Paciente encontrado");
        else
            System.out.println("Paciente no existe");
    }

    private static void buscarMedico() {
        System.out.print("ID del medico: ");
        int id = sc.nextInt();

        Medico m = hospital.buscarMedico(id);

        if (m != null)
            System.out.println("Medico encontrado");
        else
            System.out.println("Medico no existe");
    }

    private static void agendarCita() {

        System.out.print("ID Paciente: ");
        int idP = sc.nextInt();

        System.out.print("ID Medico: ");
        int idM = sc.nextInt();

        Paciente p = hospital.buscarPaciente(idP);
        Medico m = hospital.buscarMedico(idM);

        if (p == null || m == null) {
            System.out.println("Datos inválidos");
            return;
        }

        CitaMedica cita = hospital.agendarCita(
                p, m, LocalDateTime.now()
        );

        System.out.println("Cita creada");
        System.out.println("Costo: " + cita.calcularCosto());
    }
}