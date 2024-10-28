package com.mycompany.tallerpoo.com.resto.InterfazG;

import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaVerificarRol.VentanaVerificarRol;
import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaIdentificacionC.VentanaIdentificacionCliente;
import com.mycompany.tallerpoo.com.resto.cliente.ListaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaI extends JFrame {
    private JPanel panel;
    private JButton personalButton;
    private JButton clienteButton;
    private JLabel Titulo;

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
                new VentanaIdentificacionCliente(new ListaCliente());
                VentanaI.this.dispose();
            }
        });

        setVisible(true);
        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaVerificarRol();
                VentanaI.this.dispose();
            }
        });
    }
}
