package com.mycompany.tallerpoo.com.resto.personal;

import com.mycompany.tallerpoo.com.resto.Reserva;

public class Empleado extends Personal {

    public void accederReserva(Reserva reserva){
        System.out.println("Accediendo a la reserva");
        System.out.println("Fecha: "+reserva.getFecha());
        System.out.println("Hora: "+reserva.getHora());
        System.out.println("Asistencia: "+reserva.getAsistencia());
    }
}
