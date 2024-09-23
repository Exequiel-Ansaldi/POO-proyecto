/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

/**
 *
 * @author Exequiel
 */
import java.util.Scanner;

import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;

import java.util.Date;
import java.time.LocalTime;
public class Reserva {
    private Date dia;
    private LocalTime hora;
    private Mesa mesa;
    private Cliente cliente;
    private Asistencia asistencia;

    public Reserva(Date dia, LocalTime hora, Asistencia asistencia, Mesa m, Cliente c) {
        this.dia = dia;
        this.hora = hora;
        this.asistencia = asistencia;
        this.mesa = m;
        this.cliente = c;
    }

    public Date getDia() {
        return this.dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Mesa getMesa() {
        return this.mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asistencia getAsistencia() {
        return this.asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }
    public String hacerComentario(){
        Scanner lectura = new Scanner(System.in);
        String comentario = lectura.nextLine();
        return comentario;
    }
    public void confirmarReserva(){
    }
    public void modificarReserva(Date fecha, LocalTime hora, Mesa mesa ){
    }
    public void cancelarReserva(Reserva reserva){
    }
    //CORREGIR RECORDATORIO//
}