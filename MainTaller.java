/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpoo;

import com.mycompany.tallerpoo.com.resto.Reserva;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.cliente.ListaCliente;

import java.io.IOException;
import java.time.LocalDate;

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

        //Método registrarse, actualizarInfo, recuperarContrasenia (Cliente Class)
        // El archivo está en la misma carpeta del proyecto
        // Crea una instancia de ListaCliente
        ListaCliente listaClientes = new ListaCliente();

        // Ruta del archivo CSV
        String archivo = "C:\\Users\\GAMER\\Documents\\Taller POO\\CLASES-POO\\com\\resto\\data\\clientes.csv";

        // Agrega algunos clientes a la lista
        listaClientes.agregarCliente(new Cliente("Juan", "juan@mail.com", "contrasenia123", "123456789",null));
        listaClientes.agregarCliente(new Cliente("Maria", "maria@mail.com", "contrasenia456", "987654321",null));

        // Escribir en el archivo
        try {
            listaClientes.escribirArchivo(archivo, " ,");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

