package src.InterfazG.VentanaIdentificacionC;

import javax.swing.*;

import src.cliente.ListaCliente;
import src.InterfazG.VentanaMesasDisponibles;
import src.cliente.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistrarse extends JFrame {
    private JPanel panel1;
    private JTextField JTextoNombre;
    private JTextField JTextoCorreo;
    private JPasswordField jTextoContra; // Cambiado a JPasswordField para ocultar la contraseña
    private JTextField jTextNum;
    private JLabel textoNombre;
    private JLabel textoCorreo;
    private JLabel textoContrasenia;
    private JLabel textoNum;
    private JButton boton;
    private ListaCliente listaCliente; // Instancia de ListaCliente

    public VentanaRegistrarse(ListaCliente c) {
        // Recibir la lista de clientes como parámetro
        this.listaCliente = c; // Inicializar la lista de clientes
        setTitle("Registro de Usuario");
        // Inicialización defensiva: si el panel generado por GUI builder es null, crear una UI mínima
        if (panel1 == null) {
            panel1 = new JPanel();
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
            textoNombre = new JLabel("Nombre:");
            JTextoNombre = new JTextField(20);
            textoCorreo = new JLabel("Correo:");
            JTextoCorreo = new JTextField(20);
            textoContrasenia = new JLabel("Contraseña:");
            jTextoContra = new JPasswordField(20);
            textoNum = new JLabel("Teléfono:");
            jTextNum = new JTextField(15);
            boton = new JButton("Registrar");
            panel1.add(textoNombre);
            panel1.add(JTextoNombre);
            panel1.add(textoCorreo);
            panel1.add(JTextoCorreo);
            panel1.add(textoContrasenia);
            panel1.add(jTextoContra);
            panel1.add(textoNum);
            panel1.add(jTextNum);
            panel1.add(boton);
        }
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JTextoNombre.getText().trim();
                String correo = JTextoCorreo.getText().trim();
                String contrasenia = new String(jTextoContra.getPassword()).trim(); // Obtener la contraseña de JPasswordField
                String numero = jTextNum.getText().trim();

                // Validar que los campos no estén vacíos
                if (nombre.isEmpty() || correo.isEmpty() || contrasenia.isEmpty() || numero.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaRegistrarse.this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar el formato del correo
                if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(VentanaRegistrarse.this, "Por favor, ingrese un correo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar el número de teléfono (por ejemplo, que solo contenga dígitos)
                if (!numero.matches("\\d+")) {
                    JOptionPane.showMessageDialog(VentanaRegistrarse.this, "El número de teléfono debe contener solo dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar si el cliente ya existe
                if (listaCliente.buscarCliente(correo) != null) {
                    JOptionPane.showMessageDialog(VentanaRegistrarse.this, "El correo ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un nuevo cliente
                Cliente cliente = new Cliente(nombre, correo, contrasenia, numero);

                // Agregar el cliente a la lista
                listaCliente.agregarCliente(cliente);

                // Guardar en el archivo CSV (ruta unificada)
                listaCliente.guardarEnArchivo("src/data/clientes.csv");
                JOptionPane.showMessageDialog(VentanaRegistrarse.this, "Registro exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Abrir ventana de mesas disponibles y cerrar esta ventana
                new VentanaMesasDisponibles();
                VentanaRegistrarse.this.dispose();
            }
        });
    }
}