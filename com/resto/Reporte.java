package com.mycompany.tallerpoo.com.resto;
import com.mycompany.tallerpoo.com.resto.Reserva.Reserva;
import com.mycompany.tallerpoo.com.resto.Resto;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import java.time.temporal.WeekFields;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
                reservasEnRango.add(reserva);
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

    public List<String> reservasPorDia() {
        List<String> reportedia = new ArrayList<>();
        List<LocalDate> fechasReservas = new ArrayList<>();
        for (Reserva reserva : resto.getReservas()) {
            LocalDate fecha = reserva.getFecha();
            if (!fechasReservas.contains(fecha)) {
                fechasReservas.add(fecha);
            }
        }
        for (LocalDate fecha : fechasReservas) {
            int numeroReservasDia = 0;
            for (Reserva reserva : resto.getReservas()) {
                if (reserva.getFecha().equals(fecha)) {
                    numeroReservasDia++;
                }
            }
            String detalle = "Fecha: " + fecha + ", Reservas: " + numeroReservasDia;
            reportedia.add(detalle);
        }

        return reportedia;
    }
    public List<String> reservasPorMes() {
        List<String> reporte = new ArrayList<>();
        List<Integer> meses = new ArrayList<>(); // Para almacenar los meses
        List<Integer> conteoReservas = new ArrayList<>(); // Para contar reservas por mes

        // Contar reservas por mes
        for (Reserva reserva : resto.getReservas()) {
            LocalDate fecha = reserva.getFecha(); // Asumiendo que getFecha() devuelve LocalDateTime
            int mes = fecha.getMonthValue(); // Obtener el número del mes
            int year = fecha.getYear(); // Obtener el año

            // Crear una clave única combinando el año y el mes
            int clave = year * 100 + mes; // Combina el año y el mes

            // Verificar si ya se registró el mes
            int index = meses.indexOf(clave);
            if (index == -1) {
                // Si no está, agregar el nuevo mes y un conteo inicial
                meses.add(clave);
                conteoReservas.add(1);
            } else {
                // Si ya está, incrementar el conteo
                conteoReservas.set(index, conteoReservas.get(index) + 1);
            }
        }

        // Generar el reporte de reservas
        for (int i = 0; i < meses.size(); i++) {
            int clave = meses.get(i);
            int year = clave / 100; // Extraer el año
            int mes = clave % 100; // Extraer el número del mes
            int numeroReservas = conteoReservas.get(i);
            String detalle = "Año: " + year + ", Mes: " + mes + ", Reservas: " + numeroReservas;
            reporte.add(detalle);
        }

        return reporte;
    }
    public List<String> reservasPorSemana() {
    List<String> reporte = new ArrayList<>();
    List<Integer> semanas = new ArrayList<>(); // Para almacenar las semanas
    List<Integer> conteoReservas = new ArrayList<>(); // Para contar reservas por semana

    // Usar WeekFields para obtener la semana del año
    WeekFields weekFields = WeekFields.of(Locale.getDefault());

    // Contar reservas por semana
        for (Reserva reserva : resto.getReservas()) {
        LocalDate fecha = reserva.getFecha(); // Asumiendo que getFecha() devuelve LocalDateTime
        int semana = fecha.get(weekFields.weekOfWeekBasedYear()); // Obtener el número de la semana
        int year = fecha.getYear(); // Obtener el año

        // Crear una clave única combinando el año y la semana
        int clave = year * 100 + semana; // Combina el año y la semana

        // Verificar si ya se registró la semana
        int index = semanas.indexOf(clave);
        if (index == -1) {
            // Si no está, agregar la nueva semana y un conteo inicial
            semanas.add(clave);
            conteoReservas.add(1);
        } else {
            // Si ya está, incrementar el conteo
            conteoReservas.set(index, conteoReservas.get(index) + 1);
        }
    }

    // Generar el reporte de reservas
        for (int i = 0; i < semanas.size(); i++) {
        int clave = semanas.get(i);
        int year = clave / 100; // Extraer el año
        int semana = clave % 100; // Extraer el número de la semana
        int numeroReservas = conteoReservas.get(i);
        String detalle = "Año: " + year + ", Semana: " + semana + ", Reservas: " + numeroReservas;
        reporte.add(detalle);
    }

        return reporte;
    }

    public double ocupacionMediaMesas() {
        if (resto.getReservas().isEmpty()) {
            return 0.0; // Evitar división por cero
        }

        int totalComensales = 0;
        int totalMesasUsadas = 0;

        for (Reserva reserva : resto.getReservas()) {
            totalComensales += reserva.getMesa().getCapacidad(); // Asumiendo que getMesa() devuelve un objeto que tiene capacidad
            totalMesasUsadas++;
        }

        // Calcular la ocupación media
        return (double) totalComensales / totalMesasUsadas; // Devuelve la ocupación media
    }
}


