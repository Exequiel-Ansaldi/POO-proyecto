/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.mesa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Exequiel
 */
public class Mesa {
    private int capacidad;
    private String ubicacion;
    private EstadoMesa estado;

    private static List<Mesa> mesas = new ArrayList<>();
    public static void addMesas(Mesa mesa){
        mesas.add(mesa);
    }

    //Constructores
    public Mesa(int c, String u, EstadoMesa estadoM) {
        this.capacidad = c;
        this.ubicacion = u;
        this.estado = estadoM;
    }
    public Mesa(Mesa objeto){
        this.capacidad = objeto.capacidad;
        this.estado = objeto.estado;
        this.ubicacion = objeto.ubicacion;
    }

    //Getters & Setters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }

    //Métodos de Clase
    public static List<Mesa> filtrarMesa(int capacidad, String ubicacion){
        List<Mesa>filteredMesa = new ArrayList<>();

        for (Mesa mesa : mesas){
            if (capacidad == mesa.getCapacidad() && ubicacion.equals(mesa.getUbicacion())){
                addMesas(mesa);
            }
        }

    return filteredMesa;
    }
}
