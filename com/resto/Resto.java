/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;


import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.personal.Administrador;

import java.time.LocalDate;
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

    //Constructores
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

    //Getters & Setters
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

    public List <Cliente> getClientes(){
        return this.clientes;
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

    public List<Evento> getEventos(){
        return this.eventos;
    }

    public void agregarAdmin(Administrador c){
        this.admins.add(c);
    }
 
    public void setAdmin(List <Administrador> admins){
        this.admins = admins;
    }

    public List<Administrador> geAdministradores(){
        return this.admins;
    }

    public void agregarMesa(Mesa c){
        this.mesas.add(c);
    }
 
    public void setMesa(List <Mesa> mesas){
        this.mesas = mesas;
    }

    public List<Mesa> getMesas(){
        return this.mesas;
    }

    public void agregarReserva(Reserva c){
        this.reservas.add(c);
    }
 
    public void setReserva(List <Reserva> reservas){
        this.reservas = reservas;
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    //Métodos de Clase
    public boolean verificarDisponibilidad(List<Mesa> mesasSolicitadas, LocalDate fecha, LocalTime horaInicio, int duracionHoras) {
        // Calcular la hora final basándose en la duración especificada por el cliente
        LocalTime horaFinal = horaInicio.plusHours(duracionHoras);
    
        // Recorrer todas las reservas existentes
        for (Reserva reserva : reservas) {
            // Verificar si la fecha de la reserva coincide con la fecha solicitada
            if (reserva.getFecha().isEqual(fecha)) {
                // Verificar si hay alguna mesa en común entre las solicitadas y las de la reserva
                for (Mesa mesaSolicitada : mesasSolicitadas) {
                    if (reserva.getMesas().contains(mesaSolicitada)) {
                        // Verificar si el rango de tiempo solicitado se superpone con la reserva existente
                        LocalTime inicioReserva = reserva.getHora();
                        LocalTime finReserva = reserva.getHora().plusHours(reserva.getDuracionHoras());
    
                        // Verificar superposición de horarios
                        boolean horarioEnConflicto = 
                            (horaInicio.isBefore(finReserva) && horaFinal.isAfter(inicioReserva));
    
                        if (horarioEnConflicto) {
                            return false; // La mesa no está disponible en el horario solicitado
                        }
                    }
                }
            }
        }
        // Si no hay conflictos, las mesas están disponibles
        return true;
    }
    
    

}
