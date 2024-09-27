/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpoo;

import com.mycompany.tallerpoo.com.resto.Reserva;

import java.time.LocalDate;

/**
 *
 * @author Gamer
 */

public class MainTaller {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Método enviarRecordatorio
        Reserva reserva = new Reserva();
        LocalDate fechaEspecifica = LocalDate.of(2023, 3, 15);
        reserva.setFecha(fechaEspecifica);
        reserva.enviarRecordatorioReserva("carolinaittermann@gmail.com");
    }

}
