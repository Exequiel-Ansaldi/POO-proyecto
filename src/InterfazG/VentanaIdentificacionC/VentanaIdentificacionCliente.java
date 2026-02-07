package com.mycompany.tallerpoo.com.resto.InterfazG.VentanaIdentificacionC;

import com.mycompany.tallerpoo.com.resto.cliente.ListaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaIdentificacionCliente extends JFrame {
    private JPanel panel;
    private JButton iniciarsesion;
    private JLabel texto;
    private JButton registro;
    private ListaCliente listaCliente; // Instancia de ListaCliente

    public VentanaIdentificacionCliente(ListaCliente listaCliente) { // Constructor que recibe la lista de clientes
        this.listaCliente = listaCliente; // Inicializar la lista de clientes
        setTitle("Verificación");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        iniciarsesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaInicio(listaCliente); // Pasar la lista de clientes
                dispose();
            }
        });

        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaRegistrarse(listaCliente); // Asegúrate de que VentanaRegistrarse también acepte la lista de clientes
                dispose();
            }
        });
    }
}