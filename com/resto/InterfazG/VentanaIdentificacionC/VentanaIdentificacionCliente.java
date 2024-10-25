package com.mycompany.tallerpoo.com.resto.InterfazG.VentanaIdentificacionC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaIdentificacionCliente extends  JFrame{
    private JPanel panel;
    private JButton iniciarsesion;
    private JLabel texto;
    private JButton registro;

    public VentanaIdentificacionCliente(){
        setTitle("Verificacion");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        iniciarsesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaInicio();
                dispose();
            }
        });
        registro.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //new Registrarse;
               dispose();
           }
        });
    }

}
