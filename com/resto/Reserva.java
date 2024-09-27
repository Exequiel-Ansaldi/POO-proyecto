
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

    //Constructores
    public Reserva(LocalDate f, Asistencia asistencia, LocalTime h, Mesa m, Cliente c, List<Empleado> e, List <Pago> p) {
        this.fecha = f;
        this.hora = h;
        this.asistencia = asistencia;
        this.mesa = m;
        this.cliente = c;
        this.empleados = e;
        this.pagos = p;
    }
    public Reserva(){}

    //Getters & Setters
    public void setPagos( List<Pago> pagos){
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

    //Métodos de Clase
    public String hacerComentario(){
        Scanner lectura = new Scanner(System.in);
        String comentario = lectura.nextLine();
        return comentario;
    }
    public void confirmarReserva(){

    }
    public void modificarReserva(LocalDate fecha, LocalTime hora, Mesa mesa ){
    }
    public void cancelarReserva(Reserva reserva){
    }
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