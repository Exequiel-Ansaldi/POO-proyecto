package src.InterfazG;

import javax.swing.*;

import src.InterfazG.VentanaIdentificacionC.VentanaIdentificacionCliente;
import src.InterfazG.VentanaVerificarRol.VentanaVerificarRol;
import src.cliente.ListaCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa una ventana de identificación para el sistema.
 */
public class VentanaI extends JFrame {
    /**
     * Panel principal de la ventana.
     */
    private JPanel panel;

    /**
     * Botón para acceder a la sección de personal.
     */
    private JButton personalButton;

    /**
     * Botón para acceder a la sección de clientes.
     */
    private JButton clienteButton;

    /**
     * Etiqueta que muestra el título de la ventana.
     */
    private JLabel Titulo;

    /**
     * Constructor de la clase VentanaI. Inicializa la ventana de identificación.
     */

    /**
     * Constructor de la clase VentanaI. Inicializa la ventana de identificación.
     */
    public VentanaI() {
        setTitle("Identificación");
        // Si el panel no fue inicializado (por ejemplo, si faltan componentes generados), crear una UI mínima
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            clienteButton = new JButton("Cliente");
            personalButton = new JButton("Personal");
            Titulo = new JLabel("Identificación");
            panel.add(Titulo);
            panel.add(clienteButton);
            panel.add(personalButton);
        }
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
        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaVerificarRol();
                VentanaI.this.dispose();
            }
        });
    }
}
