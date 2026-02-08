package src.reserva;

/**
 *
 * @author Exequiel
 */
import src.finanza.Asistencia;
import src.mesa.Mesa;
import src.personal.Empleado;
import src.cliente.Cliente;
import src.finanza.Pago;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.time.LocalTime;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Reserva {
    /**
     * La fecha de la reserva.
     *
     * @param fecha La fecha en la que se realiza la reserva.
     */
    private LocalDate fecha;

    /**
     * La hora de inicio de la reserva.
     *
     * @param horainicioreserva La hora en la que comienza la reserva.
     */
    private LocalTime horainicioreserva;

    /**
     * La hora de finalización de la reserva.
     *
     * @param horafinalreserva La hora en la que finaliza la reserva.
     */
    private LocalTime horafinalreserva;

    /**
     * Información sobre la asistencia asociada a la reserva.
     *
     * @param asistencia La asistencia relacionada con la reserva.
     */
    private Asistencia asistencia;

    /**
     * El cliente que realiza la reserva.
     *
     * @param cliente El cliente que ha hecho la reserva.
     */
    private Cliente cliente;

    /**
     * La mesa reservada.
     *
     * @param mesa La mesa que se ha reservado.
     */
    private Mesa mesa;

    /**
     * Lista de empleados asignados a la reserva.
     *
     * @param empleados Lista de empleados que están involucrados en la reserva.
     */
    private List<Empleado> empleados;

    /**
     * Lista de pagos realizados para la reserva.
     *
     * @param pagos Lista de pagos que se han realizado para esta reserva.
     */
    private List<Pago> pagos;

    /**
     * Lista de reservas asociadas.
     *
     * @param listaReservas Lista de reservas que están relacionadas con esta reserva.
     */
    private List<Reserva> listaReservas;

    // Constructores

    /**
     * Constructor que inicializa una nueva reserva con los parámetros especificados.
     *
     * @param f La fecha de la reserva.
     * @param asistencia La asistencia asociada a la reserva.
     * @param h La hora de inicio de la reserva.
     * @param hf La hora de finalización de la reserva.
     * @param m La mesa reservada.
     * @param c El cliente que realiza la reserva.
     */
    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h, LocalTime hf, Mesa m, Cliente c){
        this.fecha = f;
        this.horainicioreserva = h;
        this.asistencia = asistencia;
        this.mesa = m;
        this.cliente = c;
        this.horafinalreserva = hf;
    }

    /**
     * Constructor que inicializa una nueva reserva con todos los parámetros especificados.
     *
     * @param f La fecha de la reserva.
     * @param asistencia La asistencia asociada a la reserva.
     * @param h La hora de inicio de la reserva.
     * @param hf La hora de finalización de la reserva.
     * @param m La mesa reservada.
     * @param c El cliente que realiza la reserva.
     * @param e Lista de empleados asignados a la reserva.
     * @param p Lista de pagos realizados para la reserva.
     * @param lR Lista de reservas asociadas.
     */
    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h, LocalTime hf, Mesa m, Cliente c, List<Empleado> e, List <Pago> p, List<Reserva> lR) {
        this.fecha = f;
        this.horainicioreserva = h;
        this.horafinalreserva = hf;
        this.asistencia = asistencia;
        this.mesa = m;
        this.cliente = c;
        this.empleados = e;
        this.pagos = p;
        this.listaReservas = lR;
    }

    /**
     * Constructor por defecto que inicializa listas vacías para empleados, pagos y reservas.
     */
    public Reserva(){
        this.empleados = new ArrayList<Empleado>();
        this.pagos = new ArrayList<Pago>();
        this.listaReservas = new ArrayList<Reserva>();
    }

    // Getters & Setters

    /**
     * Obtiene la lista de pagos realizados para la reserva.
     *
     * @return Lista de pagos.
     */
    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     * Establece la lista de pagos realizados para la reserva.
     *
     * @param pagos Lista de pagos a establecer.
     */
    public void setPagos(List<Pago> pagos){
        this.pagos = pagos;
    }

    /**
     * Agrega un pago a la lista de pagos realizados para la reserva.
     *
     * @param p El pago a agregar.
     */
    public void agregarPagos(Pago p){
        this.pagos.add(p);
    }

    /**
     * Obtiene la lista de empleados asignados a la reserva.
     *
     * @return Lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece la lista de empleados asignados a la reserva.
     *
     * @param empleados Lista de empleados a establecer.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Obtiene la hora de inicio de la reserva.
     *
     * @return Hora de inicio de la reserva.
     */
    public LocalTime getHorainicioreserva() {
        return this.horainicioreserva;
    }

    /**
     * Establece la hora de inicio de la reserva.
     *
     * @param horainicioreserva Hora de inicio a establecer.
     */
    public void setHorainicioreserva(LocalTime horainicioreserva) {
        this.horainicioreserva = horainicioreserva;
    }

    /**
     * Obtiene la hora de finalización de la reserva.
     *
     * @return Hora de finalización de la reserva.
     */
    public LocalTime getHorafinalreserva() {
        return this.horafinalreserva;
    }

    /**
     * Establece la hora de finalización de la reserva.
     *
     * @param horafinalreserva Hora de finalización a establecer.
     */
    public void setHorafinalreserva(LocalTime horafinalreserva) {
        this.horafinalreserva = horafinalreserva;
    }

    /**
     * Obtiene la lista de reservas asociadas.
     *
     * @return Lista de reservas.
     */
    public List<Reserva> getListaReservas() {
        return this.listaReservas;
    }

    /**
     * Establece la lista de reservas asociadas.
     *
     * @param listaReservas Lista de reservas a establecer.
     */
    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    /**
     * Obtiene la asistencia asociada a la reserva.
     *
     * @return Asistencia de la reserva.
     */
    public Asistencia getAsistencia() {
        return this.asistencia;
    }

    /**
     * Establece la asistencia asociada a la reserva.
     *
     * @param asistencia Asistencia a establecer.
     */
    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    /**
     * Obtiene la fecha de la reserva.
     *
     * @return Fecha de la reserva.
     */
    public LocalDate getFecha() {
        return this.fecha;
    }

    /**
     * Establece la fecha de la reserva.
     *
     * @param fecha Fecha a establecer.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el cliente que realizó la reserva.
     *
     * @return Cliente de la reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente que realizó la reserva.
     *
     * @param cliente Cliente a establecer.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la mesa reservada.
     *
     * @return Mesa de la reserva.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa reservada.
     *
     * @param mesa Mesa a establecer.
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * La función "hacerComentario" lee una línea de entrada del usuario y la devuelve como una cadena de caracteres.
     *
     * @return El método "hacerComentario" devuelve un valor de tipo String, que es la entrada del usuario para un
     * comentario.
     */
    public String hacerComentario(){
        Scanner lectura = new Scanner(System.in);
        String comentario = lectura.nextLine();
        lectura.close();
        return comentario;
    }

    /**
     * El método `confirmarReserva` comprueba si una mesa está disponible en una fecha y horainicioreserva especificadas, y
     * si es así, agrega la reserva a una lista.
     */
    public void confirmarReserva(ListaReserva lista) {
        try {
            lista.leerArchivo("com/resto/data/reservas.csv", ",");
            System.out.println("Reservas cargadas: " + lista.getReservas().size());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        boolean mesaDisponible = true;

        for (Reserva reserva : lista.getReservas()) {
            boolean fechasCoinciden = reserva.getFecha().equals(this.fecha);

            // Check for overlapping time
            boolean overlaps = !this.horainicioreserva.isAfter(reserva.getHorafinalreserva()) &&
                    !this.horafinalreserva.isBefore(reserva.getHorainicioreserva());

            if (reserva.getMesa().equals(this.mesa) && fechasCoinciden && overlaps) {
                mesaDisponible = false;
                break;
            }
        }

        if (mesaDisponible) {
            // If the table is available, add the reservation to the list
            lista.agregarReserva(this);
            System.out.println("Reserva confirmada para " + cliente.getNombre() + " el " + fecha + " a las " + horainicioreserva);
        } else {
            System.out.println("La mesa no está disponible en la fecha y hora seleccionadas.");
        }
    }

    /**
     * El método `modificarReserva` itera a través de una lista de reservas y actualiza la fecha,
     * horainicioreserva y mesa de una reserva si se encuentra, mostrando un mensaje de éxito si se modificó o un mensaje de no
     * encontrado si no.
     *
     * @param reserva Reserva es un objeto que representa una reserva en un restaurante.
     * @param fecha El parámetro `fecha` representa la nueva fecha para la reserva.
     * @param horainicioreserva El parámetro `horainicioreserva` en el método `modificarReserva` representa la nueva horainicioreserva para
     * la reserva. Es de tipo `LocalTime`, que es una clase en Java que representa una horainicioreserva
     * sin una fecha y zona horaria. Este parámetro se utiliza para actualizar la horainicioreserva de la reserva
     * especificada
     * @param mesa El parámetro `mesa` en el método `modificarReserva` representa la nueva mesa o
     * disposición de asientos para la reserva que se está modificando. Es de tipo `Mesa`, que probablemente
     * contiene información sobre la mesa como su número, capacidad, ubicación, etc. Al llamar
     * a este método, usted
     */
    public void modificarReserva(Reserva reserva, LocalDate fecha, LocalTime horainicioreserva, Mesa mesa ){
        boolean reservaEncontrada = false;
        for(Reserva x : listaReservas){
            if(x.equals(reserva)){
                x.setFecha(fecha);
                x.setHorainicioreserva(horainicioreserva);
                x.setMesa(mesa);
                reservaEncontrada = true;
                System.out.println("La reserva fue modificada exitosamente");
            }
            if (!reservaEncontrada){
                System.out.println("Reserva no encontrada");
            }
        }
    }

    /**
     * La función `cancelarReserva` elimina una reserva de una lista de reservas e imprime un
     * mensaje indicando si la reserva se eliminó correctamente o no.
     *
     * @param reserva El método `cancelarReserva` se utiliza para cancelar una reserva eliminándola de
     * una lista de reservas (`listaReservas`). El método toma un objeto `Reserva` como parámetro para
     * identificar qué reserva cancelar.
     */
    public void cancelarReserva(Reserva reserva){
        boolean reservaEliminada = false;
        for(Reserva x : listaReservas){
            if(x.equals(reserva)){
                listaReservas.remove(x);
                reservaEliminada = true;
                System.out.println("La reserva fue eliminada exitosamente");
            }
            if (!reservaEliminada){
                System.out.println("Reserva no encontrada");
            }
        }
    }
    
    /**
     * El método `enviarRecordatorioReserva` envía un correo electrónico de recordatorio a una dirección de correo electrónico especificada
     * con respecto a una reserva.
     *
     * @param correo El parámetro `correo` en el método `enviarRecordatorioReserva` representa la
     * dirección de correo electrónico del destinatario al que se enviará el recordatorio de reserva. Este método configura
     * un servidor SMTP, crea una sesión de correo, redacta un mensaje de correo electrónico con un
     * contenido de recordatorio y lo envía a
     */
    public void enviarRecordatorioReserva(String correo){
        // Configuración del servidor de correo
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";
        String smtpUser = "santiagorayn24@gmail.com";
        String smtpPass = "zlct scvg hvmy dwbl";

        // Crear una sesión de correo
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpUser, smtpPass);
            }
        });

        try {
            // Crear un mensaje de correo
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(smtpUser));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject("Recordatorio de reserva");

            // Contenido del mensaje
            String cuerpoMensaje = "Estimado cliente, recuerda que " + this.fecha + " tienes tu reserva.";
            message.setText(cuerpoMensaje);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Recordatorio enviado con éxito!");
        } catch (MessagingException e) {
            System.out.println("Error al enviar recordatorio: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fecha=" + getFecha() +
                ", asistencia=" + getAsistencia() +
                ", horaInicio=" + getHorainicioreserva() +
                ", horaFinal=" + getHorafinalreserva()+
                ", mesa=" + (mesa != null ? mesa : "null") + // Evitar referencia cíclica
                '}';
    }
}