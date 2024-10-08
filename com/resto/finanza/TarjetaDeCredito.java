/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.finanza;
/**
 *
 * @author Exequiel
 */
public class TarjetaDeCredito {
    private String nombre;
    private String emisor;
    private String motivo;
    private int nrotarjeta;
    private int cantidad;
    private Pago pago;

    public TarjetaDeCredito(String nombre, String emisor, String motivo, int nrotarjeta, int cantidad, Pago p) {
        this.nombre = nombre;
        this.emisor = emisor;
        this.motivo = motivo;
        this.nrotarjeta = nrotarjeta;
        this.cantidad = cantidad;
        this.pago = p;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmisor() {
        return this.emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getNrotarjeta() {
        return this.nrotarjeta;
    }

    public void setNrotarjeta(int nrotarjeta) {
        this.nrotarjeta = nrotarjeta;
    }


    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public Pago getPago(){
        return this.pago;
    }

    public void setPago(Pago p){
        this.pago = p;
    }


    @Override
    public String toString() {
        return
            " Nombre: " + getNombre() + " " +
            ", Emisor: " + getEmisor() + " " +
            ", Motivo: " + getMotivo() + " " +
            ", Numero de Tarjeta: " + getNrotarjeta() + " " +
            ", Cantidad: " + getCantidad() + " " +
            ", Pago: " + getPago();
    }

}
