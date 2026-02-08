/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.resto;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.Agenda;
import src.Evento;
import src.cliente.Cliente;
import src.mesa.EstadoMesa;
import src.mesa.Mesa;
import src.personal.Administrador;
import src.reserva.Reserva;

import java.time.LocalTime;

/**
 *
 * @author Exequiel
 */

/**
 * La clase `Resto` representa un restaurante con atributos como mapa, horarios de apertura y cierre,
 * listado de clientes, agenda, eventos, administradores, mesas y reservas.
 */
public class Resto {
    /**
     * Hora de apertura del restaurante.
     */
    private LocalTime apertura;

    /**
     * Hora de cierre del restaurante.
     */
    private LocalTime cierre;

    /**
     * Lista de clientes asociados al restaurante.
     */
    private List<Cliente> clientes;

    /**
     * Agenda de reservas y eventos del restaurante.
     */
    private Agenda agenda;

    /**
     * Lista de eventos programados en el restaurante.
     */
    private List<Evento> eventos;

    /**
     * Lista de administradores del restaurante.
     */
    private List<Administrador> admins;

    /**
     * Lista de mesas disponibles en el restaurante.
     */
    private List<Mesa> mesas;

    /**
     * Lista de reservas realizadas en el restaurante.
     */
    private List<Reserva> reservas;

//-----------------------------------------CONSTRUCTORES--------------------------------------------------

    /**
     * Constructor de la clase Resto.
     * Inicializa las listas de clientes, eventos, administradores, mesas y reservas.
     */
    public Resto() {
        this.clientes = new ArrayList<Cliente>();
        this.eventos = new ArrayList<Evento>();
        this.admins = new ArrayList<Administrador>();
        this.mesas = new ArrayList<Mesa>();
        this.reservas = new ArrayList<Reserva>();
    }

    /**
     * Constructor de la clase Resto.
     *
     * @param apertura Hora de apertura del restaurante.
     * @param cierre   Hora de cierre del restaurante.
     * @param clientes Lista de clientes asociados al restaurante.
     * @param agenda   Agenda para gestionar las reservas y eventos.
     * @param eventos  Lista de eventos programados en el restaurante.
     * @param admins   Lista de administradores del restaurante.
     * @param mesas    Lista de mesas disponibles en el restaurante.
     * @param reservas Lista de reservas realizadas en el restaurante.
     */
    public Resto(LocalTime apertura, LocalTime cierre, List<Cliente> clientes, Agenda agenda, List<Evento> eventos, List<Administrador> admins, List<Mesa> mesas, List<Reserva> reservas) {
        this.apertura = apertura;
        this.cierre = cierre;
        this.clientes = clientes;
        this.agenda = agenda;
        this.eventos = eventos;
        this.admins = admins;
        this.mesas = mesas;
        this.reservas = reservas;
    }

    //----------------------------------------MÉTODOS----------------------------------------------------

    /**
     * La función `getApertura()` devuelve el valor LocalTime del campo `apertura`.
     *
     * @return El método `getApertura()` devuelve un objeto `LocalTime`, específicamente el
     * horario de apertura del restaurant.
     */
    public LocalTime getApertura() {
        return this.apertura;
    }

    /**
     * La función `setApertura` establece el tiempo de apertura para un objeto específico.
     *
     * @param apertura Variable LocalTime que representa la hora de apertura del restaurant.
     */
    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    /**
     * La función `getCierre` en Java devuelve la hora de cierre almacenada en la variable `cierre`.
     *
     * @return El método `getCierre` devuelve el objeto LocalTime `cierre`. Especificamente el
     * horario de cierre del restaurant.
     */
    public LocalTime getCierre() {
        return this.cierre;
    }

    /**
     * La función `setCierre` establece la hora de cierre del restaurant.
     *
     * @param cierre El parámetro `cierre` representa la hora de cierre del restaurant.
     *               Es de tipo `LocalTime`, que es una clase en Java que representa una hora sin fecha ni hora
     *               zona.
     */
    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    /**
     * La función "agregarCliente" agrega un objeto cliente a una lista de clientes.
     *
     * @param c El parámetro `c` en el método `agregarCliente` representa un objeto del `Cliente`
     *          clase, que se está agregando a la lista de clientes ("clientes") en el objeto actual.
     */
    public void agregarCliente(Cliente c) {
        this.clientes.add(c);
    }

