/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

/**
 *
 * @author Exequiel
 */
import java.sql.Time;
import java.time.LocalDate;
import java.util.Scanner;
public class Reserva {
    private LocalDate fecha;
    private Time hora;
    private Asistencia asistencia;

    public Reserva(LocalDate f, Asistencia asistencia, Time h) {
        this.fecha = f;
        this.hora = h;
        this.asistencia = asistencia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String hacerComentario(){
        Scanner lectura = new Scanner(System.in);
        String comentario = lectura.nextLine();
        return comentario;
    }
    public void confirmarReserva(){
    }
    public void modificarReserva(LocalDate fecha, Time hora, Mesa mesa ){
    }
    public void cancelarReserva(Reserva reserva){
    }

    //+enviarRecordatorioReserva(correo:String): Reserva
}