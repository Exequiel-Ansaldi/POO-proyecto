/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.finanza;
/**
 *
 * @author Exequiel
 */

/**
 * Clase que representa una tarjeta de crédito.
 */
public class TarjetaDeCredito {
     /**
     * El nombre del titular de la tarjeta.
     */
    
    private String nombre;

    /**
     * La entidad emisora de la tarjeta.
     */

    private String emisor;
     /**
     * El motivo por el cual se utiliza la tarjeta.
     */

    private String motivo;

     /**
     * El número de la tarjeta de crédito.
     */
    private int nrotarjeta;

    /**
     * La cantidad disponible en la tarjeta.
     */
    private float cantidad;

    /**
     * Los detalles del pago asociado a la tarjeta.
     */
    private Pago pago;

    //-----------------------------------------CONSTRUCTORES--------------------------------------------------
     /**
     * Constructor por defecto para la clase TarjetaDeCredito.
     */
    public TarjetaDeCredito(){}

     /**
     * Constructor para la clase TarjetaDeCredito que inicializa todos los atributos.
     *
     * @param nombre     Nombre del titular de la tarjeta.
     * @param emisor     Emisor de la tarjeta.
     * @param motivo     Motivo de la creación de la tarjeta.
     * @param nrotarjeta Número de la tarjeta.
     * @param cantidad   Cantidad disponible en la tarjeta.
     * @param p         Objeto Pago asociado a esta tarjeta.
     */
    public TarjetaDeCredito(String nombre, String emisor, String motivo, int nrotarjeta, float cantidad, Pago p) {
        this.nombre = nombre;
        this.emisor = emisor;
        this.motivo = motivo;
        this.nrotarjeta = nrotarjeta;
        this.cantidad = cantidad;
        this.pago = p;
    }

     /**
     * Constructor para la clase TarjetaDeCredito que inicializa todos los atributos excepto el objeto Pago.
     *
     * @param nombre     Nombre del titular de la tarjeta.
     * @param emisor     Emisor de la tarjeta.
     * @param motivo     Motivo de la creación de la tarjeta.
     * @param nrotarjeta Número de la tarjeta.
     * @param cantidad   Cantidad disponible en la tarjeta.
     */

    public TarjetaDeCredito(String nombre, String emisor, String motivo, int nrotarjeta, float cantidad) {
        this.nombre = nombre;
        this.emisor = emisor;
        this.motivo = motivo;
        this.nrotarjeta = nrotarjeta;
        this.cantidad = cantidad;
    }

    //----------------------------------------MÉTODOS----------------------------------------------------
     /**
     * Obtiene el nombre del titular de la tarjeta.
     *
     * @return El nombre del titular de la tarjeta.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del titular de la tarjeta.
     *
     * @param nombre El nuevo nombre del titular de la tarjeta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el emisor de la tarjeta.
     *
     * @return El emisor de la tarjeta.
     */
    public String getEmisor() {
        return this.emisor;
    }

    /**
     * Establece el emisor de la tarjeta.
     *
     * @param emisor El nuevo emisor de la tarjeta.
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * Obtiene el motivo de la creación de la tarjeta.
     *
     * @return El motivo de la tarjeta.
     */
    public String getMotivo() {
        return this.motivo;
    }

     /**
     * Establece el motivo de la creación de la tarjeta.
     *
     * @param motivo El nuevo motivo de la tarjeta.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
     /**
     * Obtiene el número de la tarjeta.
     *
     * @return El número de la tarjeta.
     */
    public int getNrotarjeta() {
        return this.nrotarjeta;
    }

    /**
     * Establece el número de la tarjeta.
     *
     * @param nrotarjeta El nuevo número de la tarjeta.
     */
    public void setNrotarjeta(int nrotarjeta) {
        this.nrotarjeta = nrotarjeta;
    }

     /**
     * Obtiene la cantidad disponible en la tarjeta.
     *
     * @return La cantidad disponible en la tarjeta.
     */
    public float getCantidad() {
        return this.cantidad;
    }

    /**
     * Establece la cantidad disponible en la tarjeta.
     *
     * @param cantidad La nueva cantidad disponible en la tarjeta.
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el objeto Pago asociado a esta tarjeta.
     *
     * @return El objeto Pago asociado a esta tarjeta.
     */
    public Pago getPago(){
        return this.pago;
    }

    /**
     * Establece el objeto Pago asociado a esta tarjeta.
     *
     * @param p El nuevo objeto Pago asociado a esta tarjeta.
     */
    public void setPago(Pago p){
        this.pago = p;
    }


    @Override
    /**
     * Devuelve una representación en forma de cadena de la tarjeta de crédito.
     * 
     * @return Una cadena que representa los atributos de la tarjeta de crédito.
     */
    public String toString() {
        return
            " Nombre: " + getNombre() + " " +
            ", Emisor: " + getEmisor() + " " +
            ", Motivo: " + getMotivo() + " " +
            ", Numero de Tarjeta: " + getNrotarjeta() + " " +
            ", Cantidad: " + getCantidad() + " " +
            ", Pago: " + getPago();
    }


}
