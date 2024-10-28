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

    public VentanaInicio() {
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
        String correoIngresado = correo.getText();
        String contraseniaIngresada = new String(contrasenia.getPassword());
        Cliente cliente = ListaCliente.buscarCliente(correoIngresado);
        if (cliente != null) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            //new VentanaReservas();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
