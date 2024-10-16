/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.mesa;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.tallerpoo.com.resto.Reserva;
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

    public List<Mesa> filtrarMesas(List<Mesa> mesas, int capacidad, String ubicacion){ //PODRIA HACRESE UNA CLASE ENUMERACION PARA CAPACIDAD Y UBICACION
        List<Mesa> mesasFiltradas = new ArrayList<>();
        for (Mesa mesa : mesas) {
            if (mesa.getCapacidad() >= capacidad && mesa.getUbicacion().equalsIgnoreCase(ubicacion)) {
                mesasFiltradas.add(mesa);
            }
        }
        return mesasFiltradas;
    }
}
