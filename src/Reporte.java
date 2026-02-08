package src;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import src.cliente.Cliente;
import src.finanza.Asistencia;
import src.reserva.Reserva;
import src.resto.Resto;


/**
 * Clase que representa un reporte de reservas en un restaurante.
 * Proporciona métodos para obtener información sobre las reservas,
 * clientes y estadísticas de ocupación.
 */
public class Reporte {
    private Resto resto;

    /**
     * Constructor por defecto.
     */
    public Reporte() {
    }

    /**
     * Constructor que inicializa el objeto Reporte con un restaurante específico.
     *
     * @param resto El restaurante del cual se generarán los reportes.
     */
    public Reporte(Resto resto) {
        this.resto = resto;
    }

    /**
     * Obtiene el restaurante asociado a este reporte.
     *
     * @return El restaurante.
     */
    public Resto getResto() {
        return resto;
    }

    /**
     * Establece el restaurante asociado a este reporte.
     *
     * @param resto El restaurante a establecer.
     */
    public void setResto(Resto resto) {
        this.resto = resto;
    }

    /**
     * Obtiene una lista de reservas futuras para un cliente específico.
     *
     * @param cliente El cliente del cual se quieren obtener las reservas futuras.
     * @return Lista de reservas futuras del cliente.
     */
    public List<Reserva> reservasFuturasCliente(Cliente cliente) {
        List<Reserva> reservasFuturas = new ArrayList<>();
        for (Reserva reserva : resto.getReservas()) {
            if (reserva.getCliente().equals(cliente) && reserva.getFecha().isAfter(LocalDate.now())) {
                reservasFuturas.add(reserva);
            }
        }
        return reservasFuturas;
    }

    /**
     * Obtiene todas las reservas de un cliente específico.
     *
     * @param cliente El cliente del cual se quieren obtener las reservas.
     * @return Lista de todas las reservas del cliente.
     */
    public List<Reserva> reservasTotalesCliente(Cliente cliente) {
        List<Reserva> reservasTotales = new ArrayList<>();
        for (Reserva reserva : resto.getReservas()) {
            if (reserva.getCliente().equals(cliente)) {
                reservasTotales.add(reserva);
            }
        }
        return reservasTotales;
    }

    /**
     * Obtiene el cliente con más reservas asistidas.
     *
     * @return El cliente que ha asistido a más reservas.
     */
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

    /**
     * Obtiene una lista de clientes que no asistieron a sus reservas en el último año.
     *
     * @return Lista de clientes que no asistieron a sus reservas.
     */
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

    /**
     * Obtiene una lista de reservas dentro de un rango de fechas específico.
     *
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Lista de reservas dentro del rango de fechas.
     */
    public List<Reserva> ReservaDetallada(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Reserva> reservasEnRango = new ArrayList<>();
        for (Reserva reserva : resto.getReservas()) {
            if (!reserva.getFecha().isBefore(fechaInicio) && !reserva.getFecha().isAfter(fechaFin)) {
                reservasEnRango.add(reserva);
            }
        }
        return reservasEnRango;
    }

    /**
     * Determina la estación con mayor concurrencia de reservas.
     *
     * @return El nombre de la estación con mayor concurrencia.
     */
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

    /**
     * Genera un reporte de reservas por día.
     *
     * @return Lista de cadenas que representan las reservas por día.
     */
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

    /**
     * Genera un reporte de reservas por mes.
     *
     * @return Lista de cadenas que representan las reservas por mes.
     */
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
}
