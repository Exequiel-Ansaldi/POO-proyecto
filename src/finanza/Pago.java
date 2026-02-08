/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.finanza;
import src.reserva.Reserva;

 /**
 * Clase que representa un pago asociado a una reserva y una tarjeta de crédito.
 */
public class Pago {
    /**
     * El monto total del pago.
     */
    private float monto;

     /**
     * La reserva a la que se asocia el pago.
     */
    private Reserva reserva;

    /**
     * La tarjeta de crédito utilizada para realizar el pago.
     */
    private TarjetaDeCredito tarjeta;


     //-----------------------------------------CONSTRUCTORES--------------------------------------------------
    /**
     * Constructor que inicializa el monto del pago.
     *
     * @param monto Monto a pagar.
     */
    public Pago(float monto){
        this.monto = monto;
    }

    /**
     * Constructor que inicializa una reserva y la tarjeta de crédito.
     *
     * @param reserva Reserva asociada al pago.
     * @param tarjeta Tarjeta de crédito utilizada para el pago.
     */
    public Pago(Reserva reserva, TarjetaDeCredito tarjeta){
        this.reserva = reserva;
        this.tarjeta = tarjeta;
    }

    /**
     * Constructor que inicializa el monto, la reserva y la tarjeta de crédito.
     *
     * @param monto Monto a pagar.
     * @param reserva Reserva asociada al pago.
     * @param tarjeta Tarjeta de crédito utilizada para el pago.
     */
    public Pago(float monto,Reserva reserva, TarjetaDeCredito tarjeta) {
        this.monto = monto;
        this.reserva = reserva;
        this.tarjeta = tarjeta;
    }

    //----------------------------------------MÉTODOS----------------------------------------------------

    /**
     * Obtiene la reserva asociada al pago.
     *
     * @return Reserva asociada.
     */
    public Reserva getReserva(){
        return this.reserva;
    }

    /**
     * Establece una reserva asociada al pago.
     *
     * @param reserva Reserva a establecer.
     */
    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    /**
     * Obtiene la tarjeta de crédito utilizada para el pago.
     *
     * @return Tarjeta de crédito utilizada.
     */
    public TarjetaDeCredito getTarjeta(){
        return this.tarjeta;
    }

    /**
     * Establece la tarjeta de crédito utilizada para el pago.
     *
     * @param tarjeta Tarjeta de crédito a establecer.
     */
    public void setTarjeta(TarjetaDeCredito tarjeta){
        this.tarjeta = tarjeta;
    }

    /**
     * Obtiene el monto del pago.
     *
     * @return Monto del pago.
     */
    public float getMonto() {
        return this.monto;
    }

    /**
     * Establece el monto del pago.
     *
     * @param monto Monto a establecer.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    
    /**
     * La función "Descontar" deduce un monto especificado de una tarjeta de crédito en función del tipo de
     * asistencia proporcionada.
     *
     * @param monto El parámetro `monto` representa el monto que se descontará de la tarjeta de crédito.
     * @param tarjeta El parámetro `tarjeta` parece ser un objeto de la clase `TarjetaDeCredito`,
     * que probablemente representa una tarjeta de crédito. El método `Descontar` tiene la intención de deducir una cierta
     * cantidad de la tarjeta de crédito en función de los parámetros proporcionados.
     * @param a El parámetro `a` en el método `Descontar` parece ser de tipo `Asistencia`, que es
     * probablemente un enum que representa diferentes tipos de asistencia. El enum `Asistencia` probablemente tiene
     * valores como `Noasiste`, `Asiste` y `Otro` para indicar diferentes
     * @return El método está devolviendo el monto total que se descontó de la tarjeta de crédito.
     */
    public float Descontar(float monto, TarjetaDeCredito tarjeta, Asistencia a) {
        float totalDescontado = 0;
        switch (a) {
            case Noasiste:
                tarjeta.setCantidad(tarjeta.getCantidad() - 50);
                totalDescontado = 50;
            case Asiste:
                tarjeta.setCantidad(tarjeta.getCantidad() - monto);
                totalDescontado = monto;
            case Otro:
        }
        return totalDescontado;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Pago.
     *
     * @return Una cadena que representa el pago, incluyendo el monto, la reserva
     *         asociada y la tarjeta de crédito utilizada.
     */
    @Override
    public String toString() {
        return "Pago{" +
                "monto=" + monto +
                ", reserva=" + reserva +
                ", tarjeta=" + tarjeta +
                '}';
    }
}
