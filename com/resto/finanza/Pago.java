/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.finanza;

/**
 *
 * @author Exequiel
 */
public class Pago {
    private float monto;

    public Pago(float monto) {
        this.monto = monto;
    }

    public float getMonto() {
        return this.monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    //Corregir
    public float Descontar(float monto, TarjetaDeCredito tarjeta){
        return 0;
    }

}
