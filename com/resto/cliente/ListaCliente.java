package com.mycompany.tallerpoo.com.resto.cliente;
import com.mycompany.tallerpoo.com.resto.Reserva;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.mesa.EstadoMesa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaCliente {
    ArrayList<Cliente> clientes;

    public ListaCliente() {
        this.clientes = new ArrayList<>();
    }

    public ListaCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean eliminarCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public void leerArchivo(String archivo, String separador) throws IOException {
        BufferedReader br = null;
        Cliente cliente;

        try {
            br = new BufferedReader(new FileReader(archivo));

            String linea = br.readLine();

            while (null != linea) {
                String[] campos = linea.split(separador);
                cliente = new Cliente();
                cliente.setNombre(campos[0]);
                cliente.setCorreo(campos[1]);
                cliente.setContrasenia(campos[2]);
                cliente.setNumero(campos[3]);
                List<Reserva> reservas = new ArrayList<>();
                if (campos.length > 4 && !campos[4].isEmpty()) {
                    // Supongamos que las reservas están en el campo 4 y separadas por '|'
                    String[] reservasData = campos[4].split("\\|");
                    for (String reservaData : reservasData) {
                        // Supongamos que cada reserva está en el formato: fecha,asistencia,horainicio,horafinal,mesa_id
                        String[] reservaCampos = reservaData.split(",");
                        LocalDate fecha = LocalDate.parse(reservaCampos[0]);
                        Asistencia asistencia = Asistencia.valueOf(reservaCampos[1]); // Asumiendo que Asistencia es un enum
                        LocalTime horaInicio = LocalTime.parse(reservaCampos[2]);
                        LocalTime horaFinal = LocalTime.parse(reservaCampos[3]);

                        int capacidad = Integer.parseInt(reservaCampos[4]);
                        String ubicacion = reservaCampos[5];
                        EstadoMesa estadoMesa = EstadoMesa.valueOf(reservaCampos[6]);
                        Mesa mesa = new Mesa(capacidad, ubicacion, estadoMesa);
                        Reserva reserva = new Reserva(fecha, asistencia, horaInicio, horaFinal, mesa, cliente);
                        reservas.add(reserva);
                    }
                }

                cliente.setReservas(reservas);
                this.agregarCliente(cliente);
                linea = br.readLine();
            }
        } catch (Exception e) {
                System.out.println(e.getMessage());
        } finally {
            if (null!=br) {
                br.close();
            }
        }
        System.out.println("cant" + this.clientes.size());
        for (Cliente clie: clientes) {
            System.out.println(clie.toString());
        }
    }

    public void escribirArchivo(String archivo, String separador) throws IOException {
        PrintWriter pw = null;
        FileWriter nuevo = null;
        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Cliente cliente : clientes) {
                linea = cliente.getNombre() + separador;
                linea += cliente.getCorreo() + separador;
                linea += cliente.getNumero() + separador;
                linea += cliente.getContrasenia() + separador;

                List<Reserva> reservas = cliente.getReservas();
                if (reservas != null && !reservas.isEmpty()) {
                    for (Reserva reserva : reservas) {
                        linea += reserva.getFecha() + ",";
                        linea += reserva.getHora() + ",";
                        linea += reserva.getHorafinalreserva() + ",";
                        linea += reserva.getAsistencia() + ",";
                        linea += reserva.getMesa().getCapacidad() + ",";
                        linea += reserva.getMesa().getUbicacion() + ",";
                        linea += reserva.getMesa().getEstado() + ";";
                    }
                } else {
                    linea += "Sin reservas";
                }

                pw.println(linea);

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != nuevo)
                    nuevo.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
