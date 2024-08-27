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
public class HorarioResto {
     private Date dia;
     private LocalTime apertura;
     private LocalTime cierre;

    public HorarioResto(Date dia, LocalTime apertura, LocalTime cierre) {
        this.dia = dia;
        this.apertura = apertura;
        this.cierre = cierre;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }
     
}