    /**
     * Esta función Java establece una lista de objetos Cliente en una variable de clase.
     *
     * @param clientes El parámetro "clientes" es una Lista de objetos de tipo Cliente. el metodo
     *                 "setCliente" se utiliza para establecer la Lista de objetos Cliente en una variable de clase llamada "clientes".
     */

    public void setCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * La función devuelve una lista de objetos Cliente.
     *
     * @return Se devuelve una lista de objetos Cliente.
     */
    public List<Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * La función `getAgenda()` devuelve el objeto de agenda.
     *
     * @return Se devuelve un objeto `Agenda`.
     */
    public Agenda getAgenda() {
        return this.agenda;
    }

    /**
     * Esta función de Java establece la agenda para el restaurant.
     *
     * @param agenda El método `setAgenda` es un método de establecimiento utilizado para asignar un valor a la `agenda`
     *               variable de instancia de la clase. El parámetro `Agenda agenda` especifica que el método espera
     *               un objeto de tipo `Agenda` que se pasará como argumento. Este objeto será asignado a
     */
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    /**
     * La función "agregarEvento" agrega un objeto Evento a una lista de eventos.
     *
     * @param c El parámetro `c` en el método `agregarEvento` representa un objeto `Evento` que
     *          quiero agregar a la lista de eventos (`eventos`).
     */
    public void agregarEvento(Evento c) {
        this.eventos.add(c);
    }

