package src.InterfazG.VentanaIdentificacionC;


import javax.swing.*;

import src.cliente.Cliente;
import src.reserva.Reserva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReservaCliente extends JFrame {


    private JList <Reserva>listareserva;
    private JPanel panel1;
    private JScrollPane scroll;
    private JButton reservar;
    private JButton cancelar;
    private JButton modificar;

    public VentanaReservaCliente(Cliente cliente) {
        setTitle("Reservas");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        //modeloReservas = new DefaultListModel<>();
        //scroll.setModel(modeloReservas);
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modificar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
        });

    }
}
