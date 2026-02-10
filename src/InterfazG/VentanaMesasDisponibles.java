package src.InterfazG;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import src.mesa.ListaMesa;
import src.mesa.Mesa;
import src.mesa.EstadoMesa;

/**
 * Ventana simple que muestra las mesas disponibles.
 */
public class VentanaMesasDisponibles extends JFrame {
    private JList<String> listaVisual;
    private DefaultListModel<String> modelo;

    public VentanaMesasDisponibles() {
        setTitle("Mesas disponibles");
        modelo = new DefaultListModel<>();
        listaVisual = new JList<>(modelo);
        JScrollPane scroll = new JScrollPane(listaVisual);

        cargarMesas();

        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(cerrar);

        getContentPane().setLayout(new BorderLayout(8,8));
        getContentPane().add(new JLabel("Mesas disponibles:"), BorderLayout.NORTH);
        getContentPane().add(scroll, BorderLayout.CENTER);
        getContentPane().add(bottom, BorderLayout.SOUTH);

        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void cargarMesas(){
        ListaMesa lista = new ListaMesa();
        // intentar leer archivo si existe
        try{
            lista.leerArchivo("src/data/mesas.csv", ",");
        }catch(IOException ignored){
            // si no existe, crear algunas mesas de ejemplo
            lista.agregarMesa(new Mesa(2, "Interior", EstadoMesa.Disponible));
            lista.agregarMesa(new Mesa(4, "Patio", EstadoMesa.Disponible));
            lista.agregarMesa(new Mesa(6, "VIP", EstadoMesa.No_Disponible));
        }

        List<Mesa> mesas = lista.getMesas();
        for (Mesa m : mesas){
            if (m.getEstado() == EstadoMesa.Disponible){
                modelo.addElement(m.toString());
            }
        }
        if (modelo.isEmpty()) modelo.addElement("No hay mesas disponibles");
    }
}
