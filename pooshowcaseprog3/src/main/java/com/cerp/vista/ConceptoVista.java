package com.cerp.vista;
import javax.swing.*;

import java.awt.*;
import java.net.URI;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;


/**
 * @file ConceptoVista.java
 * @brief Clase que define la interfaz gráfica de usuario para mostrar conceptos y descripciones de respuesta.
 * @date 2023-03-22
 * @version 1.0
 */
import com.cerp.modelo.Concepto;

/**
 * @class ConceptoVista
 * @brief Clase que define la interfaz gráfica de usuario para mostrar conceptos y descripciones de respuesta.
 */
public class ConceptoVista extends JFrame {
    private JLabel idLabel;
    private JLabel conceptoLabel;
    //private JRadioButton[] respuestaButtons;
    //private ButtonGroup buttonGroup;
    private JTextArea descripcionesLabel;
    //JTextArea Espacio de texto grande
    private JButton siguienteButton;
    private JButton urlButton;
    private JButton atrasButton;

    private InicioVista parentWindow;
    private int correctIndex;

    public ConceptoVista(InicioVista parentWindow) {       
        this.parentWindow = parentWindow; // Asignar el objeto recibido al atributo parentWindow
        
        initComponents();
    }

    /**
     * Inicializa y configura los componentes de la interfaz gráfica.
     */
    private void initComponents() {
        // Configuración de la ventana
        setTitle("Juego de conceptos para Programación 3 - CeRP del Suroeste - Prof. Domingo Pérez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Panel para mostrar la concepto
        JPanel conceptoPanel = new JPanel();
        conceptoPanel.setLayout(new BoxLayout(conceptoPanel, BoxLayout.Y_AXIS));
        conceptoPanel.setPreferredSize(new Dimension(600, 50)); // especificar una altura fija

        // Configuración de los componentes
        idLabel = new JLabel("ID de concepto: " + (1001));
        idLabel.setBounds(20, 20, 200, 20);
        conceptoPanel.add(idLabel, BorderLayout.CENTER);

        conceptoLabel = new JLabel("Concepto:");
        conceptoLabel.setBounds(20, 50, 80, 20);
        conceptoPanel.add(conceptoLabel, BorderLayout.CENTER);

        descripcionesLabel = new JTextArea("Descrición:");
        descripcionesLabel.setBounds(20, 80, 80, 20);
        conceptoPanel.add(descripcionesLabel, BorderLayout.CENTER);

        add(conceptoPanel, BorderLayout.CENTER);

        // Panel para mostrar los botones de acción
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        siguienteButton = new JButton("Siguiente");
        siguienteButton.setBounds(150, 170, 100, 30);

        urlButton = new JButton("URL");
        urlButton.setBounds(260, 170, 100, 30);

        atrasButton = new JButton("Atrás");
        atrasButton.setBounds(20, 170, 100, 30);

        actionPanel.add(siguienteButton);
        actionPanel.add(urlButton);
        actionPanel.add(atrasButton);

        add(actionPanel, BorderLayout.SOUTH);

        // Hacer visible la ventana
        setVisible(true);
    }

    public JLabel getIdLabel() {
        return idLabel;
    }
    
    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }
    
    public JLabel getConceptoLabel() {
        return conceptoLabel;
    }
    
    public void setConceptoLabel(JLabel conceptoLabel) {
        this.conceptoLabel = conceptoLabel;
    }
    
    public JTextArea getDescripcionArea() {
        return descripcionesLabel;
    }
    
    public void setDescripcionArea(JTextArea descripcionesLabel) {
        this.descripcionesLabel = descripcionesLabel;
    }
    
    public JButton getSiguienteButton() {
        return siguienteButton;
    }
    
    public void setSiguienteButton(JButton siguienteButton) {
        this.siguienteButton = siguienteButton;
    }
    
    public JButton getUrlButton() {
        return urlButton;
    }
    
    public void setUrlButton(JButton urlButton) {
        this.urlButton = urlButton;
    }
    
    public JButton getAtrasButton() {
        return atrasButton;
    }
    
    public void setAtrasButton(JButton atrasButton) {
        this.atrasButton = atrasButton;
    }
    
    public InicioVista getParentWindow() {
        return parentWindow;
    }
    
    public void setParentWindow(InicioVista parentWindow) {
        this.parentWindow = parentWindow;
    }
    
    public int getCorrectIndex() {
        return correctIndex;
    }
    
    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }

    /**
     * Muestra un mensaje de error en la interfaz gráfica.
     * @param mensaje El mensaje de error a mostrar.
     */
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de confirmación en la vista.
     * 
     * @param mensaje el mensaje a mostrar.
     */
    public void mostrarMensajeConfirmacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    } 
        
}

