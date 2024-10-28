package com.mycompany.tallerpoo.com.resto.InterfazG.VentanaIdentificacionC;

import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.cliente.ListaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {
    private JButton boton;
    private JTextField correo;
    private JPasswordField contrasenia;
    private JLabel texto;
    private JPanel panel;
    private ListaCliente listaCliente; // Instancia de ListaCliente

    public VentanaInicio(ListaCliente listaCliente) { // Recibir la lista de clientes como parámetro
        this.listaCliente = listaCliente; // Inicializar la lista de clientes
        setTitle("Inicio de Sesión");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
    }

    public void iniciarSesion() {
        String correoIngresado = correo.getText().trim();
        String contraseniaIngresada = new String(contrasenia.getPassword()).trim();

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