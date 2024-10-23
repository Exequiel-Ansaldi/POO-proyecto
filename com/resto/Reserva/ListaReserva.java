package com.mycompany.tallerpoo.com.resto.Reserva;

import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.EstadoMesa;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;

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

    public boolean eliminarReserva(Reserva reserva) {
        if (reservas.contains(reserva)) {
            reservas.remove(reserva);
            return true;
        }
        return false;
    }

    public void leerArchivo(String archivo, String separador) throws IOException {
        BufferedReader br = null;
        Reserva reserva;

        try {
            br = new BufferedReader(new FileReader(archivo));

            String linea = br.readLine();

            while (null != linea) {
                String[] campos = linea.split(separador);
                reserva = new Reserva();
                LocalDate fecha = LocalDate.parse(campos[0]); // Fecha de la reserva
                Asistencia asistencia = Asistencia.valueOf(campos[1]); // Tipo de asistencia
                LocalTime horaInicio = LocalTime.parse(campos[2]); // Hora de inicio
                LocalTime horaFinal = LocalTime.parse(campos[3]); // Hora final
                Mesa mesa = new Mesa(Integer.parseInt(campos[4]), campos[5], EstadoMesa.valueOf(campos[6])); // Crear la mesa, asumiendo que tienes un constructor
                Cliente cliente = new Cliente(campos[7],campos[8],campos[9],campos[10]);
                reserva = new Reserva(fecha, asistencia, horaInicio, horaFinal, mesa, cliente); // Cliente se puede pasar como null o lo que necesites

                // Agregar la reserva a la lista
                this.agregarReserva(reserva); // Método que debes implementar para agregar reservas
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
                linea += reserva.getHora() + separador;
                linea += reserva.getHorafinalreserva() + separador;
                linea += reserva.getMesa().getCapacidad() + separador; // Asegúrate de tener los métodos adecuados
                linea += reserva.getMesa().getUbicacion() + separador;
                linea += reserva.getMesa().getEstado() + separador; // Enum a String
                linea+= reserva.getCliente().getNombre() + separador;
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
