/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Exequiel
 */
public class Cliente {
    private String nombre;
    private String correo;
    private String contrasenia;
    private int numero;
    private List<Reserva> reservas;
    
    public Cliente(){
        this.reservas = new ArrayList<Reserva>();
    }

    public Cliente(String nombre, String correo, String contrasenia, int numero, List<Reserva> reservas) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.numero = numero;
        this.reservas = reservas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    public void agregarReserva(Reserva r){
        this.reservas.add(r);
    }
    
    
    public void registrarse(){
    }
    public void iniciarSesion(String c, String contra){
    }
    public void actualizarInfo(){
    }
    public void historialReserva(){ //DEVUELVE UNA LISTA DE RESERVAS//
    }
    public void reservarMesa(){ // PARAMETROS FECHA: DATE, HORA: TIME Y MESA: MESA//
    }
    public void recuperarContrasenia(String c){
    }
}