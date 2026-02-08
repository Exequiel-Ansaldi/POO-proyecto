package src.InterfazG.VentanaIdentificacionC;

import javax.swing.*;

import src.cliente.ListaCliente;
import src.cliente.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {

    private JButton boton; // Botón para iniciar sesión
    private JTextField correo; // Campo de texto para ingresar el correo electrónico
    private JPasswordField contrasenia; // Campo de texto para ingresar la contraseña
    private JLabel texto; // Etiqueta para mostrar mensajes
    private JPanel panel; // Panel que contiene los componentes de la ventana
    private ListaCliente listaCliente; // Instancia de ListaCliente para gestionar los clientes

    /**
     * Constructor de la clase VentanaInicio.
     *
     * @param listaCliente La lista de clientes que se utilizará para validar el inicio de sesión.
     */
    public VentanaInicio(ListaCliente listaCliente) { // Recibir la lista de clientes como parámetro
        this.listaCliente = listaCliente; // Inicializar la lista de clientes
        setTitle("Inicio de Sesión"); // Establecer el título de la ventana
        // Inicialización defensiva: si el panel generado por GUI builder es null, crear una UI mínima
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            texto = new JLabel("Inicio de Sesión");
            correo = new JTextField(20);
            contrasenia = new JPasswordField(20);
            boton = new JButton("Entrar");
            panel.add(texto);
            panel.add(new JLabel("Correo:"));
            panel.add(correo);
            panel.add(new JLabel("Contraseña:"));
            panel.add(contrasenia);
            panel.add(boton);
        }
        setContentPane(panel); // Establecer el panel como contenido de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        pack(); // Ajustar el tamaño de la ventana según los componentes
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true); // Hacer visible la ventana

        // Agregar un ActionListener al botón para manejar el evento de clic
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion(); // Llamar al método iniciarSesion al hacer clic en el botón
            }
        });
    }

    /**
     * Método que maneja el inicio de sesión del usuario.
     * Valida el correo electrónico y la contraseña ingresados.
     */
    public void iniciarSesion() {
        String correoIngresado = correo.getText().trim(); // Obtener el correo ingresado
        String contraseniaIngresada = new String(contrasenia.getPassword()).trim(); // Obtener la contraseña ingresada

        // Buscar cliente en la lista
        Cliente cliente = listaCliente.buscarCliente(correoIngresado);

        // Validar que el cliente existe y la contraseña es correcta
        if (cliente != null && cliente.getContrasenia().equals(contraseniaIngresada)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Aquí puedes abrir la ventana de reservas, si es necesario
            dispose(); // Cerrar la ventana de inicio de sesión
        } else {
            JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}