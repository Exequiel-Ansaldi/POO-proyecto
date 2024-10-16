package com.mycompany.tallerpoo.com.resto.personal;

import java.time.LocalTime;
import java.util.Scanner;

import com.mycompany.tallerpoo.com.resto.Resto;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.mesa.EstadoMesa;

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
//TERMINAR METODO
    }

    public void desbloquearMesa(){
//TERMINAR METODO
    }

    
    public void asignarRol(CodRol rol){
        super.setRol(rol); 
    }

    public void CrearCuenta() {
        Scanner scanner = new Scanner(System.in);

        // Pedir al administrador que ingrese los datos del nuevo empleado
        System.out.println("Ingrese el ID del nuevo empleado:");
        int id = scanner.nextInt();

        // Consumir la línea siguiente para evitar problemas con la lectura de cadenas
        scanner.nextLine();

        System.out.println("Ingrese el rol del empleado (Administrador, Maitre, Mesero):");
        String rolString = scanner.nextLine().toUpperCase();
        CodRol rol;
        rol = CodRol.valueOf(rolString);
        Empleado empleado_nuevo = new Empleado(id, rol);

    }
}
