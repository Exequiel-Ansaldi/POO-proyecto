/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpoo;

import com.mycompany.tallerpoo.com.resto.Reserva;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.cliente.ListaCliente;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.EstadoMesa;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

        Cliente cliente = new Cliente("Juan", "juan@example.com", "1234", "987654321", new ArrayList<>());

        // Crear una mesa (supón que tienes un constructor adecuado en la clase Mesa)
        Mesa mesa = new Mesa(4, "Patio", EstadoMesa.Disponible); // Supón que la mesa se identifica con un número

        // Crear una reserva
        LocalDate fecha = LocalDate.now();
        LocalTime horaInicio = LocalTime.of(12, 0); // 12:00 PM
        LocalTime horaFin = LocalTime.of(14, 0); // 2:00 PM
        Asistencia asistencia = Asistencia.Asiste; // Supón que CONFIRMADA es un valor de la enumeración Asistencia

        Reserva reserva = new Reserva(fecha, asistencia, horaInicio, horaFin, mesa, cliente);

        // Agregar la reserva a la lista de reservas del cliente
        cliente.getReservas().add(reserva);

        // Añadir el cliente a la lista de clientes
        ListaCliente listaCliente = new ListaCliente(new ArrayList<>());
        listaCliente.agregarCliente(cliente);

        // Guardar los datos del cliente en el archivo
        try {
            listaCliente.escribirArchivo("C:\\Users\\GAMER\\Documents\\Taller POO\\CLASES-POO\\com\\resto\\data\\clientes.csv", "," );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

