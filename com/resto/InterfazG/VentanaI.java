package com.mycompany.tallerpoo.com.resto.InterfazG;

import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaVerificarRol.VentanaVerificarRol;
import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaIdentificacionC.VentanaIdentificacionCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa una ventana de identificación para el sistema.
 */
public class VentanaI extends JFrame {
    /**
     * Panel principal de la ventana.
     */
    private JPanel panel;

    /**
     * Botón para acceder a la sección de personal.
     */
    private JButton personalButton;

    /**
     * Botón para acceder a la sección de clientes.
     */
    private JButton clienteButton;

    /**
     * Etiqueta que muestra el título de la ventana.
     */
    private JLabel Titulo;

    /**
     * Constructor de la clase VentanaI. Inicializa la ventana de identificación.
     */

    /**
     * Constructor de la clase VentanaI. Inicializa la ventana de identificación.
     */
    public VentanaI() {
        setTitle("Identificación");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaIdentificacionCliente();
                VentanaI.this.dispose();
            }
        });
        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaVerificarRol();
                VentanaI.this.dispose();
            }
        });
    }
}
