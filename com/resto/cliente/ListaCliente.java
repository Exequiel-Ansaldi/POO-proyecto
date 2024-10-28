package com.mycompany.tallerpoo.com.resto.cliente;
import com.mycompany.tallerpoo.com.resto.reserva.Reserva;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.mesa.EstadoMesa;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una lista de clientes.
 */
public class ListaCliente {
    private List<Cliente> clientes;

    // Constructor
    public ListaCliente() {
        this.clientes = new ArrayList<>();
    }

    // Método para cargar clientes desde un archivo
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) { // Asegurarse de que hay 4 campos
                    Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3]);
                    clientes.add(cliente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar clientes en un archivo
    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Cliente cliente : clientes) {
                writer.write(cliente.getNombre() + "," + cliente.getCorreo() + "," +
                        cliente.getContrasenia() + "," + cliente.getNumero());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la lista de clientes
    public List<Cliente> getClientes() {
        return clientes;
    }

    // Método para agregar un cliente a la lista
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static Cliente buscarCliente(String correo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equalsIgnoreCase(correo)) {
                return cliente; // Retorna el cliente si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Método para imprimir todos los clientes
    public void imprimirClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

}
