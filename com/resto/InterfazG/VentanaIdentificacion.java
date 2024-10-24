package com.mycompany.tallerpoo.com.resto.InterfazG;

import javax.swing.*;
import java.awt.*;

public class VentanaIdentificacion extends JFrame {
    private JButton botonPersonal;
    private JButton botonCliente;

    public VentanaIdentificacion() {
        setTitle("Quien desea ingresar al sistema?");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Creación de los botones
        botonPersonal = new JButton("Personal del Restaurante");
        botonCliente = new JButton("Cliente");


    }
}
