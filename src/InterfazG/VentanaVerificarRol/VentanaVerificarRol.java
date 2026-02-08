package src.InterfazG.VentanaVerificarRol;


import javax.swing.*;

import src.InterfazG.VentanaAdministrador.VentanaAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVerificarRol extends JFrame {
    private JPanel panel;
    private JPanel panel2;
    private JTextField ingreso;
    private JButton verificarButton;
    public VentanaVerificarRol() {
        setTitle("Verificacion");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoRol = ingreso.getText().trim();
                if (codigoRol.equalsIgnoreCase("Administrador")) {
                    new VentanaAdministrador();
                } else if (codigoRol.equalsIgnoreCase("Mesero") || codigoRol.equalsIgnoreCase("Maitre")) {
                    //new VentanaReservas();
                } else {
                    JOptionPane.showMessageDialog(null, "Código de rol no válido", "ERROR" ,JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });

        setVisible(true);
    }
}
