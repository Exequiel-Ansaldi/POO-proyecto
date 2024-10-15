package com.mycompany.tallerpoo.com.resto.personal;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

import com.mycompany.tallerpoo.com.resto.Resto;

public class Administrador extends Personal {
    private Resto resto;


    public Administrador() {
    }


    public Administrador(Resto resto) {
        this.resto = resto;
    }


    public Resto getResto() {
        return this.resto;
    }

    public void setResto(Resto resto) {
        this.resto = resto;
    }


    @Override
    public String toString() {
        return "Restaurant administrado: " + getResto();
    }


    public void gestionHorario(){

        if (this.resto == null) {
            System.out.println("No hay un restaurante asignado para gestionar.");
            return;
        }

        Scanner lectura = new Scanner(System.in);

        // Solicitar hora de apertura
        System.out.print("Ingrese la hora de apertura (HH:MM): ");
        String horaAperturaInput = lectura.nextLine();
        LocalTime horaApertura = LocalTime.parse(horaAperturaInput);

        // Solicitar hora de cierre
        System.out.print("Ingrese la hora de cierre (HH:MM): ");
        String horaCierreInput = lectura.nextLine();
        LocalTime horaCierre = LocalTime.parse(horaCierreInput);

        // Actualizar los horarios del restaurante
        resto.setApertura(horaApertura);
        resto.setCierre(horaCierre);
        lectura.close();
    }

        
    public void BloquearMesa(){
    }

    
    public void asignarRol(CodRol rol){
        super.setRol(rol); 
    }

    //Ver que onda este metodo
        /* 
        CrearCuenta(empleado:Empleado): void
        */

}
