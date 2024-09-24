/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;


import com.mycompany.tallerpoo.com.resto.cliente.Cliente;

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

    public Resto(){
        this.clientes = new ArrayList<Cliente>();
    }

    public Resto(String mapa, LocalTime apertura, LocalTime cierre, List <Cliente> clientes) {
        this.mapa = mapa;
        this.apertura = apertura;
        this.cierre = cierre;
        this.clientes = clientes;
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
}
