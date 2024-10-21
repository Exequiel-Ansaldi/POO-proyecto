package com.mycompany.tallerpoo.com.resto.personal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.mycompany.tallerpoo.com.resto.Resto;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.mesa.EstadoMesa;

public class Administrador extends Personal {
    private Resto resto;


    public Administrador() {
    }


    public Administrador(Resto resto) {
        this.resto = resto;
    }


    public Resto getResto() {
        return this.resto;
    }

    public void setResto(Resto resto) {
        this.resto = resto;
    }


    /**
     * El método `gestionHorario` gestiona las horas de apertura y cierre de un restaurante tomando la
     * entrada del usuario para los horarios de apertura y cierre, y actualiza el horario del restaurante
     * en consecuencia.
     */

    public void gestionHorario(){

        if (this.resto == null) {
            System.out.println("No hay un restaurante asignado para gestionar.");
            return;
        }

        Scanner lectura = new Scanner(System.in);

        // Solicitar hora de apertura
        System.out.print("Ingrese la hora de apertura (HH:MM): ");
        String horaAperturaInput = lectura.nextLine();
        LocalTime horaApertura = LocalTime.parse(horaAperturaInput);

        // Solicitar hora de cierre
        System.out.print("Ingrese la hora de cierre (HH:MM): ");
        String horaCierreInput = lectura.nextLine();
        LocalTime horaCierre = LocalTime.parse(horaCierreInput);

        // Actualizar los horarios del restaurante
        resto.setApertura(horaApertura);
        resto.setCierre(horaCierre);
        lectura.close();
    }


    /**
     * La función "bloquearMesa" bloquea una lista de mesas para una fecha y un rango de tiempo específico,
     * si están disponibles en ese momento.
     * 
     * @param mesasABloquear `mesasABloquear` es una lista de objetos `Mesa` que representan las mesas que
     * se bloquearán o marcarán como no disponibles para una fecha y rango de tiempo específicos.
     * @param fecha El parámetro `fecha` representa la fecha en la que las mesas se están bloqueando.
     * @param horaInicio El parámetro `horaInicio` representa la hora de inicio para la cual la mesa será
     * bloqueada. Es de tipo `LocalTime`, que es una clase en Java que representa una hora sin fecha ni
     * zona horaria. Se usa para almacenar la hora del día con una precisión de nanosegundos.
     * @param horaFin El parámetro `horaFin` representa la hora de finalización para la cual la mesa será
     * bloqueada. Es de tipo `LocalTime`, que es una clase en Java que representa una hora sin fecha ni
     * zona horaria. Almacena la hora, el minuto, el segundo y la fracción de segundo.
     */

    public void bloquearMesa(List<Mesa> mesasABloquear, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        for (Mesa mesa : mesasABloquear) {
            if (mesa.getEstado() == EstadoMesa.Disponible) {
                mesa.setEstado(EstadoMesa.No_Disponible);
                System.out.println("Mesa " + mesa.getUbicacion() + " bloqueada desde " + horaInicio + " hasta " + horaFin + " en la fecha " + fecha);
            } else {
                System.out.println("La mesa " + mesa.getUbicacion() + " ya está bloqueada.");
            }
        }
    }

    /**
     * La función `desbloquearMesa` toma una lista de mesas y cambia el estado de cada mesa de
     * "No_Disponible" a "Disponible" si actualmente no está disponible.
     * 
     * @param mesasADesbloquear `mesasADesbloquear` es una lista de objetos `Mesa` que necesitan ser
     * desbloqueadas. El método `desbloquearMesa` itera sobre esta lista y cambia el estado de cada
     * objeto `Mesa` de "No_Disponible" a "Disponible".
     */

    public void desbloquearMesa(List<Mesa> mesasADesbloquear) {
        for (Mesa mesa : mesasADesbloquear) {
            if (mesa.getEstado() == EstadoMesa.No_Disponible) {
                mesa.setEstado(EstadoMesa.Disponible);
                System.out.println("Mesa " + mesa.getUbicacion() + " desbloqueada.");
            } else {
                System.out.println("La mesa " + mesa.getUbicacion() + " ya está disponible.");
            }
        }
    }
    
    /**
     * El método `asignarRol` asigna un rol a un objeto estableciendo el rol mediante el método `setRol`.
     * 
     * @param rol El parámetro "rol" en el método "asignarRol" es de tipo "CodRol", que probablemente sea
     * una clase que representa un rol o permiso en el sistema. El método asigna este rol a la clase
     * superior usando el método "setRol".
     */

    public void asignarRol(CodRol rol){
        super.setRol(rol); 
    }

    /**
     * La función "CrearCuenta" en Java solicita al administrador que ingrese el ID y el rol de un nuevo
     * empleado, crea un objeto empleado con la información proporcionada.
     */
    public void CrearCuenta() {
        Scanner scanner = new Scanner(System.in);

        // Pedir al administrador que ingrese los datos del nuevo empleado
        System.out.println("Ingrese el ID del nuevo empleado:");
        int id = scanner.nextInt();

        // Consumir la línea siguiente para evitar problemas con la lectura de cadenas
        scanner.nextLine();

        System.out.println("Ingrese el rol del empleado (Administrador, Maitre, Mesero):");
        String rolString = scanner.nextLine().toUpperCase();
        CodRol rol;
        rol = CodRol.valueOf(rolString);
        Empleado empleado_nuevo = new Empleado(id, rol);

    }

    @Override
    public String toString() {
        return "Administrador{" +
                "resto=" + resto +
                '}';
    }
}
