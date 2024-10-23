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
    private int capacidad;
    private String ubicacion;
    private List<Reserva> reservas;
    private Evento evento;
    private EstadoMesa estado;
    
    public Mesa(){
        this.reservas = new ArrayList<Reserva>();
    }
    public Mesa(List<Reserva> reservas){
        this.reservas = reservas;
    }

    public Mesa(int capacidad, String ubicacion, EstadoMesa estado) {
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.reservas = new ArrayList<>();
    }

    public Mesa(int capacidad, String ubicacion, Evento evento, List<Reserva> reservas, EstadoMesa estado) {
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.evento = evento;
        this.reservas = reservas;
        this.estado = estado;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

     public void agregarReservas(Reserva r){
         this.reservas.add(r);
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

     public Evento getEvento(){
        return this.evento;
    }

     public void setEvento(Evento evento){
        this.evento = evento;
    }

    public EstadoMesa getEstado(){
        return this.estado;
    }

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

    @Override
    public String toString() {
        return "Mesa{" +
                "capacidad=" + capacidad +
                ", ubicacion='" + ubicacion + '\'' +
                ", numero="+
                ", reservas=" + reservas +
                ", evento=" + evento +
                ", estado=" + estado +

                '}';
    }
}
