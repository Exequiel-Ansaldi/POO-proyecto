package src.reserva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import src.finanza.Asistencia;
import src.finanza.Pago;
import src.mesa.Mesa;
import src.personal.Empleado;

public class ListaReserva {
    ArrayList<Reserva> reservas = new ArrayList<>();

    public ListaReserva() {
        this.reservas = new ArrayList<>();
    }

    public ListaReserva(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void agregarMesa(Mesa mesa, Reserva reserva) {
        for (Reserva reservas1 : reservas) {
            if (reservas1.equals(reserva)){
                reservas1.setMesa(reserva.getMesa());
            }
        }
    }

    public boolean eliminarReserva(Reserva reserva) {
        if (reservas.contains(reserva)) {
            reservas.remove(reserva);
            return true;
        }
        return false;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void leerArchivo(String archivo, String separador) throws IOException {
        BufferedReader br = null;
        Reserva reserva;

        try {
            br = new BufferedReader(new FileReader(archivo));

            String linea = br.readLine();

            while (linea != null) {
                String[] campos = linea.split(separador);
                if (campos.length < 2) {
                    System.err.println("Formato de linea invalida: " + linea);
                    linea = br.readLine();
                    continue; // Skip this line and read the next one
                }
                reserva = new Reserva();
                LocalDate fecha = LocalDate.parse(campos[0]); // Fecha de la reserva

                // Ensure there are enough fields before accessing them
                if (campos.length > 1) {
                } else {

                }


                linea = br.readLine(); // Leer la siguiente línea
            }
        } finally {
            if (br != null) {
                br.close(); // Cierra el BufferedReader
            }
        }
    }

    public void escribirArchivo(String archivo, String separador) throws IOException {
        PrintWriter pw = null;
        FileWriter nuevo = null;
        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;

            for (Reserva reserva : reservas) {
                linea = reserva.getFecha() + separador;
                linea += reserva.getAsistencia() + separador;
                linea += reserva.getHorainicioreserva() + separador;
                linea += reserva.getHorafinalreserva() + separador;
                linea += reserva.getMesa().getCapacidad() + separador;
                linea += reserva.getMesa().getUbicacion() + separador;
                linea += reserva.getMesa().getEstado() + separador;
                linea += reserva.getCliente().getNombre() + separador;


                linea += reserva.getCliente().getCorreo() + separador;
                linea += reserva.getCliente().getContrasenia() + separador;
                linea += reserva.getCliente().getNumero() + separador;
                List<Empleado> empleados = reserva.getEmpleados();
                if (empleados != null && !empleados.isEmpty()) {
                    for (Empleado empleado : empleados) {
                        linea += empleado.getRol().name() + ",";
                    }

                    if (linea.endsWith(",")) {
                        linea = linea.substring(0, linea.length() - 1);
                    }
                }
                linea += separador;

                List<Pago> pagos = reserva.getPagos();
                if (pagos != null && !pagos.isEmpty()) {
                    for (Pago pago : pagos) {
                        linea += pago.getMonto() + ":" + pago.getTarjeta().getNombre() + ":" + pago.getTarjeta().getEmisor() + ":" + pago.getTarjeta().getMotivo() + ":" + pago.getTarjeta().getNrotarjeta() + ",";
                    }

                    if (linea.endsWith(",")) {
                        linea = linea.substring(0, linea.length() - 1);
                    }
                }
                pw.println(linea);
            }
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (nuevo != null) {
                nuevo.close();
            }
        }
    }
}
