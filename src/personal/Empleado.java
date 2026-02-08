package src.personal;
import java.util.ArrayList;
import java.util.List;

import src.reserva.Reserva;

/**
 * La clase {@code Empleado} representa a un empleado dentro del sistema de reservas.
 * Extiende de la clase {@code Personal} y contiene información sobre las reservas
 * que el empleado puede manejar.
 */

public class Empleado extends Personal {
     /** 
     * Lista de reservas asociadas a este empleado.
     */
    private List<Reserva> reservas;

    //-----------------------------------------CONSTRUCTORES--------------------------------------------------
     /**
     * Constructor por defecto que inicializa un empleado sin reservas.
     */
    public Empleado(){
        super();
        this.reservas = new ArrayList<Reserva>();
    }
    /**
     * Constructor que inicializa un empleado con un id, un rol y una lista de reservas.
     *
     * @param id El identificador único del empleado.
     * @param r El rol del empleado, que debe ser uno de los valores de la enumeración {@code CodRol}.
     * @param reservas La lista de reservas asociadas al empleado.
     */
    public Empleado(int id, CodRol r, List<Reserva> reservas) {
        super(id, r);
        this.reservas = reservas;
    }

    /**
     * Constructor que inicializa un empleado con un id y un rol, sin reservas.
     *
     * @param id El identificador único del empleado.
     * @param r El rol del empleado, que debe ser uno de los valores de la enumeración {@code CodRol}.
     */
    public Empleado(int id, CodRol r){
        super(id, r);
    }
    //----------------------------------------MÉTODOS----------------------------------------------------

     /**
     * Obtiene la lista de reservas asociadas a este empleado.
     *
     * @return La lista de reservas del empleado.
     */
    public List<Reserva> getReservas() {
        return this.reservas;
    }
     /**
     * Establece la lista de reservas para este empleado.
     *
     * @param reservas La nueva lista de reservas a asociar al empleado.
     */
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    /**
     * Agrega una nueva reserva a la lista de reservas del empleado.
     *
     * @param r La reserva a agregar.
     */
    public void agregarReservas(Reserva r){
        this.reservas.add(r);
    }

    /**
     * La función `accederReserva` imprime los detalles de una reserva como la fecha, la hora y
     * el estado de asistencia.
     *
     * @param reserva Un objeto de reserva que contiene información como la fecha, la hora y el estado de asistencia.
     */
    public void accederReserva(Reserva reserva){
        System.out.println("Accediendo a la reserva");
        System.out.println("Fecha: "+reserva.getFecha());
        System.out.println("Hora: "+reserva.getHorainicioreserva());
        System.out.println("Asistencia: "+reserva.getAsistencia());
    }
    /**
     * Devuelve una representación en forma de cadena de un objeto {@code Empleado}.
     * La representación incluye información sobre las reservas asociadas al empleado.
     *
     * @return Una cadena que representa el empleado, incluyendo la lista de reservas.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "reservas=" + reservas +
                '}';
    }
}
