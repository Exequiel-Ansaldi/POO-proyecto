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

    public TarjetaDeCredito(String nombre, String emisor, String motivo, int nrotarjeta) {
        this.nombre = nombre;
        this.emisor = emisor;
        this.motivo = motivo;
        this.nrotarjeta = nrotarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getNrotarjeta() {
        return nrotarjeta;
    }

    public void setNrotarjeta(int nrotarjeta) {
        this.nrotarjeta = nrotarjeta;
    }
}
