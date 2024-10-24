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
        JFrame frame = new JFrame("Identificación");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new VentanaReservas();
                dispose();
            }
        });

        setVisible(true);
        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaVerificarRol();
                dispose();
            }
        });
    }
}
