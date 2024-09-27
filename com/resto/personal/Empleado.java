package com.mycompany.tallerpoo.com.resto.personal;

import com.mycompany.tallerpoo.com.resto.Reserva;

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

    //Métodos de Clase
    public void accederReserva(Reserva reserva){
        System.out.println("Accediendo a la reserva");
        System.out.println("Fecha: "+reserva.getFecha());
        System.out.println("Hora: "+reserva.getHora());
        System.out.println("Asistencia: "+reserva.getAsistencia());
    }
}
