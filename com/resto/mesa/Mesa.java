/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Exequiel
 */
public class Mesa {
    private int capacidad;
    private String ubicacion;
    private List<Reserva> reservas;
    
    public Mesa(){
        this.reservas = new ArrayList<Reserva>();
    }

    public Mesa(int capacidad, String ubicacion) {
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
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
}
