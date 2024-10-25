/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpoo;

import com.mycompany.tallerpoo.com.resto.Evento;
import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaI;
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

        // Crear un cliente
        Cliente cliente = new Cliente("pedro", "juan@example.com", "1234", "987654321", new ArrayList<>());

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

        LocalDate dia = LocalDate.of(2024, 10, 23);
        LocalTime horainicio = LocalTime.of(12, 0);
        LocalTime horafin = LocalTime.of(14, 0);
        Evento evento = new Evento("Cumple", "prueba", dia, horainicio, horafin, new ArrayList<>());

        mesa.setEvento(evento);

        ListaMesa listaMesa = new ListaMesa();
        listaMesa.agregarMesa(mesa);
        listaMesa.agregarReservaAMesa(mesa, reserva);
        listaMesa.agregarEventoAMesa(mesa, evento);

        Evento eventoAsociado = mesa.getEvento(); // Get the associated event
        if (eventoAsociado != null) {
            System.out.println("Evento asociado a la mesa: " + eventoAsociado.toString());
        } else {
            System.out.println("No hay evento asociado a la mesa.");
        }

        // Añadir el cliente a la lista de clientes
        listaCliente.agregarCliente(cliente);

        // Añadir la reserva a la lista de reservas
        listaReserva.agregarReserva(reserva);

        reserva.confirmarReserva(listaReserva);

        VentanaI ventanaIdentificacion = new VentanaI();
        ventanaIdentificacion.setVisible(true);
        // Guardar los datos del cliente en el archivo
        try {
            listaCliente.escribirArchivo("com/resto/data/clientes.csv", ",");
            listaCliente.leerArchivo("com/resto/data/clientes.csv", ",");
            //listaReserva.escribirArchivo("com/resto/data/reservas.csv", ",");
            //listaMesa.escribirArchivo("com/resto/data/mesas.csv", " , ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

