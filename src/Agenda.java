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
 * La clase Agenda representa la agenda del restaurant con atributos de fecha, hora de inicio y hora de finalización.
 */
public class Agenda {
    /** La fecha del evento. */
    private LocalDate fecha;

    /** La hora de inicio del evento. */
    private LocalTime horainicio;

    /** La hora de fin del evento. */
    private LocalTime horafin;

    //------------------------------------------CONSTRUCTORES-------------------------------------------------

    /**
     * Constructor de la clase Agenda.
     *
     * @param fecha La fecha del evento en la agenda.
     * @param horainicio La hora de inicio del evento.
     * @param horafin La hora de finalización del evento.
     */
    public Agenda(LocalDate fecha, LocalTime horainicio, LocalTime horafin) {
        this.fecha = fecha;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    /**
     * Constructor por defecto.
     */
    public Agenda(){}

    //-----------------------------------------METODOS-------------------------------------------------------

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

    /**
     * Devuelve una representación en forma de cadena de la instancia de Agenda.
     *
     * @return Una cadena que contiene la fecha, la hora de inicio y la hora de fin de la agenda.
     */
    @Override
    public String toString() {
        return "Agenda{" +
                "fecha=" + fecha +
                ", horainicio=" + horainicio +
                ", horafin=" + horafin +
                '}';
    }
}
