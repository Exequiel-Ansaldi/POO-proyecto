/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.cliente;

import com.mycompany.tallerpoo.com.resto.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public Cliente(String nombre, String correo, String contrasenia, int numero, List<Reserva> reservas) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.numero = numero;
        this.reservas = reservas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    public void agregarReserva(Reserva r){
        this.reservas.add(r);
    }

    public void registrarse(){

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        this.nombre = lectura.nextLine();
        System.out.println("Ingrese su correo: ");
        this.correo = lectura.nextLine();
        //patron email son los valores validos que puede tomar una direcccion de correo
        String patronemail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        //pattern compila a patronemail
        Pattern patron = Pattern.compile(patronemail);
        //a partir del pattern se crea un matcher para verificar coincidencias
        Matcher matcheo = patron.matcher(this.correo);
        while (!matcheo.matches()){
            System.out.println("Ingrese nuevamente su correo");
            this.correo = lectura.nextLine();
            matcheo = patron.matcher(this.correo);
        }
        
        while (true){
            System.out.println("Ingrese su contraseña: ");
            this.contrasenia = lectura.nextLine();
            System.out.println("Confirme su contraseña");
            String confirmarcontrasenia = lectura.nextLine();
            if (!(this.contrasenia.equals(confirmarcontrasenia))){
                System.out.println("Las contraseñas no coinciden, ingrese nuevamente");
            }else{
                break;
            }
        }

        System.out.println("Registro exitoso");
        lectura.close();

    }

    public void iniciarSesion(String c, String contra){
        if (this.correo.equals(correo) && this.contrasenia.equals(contrasenia)) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Correo o contraseña incorrectos. Inténtelo de nuevo.");
        }
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