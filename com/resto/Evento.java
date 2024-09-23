/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;

/**
 *
 * @author Exequiel
 */
import java.util.Date;
import java.time.LocalTime;
public class Evento {
    private String nombre;
    private String descripcion;
    //ATRIBUTO LISTA DE MESAS BLOQUEADAS//
    private Date dia;
    private LocalTime horainicio;
    private LocalTime horafin;

    public Evento(String nombre, String descripcion, Date dia, LocalTime horainicio, LocalTime horafin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public LocalTime getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalTime getHorafin() {
        return horafin;
    }

    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }
    
}
