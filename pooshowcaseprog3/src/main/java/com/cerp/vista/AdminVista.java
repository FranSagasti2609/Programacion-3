package com.cerp.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @file AdminVista.java
 * @brief Clase para representar la interfaz gráfica de administración de conceptos.
 * @date 20/03/2023
 * @version 1.0
 */
public class AdminVista extends JFrame {
    private JLabel idLabel;
    private JLabel conceptoLabel;
    private JTextField conceptoField;
    private JLabel descripcionLabel;
    private JTextField descripcionField;
    private JLabel urlLabel;
    private JTextField urlField;
    private JButton confirmarButton;
    private JButton atrasButton;
    private JButton limpiarButton;

    private InicioVista parentWindow;

    /**
     * Constructor de la clase AdminVista.
     * 
     * @param modelo la lista de conceptos existente.
     * @param parentWindow el objeto InicioVista que se utilizará como ventana padre.
     */
    public AdminVista(InicioVista parentWindow) {
        this.parentWindow = parentWindow; // Asignar el objeto recibido al atributo parentWindow

        initComponents();
    }

    /**
     * Inicializa y configura los componentes de la interfaz gráfica.
     */
    private void initComponents() {
        // Configuración de la ventana
        setTitle("Panel de Administración de Conceptos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

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

        conceptoField = new JTextField();
        conceptoField.setBounds(100, 50, 300, 20);
        conceptoPanel.add(conceptoField, BorderLayout.CENTER);

        descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(20, 80, 80, 20);
        conceptoPanel.add(descripcionLabel, BorderLayout.CENTER);

        descripcionField = new JTextField();
        descripcionField.setBounds(100, 80, 300, 20);
        conceptoPanel.add(descripcionField, BorderLayout.CENTER);

        urlLabel = new JLabel("Url a Replit:");
        urlLabel.setBounds(20, 110, 140, 20);
        conceptoPanel.add(urlLabel, BorderLayout.CENTER);

        urlField = new JTextField();
        urlField.setBounds(160, 110, 240, 20);
        conceptoPanel.add(urlField, BorderLayout.CENTER);

        add(conceptoPanel, BorderLayout.CENTER);

        // Panel para mostrar los botones de acción
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(260, 170, 100, 30);

        atrasButton = new JButton("Atrás");
        atrasButton.setBounds(100, 170, 100, 30);

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(0, 170, 100, 30);

        actionPanel.add(confirmarButton);
        actionPanel.add(atrasButton);
        actionPanel.add(limpiarButton);

        add(actionPanel, BorderLayout.SOUTH);

        // Hacer visible la ventana
        setVisible(true);

        // Ajustar tamaño al contenido
        //pack();

        // No permitir redimensionar
        //setResizable(false);
    }

    

    /**
     * Actualiza el texto del ID de la concepto en la vista.
     */
    public void actualizarIdLabel(int tam) {
        idLabel.setText("ID de concepto: " + (tam + 1));
    }

    /*public FileHandler<Pregunta> getFileHandler() {
        return fileHandler;
    }*/

    public InicioVista getParentWindow() {
        return parentWindow;
    }

    public JButton getConfirmarButton() {
        return confirmarButton;
    }

    public JButton getAtrasButton() {
        return atrasButton;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }

    public JTextField getConceptoField() {
        return conceptoField;
    }

    public JTextField getDescripcionField() {
        return descripcionField;
    }

    public JTextField getUrlField() {
        return urlField;
    }

    /**
     * Devuelve el objeto JLabel del ID de la concepto.
     * 
     * @return el objeto JLabel del ID de la concepto.
     */
    public JLabel getIdLabel() {
        return idLabel;
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

    /**
     * Actualiza el campo de texto de la concepto con la concepto actual del modelo.
     */
    public void actualizarConceptoField() {
        conceptoField.setText("");
    }

    /**
     * Actualiza el campo de texto de descripcion con las descripcion de la concepto actual del modelo.
     */
    public void actualizarDescripcionField() {
        descripcionField.setText("");
    }

    /**
     * Actualiza el campo de texto de la respuesta url con la respuesta url de la concepto actual del modelo.
     */
    public void actualizarUrlField() {
        urlField.setText("");
    }
    

}
