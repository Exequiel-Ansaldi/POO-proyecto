/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

/**
 *
 * @author Exequiel
 */
import java.util.Date;
import java.time.LocalTime;
public class Verificacion {
    private Mesa mesa;
    private Date fecha;
    private LocalTime horainicio;
    private LocalTime horafin;
    private EstadoMesa estado;

    public Verificacion(Mesa mesa, Date fecha, LocalTime horainicio, LocalTime horafin, EstadoMesa estado) {
        this.mesa = mesa;
        this.fecha = fecha;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }
    public void filtrarMesa(Mesa mesa, Date fecha, LocalTime horainici, LocalTime horafinal){ //DEVUELVE LISTA DE MESAS DISPONIBLES//
    }
    
}
