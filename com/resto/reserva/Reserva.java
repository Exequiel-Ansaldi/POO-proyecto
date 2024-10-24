
package com.mycompany.tallerpoo.com.resto.reserva;

/**
 *
 * @author Exequiel
 */
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;
import com.mycompany.tallerpoo.com.resto.personal.Empleado;
import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.finanza.Pago;

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
    private LocalDate fecha;
    private LocalTime horainicioreserva;
    private LocalTime horafinalreserva;
    private Asistencia asistencia;
    private Cliente cliente;
    private Mesa mesa;
    private List<Empleado> empleados;
    private List<Pago> pagos;
    private List<Reserva> listaReservas;

    //Constructores
    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h, LocalTime hf, Mesa m, Cliente c){
        this.fecha = f;
        this.horainicioreserva = h;
        this.asistencia = asistencia;
        this.mesa = m;
        this.cliente = c;
        this.horafinalreserva = hf;
    }
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
    public Reserva(){
        this.empleados = new ArrayList<Empleado>();
        this.pagos = new ArrayList<Pago>();
        this.listaReservas = new ArrayList<Reserva>();
    }

    //Getters & Setters
    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos){
        this.pagos = pagos;
    }

    public void agregarPagos(Pago p){
        this.pagos.add(p);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public LocalTime getHorainicioreserva() {
        return this.horainicioreserva;
    }

    public void setHorainicioreserva(LocalTime horainicioreserva) {
        this.horainicioreserva = horainicioreserva;
    }

    public LocalTime getHorafinalreserva() {
        return this.horafinalreserva;
    }

    public void setHorafinalreserva(LocalTime horafinalreserva) {
        this.horafinalreserva = horafinalreserva;
    }

    public List<Reserva> getListaReservas() {
        return this.listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }


    public Asistencia getAsistencia() {
        return this.asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

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
                "fecha=" + fecha +
                ", hora de inicio de la reserva=" + horainicioreserva +
                ", hora final de la reserva= " + horafinalreserva + 
                ", asistencia=" + asistencia +
                ", cliente=" + cliente +
                ", mesa=" + mesa +
                ", empleados=" + empleados +
                ", pagos=" + pagos +
                ", listaReservas=" + listaReservas +
                '}';
    }
}