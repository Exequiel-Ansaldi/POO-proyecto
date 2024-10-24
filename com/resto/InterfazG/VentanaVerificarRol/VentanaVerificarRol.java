package com.mycompany.tallerpoo.com.resto.InterfazG.VentanaVerificarRol;

import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaAdministrador.VentanaAdministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVerificarRol {
    private JPanel panel;
    private JPanel panel2;
    private JTextField ingreso;
    private JButton ingresarButton;
    private JButton verificarButton;
    public VentanaVerificarRol() {
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoRol = ingresarButton.getText().trim();
                if (codigoRol.equalsIgnoreCase("Administrador")) {
                    new VentanaAdministrador();
                } else if (codigoRol.equalsIgnoreCase("Mesero") || codigoRol.equalsIgnoreCase("Maitre")) {
                    new VentanaReservas();
                } else {
                    JOptionPane.showMessageDialog(null, "Código de rol no válido");
                }
                dispose();
            }
        });

        setVisible(true);
    }
}
