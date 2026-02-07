/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto;

import com.mycompany.tallerpoo.com.resto.mesa.Mesa;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;



/**
* La clase "Evento" representa un evento con un nombre, una descripción, una fecha, una hora de inicio, una hora de finalización y una
* lista de mesas.
*/
public class Evento {
    /**
     * Nombre del evento.
     */
    private String nombre;

    /**
     * Descripción del evento.
     */
    private String descripcion;

    /**
     * Día en que se realiza el evento.
     */
    private LocalDate dia;

    /**
     * Hora de inicio del evento.
     */
    private LocalTime horainicio;

    /**
     * Hora de finalización del evento.
     */
    private LocalTime horafin;

    /**
     * Lista de mesas asociadas al evento.
     */
    private List<Mesa> mesas;

    //-----------------------------------------CONSTRUCTORES---------------------------------------------------------

    /**
     * Constructor por defecto que inicializa la lista de mesas.
     */
    public Evento(){
        this.mesas = new ArrayList<Mesa>();
    }

    /**
     * Constructor que inicializa todos los atributos del evento.
     *
     * @param nombre        El nombre del evento.
     * @param descripcion   La descripción del evento.
     * @param dia          El día en que se realiza el evento.
     * @param horainicio    La hora de inicio del evento.
     * @param horafin       La hora de finalización del evento.
     * @param mesas         La lista de mesas asociadas al evento.
     */
    public Evento(String nombre, String descripcion, LocalDate dia, LocalTime horainicio, LocalTime horafin, List<Mesa> mesas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.mesas = mesas;
    }

    //--------------------------------------------METODOS-----------------------------------------------------
   /**
    * La función `getNombre()` en Java retorna el valor del atributo `nombre`.
    *
    * @return El método `getNombre()` retorna el valor del atributo `nombre`.
    */
    public String getNombre() {
        return this.nombre;
    }

   /**
    * La función establece el valor de la variable "nombre" en una clase Java.
    *
    * @param nombre El parámetro "nombre" en el método "setNombre" es de tipo String, que representa
    * el nombre que se le asignará a un objeto evento.
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /**
    * La función getDescripcion en Java devuelve la descripción de un objeto.
    *
    * @return El método `getDescripcion()` está devolviendo el valor de la variable de instancia
    * `descripcion`.
    */
    public String getDescripcion() {
        return this.descripcion;
    }

  /**
    * La función establece la descripción de un objeto Evento.
    *
    * @param descripcion El método `setDescripcion` es un método de establecimiento que se utiliza para establecer el valor del
    * atributo `descripcion` en una clase Evento. El parámetro `descripcion` es el valor que se
    * asignará al atributo `descripcion`.
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
    * La función `getDia()` devuelve el objeto LocalDate `dia`.
    *
    * @return El método `getDia()` devuelve un objeto `LocalDate`, específicamente la variable de instancia `dia`
    * de la clase.
    */
    public LocalDate getDia() {
        return this.dia;
    }

   /**
    * La función establece el valor de una variable LocalDate llamada "dia".
    *
    * @param dia El parámetro "dia" es un objeto LocalDate que representa una fecha específica.
    */
    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    /**
    * La función `getHorainicio()` devuelve el valor del atributo `horainicio` en una clase Java.
    *
    * @return El método `getHorainicio` está devolviendo un objeto `LocalTime`, específicamente el
    * atributo `horainicio` del objeto actual.
    */
    public LocalTime getHorainicio() {
        return this.horainicio;
    }

   /**
    * La función establece el valor de la variable "horainicio" en el valor LocalTime proporcionado.
    *
    * @param horainicio El parámetro `horainicio` es del tipo `LocalTime`, que representa una hora
    * sin fecha ni zona horaria en el sistema de calendario ISO-8601, como 10:15:30.
    */
    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    /**
    * La función `getHorafin()` devuelve el valor del atributo `horafin` en una clase Java.
    *
    * @return El método `getHorafin` está devolviendo un objeto `LocalTime`, específicamente la variable de instancia `horafin`
    * de la clase.
    */
    public LocalTime getHorafin() {
        return this.horafin;
    }

    /**
    * La función establece el valor de la variable "horafin" en el valor de LocalTime proporcionado.
    *
    * @param horafin El método `setHorafin` es un método de establecimiento que se utiliza para establecer el valor de la variable de instancia `horafin`
    * en una clase. El parámetro `horafin` es del tipo `LocalTime`
    */
    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }

    /**
    * Esta función Java establece la lista de objetos Mesa para un evento determinado.
    *
    * @param mesas El parámetro `mesas` es una lista de objetos de tipo `Mesa`. El método `setMesa` se
    * utiliza para establecer el valor del campo privado `mesas` en la clase en la lista proporcionada de objetos `Mesa`.
    */
    public void setMesa(List<Mesa> mesas){
        this.mesas = mesas;
    }
    
    /**
    * La función "agregarMesa" agrega un objeto Mesa a una lista de mesas.
    *
    * @param m El parámetro "m" en el método "agregarMesa" es un objeto de la clase "Mesa". Representa
    * una sola mesa o mesa de comedor que desea agregar a la lista de mesas en el
    * objeto actual.
    */
    public void agregarMesa(Mesa m){
        this.mesas.add(m);
    }

    /**
    * La función `getMesas()` devuelve una lista de objetos Mesa.
    *
    * @return Se devuelve una lista de objetos Mesa.
    */
    public List<Mesa> getMesas(){
        return this.mesas;
    }

    /**
     * Devuelve una representación en cadena del objeto Evento.
     *
     * @return una cadena que representa los atributos del evento.
     */
    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", dia=" + dia +
                ", horainicio=" + horainicio +
                ", horafin=" + horafin +
                ", mesas=" + mesas +
                '}';
    }
}
