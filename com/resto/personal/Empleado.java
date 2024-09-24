package com.mycompany.tallerpoo.com.resto.personal;

import com.mycompany.tallerpoo.com.resto.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Personal {
    private List<Reserva> reservas;

    public Empleado(){
        super();
        this.reservas = new ArrayList<Reserva>();
    }

    public Empleado(int id, CodRol r, List<Reserva> reservas) {
        super(id, r);
        this.reservas = reservas;
    }

    public void accederReserva(Reserva reserva){
        System.out.println("Accediendo a la reserva");
        System.out.println("Fecha: "+reserva.getFecha());
        System.out.println("Hora: "+reserva.getHora());
        System.out.println("Asistencia: "+reserva.getAsistencia());
    }
}
