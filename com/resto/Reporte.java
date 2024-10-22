package com.mycompany.tallerpoo.com.resto;
import com.mycompany.tallerpoo.com.resto.Resto;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private Resto resto;

    public Reporte() {
    }
    public Reporte(Resto resto) {
        this.resto = resto;
    }
    public Resto getResto() {
        return resto;
    }
    public void setResto(Resto resto) {
        this.resto = resto;
    }

    public List<Reserva> reservasFuturasCliente(Cliente cliente) {
        List<Reserva> reservasFuturas = new ArrayList<>();
        for (Reserva reserva : resto.getReservas()) {
            if (reserva.getCliente().equals(cliente) && reserva.getFecha().isAfter(LocalDate.now())) {
                reservasFuturas.add(reserva);
            }
        }
        return reservasFuturas;
    }

    public List<Reserva> reservasTotalesCliente(Cliente cliente) {
        List<Reserva> reservasTotales = new ArrayList<>();
        for (Reserva reserva : resto.getReservas()) {
            if (reserva.getCliente().equals(cliente)) {
                reservasTotales.add(reserva);
            }
        }
        return reservasTotales;
    }

    public Cliente clienteConMasReservasAsistidas() {
        Cliente clienteConMasReservas = null;
        int maxReservas = 0;

        for (Cliente cliente : resto.getClientes()) {
            int reservasAsistidas = 0;
            for (Reserva reserva : resto.getReservas()) {
                if (reserva.getCliente().equals(cliente) && reserva.getAsistencia() == Asistencia.Asiste) {
                    reservasAsistidas++;
                }
            }
            if (reservasAsistidas > maxReservas) {
                maxReservas = reservasAsistidas;
                clienteConMasReservas = cliente;
            }
        }
        return clienteConMasReservas;
    }
    public List<Cliente> clientesConReservasNoAsistidasUltimoAnio() {
        List<Cliente> clientesNoAsistidos = new ArrayList<>();
        LocalDate haceUnAnio = LocalDate.now().minusYears(1);

        for (Cliente cliente : resto.getClientes()) {
            boolean noAsistio = false;
            for (Reserva reserva : resto.getReservas()) {
                if (reserva.getCliente().equals(cliente) &&
                        reserva.getFecha().isAfter(haceUnAnio) &&
                        reserva.getAsistencia() == Asistencia.Noasiste) {
                        noAsistio = true;
                    break;
                }
            }
            if (noAsistio) {
                clientesNoAsistidos.add(cliente);
            }
        }
        return clientesNoAsistidos;
    }
    public List<Reserva> ReservaDetallada(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Reserva> reservasEnRango = new ArrayList<>();
        for (Reserva reserva : resto.getReservas()) {
            if (!reserva.getFecha().isBefore(fechaInicio) && !reserva.getFecha().isAfter(fechaFin)) {
                String detalleReserva = "Mesa: " + reserva.getMesa()+
                        ", Fecha: " + reserva.getFecha() +
                        ", Hora de comienzo: " + reserva.getHora() +
                        ", Hora de fin: " + reserva.getHorafinalreserva() +
                        ", Cliente: " + reserva.getCliente().getNombre() +
                        ", Cantidad de comensales: " + reserva.getMesa().getCapacidad();
                reservasDetalladas.add(detalleReserva);
            }
        }
        return reservasEnRango;
    }
    
    public String MayorConcurrenciaPorEstacion() {
        int primavera = 0, verano = 0, otonio = 0, invierno = 0;

        for (Reserva reserva : resto.getReservas()) {
            LocalDate fecha = reserva.getFecha();
            Month mes = fecha.getMonth();

            if (mes == Month.SEPTEMBER || mes == Month.OCTOBER || mes == Month.NOVEMBER) {
                primavera++;
            } else if (mes == Month.DECEMBER || mes == Month.JANUARY || mes == Month.FEBRUARY) {
                verano++;
            } else if (mes == Month.MARCH || mes == Month.APRIL || mes == Month.MAY) {
                otonio++;
            } else {
                invierno++;
            }
        }

        String estacionMayorConcurrencia;
        if (primavera >= verano && primavera >= otonio && primavera >= invierno) {
            estacionMayorConcurrencia = "Primavera";
        } else if (verano >= otonio && verano >= invierno) {
            estacionMayorConcurrencia = "Verano";
        } else if (otonio >= invierno) {
            estacionMayorConcurrencia = "Otoño";
        } else {
            estacionMayorConcurrencia = "Invierno";
        }

        return estacionMayorConcurrencia;
    }

   /* public void ReservaDia(){
        int numeroreservasdia = 0;
        for (Reserva reserva : resto.getReservas()) {
            if (reserva.getFecha().isAfter(LocalDate.now())) {
                numeroreservasdia++;
            }
        }
    }
    */
}

