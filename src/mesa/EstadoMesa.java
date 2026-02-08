/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.mesa;


/**
 * @author Santiago
 * La enumeración EstadoMesa representa los posibles estados de una mesa en el sistema de gestión de reservas.
 *
 * <p>Los estados posibles son:</p>
 * <ul>
 *   <li><code>Disponible</code>: Indica que la mesa está disponible para ser reservada.</li>
 *   <li><code>No_Disponible</code>: Indica que la mesa no está disponible para ser reservada.</li>
 * </ul>
 */
public enum EstadoMesa {
    /**
     * Estado que indica que la mesa está disponible para ser reservada.
     */
    Disponible,

    /**
     * Estado que indica que la mesa no está disponible para ser reservada.
     */
    No_Disponible;
}