package com.mycompany.tallerpoo.com.resto.cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
                this.agregarCliente(cliente);
                linea = br.readLine();
            }
        } catch (Exception e) {

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
