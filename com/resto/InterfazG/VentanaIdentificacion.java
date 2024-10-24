package com.mycompany.tallerpoo.com.resto.InterfazG;

import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaVerificarRol.VentanaVerificarRol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaIdentificacion {
    private JPanel panel;
    private JButton personalButton;
    private JButton clienteButton;
    private JLabel Titulo;
    public VentanaIdentificacion() {

        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaReservas();
                dispose();
            }
        });
        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaVerificarRol();
                dispose();
            }
        });
        setVisible(true);
    }
}
