package com.mycompany.tallerpoo.com.resto.personal;

import com.mycompany.tallerpoo.com.resto.cliente.Cliente;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ListaAdmins {
    ArrayList<Administrador> administradores;

    public ListaAdmins() {
        administradores = new ArrayList<>();
    }

    public ListaAdmins(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public boolean eliminarAdministrador(Administrador administrador) {
        if (administradores.contains(administrador)) {
            administradores.remove(administrador);
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
                int id = Integer.parseInt(campos[0]);
                CodRol codRol = CodRol.valueOf(campos[1]);
                Administrador administrador = new Administrador(id, codRol);
                administradores.add(administrador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close(); // Cerrar el BufferedReader
            }
        }
    }

    public void escribirArchivo(String archivo, String separador) throws IOException {
        FileWriter nuevo = null;
        PrintWriter pw = null;

        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Administrador administrador : administradores) {
                linea = administrador.getIdPersonal() + separador; //
                linea += administrador.getRol() + separador; // Código de rol
            }
        } catch (IOException e) {
            e.printStackTrace();
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

