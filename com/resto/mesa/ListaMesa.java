package com.mycompany.tallerpoo.com.resto.mesa;

import com.mycompany.tallerpoo.com.resto.Evento;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.reserva.Reserva;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ListaMesa {
    ArrayList<Mesa> mesas;

    public ListaMesa(){
        this.mesas = new ArrayList<>();
    }
    public ListaMesa(ArrayList<Mesa> mesas){
        this.mesas = mesas;
    }
    public void agregarMesa(Mesa mesa){
        mesas.add(mesa);
    }
    public boolean eliminarMesa(Mesa mesa){
        if(mesas.contains(mesa)){
            mesas.remove(mesa);
            return true;
        }
        return false;
    }
    public void leerArchivo(String archivo, String separador) throws IOException {
        BufferedReader br = null;
        Mesa mesa;

        try{
            br = new BufferedReader(new FileReader(archivo));

            String linea = br.readLine();

            while (null != linea){
                String[] campos = linea.split(separador);
                mesa = new Mesa();
                mesa.setCapacidad(Integer.parseInt(campos[0]));
                mesa.setUbicacion(campos[1]);
                EstadoMesa estado = EstadoMesa.valueOf(campos[2]);
                List<Reserva> reservas = new ArrayList<>();
                if(campos.length > 3 && !campos[3].isEmpty()){
                    String[] reservasData = campos[3].split(",");
                    for (String reservaData : reservasData) {
                        // Supongamos que cada reserva está en el formato: fecha,asistencia,horainicio,horafinal,mesa_id
                        String[] reservaCampos = reservaData.split(",");
                        LocalDate fecha = LocalDate.parse(reservaCampos[0]);
                        Asistencia asistencia = Asistencia.valueOf(reservaCampos[1]); // Asumiendo que Asistencia es un enum
                        LocalTime horaInicio = LocalTime.parse(reservaCampos[2]);
                        LocalTime horaFinal = LocalTime.parse(reservaCampos[3]);

                        String nombre = reservaCampos[7];
                        String correo = reservaCampos[8];
                        String contrasenia = reservaCampos[8];
                        String numero = reservaCampos[9];

                        Cliente cliente = new Cliente(nombre, correo, contrasenia, numero);

                        Reserva reserva = new Reserva(fecha, asistencia, horaInicio, horaFinal, mesa, cliente);
                        reservas.add(reserva);
                    }
                }

                // Leer el evento de la mesa
                if (campos.length > 4 && !campos[4].isEmpty()) {
                    String nombre = campos[4];
                    String descripcion = campos[5];
                    LocalDate dia = LocalDate.parse(campos[6]);
                    LocalTime horaInicio = LocalTime.parse(campos[7]);
                    LocalTime horaFin = LocalTime.parse(campos[8]);

                    Evento evento = new Evento(nombre, descripcion, dia, horaInicio, horaFin, new ArrayList<>());
                    mesa.setEvento(evento);
                }
                mesas.add(mesa);
                linea = br.readLine();
            }
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }finally {
            if (null!=br){
                br.close();
            }
        }
        System.out.println("cant"+this.mesas.size());
        for (Mesa m: mesas){
            System.out.println(m.toString());
        }
    }

    public void escribirArchivo(String archivo, String separador) throws IOException {
        PrintWriter pw = null;
        FileWriter nuevo = null;
        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Mesa mesa : mesas) {
                linea = mesa.getUbicacion() + separador;
                linea += mesa.getCapacidad() + separador;
                linea += mesa.getEstado() + separador;

                List<Reserva> reservas = mesa.getReservas();
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

                Evento evento = mesa.getEvento();
                if (evento != null) {
                    linea += evento.getDescripcion() + ",";
                    linea += evento.getNombre() + ",";
                    linea += evento.getMesas() + ",";
                    linea += evento.getDia() + ",";
                    linea += evento.getHorainicio() + ",";
                    linea += evento.getHorafin() + ",";
                }
                pw.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != nuevo)
                    nuevo.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
