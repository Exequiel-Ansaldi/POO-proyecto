
package com.mycompany.tallerpoo.com.resto;

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

import java.time.LocalTime;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Reserva {
    private LocalDate fecha;
    private LocalTime hora;
    private Asistencia asistencia;
    private Cliente cliente;
    private Mesa mesa;
    private List<Empleado> empleados;
    private List<Pago> pagos;
    private List<Reserva> listaReservas;

    //Constructores
    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h, Mesa m, Cliente c){
        this.fecha = f;
        this.hora = h;
        this.asistencia = asistencia;
        this.mesa = m;
        this.cliente = c;
    }
    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h, Mesa m, Cliente c, List<Empleado> e, List <Pago> p, List<Reserva> lR) {
        this.fecha = f;
        this.hora = h;
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

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
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
     * El método `confirmarReserva` comprueba si una mesa está disponible en una fecha y hora especificadas, y
     * si es así, agrega la reserva a una lista.
     */
    public void confirmarReserva(){
        // Verificar si la mesa está disponible en la fecha y hora
        boolean mesaDisponible = true;

        for (Reserva reserva : listaReservas) {
            if (reserva.getMesa().equals(this.mesa) &&
                    reserva.getFecha().equals(this.fecha) &&
                    reserva.getHora().equals(this.hora)) {
                mesaDisponible = false;
                break;
            }
        }

        if (mesaDisponible) {
            // Si la mesa está disponible, agregar la reserva a la lista
            listaReservas.add(this);
            System.out.println("Reserva confirmada para " + cliente.getNombre() + " el " + fecha + " a las " + hora);
        } else {
            System.out.println("La mesa no está disponible en la fecha y hora seleccionadas.");
        }
    }

    /**
     * El método `modificarReserva` itera a través de una lista de reservas y actualiza la fecha,
     * hora y mesa de una reserva si se encuentra, mostrando un mensaje de éxito si se modificó o un mensaje de no
     * encontrado si no.
     *
     * @param reserva Reserva es un objeto que representa una reserva en un restaurante.
     * @param fecha El parámetro `fecha` representa la nueva fecha para la reserva.
     * @param hora El parámetro `hora` en el método `modificarReserva` representa la nueva hora para
     * la reserva. Es de tipo `LocalTime`, que es una clase en Java que representa una hora
     * sin una fecha y zona horaria. Este parámetro se utiliza para actualizar la hora de la reserva
     * especificada por
     * @param mesa El parámetro `mesa` en el método `modificarReserva` representa la nueva mesa o
     * disposición de asientos para la reserva que se está modificando. Es de tipo `Mesa`, que probablemente
     * contiene información sobre la mesa como su número, capacidad, ubicación, etc. Al llamar
     * a este método, usted
     */
    public void modificarReserva(Reserva reserva, LocalDate fecha, LocalTime hora, Mesa mesa ){
        boolean reservaEncontrada = false;
        for(Reserva x : listaReservas){
            if(x.equals(reserva)){
                x.setFecha(fecha);
                x.setHora(hora);
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
}