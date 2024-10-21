/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;

/**
 *
 * @author Exequiel
 */

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La clase Agenda representa un la agenda del restaurant con atributos de fecha, hora de inicio y hora de finalización.
 */
public class Agenda {
    private LocalDate fecha;
    private LocalTime horainicio;
    private LocalTime horafin;

    //Constructores
    // Es un constructor para la clase `Agenda` en Java. este constructor
    // toma tres parámetros: `fecha` de tipo `LocalDate`, `horainicio` de tipo `LocalTime`, y
    // `horafin` de tipo `LocalTime`.
    public Agenda(LocalDate fecha, LocalTime horainicio, LocalTime horafin) {
        this.fecha = fecha;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }
   // La línea `public Agenda(){}` es un constructor predeterminado para la clase `Agenda` en Java. Este
   // el constructor no toma ningún parámetro e inicializa una instancia de la clase `Agenda` con
   // valores predeterminados.
    public Agenda(){}

    //Getters & Setters
   /**
    * Esta función Java devuelve la fecha almacenada en la variable de instancia "fecha".
    * 
    * @return Un objeto `LocalDate` que representa la fecha almacenada en la variable de instancia `fecha` esta
    * siendo devuelto.
    */
    public LocalDate getFecha() {
        return this.fecha;
    }

    /**
     * Esta función Java establece el valor de una variable LocalDate llamada "fecha".
     * 
     * @param fecha El parámetro `fecha` es de tipo `LocalDate`, el cual representa una fecha sin
     * zona horaria.
     */

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * La función `getHorainicio()` devuelve el valor del atributo `horainicio` en una clase Java.
     * 
     * @return El método `getHorainicio` devuelve un objeto `LocalTime`, específicamente el
     * Atributo `horainicio` del objeto actual.
     */
    public LocalTime getHorainicio() {
        return this.horainicio;
    }

  /**
    * La función `setHorainicio` establece el valor de la variable `horainicio` al proporcionado
    * Valor `Hora local`.
    * 
    * @param horainicio El parámetro `horainicio` es de tipo `LocalTime`, el cual representa un tiempo
    * sin fecha ni zona horaria.
    */
    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

   /**
    * La función `getHorafin()` devuelve el valor del atributo `horafin` en una clase Java.
    * 
    * @return El método `getHorafin()` devuelve un objeto `LocalTime`, que representa una hora
    *sin fecha ni zona horaria.
    */
    public LocalTime getHorafin() {
        return this.horafin;
    }

   /**
    * La función `setHorafin` establece el valor de la variable `horafin` al `LocalTime` proporcionado
    * valor.
    * 
    * @param horafin El parámetro `horafin` es de tipo `LocalTime`, que representa una hora sin
    * información de fecha o zona horaria.
    */
    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "fecha=" + fecha +
                ", horainicio=" + horainicio +
                ", horafin=" + horafin +
                '}';
    }
}
