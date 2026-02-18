package src.mesa;

import java.util.ArrayList;
import java.util.List;
import src.reserva.Reserva;
import src.Evento;
import src.cliente.Cliente; 
import src.finanza.Asistencia;  
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import src.mesa.Mesa;
import java.io.FileReader;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import src.mesa.EstadoMesa;

/**
 * La clase ListaMesa representa una colección de mesas en un restaurante.
 * Permite agregar, eliminar y gestionar reservas y eventos para cada mesa.
 */
public class ListaMesa {

    /** 
     * Lista que contiene las mesas del restaurante.
     */
    ArrayList<Mesa> mesas;

    //-----------------------------------------CONSTRUCTORES--------------------------------------------------
    /**
     * Constructor por defecto que inicializa una nueva lista de mesas vacía.
     */
    public ListaMesa(){
        this.mesas = new ArrayList<>();
    }

     /**
     * Constructor que inicializa la lista de mesas con una lista dada.
     * 
     * @param mesas La lista inicial de mesas.
     */
    public ListaMesa(ArrayList<Mesa> mesas){
        this.mesas = mesas;
    }

    /**
     * Obtiene la lista de mesas.
     * @return lista de mesas
     */
    public List<Mesa> getMesas(){
        return this.mesas;
    }

    //----------------------------------------MÉTODOS----------------------------------------------------
    /**
     * Agrega una mesa a la lista de mesas.
     * 
     * @param mesa La mesa a agregar.
     */
    public void agregarMesa(Mesa mesa){
        mesas.add(mesa);
    }

    /**
     * Elimina una mesa de la lista si existe.
     * 
     * @param mesa La mesa a eliminar.
     * @return true si la mesa fue eliminada, false si no estaba en la lista.
     */
    public boolean eliminarMesa(Mesa mesa){
        if(mesas.contains(mesa)){
            mesas.remove(mesa);
            return true;
        }
        return false;
    }

     /**
     * Agrega una reserva a una mesa específica si la mesa existe en la lista.
     * 
     * @param mesa   La mesa a la que se desea agregar la reserva.
     * @param reserva La reserva a agregar a la mesa.
     */
    public boolean agregarReservaAMesa(Mesa mesa, Reserva reserva) {
        if (mesas.contains(mesa)) {
            mesa.agregarReservas(reserva);
            return true;
        } else {

            return false;
        }
    }

    /**
     * Agrega un evento a una mesa específica si la mesa existe en la lista.
     * 
     * @param mesa   La mesa a la que se desea agregar el evento.
     * @param evento El evento a agregar a la mesa.
     */
    public boolean agregarEventoAMesa(Mesa mesa, Evento evento) {
        if (mesas.contains(mesa)) {
            mesa.setEvento(evento);
            return true;
        }else{
            return false;
        }
    }
     /**
     * Lee los datos de mesas desde un archivo y los agrega a la lista.
     * Cada línea del archivo representa una mesa y puede contener datos de reservas y eventos.
     * 
     * @param archivo   El nombre del archivo de entrada.
     * @param separador El separador de campos en el archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
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
                List<Reserva> reservas = new ArrayList<>();
                if(campos.length > 3 && !campos[3].isEmpty()){
                    String[] reservasData = campos[3].split(",");
                    for (String reservaData : reservasData) {
                        String[] reservaCampos = reservaData.split(",");
                        LocalDate fecha = LocalDate.parse(reservaCampos[0]);
                        Asistencia asistencia = Asistencia.valueOf(reservaCampos[1]);
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
                // Establecer estado si está presente
                if (campos.length > 2 && campos[2] != null && !campos[2].isEmpty()) {
                    try {
                        mesa.setEstado(EstadoMesa.valueOf(campos[2]));
                    } catch (IllegalArgumentException iae) {
                        // Si el valor no coincide con el enum, marcar como No_Disponible por defecto
                        mesa.setEstado(EstadoMesa.No_Disponible);
                    }
                } else {
                    mesa.setEstado(EstadoMesa.No_Disponible);
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

    /**
     * Escribe los datos de las mesas en un archivo.
     * Cada mesa se guarda en una línea con sus reservas y eventos asociados.
     * 
     * @param archivo   El nombre del archivo de salida.
     * @param separador El separador de campos en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */

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

                        linea += reserva.getFecha() + "," +
                                reserva.getHorainicioreserva() + "," +
                                reserva.getHorafinalreserva() + "," +
                                reserva.getAsistencia() + ";";
                    }
                } else {
                    linea += "Sin reservas";
                }

                // Write event details if they exist
                Evento evento = mesa.getEvento();
                if (evento != null) {
                    linea += evento.getDescripcion() + "," +
                            evento.getNombre() + "," +
                            evento.getMesas() + "," +
                            evento.getDia() + "," +
                            evento.getHorainicio() + "," +
                            evento.getHorafin() + ",";
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
