package com.cerp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

//import com.cerp.FileHandler;
import com.cerp.modelo.Concepto;
import com.cerp.vista.AdminVista;
import com.cerp.vista.InicioVista;


/**
 * Clase para representar el controlador de la interfaz gráfica de administración de preguntas.
 */
public class AdminControlador implements ActionListener {
    private List<Concepto> modelo;
    private AdminVista vista;
    private InicioVista vistaInicio2;
    //private FileHandler<Pregunta> fileHandler;

    public AdminControlador(List<Concepto> modelo, AdminVista vista, InicioVista vistaInicio) {
        this.modelo = modelo;
        this.vista = vista;
        this.vistaInicio2 = vistaInicio;

        vista.getConfirmarButton().addActionListener(this);
        vista.getAtrasButton().addActionListener(this);
        vista.getLimpiarButton().addActionListener(this);
        
        // Cargar la primera pregunta en la vista
        this.vista.actualizarIdLabel(modelo.size());
        this.vista.actualizarConceptoField();
        this.vista.actualizarDescripcionField();
        this.vista.actualizarUrlField();

        this.vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInicio2.getControlador().guardarConcepto();
                System.exit(0);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getConfirmarButton()) {
            if (vista.getConceptoField().getText().isEmpty() || vista.getDescripcionField().getText().isEmpty()) {
                vista.mostrarMensajeError("Debe completar todos los campos.");
            } else {
                vista.getConfirmarButton().setEnabled(false); // Desactivar el botón de confirmar temporalmente

                String concepto = vista.getConceptoField().getText();
                String descripcion = vista.getDescripcionField().getText();
                String url = vista.getUrlField().getText();

                Concepto nuevoConcepto = new Concepto(modelo.size() + 1, concepto, url, descripcion);

                this.modelo.add(nuevoConcepto);
                vistaInicio2.getControlador().ActualizarControlador();
                
                System.out.println("DENTRO de ADMIN El tamanio es " + modelo.size());
                

                vista.mostrarMensajeConfirmacion("Concepto agregado correctamente.");

                vista.getIdLabel().setText("ID de concepto: " + (modelo.size() + 1));
                vista.actualizarConceptoField();
                vista.actualizarDescripcionField();
                vista.actualizarUrlField();

                vista.getConfirmarButton().setEnabled(true); // Volver a activar el botón de confirmar
            }
        } else if (e.getSource() == vista.getAtrasButton()) {
            vista.getParentWindow().setVisible(true);
            vista.dispose();
            System.out.println("DENTRO de ADMIN pero ATRAS El tamanio es " + modelo.size());
        } else if (e.getSource() == vista.getLimpiarButton()) {
            modelo.clear();
            vista.getParentWindow().setVisible(true);
            vista.dispose();
        }
    }
}