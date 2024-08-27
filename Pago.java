/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

/**
 *
 * @author GAMER
 */
public class Pago {
    private float monto;
    //ACA VA EL ATRIBUTO reserva: RESERVA//
    private TarjetaDeCredito tarjeta;

    public Pago(float monto, TarjetaDeCredito tarjeta) { // AGREGAR RESERVA//
        this.monto = monto;
        this.tarjeta = tarjeta;
    }
//AGREGAR RESERVA//
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public TarjetaDeCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
    public float Descontar(float monto, TarjetaDeCredito tarjeta){ //ASISTENCIA CLASE ENUMERACION AGREGAR//
    }
}
