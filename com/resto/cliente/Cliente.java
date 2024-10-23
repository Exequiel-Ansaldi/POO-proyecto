/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo.com.resto.cliente;

import com.mycompany.tallerpoo.com.resto.reserva.Reserva;
import com.mycompany.tallerpoo.com.resto.Resto;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.mesa.Mesa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Exequiel
 */


/**
 * La clase `Cliente` representa un cliente con atributos como nombre, correo electrónico, contraseña, número de teléfono,
 * y una lista de reservas.
 */
public class Cliente {
        /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Correo electrónico del cliente.
     */
    private String correo;

    /**
     * Contraseña del cliente.
     */
    private String contrasenia;

    /**
     * Número de teléfono del cliente.
     */
    private String numero;

    /**
     * Lista de reservas asociadas al cliente.
     */
    private List<Reserva> reservas;

    //-----------------------------------------CONSTRUCTORES--------------------------------------------------

    /**
     * Constructor por defecto de la clase Cliente.
     * Inicializa la lista de reservas como una lista vacía.
     */
    public Cliente(){
        this.reservas = new ArrayList<Reserva>();
    }

    /**
     * Constructor de la clase Cliente que inicializa un cliente con los datos proporcionados.
     *
     * @param nombre      el nombre del cliente.
     * @param correo      el correo electrónico del cliente.
     * @param contrasenia la contraseña del cliente.
     * @param numero      el número de teléfono del cliente.    
     */
    public Cliente(String nombre, String correo, String contrasenia, String numero){
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.numero = numero;
    }
    // Define un constructor para una clase llamada "Cliente". El constructor asume
    // parámetros como `nombre` (nombre), `correo` (correo electrónico), `contrasenia` (contraseña), `numero`
    // (número), y una lista de objetos `Reserva` llamados `reservas`. Dentro del constructor, los valores.
    // de estos parámetros se asignan a las variables de instancia correspondientes de la clase `Cliente`.
    public Cliente(String nombre, String correo, String contrasenia, String numero, List<Reserva> reservas) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.numero = numero;
        this.reservas = reservas;
    }

    //----------------------------------------MÉTODOS----------------------------------------------------

   /**
    * La función `getNombre()` en Java devuelve el valor del atributo `nombre`.
    * 
    * @return Se está devolviendo el atributo `nombre`.
    */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * La función establece el valor de la variable "nombre" en una clase Java.
     * 
     * @param nombre El parámetro "nombre" es de tipo String que representa el nombre de un objeto o
     * entidad. El método "setNombre" se utiliza para establecer el valor del atributo "nombre" de un objeto
     * al valor de cadena proporcionado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el correo del cliente.
     * 
     * @return el correo del cliente.
     */
    public String getCorreo() {
        return this.correo;
    }
    /**
     * Establece el correo del cliente.
     * 
     * @param correo el correo a establecer para el cliente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return la contraseña del cliente.
     */
    public String getContrasenia() {
        return this.contrasenia;
    }

    /**
     * Establece la contraseña del cliente.
     * 
     * @param contrasenia la contraseña a establecer para el cliente.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return el número de teléfono del cliente.
     */
    public String getNumero() {
        return this.numero;
    }

    /**
     * Establece el número de teléfono del cliente.
     * 
     * @param numero el número de teléfono a establecer para el cliente.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Establece la lista de reservas del cliente.
     * 
     * @param reservas la lista de reservas a establecer para el cliente.
     */
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Obtiene la lista de reservas del cliente.
     * 
     * @return la lista de reservas del cliente.
     */
    public List<Reserva> getReservas(){
        return this.reservas;
    }

    /**
     * La función "agregarReserva" agrega un objeto de reserva a una lista de reservas.
     *
     * @param r El parámetro `r` en el método `agregarReserva` es un objeto de tipo `Reserva`, que
     * representa una reserva. Este método agrega el objeto de reserva `r` a una lista de reservas
     * (`reservas`).
     */
    public void agregarReserva(Reserva r){
        this.reservas.add(r);
    }

    /**
     * El método `registrarse` en Java solicita al usuario que ingrese su nombre, correo electrónico, numero de telefono y contraseña
     * valida el formato del correo electrónico y asegura la confirmación de la contraseña antes de registrar
     * con éxito al usuario.
     */
    public void registrarse(){

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        this.nombre = lectura.nextLine();
        System.out.println("Ingrese su correo: ");
        this.correo = lectura.nextLine();
        //Patron email son los valores válidos que puede tomar una direcccion de correo
        String patronemail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        //pattern compila a patronemail
        Pattern patron = Pattern.compile(patronemail);
        //a partir del pattern se crea un matcher para verificar coincidencias
        Matcher matcheo = patron.matcher(this.correo);
        while (!matcheo.matches()){
            System.out.println("Ingrese nuevamente su correo");
            this.correo = lectura.nextLine();
            matcheo = patron.matcher(this.correo);
        }

        System.out.println("Ingrese su número de teléfono: ");
        this.numero = lectura.nextLine();
        String patronTelefono = "^[+]?\\d+$";
        Pattern patronT = Pattern.compile(patronTelefono);
        Matcher matcheoT = patronT.matcher(this.numero);
        while (!matcheoT.matches()) {
            System.out.println("Número de teléfono inválido. Ingrese nuevamente su número de teléfono:");
            this.numero = lectura.nextLine();
            matcheoT = patron.matcher(this.numero);
        }

        while (true){
            System.out.println("Ingrese su contraseña: ");
            this.contrasenia = lectura.nextLine();
            System.out.println("Confirme su contraseña");
            String confirmarcontrasenia = lectura.nextLine();
            if (!(this.contrasenia.equals(confirmarcontrasenia))){
                System.out.println("Las contraseñas no coinciden, ingrese nuevamente");
            }else{
                break;
            }
        }

        System.out.println("Registro exitoso");

    }

    /**
     * La función `iniciarSesion` verifica si el correo electrónico y la contraseña proporcionados coinciden con los valores almacenados
     * e imprime un mensaje de éxito si lo hacen, de lo contrario imprime un mensaje de error.
     */
    public void iniciarSesion(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese su correo");
        String c = lectura.nextLine();
        System.out.println("Ingrese su contraseña");
        String contra = lectura.nextLine();
        if (this.correo.equals(c) && this.contrasenia.equals(contra)) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Correo o contraseña incorrectos. Inténtelo de nuevo.");
        }
    }

    /**
     * El método `actualizarInfo` en Java permite al usuario actualizar diferentes partes de la información
     * como el nombre, el correo electrónico, la contraseña y el número de teléfono con verificaciones de validación.
     */
    public void actualizarInfo(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Pulse según la información a actualizar: ");
        System.out.println("1: Nombre");
        System.out.println("2: Correo");
        System.out.println("3: Contraseña");
        System.out.println("4: Numero de telofono");
        int opcion = lectura.nextInt();
        lectura.nextLine();
        switch (opcion) {
            case 1:
                this.nombre = lectura.nextLine();
                System.out.println("Nombre actualizado");
                break;
            case 2:
                String nuevocorreo = lectura.nextLine();
                String patronemail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
                Pattern patron = Pattern.compile(patronemail);
                Matcher matcheo = patron.matcher(nuevocorreo);
                while (!matcheo.matches()) {
                    System.out.println("Ingrese nuevamente su correo");
                    nuevocorreo = lectura.nextLine();
                    matcheo = patron.matcher(nuevocorreo);
                }
                this.correo = nuevocorreo;
                System.out.println("Correo actualizado");
                break;

            case 3:
                System.out.print("Ingrese la nueva contraseña: ");
                this.contrasenia = lectura.nextLine();
                System.out.println("Contraseña actualizada correctamente.");
                break;

            case 4:
                System.out.println("Ingrese su nuevo numero de telefono: ");
                this.numero = lectura.nextLine();
                System.out.println("Telefono actualizado");
                break;

            default:
                break;
        }
    }
    /**
     * La función `historialReserva` crea una copia ordenada de una lista de reservas basada en la fecha
     * y la hora.
     *
     * @return El método `historialReserva()` está devolviendo una lista ordenada de reservas
     * (`List<Reserva>`) basada en su fecha y hora. Las reservas se ordenan en orden ascendente,
     * con la fecha y hora más temprana primero.
     */
    public List<Reserva> historialReserva() {
        // Crear una copia de la lista de reservas
        List<Reserva> historial = new ArrayList<>(reservas);

        // Ordenar las reservas por fecha y hora
        historial.sort(new Comparator<Reserva>() {
            @Override
            public int compare(Reserva r1, Reserva r2) {
                // Obtener la fecha y hora de cada reserva
                LocalDateTime fechaHora1 = LocalDateTime.of(r1.getFecha(), r1.getHora());
                LocalDateTime fechaHora2 = LocalDateTime.of(r2.getFecha(), r2.getHora());
            
                // Comparar las fechas y horas
                return fechaHora1.compareTo(fechaHora2);
            }
        });

        // Devolver la lista de reservas ordenada
        return historial;
    }

    /**
     * El método `reservarMesa` en Java verifica la disponibilidad de las mesas solicitadas en un
     * restaurante para una fecha y hora dadas, y crea reservas si las mesas están disponibles.
     * 
     * @param resto El parámetro "resto" es un objeto de tipo "Resto", que probablemente representa un
     * restaurante o un establecimiento de comida donde se está haciendo la reserva.
     * @param mesasSolicitadas El parámetro `mesasSolicitadas` es una lista de objetos Mesa que 
     * representan las mesas que han sido solicitadas para la reserva.
     * @param fecha La variable "fecha" representa la fecha en la que se desea reservar la mesa. Es de
     * tipo LocalDate, que es una clase en Java que representa una fecha sin zona horaria. Se utiliza
     * para almacenar fechas como "2022-10-31".
     * @param horaInicio El parámetro `horaInicio` representa la hora de inicio de la reserva. Es de
     * tipo `LocalTime`, que es una clase en Java que representa una hora sin fecha ni zona horaria.
     * Almacena la hora, minuto, segundo y fracción de segundo.
     * @param horafinal El parámetro "horafinal" representa la hora hasta la cual se reservó determinada mesa
     */
    public void reservarMesa(Resto resto, List<Mesa> mesasSolicitadas, LocalDate fecha, LocalTime horaInicio, LocalTime horafinal){
        boolean disponibles = resto.verificarDisponibilidad(mesasSolicitadas, fecha, horaInicio, horafinal);
        if (disponibles) {
            for (Mesa mesa : mesasSolicitadas) {
                // Crear una nueva reserva para cada mesa
                Reserva nuevaReserva = new Reserva(fecha, Asistencia.Asiste, horaInicio,horafinal,mesa,this);
                this.reservas.add(nuevaReserva);
            }
        }
    }



    /**
     * El método `recuperarContrasenia` en Java permite a un usuario restablecer su contraseña si proporciona
     * la dirección de correo electrónico correcta.
     *
     * @param c El parámetro `c` en el método `recuperarContrasenia` es una cadena que representa la
     * dirección de correo electrónico ingresada por el usuario. El método verifica si esta dirección de correo electrónico coincide con la almacenada
     * dirección de correo electrónico (`this.correo`) en el objeto. Si coinciden, se le solicita al usuario que ingrese
     */
    public void recuperarContrasenia(String c){
        if(this.correo.equals(c)){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese una nueva contraseña \n");
            this.contrasenia = sc.nextLine();
        }else{
            System.out.println("ERROR, correo no Existente");
        }


    }
    /**
     * Devuelve una representación en forma de cadena de texto del objeto `Cliente`.
     * Incluye el nombre, el correo, la contraseña, el número de teléfono y la lista de reservas.
     *
     * @return una cadena de texto que representa el objeto `Cliente` y sus atributos.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", numero='" + numero + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}
