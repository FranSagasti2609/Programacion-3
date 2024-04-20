package com.cerp;

/**
 * Hello world!
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cerp.controlador.InicioControlador;
import com.cerp.modelo.Concepto;
import com.cerp.vista.InicioVista;


public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Comencemos..." );
        // Crear instancia de FileHandler para cargar las preguntas desde preguntas.data
        FileHandler<Concepto> fileHandler = new FileHandler<Concepto>("C:\\CERP\\Informatica\\Programacion-3\\pooshowcaseprog3\\src\\main\\java\\com\\cerp\\resource\\conceptos.data");

        List<Concepto> modelo = new ArrayList<>();        

        try {
            modelo = fileHandler.fileToList();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("El tamanio es " + modelo.size());

        InicioVista vistaInicio = new InicioVista(fileHandler);
        InicioControlador controlador = new InicioControlador(modelo, vistaInicio);
        vistaInicio.setControlador(controlador);
        

    }
}