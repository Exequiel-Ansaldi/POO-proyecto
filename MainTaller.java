/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpoo;

import com.mycompany.tallerpoo.com.resto.Reserva;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;

import java.time.LocalDate;

/**
 *
 * @author Gamer
 */

public class MainTaller {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Método enviarRecordatorio
        /*Reserva reserva = new Reserva();
        LocalDate fechaEspecifica = LocalDate.of(2023, 3, 15);
        reserva.setFecha(fechaEspecifica);
        reserva.enviarRecordatorioReserva("carolinaittermann@gmail.com");*/

        //Método registrarse, actualizarInfo, recuperarContrasenia (Cliente Class)
        Cliente c1 = new Cliente();
        c1.registrarse();
        System.out.println(c1.toString());
        c1.actualizarInfo();
        System.out.println(c1.toString());
        c1.recuperarContrasenia(c1.getCorreo());

    }

}
