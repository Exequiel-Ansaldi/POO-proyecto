package com.mycompany.tallerpoo.com.resto.InterfazG.VentanaIdentificacionC;

import com.mycompany.tallerpoo.com.resto.cliente.Cliente;
import com.mycompany.tallerpoo.com.resto.cliente.ListaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaRegistrarse extends JFrame {
    private JPanel panel1;
    private JTextField JTextoNombre;
    private JTextField JTextoCorreo;
    private JTextField jTextoContra;
    private JTextField jTextNum;
    private JLabel textoNombre;
    private JLabel textoCorreo;
    private JLabel textoContrasenia;
    private JLabel textoNum;
    private JButton boton;
    public VentanaRegistrarse() {
        setTitle("Inicio de Sesión");
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
               String contrasenia = jTextoContra.getText().trim();
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


               Cliente cliente = ListaCliente.buscarCliente(correo, contrasenia);

               // Agregar el cliente a la lista y guardar en el archivo CSV
               listaCliente.agregarCliente(cliente);
               try {
                   listaCliente.escribirArchivo("data/clientes.csv", ","); // Asegúrate de ajustar la ruta y el separador
                   JOptionPane.showMessageDialog(VentanaRegistrarse.this, "Registro exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                   dispose(); // Cerrar la ventana de registro una vez que el usuario se haya registrado
               } catch (IOException ex) {
                   JOptionPane.showMessageDialog(VentanaRegistrarse.this, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
               }
           }
        });
    }
}
