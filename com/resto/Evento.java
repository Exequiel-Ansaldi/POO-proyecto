/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;

import com.mycompany.tallerpoo.com.resto.mesa.Mesa;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author Exequiel
 */

public class Evento {
    private String nombre;
    private String descripcion;
    private Date dia;
    private LocalTime horainicio;
    private LocalTime horafin;
    private List<Mesa> mesas;

    public Evento(){
        this.mesas = new ArrayList<Mesa>();
    }

    public Evento(String nombre, String descripcion, Date dia, LocalTime horainicio, LocalTime horafin, List<Mesa> mesas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.mesas = mesas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDia() {
        return this.dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public LocalTime getHorainicio() {
        return this.horainicio;
    }

    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalTime getHorafin() {
        return this.horafin;
    }

    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }
    
    public void agregarMesa(Mesa m){
        this.mesas.add(m);
    }
}
