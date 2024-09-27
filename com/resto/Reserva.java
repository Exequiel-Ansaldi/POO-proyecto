/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;

/**
 *
 * @author Exequiel
 */


import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.personal.Empleado;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.finanza.Pago;


import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reserva {
    private LocalDate fecha;
    private LocalTime hora;
    private Asistencia asistencia;
    private Cliente cliente;
    private Mesa mesa;
    private List<Empleado> empleados;
    private List<Pago> pagos;

    //Constructores
    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h, Mesa m, Cliente c, List<Empleado> e, List <Pago> p) {
        this.fecha = f;
        this.hora = h;
        this.asistencia = asistencia;
        this.mesa = m;
        this.cliente = c;
        this.empleados = e;
        this.pagos = p;
    }

    //Getters & Setters
    public void setPagos( List<Pago> pagos){
        this.pagos = pagos;
    }

    public void agregarPagos(Pago p){
        this.pagos.add(p);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Asistencia getAsistencia() {
        return this.asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    //Métodos de Clase
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
    public void enviarRecordatorioReserva(String correo){}
}