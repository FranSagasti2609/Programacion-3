package com.cerp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import com.cerp.modelo.Concepto;
import com.cerp.vista.AdminVista;
import com.cerp.vista.InicioVista;
import com.cerp.vista.ConceptoVista;


public class InicioControlador implements ActionListener {
    private List<Concepto> modelo;
    private InicioVista vista;

    public InicioControlador(List<Concepto> modelo, InicioVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.getItemAdmin().addActionListener(this);
        vista.getItemConceptos().addActionListener(this);

        vista.getLabelConceptos().setText("Hay en el sistema " + modelo.size() +" conceptos");
    }

    public void ActualizarControlador (){
        vista.getLabelConceptos().setText("Hay en el sistema " + modelo.size() +" conceptos");
    }

    @SuppressWarnings("unused")
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() ==vista.getItemAdmin()) {
            System.out.println("Hola admin");

            // Crear instancia de AdminControlador y mostrar vista AdminVista
            AdminVista vistaAdmin = new AdminVista(vista);
            AdminControlador controladorAdmin = new AdminControlador(modelo, vistaAdmin, vista);

        } else if (e.getSource() == vista.getItemConceptos()) {
            System.out.println("Hola juego");

            // Crear instancia de AdminControlador y mostrar vista AdminVista
            ConceptoVista vistaConcepto = new ConceptoVista(vista);
            
            System.out.println("Hola juego luego de crear vistaConcepto");
            ConceptoControlador controladorPregunta = new ConceptoControlador(modelo, vistaConcepto, vista);
        }
        
        vista.dispose();

       /*  try {
            vista.getFileHandler().listToFile(modelo);
            System.out.println("******************\nEl tamanio es " + modelo.size() + "\nLista guardada correctamente");
        } catch (IOException err) {
            // TODO Auto-generated catch block
            err.printStackTrace();
        }*/
    }

    public List<Concepto> getModelo() {
        return modelo;
    }

    public void setModelo(List<Concepto> modelo) {
        this.modelo = modelo;
    }

    public void guardarConcepto() {
        try {
            vista.getFileHandler().listToFile(modelo);
            System.out.println("******************\nEl tamanio es " + modelo.size() + "\nLista guardada correctamente");
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    


}