/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpoo;

import com.mycompany.tallerpoo.com.resto.Evento;
import com.mycompany.tallerpoo.com.resto.mesa.ListaMesa;
import com.mycompany.tallerpoo.com.resto.reserva.ListaReserva;
import com.mycompany.tallerpoo.com.resto.reserva.Reserva;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.cliente.ListaCliente;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.EstadoMesa;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Gamer
 */

public class MainTaller {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        //Método enviarRecordatorio
        /*Reserva reserva = new Reserva();
        LocalDate fechaEspecifica = LocalDate.of(2023, 3, 15);
        reserva.setFecha(fechaEspecifica);
        reserva.enviarRecordatorioReserva("carolinaittermann@gmail.com");*/

        // Crear un cliente
        Cliente cliente = new Cliente("Juan", "juan@example.com", "1234", "987654321", new ArrayList<>());

        // Crear una mesa
        Mesa mesa = new Mesa(4, "Patio", EstadoMesa.Disponible);

        // Crear una reserva
        LocalDate fecha = LocalDate.now();
        LocalTime horaInicio = LocalTime.of(12, 0);
        LocalTime horaFin = LocalTime.of(14, 0);
        Asistencia asistencia = Asistencia.Asiste;

        Reserva reserva = new Reserva(fecha, asistencia, horaInicio, horaFin, mesa, cliente);

        // Agregar la reserva a la lista de reservas del cliente
        cliente.getReservas().add(reserva);

        // Crear listas de clientes y reservas
        ListaCliente listaCliente = new ListaCliente(new ArrayList<>());
        ListaReserva listaReserva = new ListaReserva();
        Evento evento = new Evento();

        ListaMesa listaMesa = new ListaMesa();
        listaMesa.agregarMesa(mesa);
        listaMesa.agregarReservaAMesa(mesa, reserva);
        listaMesa.agregarEventoAMesa(mesa, evento);

        // Añadir el cliente a la lista de clientes
        listaCliente.agregarCliente(cliente);

        // Añadir la reserva a la lista de reservas
        listaReserva.agregarReserva(reserva);

        //reserva.confirmarReserva(listaReserva);

        // Guardar los datos del cliente en el archivo
        try {
            listaCliente.escribirArchivo("C:\\Users\\GAMER\\Documents\\Taller POO\\CLASES-POO\\com\\resto\\data\\clientes.csv", ",");
            listaReserva.escribirArchivo("C:\\Users\\GAMER\\Documents\\Taller POO\\CLASES-POO\\com\\resto\\data\\reservas.csv", ",");
            listaMesa.escribirArchivo("C:\\Users\\GAMER\\Documents\\Taller POO\\CLASES-POO\\com\\resto\\data\\mesas.csv", " , ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

