package com.mycompany.tallerpoo.com.resto.personal;

import com.mycompany.tallerpoo.com.resto.Reserva.Reserva.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Personal {
    private List<Reserva> reservas;

    //Constructores
    public Empleado(){
        super();
        this.reservas = new ArrayList<Reserva>();
    }
    public Empleado(int id, CodRol r, List<Reserva> reservas) {
        super(id, r);
        this.reservas = reservas;
    }
    public Empleado(int id, CodRol r){
        super(id, r);
    }

    //Setters & Getters
    public List<Reserva> getReservas() {
        return this.reservas;
    }
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    public void agregarReservas(Reserva r){
        this.reservas.add(r);
    }

    
    /**
     * La función `accederReserva` imprime los detalles de una reserva como la fecha, la hora y
     * el estado de asistencia.
     *
     * @param reserva Un objeto de reserva que contiene información como la fecha, la hora y el estado de asistencia.
     */
    public void accederReserva(Reserva reserva){
        System.out.println("Accediendo a la reserva");
        System.out.println("Fecha: "+reserva.getFecha());
        System.out.println("Hora: "+reserva.getHora());
        System.out.println("Asistencia: "+reserva.getAsistencia());
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "reservas=" + reservas +
                '}';
    }
}
