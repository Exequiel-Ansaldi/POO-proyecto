package com.mycompany.tallerpoo.com.resto.mesa;

import com.mycompany.tallerpoo.com.resto.Evento;
import com.mycompany.tallerpoo.com.resto.finanza.Asistencia;
import com.mycompany.tallerpoo.com.resto.reserva.Reserva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ListaMesa {
    ArrayList<Mesa> mesas;

    public ListaMesa(){
        this.mesas = new ArrayList<>();
    }
    public ListaMesa(ArrayList<Mesa> mesas){
        this.mesas = mesas;
    }
    public void agregarMesa(Mesa mesa){
        mesas.add(mesa);
    }
    public boolean eliminarMesa(Mesa mesa){
        if(mesas.contains(mesa)){
            mesas.remove(mesa);
            return true;
        }
        return false;
    }
    public void leerArchivo(String archivo, String separador) throws IOException {
        BufferedReader br = null;
        Mesa mesa;

        try{
            br = new BufferedReader(new FileReader(archivo));

            String linea = br.readLine();

            while (null != linea){
                String[] campos = linea.split(separador);
                mesa = new Mesa();
                mesa.setCapacidad(Integer.parseInt(campos[0]));
                mesa.setUbicacion(campos[1]);
                EstadoMesa estado = EstadoMesa.valueOf(campos[2]);
                List<Reserva> reservas = new ArrayList<>();
                if(campos.length > 3 && !campos[3].isEmpty()){
                    String[] reservasData = campos[3].split(",");
                    for (String reservaData : reservasData) {
                        // Supongamos que cada reserva está en el formato: fecha,asistencia,horainicio,horafinal,mesa_id
                        String[] reservaCampos = reservaData.split(",");
                        LocalDate fecha = LocalDate.parse(reservaCampos[0]);
                        Asistencia asistencia = Asistencia.valueOf(reservaCampos[1]); // Asumiendo que Asistencia es un enum
                        LocalTime horaInicio = LocalTime.parse(reservaCampos[2]);
                        LocalTime horaFinal = LocalTime.parse(reservaCampos[3]);

                        String nombre = reservaCampos[4];
                        String descripcion = reservaCampos[5];
                        LocalDate dia = LocalDate.parse(reservaCampos[6]);



                        Evento evento = new Evento()
                    }
                }



            }
        }catch(IOException exc){
        }
    }

}
