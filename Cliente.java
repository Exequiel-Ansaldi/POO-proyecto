/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

/**
 *
 * @author Exequiel
 */
public class Cliente {
    private String nombre;
    private String correo;
    private String contrasenia;
    private int numero;

    public Cliente(String nombre, String correo, String contrasenia, int numero) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.numero = numero;
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