/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.finanza;
import com.mycompany.tallerpoo.com.resto.Reserva;
/**
 *
 * @author Exequiel
 */
public class Pago {
    private float monto;
    private Reserva reserva;
    private TarjetaDeCredito tarjeta;

    public Pago(float monto){
        this.monto = monto;
    }
    public Pago(Reserva reserva, TarjetaDeCredito tarjeta){
        this.reserva = reserva;
        this.tarjeta = tarjeta;
    }
    public Pago(float monto,Reserva reserva, TarjetaDeCredito tarjeta) {
        this.monto = monto;
        this.reserva = reserva;
        this.tarjeta = tarjeta;
    }

    public Reserva getReserva(){
        return this.reserva;
    }

    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    public TarjetaDeCredito getTarjeta(){
        return this.tarjeta;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta){
        this.tarjeta = tarjeta;
    }

    public float getMonto() {
        return this.monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    //Corregir
    public float Descontar(float monto, TarjetaDeCredito tarjeta, Asistencia a) {
        float totalDescontado = 0;
        switch (a) {
            case Noasiste:
                tarjeta.setCantidad(tarjeta.getCantidad() - 50);
                System.out.println("Se descontaron $50 por Inasistencia");
                totalDescontado = 50;
            case Asiste:
                tarjeta.setCantidad(tarjeta.getCantidad() - monto);
                System.out.println("Se desconto: $" + monto);
                totalDescontado = monto;
            case Otro:
        }
        return totalDescontado;
    }
}