    /**
     * La función establece una lista de objetos Evento en una variable de clase.
     *
     * @param eventos El parámetro "eventos" es una Lista de objetos de tipo "Evento". el metodo
     *                "setEvento" se utiliza para establecer el valor de la variable de instancia "eventos" en la Lista de eventos proporcionada.
     *                Objetos de eventos.
     */
    public void setEvento(List<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * La función `getEventos` devuelve una lista de objetos `Evento`.
     *
     * @return Se devuelve una lista de objetos Evento.
     */
    public List<Evento> getEventos() {
        return this.eventos;
    }

    /**
     * La función "agregarAdmin" agrega un objeto Administrador a una lista de administradores.
     *
     * @param c El parámetro `c` en el método `agregarAdmin` es un objeto de tipo `Administrador`,
     *          que representa un administrador. Este método agrega el administrador especificado a una colección.
     *          de administradores (`admins`).
     */
    public void agregarAdmin(Administrador c) {
        this.admins.add(c);
    }

    /**
     * La función establece una lista de objetos Administrador en una variable de clase.
     *
     * @param admins El parámetro `admins` es una Lista de objetos de tipo `Administrador`, que es
     *               una clase que representa a los administradores en el sistema. El método `setAdmin` se utiliza para configurar la
     *               lista de administradores para un objeto o instancia en particular.
     */
    public void setAdmin(List<Administrador> admins) {
        this.admins = admins;
    }

    /**
     * La función devuelve una lista de objetos Administrador.
     *
     * @return Se devuelve una lista de objetos de Administrador.
     */
    public List<Administrador> geAdministradores() {
        return this.admins;
    }


    /**
     * La función setMesa establece la lista de objetos Mesa para una instancia determinada.
     *
     * @param mesas El parámetro `mesas` en el método `setMesa` es una Lista de objetos de tipo `Mesa`.
     *              Este método se utiliza para establecer la lista de objetos `Mesa` para la instancia actual de la clase.
     */
    public void setMesa(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    /**
     * La función `getMesas` devuelve una lista de objetos Mesa.
     *
     * @return Se devuelve una lista de objetos de Mesa.
     */
    public List<Mesa> getMesas() {
        return this.mesas;
    }

    /**
     * La función "agregarReserva" añade un objeto de reserva a una lista de reservas.
     *
     * @param c El parámetro "c" en el método "agregarReserva" representa un objeto de tipo "Reserva"
     *          que se desea agregar a la lista de reservas.
     */
    public void agregarReserva(Reserva c) {
        this.reservas.add(c);
    }

    /**
     * La función establece una lista de reservas para un objeto determinado.
     *
     * @param reservas El método `setReserva`es un método de establecimiento para configurar una lista de
     *                 Objetos `Reserva`. El parámetro `reservas` es una Lista de objetos `Reserva` que se desea configurar
     *                 para el objeto actual. Al llamar a este método y pasar una Lista de `Reserva`.
     */
    public void setReserva(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * La función `getReservas` devuelve una lista de objetos `Reserva`.
     *
     * @return Se devuelve una lista de objetos Reserva.
     */
    public List<Reserva> getReservas() {
        return this.reservas;
    }

    /**
     * La función `verificarDisponibilidad` comprueba si un conjunto de mesas solicitadas está disponible en una
     * fecha y hora determinadas para una duración especificada, teniendo en cuenta el horario de apertura y las reservas existentes.
     *
     * @param mesasSolicitadas La lista de mesas solicitadas por el cliente.
     * @param fecha            La variable `fecha` representa la fecha en la que se desea verificar la
     *                         disponibilidad de mesas para realizar una reserva.
     * @param horaInicio       El parámetro `horaInicio` representa la hora de inicio de la reserva.
     *                         Es un objeto `LocalTime` que indica la hora a la que se programa el inicio de la reserva.
     * @param horafinal        El parámetro `duracionHoras` representa la duración en horas para la que se solicitan
     *                         las mesas por parte del cliente. Se utiliza para calcular la hora de finalización en función de la hora de inicio proporcionada por el cliente.
     *                         Esta duración se utiliza para verificar la disponibilidad y los conflictos con las reservas existentes.
     * @return El método `verificarDisponibilidad` devuelve un valor booleano. Devuelve `true` si las mesas solicitadas están disponibles para reservar
     * en la fecha y hora especificadas sin ningún conflicto de programación, y `false` si hay conflictos con las reservas existentes o si la hora solicitada
     * está fuera del horario de apertura del establecimiento.
     */
    public boolean verificarDisponibilidad(List<Mesa> mesasSolicitadas, LocalDate fecha, LocalTime horaInicio, LocalTime horafinal) {
        // Comprobar que las horas de inicio y fin estén dentro del horario de apertura y cierre
        if (horaInicio.isBefore(apertura) || horafinal.isAfter(cierre)) {
            return false; // No está disponible dentro del horario
        }


        for (Reserva reserva : reservas) {
            // Verificar si la fecha de la reserva coincide con la fecha solicitada
            if (reserva.getFecha().isEqual(fecha)) {
                // Verificar si hay alguna mesa en común entre las solicitadas y las de la reserva
                Mesa mesaReserva = reserva.getMesa(); // Obtener la mesa de la reserva

                // Comprobar si la mesa de la reserva está en la lista de mesas solicitadas
                if (mesasSolicitadas.contains(mesaReserva)) {
                    // Obtener la hora de inicio de la reserva existente
                    LocalTime inicioReserva = reserva.getHorainicioreserva();
                    LocalTime finReserva = reserva.getHorafinalreserva();

                    // Verificar superposición de horarios
                    boolean horarioEnConflicto =
                            (horaInicio.isBefore(finReserva) && horafinal.isAfter(inicioReserva));

                    if (horarioEnConflicto) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena del objeto Resto.
     *
     * @return una cadena que representa los atributos del restaurante, incluyendo
     * la hora de apertura, la hora de cierre, la lista de clientes,
     * la agenda, los eventos, los administradores, las mesas y las reservas.
     */
    @Override
    public String toString() {
        return "Resto{" +
                "apertura=" + apertura +
                ", cierre=" + cierre +
                ", clientes=" + clientes +
                ", agenda=" + agenda +
                ", eventos=" + eventos +
                ", admins=" + admins +
                ", mesas=" + mesas +
                ", reservas=" + reservas +
                '}';
    }

    /**
     * Crea un mapa de mesas del restaurante, organizándolas según su ubicación
     * y estado (disponible o no disponible).
     *
     * @param MesasResto lista de mesas del restaurante que se deben clasificar.
     */
    public void crearMapa(List<Mesa> MesasResto) {
        List<Mesa> mesasPatioDisponible = new ArrayList<Mesa>();
        List<Mesa> mesasInternoDisponible = new ArrayList<Mesa>();
        List<Mesa> mesasPatioNoDisponible = new ArrayList<Mesa>();
        List<Mesa> mesasInternoNoDisponible = new ArrayList<Mesa>();

        //Catalogo por Ubicación y Estado para mostrarlas en conjunto.
        for (Mesa m : MesasResto) {
            if (m.getUbicacion().equals("Patio")) {
                if (m.getEstado().equals(EstadoMesa.Disponible)) {
                    mesasPatioDisponible.add(m);
                } else {
                    mesasPatioNoDisponible.add(m);
                }
            } else if (m.getUbicacion().equals("Interno")) {
                if (m.getEstado().equals(EstadoMesa.Disponible)) {
                    mesasInternoDisponible.add(m);
                } else {
                    mesasInternoNoDisponible.add(m);
                }
            }
        }
        //Seguir el resto con interfaz.
    }


}


