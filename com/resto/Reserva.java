/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;

/**
 *
 * @author Santiago
 */

import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.personal.Empleado;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reserva {
    private LocalDate fecha;
    private LocalTime hora;
    private Asistencia asistencia;
    private List<Empleado> empleados;

    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h) {
        this.fecha = f;
        this.hora = h;
        this.asistencia = asistencia;
    }

    public Reserva() {
        this.fecha = LocalDate.parse("2000-01-01");
        this.hora = LocalTime.parse("00:00");
        this.asistencia = null;
        this.empleados = new ArrayList<Empleado>();
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }

    public String hacerComentario(){
        Scanner lectura = new Scanner(System.in);
        String comentario = lectura.nextLine();
        return comentario;
    }

    public void confirmarReserva(){
    }
    public void modificarReserva(LocalDate fecha, LocalTime hora, Mesa mesa ){
    }
    public void cancelarReserva(Reserva reserva){
    }
    public void enviarRecordatorioReserva(String correo){
    }

}