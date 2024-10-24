package com.mycompany.tallerpoo.com.resto.InterfazG;

import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaVerificarRol.VentanaVerificarRol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaIdentificacion extends JFrame {
    private JPanel panel;
    private JButton personalButton;
    private JButton clienteButton;
    private JLabel Titulo;

    public VentanaIdentificacion() {
        setTitle("Identificación");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new VentanaReservas();
                VentanaIdentificacion.this.dispose();
            }
        });

        setVisible(true);
        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaVerificarRol();
                VentanaIdentificacion.this.dispose();
            }
        });
    }
}
