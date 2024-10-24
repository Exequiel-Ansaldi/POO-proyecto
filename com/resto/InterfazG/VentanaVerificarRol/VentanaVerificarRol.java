package com.mycompany.tallerpoo.com.resto.InterfazG.VentanaVerificarRol;

import com.mycompany.tallerpoo.com.resto.InterfazG.VentanaAdministrador.VentanaAdministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVerificarRol extends JFrame {
    private JPanel panel;
    private JPanel panel2;
    private JTextField ingreso;
    private JButton verificarButton;
    public VentanaVerificarRol() {
        JFrame frame = new JFrame("Verificación");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoRol = ingreso.getText().trim();
                if (codigoRol.equalsIgnoreCase("Administrador")) {
                    new VentanaAdministrador();
                } else if (codigoRol.equalsIgnoreCase("Mesero") || codigoRol.equalsIgnoreCase("Maitre")) {
                    //new VentanaReservas();
                } else {
                    JOptionPane.showMessageDialog(null, "Código de rol no válido");
                }
                dispose();
            }
        });

        setVisible(true);
    }
}
