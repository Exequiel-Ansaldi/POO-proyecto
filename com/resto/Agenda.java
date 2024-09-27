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

public class Agenda {
    private Date fecha;
    private LocalTime horainicio;
    private LocalTime horafin;

    //Constructores
    public Agenda(Date fecha, LocalTime horainicio, LocalTime horafin) {
        this.fecha = fecha;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }
    public Agenda(){}

    //Getters & Setters
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

}
