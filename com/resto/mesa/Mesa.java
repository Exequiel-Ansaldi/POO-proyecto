/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.mesa;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.tallerpoo.com.resto.reserva.Reserva;
import com.mycompany.tallerpoo.com.resto.Evento;

/**
 *
 * @author Exequiel
 */
public class Mesa {
    /**
     * La capacidad máxima de la mesa.
     */
    private int capacidad;

     /**
     * La ubicación de la mesa dentro del restaurante.
     */
    private String ubicacion;

    /**
     * La lista de reservas asociadas a la mesa.
     */
    private List<Reserva> reservas;

    /**
     * Un evento especial que puede estar asociado a la mesa.
     */
    private Evento evento;

    /**
     * El estado actual de la mesa (disponible o no disponible).
     */
    private EstadoMesa estado;
    
     //-----------------------------------------CONSTRUCTORES--------------------------------------------------
    /**
     * Constructor por defecto que inicializa la lista de reservas.
     */
    public Mesa(){
        this.reservas = new ArrayList<Reserva>();
    }

     /**
     * Constructor que inicializa la mesa con una lista de reservas.
     * 
     * @param reservas La lista de reservas asociadas a la mesa.
     */
    public Mesa(List<Reserva> reservas){
        this.reservas = reservas;
    }

     /**
     * Constructor que inicializa la mesa con capacidad, ubicación y estado.
     * 
     * @param capacidad La capacidad máxima de la mesa.
     * @param ubicacion La ubicación de la mesa.
     * @param estado    El estado actual de la mesa.
     */

    public Mesa(int capacidad, String ubicacion, EstadoMesa estado) {
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.reservas = new ArrayList<>();
    }

     /**
     * Constructor que inicializa la mesa con capacidad, ubicación, evento, reservas y estado.
     * 
     * @param capacidad La capacidad máxima de la mesa.
     * @param ubicacion La ubicación de la mesa.
     * @param evento    El evento especial asociado a la mesa.
     * @param reservas  La lista de reservas asociadas a la mesa.
     * @param estado    El estado actual de la mesa.
     */

    public Mesa(int capacidad, String ubicacion, Evento evento, List<Reserva> reservas, EstadoMesa estado) {
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.evento = evento;
        this.reservas = reservas;
        this.estado = estado;
    }

    //----------------------------------------MÉTODOS----------------------------------------------------
    /**
     * Devuelve la capacidad máxima de la mesa.
     * 
     * @return La capacidad de la mesa.
     */
    public int getCapacidad() {
        return this.capacidad;
    }

     /**
     * Establece la capacidad máxima de la mesa.
     * 
     * @param capacidad La nueva capacidad de la mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Devuelve la ubicación de la mesa.
     * 
     * @return La ubicación de la mesa.
     */
    public String getUbicacion() {
        return this.ubicacion;
    }

     /**
     * Establece la ubicación de la mesa.
     * 
     * @param ubicacion La nueva ubicación de la mesa.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

     /**
     * Establece la lista de reservas asociadas a la mesa.
     * 
     * @param reservas La nueva lista de reservas.
     */
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Agrega una nueva reserva a la lista de reservas de la mesa.
     * 
     * @param r La reserva a agregar.
     */
     public void agregarReservas(Reserva r){
         this.reservas.add(r);
    }

    /**
     * Devuelve la lista de reservas asociadas a la mesa.
     * 
     * @return La lista de reservas.
     */
    public List<Reserva> getReservas(){
        return this.reservas;
    }

    /**
     * Devuelve el evento asociado a la mesa.
     * 
     * @return El evento de la mesa.
     */
     public Evento getEvento(){
        return this.evento;
    }

    /**
     * Establece un evento especial para la mesa.
     * 
     * @param evento El nuevo evento asociado a la mesa.
     */
    public void setEvento(Evento evento){
        this.evento = evento;
    }

    /**
     * Devuelve el estado actual de la mesa.
     * 
     * @return El estado de la mesa.
     */
    public EstadoMesa getEstado(){
        return this.estado;
    }

    /**
     * Establece el estado actual de la mesa.
     * 
     * @param estado El nuevo estado de la mesa.
     */
    public void setEstado(EstadoMesa estado){
        this.estado = estado;
    }

    /**
    * La función filtra una lista de mesas según su capacidad y ubicación.
    * 
    * @param mesas El parámetro `mesas` es una lista de objetos `Mesa`, que representa una colección de
    * mesas. El método `filtrarMesas` toma esta lista de mesas como entrada y las filtra basándose en los
    * criterios de capacidad y ubicación proporcionados. Luego devuelve una nueva lista que contiene solo las mesas
    * que cumplen con estos criterios.
    * @param capacidad El parámetro `capacidad` representa la capacidad mínima que un objeto `Mesa`
    * debe tener para ser incluido en la lista filtrada. Solo los objetos `Mesa` con una capacidad
    * mayor o igual a este valor se agregarán a la lista `mesasFiltradas`.
    * @param ubicacion El parámetro "ubicacion" en el método "filtrarMesas" representa la ubicación
    * o área donde se encuentra la mesa. Es un parámetro de tipo String que se utiliza para filtrar la
    * lista de mesas según su ubicación. El método filtra las mesas según los criterios de capacidad y
    * ubicación antes de devolver la lista filtrada.
    * @return El método `filtrarMesas` devuelve una Lista de objetos `Mesa` que cumplen con los criterios
    * especificados de tener una capacidad mayor o igual al valor de capacidad proporcionado y estar
    * ubicadas en la ubicación especificada.
    */
    public List<Mesa> filtrarMesas(List<Mesa> mesas, int capacidad, String ubicacion){
        List<Mesa> mesasFiltradas = new ArrayList<>();
        for (Mesa mesa : mesas) {
            if (mesa.getCapacidad() >= capacidad && mesa.getUbicacion().equalsIgnoreCase(ubicacion) && mesa.getEstado() == EstadoMesa.Disponible){
                mesasFiltradas.add(mesa);
            }
        }
        return mesasFiltradas;
    }

    /**
     * Devuelve una representación en forma de cadena de la mesa.
     * 
     * @return Una cadena que representa los atributos de la mesa,
     *         incluyendo capacidad, ubicación, reservas, evento y estado.
     */
    @Override
    public String toString() {
        StringBuilder reservasInfo = new StringBuilder();
        if (reservas != null && !reservas.isEmpty()) {
            reservasInfo.append("[");
            for (Reserva reserva : reservas) {
                reservasInfo.append("Reserva{fecha='").append(reserva.getFecha()).append("', ");
                reservasInfo.append("horaInicio='").append(reserva.getHorainicioreserva()).append("', ");
                reservasInfo.append("horaFinal='").append(reserva.getHorafinalreserva()).append("'}, ");
            }
            // Eliminar la última coma y espacio
            if (!reservasInfo.isEmpty()) {
                reservasInfo.setLength(reservasInfo.length() - 2);
            }
            reservasInfo.append("]");
        } else {
            reservasInfo.append("[]"); // Si no hay reservas
        }

        return "Mesa{" +
                "capacidad=" + capacidad +
                ", ubicacion='" + ubicacion + '\'' +
                ", reservas=" + reservasInfo.toString() +
                ", evento='" + evento + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
