/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;


import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.personal.Administrador;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

/**
 *
 * @author Exequiel
 */

public class Resto {
     private String mapa;
     private LocalTime apertura;
     private LocalTime cierre;
     private List<Cliente> clientes;
     private Agenda agenda;
     private List<Evento> eventos;
     private List<Administrador> admins;
     private List<Mesa> mesas;
     private List<Reserva> reservas;

    public Resto(){
        this.clientes = new ArrayList<Cliente>();
        this.eventos = new ArrayList<Evento>();
        this.admins = new ArrayList<Administrador>();
        this.mesas = new ArrayList<Mesa>();
        this.reservas = new ArrayList<Reserva>();
    }

    public Resto(String mapa, LocalTime apertura, LocalTime cierre, List <Cliente> clientes, Agenda agenda, List <Evento> eventos, List<Administrador> admins, List<Mesa> mesas, List<Reserva> reservas) {
        this.mapa = mapa;
        this.apertura = apertura;
        this.cierre = cierre;
        this.clientes = clientes;
        this.agenda = agenda;
        this.eventos = eventos;
        this.admins = admins;
        this.mesas = mesas;
        this.reservas = reservas;
    }


    public LocalTime getApertura() {
        return this.apertura;
    }

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    public LocalTime getCierre() {
        return this.cierre;
    }

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    public String getMapa() {
        return this.mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public void agregarCliente(Cliente c){
        this.clientes.add(c);
    }

    public void setCliente(List <Cliente> clientes){
        this.clientes = clientes;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void agregarEvento(Evento c){
        this.eventos.add(c);
    }
 
     public void setEvento(List <Evento> eventos){
        this.eventos = eventos;
    }

    public void agregarAdmin(Administrador c){
        this.admins.add(c);
    }
 
     public void setAdmin(List <Administrador> admins){
        this.admins = admins;
    }

    public void agregarMesa(Mesa c){
        this.mesas.add(c);
    }
 
     public void setMesa(List <Mesa> mesas){
        this.mesas = mesas;
    }

    public void agregarReserva(Reserva c){
        this.reservas.add(c);
    }
 
     public void setReserva(List <Reserva> reservas){
        this.reservas = reservas;
    }
}
